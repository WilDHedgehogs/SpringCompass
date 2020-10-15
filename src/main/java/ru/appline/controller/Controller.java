package ru.appline.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compass;
import ru.appline.logic.CompassModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    private static final CompassModel compassModel = CompassModel.getInstance();

    @PostMapping(value = "/createCompass", consumes = "application/json", produces = "application/json")
    public JsonObject createCompass(@RequestBody JsonObject json) {

        JsonObject message = new JsonObject();

        //Проверка что на входе у нас 4 или 8 сторон.
        if (json.size() == 4 || json.size() == 8) {

            Map<String, String> degrees = new HashMap<>();

            degrees.put("North", json.get("North").getAsString());
            degrees.put("East", json.get("East").getAsString());
            degrees.put("South", json.get("South").getAsString());
            degrees.put("West", json.get("West").getAsString());

            //Проверка на расширенный компас
            if (json.has("North-East")) {

                degrees.put("North-East", json.get("North-East").getAsString());
                degrees.put("South-East", json.get("South-East").getAsString());
                degrees.put("South-West", json.get("South-West").getAsString());
                degrees.put("North-West", json.get("North-West").getAsString());

            }

            compassModel.setCompass(degrees);

            message.addProperty("message", "Установлено " + json.size() + " стороны света");

        } else {

            message.addProperty("message", "Не правильное количество сторон");

        }

        return message;

    }

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public JsonObject getSide(@RequestBody JsonObject json) {

        JsonObject message = new JsonObject();

        message.addProperty("Side:", compassModel.getSide(json.get("Degree").getAsInt()));

        return message;

    }

}
