package com.sangupta.unsplash;

import com.sangupta.jerry.constants.HttpHeaderName;
import com.sangupta.jerry.http.WebRequest;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.http.service.HttpService;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.GsonUtils;
import com.sangupta.jerry.util.UriUtils;
import com.sangupta.unsplash.model.UnsplashImage;

public class UnsplashClient {
	
	protected String baseUrl = "https://api.unsplash.com";
	
	private HttpService httpService;
	
	private final String clientID;
	
	UnsplashClient(String clientID) {
		this.clientID = clientID;
	}
	
	public UnsplashImage[] getPhotos(int page, int perPage, UnsplashSort sort) {
		String url = UriUtils.addWebPaths(this.baseUrl, "/photos?page" + page + "&per_page=" + perPage + "&order_by=" + sort.toString().toLowerCase());
		return getJSON(url, UnsplashImage[].class);
	}

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
		
		return GsonUtils.getGson().fromJson(json, classOfT);
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
