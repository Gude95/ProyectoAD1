package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {
public void exportarJSON(File exportarJson, User user){

    String userString = "{\"nombre\":\""+ user.getName() +"\",\"edad\":" + user.getAge() + ",\"correo\":" + user.getEmail() +"}";
    JsonObject userObject = JsonParser.parseString(userString).getAsJsonObject();

    // Crear una instancia de Gson
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder = gsonBuilder.setPrettyPrinting();
    Gson gson = gsonBuilder.create();

    // Convertir el objeto Java a JSON
    try (FileWriter writer = new FileWriter(exportarJson)) {
        gson.toJson(userObject, writer);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void exportarJSONAdmin(File exportarJson, Users users){

    for (User user: users.getUsers().values()) {

        String userString = "{\"nombre\":\"" + user.getName() + "\",\"edad\":" + user.getAge() + ",\"correo\":" + user.getEmail() + "}";
        JsonObject userObject = JsonParser.parseString(userString).getAsJsonObject();

        // Crear una instancia de Gson
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder = gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        // Convertir el objeto Java a JSON
        try (FileWriter writer = new FileWriter(exportarJson, true)) {
            gson.toJson(userObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
