package com.sesoc.ictmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.sesoc.ictmd.api.SearchExample;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private SearchExample searchExample;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String testSearch(String searchWord, Model model) {
		PhotoList<Photo> searchResult = null;
		try {
			searchResult = searchExample.search(searchWord);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		model.addAttribute("searchResult", searchResult);

		return "commons/testPage";
	}

}