package mobileclass.kylesblogviewer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Kyle on 9/2/2015.
 */
public class HttpGet {
    private String pagina = "", devuelve = "";
    private JSONArray jsonArray;
    private ArrayList<JSONObject> joAry= new ArrayList<>();
    private ArrayList<BlogPost> blogPostArray = new ArrayList<>();

    public HttpGet(String url) {
        getContextWeb(url);
    }

    public ArrayList<BlogPost> getBlogPostArray() {
        return blogPostArray;
    }

    public void getContextWeb(String urlS) {
        URL url;
        try {
            url = new URL(urlS);
            HttpURLConnection conexion = (HttpURLConnection) url
                    .openConnection();
            conexion.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    pagina += linea;
                    linea = reader.readLine();
                }
                reader.close();

                devuelve = pagina;
            } else {
                conexion.disconnect();
            }
            conexion.disconnect();

            jsonArray  = new JSONArray(devuelve); // json
            for (int i = 0; i < jsonArray.length(); i++) {
                blogPostArray.add(new BlogPost(
                        Integer.parseInt(jsonArray.getJSONObject(i).getString("id")),
                        jsonArray.getJSONObject(i).getString("title"),
                        jsonArray.getJSONObject(i).getString("subTitle"),
                        jsonArray.getJSONObject(i).getString("date"),
                        jsonArray.getJSONObject(i).getString("image"),
                        jsonArray.getJSONObject(i).getString("postBody")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
