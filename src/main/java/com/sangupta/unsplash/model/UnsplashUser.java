/**
 *
 * unsplash-java-client: Java Client for Unsplash.com API
 * Copyright (c) 2017, Sandeep Gupta
 * 
 * https://sangupta.com/projects/unsplash-java-client
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.unsplash.model;

public class UnsplashUser {
	
	public String id;
	
	public String updatedAt;
	
	public String username;
	
	public String name;
	
	public String firstName;
	
	public String lastName;
	
	public String twitterUsername;
	
	public String portfolioUrl;
	
	public String bio;
	
	public String location;
	
	public int totalLikes;
	
	public int totalPhotos;
	
	public int totalCollections;
	
	public UnsplashThumbnails profileImage;

	public UnsplashLinks links;
	
}
