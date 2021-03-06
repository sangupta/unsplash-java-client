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
	
	public int views;
	
	public boolean likedByUser;
	
	public String description;
	
	public UnsplashUser user;
	
	public UnsplashUrls urls;
	
	public List<UnsplashCategory> categories;
	
	public UnsplashLinks links;
	
	public UnsplashExif exif;
	
	public UnsplashLocation location;
	
	public String getImageUrl() {
		if(this.urls == null) {
			return null;
		}
		
		return this.urls.raw;
	}

	@Override
	public int hashCode() {
		if(this.id == null) {
			return 0;
		}
		
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		if(this.id == null) {
			return false;
		}
		
		if(obj instanceof UnsplashImage) {
			UnsplashImage other = (UnsplashImage) obj;
			
			return this.id.equals(other.id);
		}
		
		if(obj instanceof String) {
			return this.id.equals(obj); 
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "UnsplashImage: " + this.getImageUrl();
	}
	
}
