package br.com.nevesfilms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class VideosController {

    @GetMapping(path = "/getVideos", produces = "application/json")
    public String getVideosList() throws Exception {

        URL url = new URL("https://api.vimeo.com/users/nevesfilms/videos -H \"Authorization: Bearer 1b85e889c8ad2d86c398bdae81d907e9");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestProperty("Authorization", "Bearer 1b85e889c8ad2d86c398bdae81d907e9");
        urlConnection.setRequestMethod("GET");

        urlConnection.setDoOutput(true);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();
        return content.toString();
    }
}
