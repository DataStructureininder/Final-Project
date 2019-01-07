import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputKeyword = sc.nextLine();
		SearchResult sr = new SearchResult(inputKeyword);
		sr.setResultURL();
		System.out.println(sr.retResult());
	}
}

