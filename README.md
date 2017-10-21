# DeviantArt Java Client

A strongly-typed Java client for https://deviantart.com website.

## Usage

```java
public static void main(String[] args) {
  DeviantArtClient client = new DeviantArtClient();
  client.setHttpService(new DefaultHttpServiceImpl());

  List<DeviantArtImage> images = client.getImages(
  	DeviantArtCategory.DigitalArt,   // in the digital art section 
  	DeviantArtBoost.Popular,         // that are most popular
  	DeviantArtSort.Time,             // sort by newest first
  	DeviantArtType.Deviation,        // all deviations
  	null);
  
  System.out.println(images.size());
}
```

## License

Apache Version 2.0
