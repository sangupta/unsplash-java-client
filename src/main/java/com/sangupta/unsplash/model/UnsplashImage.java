package com.sangupta.unsplash.model;

import java.util.List;

public class UnsplashImage {
	
	public String id;
	
	public String createdAt;
	
	public String updatedAt;
	
	public int width;
	
	public int height;
	
	public String color;
	
	public int downloads;
	
	public int likes;
	
	public String description;
	
	public UnsplashUser user;
	
	public UnsplashUrls urls;
	
	public List<UnsplashCategory> categories;
	
	public UnsplashLinks links;
	
	public UnsplashExif exif;
	
	public UnsplashLocation location;

}
