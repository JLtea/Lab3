import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int wordCount(final String text, final String keyword) {
        String lower = text.toLowerCase();
        String[] newText = lower.split("\\n\\s+");
        int count = 0;
        for (int i = 0; i < newText.length; i++) {
            if (newText[i].contains(keyword)) {
                count++;
            }
        }
        return count;
    }

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        String hamlet = WebScraper.urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(hamlet, "prince"));
    }
}
