package WebsiteParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;




public class InspirationalQuotes { //Code From P10 example for APIS CPSC210 UBC

        StringBuilder sb;
        BufferedReader br = null;
//        "http://quotes.rest/qod.json?category=inspire"
  // "https://favqs.com/api/qotd"
 //"http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en"
public void inspiration() throws IOException, JSONException {
        try {
          System.setProperty("http.agent", "Mozilla/5.0");
            String theURL ="http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en" ; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }
            String jsonText = sb.toString(); //Adapted from code from StackOverflowUser Rolland ILLIG
            JSONObject json = new JSONObject(jsonText);


            System.out.println(json.get("quoteText")); //Adapted from code from StackOverflowUser Rolland ILLIG
            System.out.println(json.get("quoteAuthor"));


        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}
