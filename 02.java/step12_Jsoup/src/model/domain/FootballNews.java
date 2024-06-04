package model.domain;

public class FootballNews {
	private String title;
	private String url;
	
	public FootballNews() {}
	public FootballNews(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "FootballNews [title=" + title + ", url=" + url + "]";
	}
}
