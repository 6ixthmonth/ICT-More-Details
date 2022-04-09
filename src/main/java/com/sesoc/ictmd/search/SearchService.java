package com.sesoc.ictmd.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.photos.Size;

@Service
@PropertySource("classpath:key.properties")
public class SearchService {

	@Value("${FLICKR_API_KEY}")
	private String apiKey;
	@Value("${FLICKR_SHARED_SECRET}")
	private String sharedSecret;

	private Flickr f;
	private PhotosInterface i; // getInfo, getExif
	private SearchParameters p;
	private Set<String> e = new HashSet<>(); // extras

	@PostConstruct
	private void init() {
		f = new Flickr(apiKey, sharedSecret, new REST());
		i = f.getPhotosInterface();
		p = new SearchParameters();

		initExtras();

		p.setPrivacyFilter(1); // public photos
		p.setHasGeo(true);
		p.setExtras(e);
		p.setSafeSearch(Flickr.SAFETYLEVEL_SAFE);
		try {
			p.setMedia("photos");
		} catch (FlickrException fe) {
			fe.printStackTrace();
		}
	}

	private void initExtras() {
		if (e != null) {
			e.add("license");
			e.add("date_upload");
			e.add("date_taken");
//			e.add("owner_name");
//			e.add("icon_server");
			e.add("original_format");
			e.add("last_update");
			e.add("geo");
			e.add("tags");
			e.add("machine_tags");
			e.add("o_dims");
			e.add("views");
			e.add("media");
			e.add("path_alias");
//			e.add("url_sq");
//			e.add("url_t");
//			e.add("url_s");
//			e.add("url_m");
//			e.add("url_l");
			e.add("url_o");
//			e.add("count_faves");
//			e.add("count_comments");
//			e.add("count_views");
		}
	}
	
	public PhotoList<Photo> getPhotos(String query, int count) {
		p.setText(query);
		PhotoList<Photo> result = null;
		try {
			result = i.search(p, count, 0);
		} catch (FlickrException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Photo getPhoto(String photoId) {
		Photo result = null;
		try {
			result = i.getInfo(photoId, sharedSecret);
		} catch (FlickrException e) {
			e.printStackTrace();
		}

		return result;
	}

	public HashMap<String, Object> photoToMap(Photo photo) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("id", photo.getId());
		result.put("title", photo.getTitle());
		result.put("description", photo.getDescription());
		result.put("datePosted", photo.getDatePosted());
//		result.put("url", photo.getUrl());
//		result.put("urls", photo.getUrls());
		result.put("largeUrl", photo.getLargeUrl());
//		result.put("large1600Url", photo.getLarge1600Url());
//		result.put("large2048Url", photo.getLarge2048Url());
		result.put("url", photo.getPhotoUrl().getUrl());
		try {
			result.put("originalUrl", photo.getOriginalUrl());
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		ArrayList<HashMap<String, Object>> sizes = new ArrayList<>();
		try {
			for (Size s : i.getSizes(photo.getId())) {
				HashMap<String, Object> temp = new HashMap<>();
				temp.put("labelName", s.getLabelName());
				temp.put("width", s.getWidth());
				temp.put("height", s.getHeight());
				sizes.add(temp);
			}
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		result.put("sizes", sizes);

		return result;
	}

}