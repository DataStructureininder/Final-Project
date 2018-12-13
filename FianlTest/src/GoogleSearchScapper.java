import java.io.IOException;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * [[SuppressWarningsSpartan]]
 * 
 */

public class GoogleSearchScapper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String encoding = "UTF-8";
		try {
			String searchText = sc.nextLine()+" 菜單";
			Document duckduckgo = Jsoup.connect("https://www.google.com/search?q=" +
					URLEncoder.encode(searchText, encoding)).userAgent("Mozilla/5.0").get();
			Elements searchResult = duckduckgo.getElementsByAttributeValue("class", "r");

			//Check if any results found
			if (searchResult.isEmpty()) {
				System.out.println("No results found");
				return;
			}
			
			ArrayList<String> tempResult = new ArrayList<>();
			searchResult.forEach(link->tempResult.add(link.toString()));
			for(String ele: tempResult) {
				if(ele.indexOf("http")!=-1) {
					ele = ele.substring(ele.indexOf("http"), ele.indexOf("&amp"));
					System.out.println(ele);
				}				
			}

			
		} catch (IOException e) {

			e.printStackTrace();

		}

//		sc.close();

	}
}
