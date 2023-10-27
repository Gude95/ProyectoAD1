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
    /*
    String jsonString = "{\"nombre\":\""+ nombre +"\",\"edad\":" + edad + "\",\"correo\":" + correo +"}";
    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

    System.out.println(jsonObject);
    */

    // Crear una instancia de Gson
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder = gsonBuilder.setPrettyPrinting();
    Gson gson = gsonBuilder.create();

    // Convertir el objeto Java a JSON
    try (FileWriter writer = new FileWriter(exportarJson)) {
        gson.toJson(user, writer);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
