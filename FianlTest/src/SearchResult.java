import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SearchResult {
	private String searchText = "菜單 ";
	private ArrayList<URL> legalURL = new ArrayList<>();

	private void setText(String searchtext) {
		this.searchText += searchtext;
	}


	public void setResultURL() {
		String encoding = "UTF-8";
		try {
			Document duckduckgo = Jsoup.connect("https://www.google.com/search?q=" + 
					URLEncoder.encode(searchText, encoding)).userAgent("Mozilla/5.0").get();
			Elements searchResult = duckduckgo.getElementsByAttributeValue("class", "r");

			// Check if any results found
			if (searchResult.isEmpty()) {
				System.out.println("No results found");
				return;
			}

			ArrayList<String> tempResult = new ArrayList<>();
			searchResult.forEach(link -> tempResult.add(link.toString()));
			for (String ele : tempResult) {
				if(ele.indexOf("http")!=-1) {
					ele = ele.substring(ele.indexOf("http"), ele.indexOf("&amp"));
					legalURL.add(new URL(ele));
				}	
			}
		

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String searchText = sc.nextLine();
		SearchResult sr = new SearchResult();
		sr.setText(searchText);
		sr.setResultURL();

	}
}
