package com.sangupta.unsplash;

import com.google.gson.FieldNamingPolicy;
import com.sangupta.jerry.constants.HttpHeaderName;
import com.sangupta.jerry.http.WebRequest;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.http.service.HttpService;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.GsonUtils;
import com.sangupta.jerry.util.UriUtils;
import com.sangupta.unsplash.model.UnsplashImage;

public class UnsplashClient {
	
	/**
	 * Base URL for the API
	 */
	protected String baseUrl = "https://api.unsplash.com";
	
	/**
	 * {@link HttpService} to use
	 */
	private HttpService httpService;
	
	/**
	 * The clientID
	 */
	private final String clientID;
	
	/**
	 * Constructor
	 * 
	 * @param clientID the client ID to use. Cannot be <code>null</code>
	 */
	UnsplashClient(String clientID) {
		if(AssertUtils.isEmpty(clientID)) {
			throw new IllegalArgumentException("ClientID cannot be null/empty");
		}
		
		this.clientID = clientID;
	}
	
	/**
	 * Get photos from the site.
	 * 
	 * @param page
	 * @param perPage
	 * @param sort
	 * @return
	 */
	public UnsplashImage[] getPhotos(int page, int perPage, UnsplashSort sort) {
		String url = UriUtils.addWebPaths(this.baseUrl, "/photos?page" + page + "&per_page=" + perPage + "&order_by=" + sort.toString().toLowerCase());
		return getJSON(url, UnsplashImage[].class);
	}
	
	/**
	 * Find all curated photos.
	 * 
	 * @param page
	 * @param perPage
	 * @param sort
	 * @return
	 */
	public UnsplashImage[] getCuratedPhotos(int page, int perPage, UnsplashSort sort) {
		String url = UriUtils.addWebPaths(this.baseUrl, "/photos/curated?page" + page + "&per_page=" + perPage + "&order_by=" + sort.toString().toLowerCase());
		return getJSON(url, UnsplashImage[].class);
	}
	
	/**
	 * Get details of a given photo.
	 * 
	 * @param photoID
	 * @return
	 */
	public UnsplashImage getPhoto(String photoID) {
		String url = UriUtils.addWebPaths(this.baseUrl, "/photos/" + photoID);
		return getJSON(url, UnsplashImage.class);
	}
	
	public UnsplashImage getPhoto(String photoID, int width, int height, int[] rect) {
		String url = UriUtils.addWebPaths(this.baseUrl, "/photos/" + photoID);
		
		boolean added = false;
		if(width > 0) {
			added = true;
			url = url + "?w=" + width;
		}
		
		if(height > 0) {
			url = url + (added ? "&" : "?");
			url = url + "h=" + height;
			added = true;
		}
		
		if(AssertUtils.isNotEmpty(rect) || rect.length == 4) {
			url = url + (added ? "&" : "?");
			url = "rect=" + rect[0] + "," + rect[1] + "," + rect[2] + "," + rect[3];
		}
		
		return getJSON(url, UnsplashImage.class);
	}

	/**
	 * Hit the given URL as a HTTP GET request and parse the JSON response
	 * into the provided strongly typed object.
	 * 
	 * @param url
	 * @param classOfT
	 * @return
	 */
	private <T> T getJSON(String url, Class<T> classOfT) {
		WebRequest request = WebRequest.get(url);
		request.addHeader(HttpHeaderName.AUTHORIZATION, "Client-ID " + this.clientID);
		
		WebResponse response = this.httpService.executeSilently(request);
		if(response == null) {
			return null;
		}
		
		if(!response.isSuccess()) {
			return null;
		}
		
		String json = response.getContent();
		if(AssertUtils.isEmpty(json)) {
			return null;
		}
		
		return GsonUtils.getGson(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).fromJson(json, classOfT);
	}
	
	// Usual accessors follow

	/**
	 * @return the httpService
	 */
	public HttpService getHttpService() {
		return httpService;
	}

	/**
	 * @param httpService the httpService to set
	 */
	public void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}

}
