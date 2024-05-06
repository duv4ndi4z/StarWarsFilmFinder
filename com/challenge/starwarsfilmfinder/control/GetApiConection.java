package com.challenge.starwarsfilmfinder.control;

import com.challenge.starwarsfilmfinder.models.Film;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class GetApiConection {
    private Map<Integer, String> listURL;
    public GetApiConection() {
        listURL = new HashMap<>();
        listURL.put(1,"https://swapi.dev/api/films/1/");
        listURL.put(2,"https://swapi.dev/api/films/2/");
        listURL.put(3,"https://swapi.dev/api/films/3/");
        listURL.put(4,"https://swapi.dev/api/films/4/");
        listURL.put(5,"https://swapi.dev/api/films/5/");
        listURL.put(6,"https://swapi.dev/api/films/6/");
    }
    private String getUrl(int number){
        return listURL.get(number);
    }
    public Film Query(Integer number) {

        String url = getUrl(number);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocurrio un error al conectar con el API");
        }catch (Exception e){
            System.out.println("Error desconocido");
        }
        return new Gson().fromJson(response.body(), Film.class);

    }
}
