# Unsplash Java Client

A strongly-typed Java client for https://unsplash.com website.

API reference: https://unsplash.com/documentation

## Usage

```java
public static void main(String[] args) {
  UnsplashClient client = new UnsplashClient("your-client-id");
  client.setHttpService(new DefaultHttpServiceImpl());

  UnsplashImage[] images = client.getPhotos(1, 100, UnsplashSort.Latest);
  System.out.println("Found images: " + images.length);
}
```

## License

Apache Version 2.0
