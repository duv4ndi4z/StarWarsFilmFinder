package com.challenge.starwarsfilmfinder.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void saveJsonFile(Film film) throws IOException {
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = null;
        try {
            writer = new FileWriter(film.title() + ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.write(gson.toJson(film));
        writer.close();

    }
}
