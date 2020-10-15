package ru.appline.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompassModel {

    private static final CompassModel instance = new CompassModel();
    private Compass compass;

    private CompassModel() {

        compass = new Compass();

    }

    public static CompassModel getInstance() {

        return instance;

    }

    public void setCompass(Map<String, String> degrees) {

        int lBorder;
        int rBorder;
        String borders;

        borders = degrees.get("North");
        lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
        rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
        Map<String, Integer> north = new HashMap<>();
        north.put("lBorder", lBorder);
        north.put("rBorder", rBorder);

        borders = degrees.get("East");
        lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
        rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
        Map<String, Integer> east = new HashMap<>();
        east.put("lBorder", lBorder);
        east.put("rBorder", rBorder);

        borders = degrees.get("South");
        lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
        rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
        Map<String, Integer> south = new HashMap<>();
        south.put("lBorder", lBorder);
        south.put("rBorder", rBorder);

        borders = degrees.get("West");
        lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
        rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
        Map<String, Integer> west = new HashMap<>();
        west.put("lBorder", lBorder);
        west.put("rBorder", rBorder);

        switch (degrees.size()) {

            case 4:

                compass = new Compass(north, east, south, west);
                break;

            case 8:

                borders = degrees.get("North-East");
                lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
                rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
                Map<String, Integer> northEast = new HashMap<>();
                northEast.put("lBorder", lBorder);
                northEast.put("rBorder", rBorder);

                borders = degrees.get("South-East");
                lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
                rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
                Map<String, Integer> southEast = new HashMap<>();
                southEast.put("lBorder", lBorder);
                southEast.put("rBorder", rBorder);

                borders = degrees.get("South-West");
                lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
                rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
                Map<String, Integer> southWest = new HashMap<>();
                southWest.put("lBorder", lBorder);
                southWest.put("rBorder", rBorder);

                borders = degrees.get("North-West");
                lBorder = Integer.parseInt(borders.substring(0, borders.indexOf("-")));
                rBorder = Integer.parseInt(borders.substring(borders.indexOf("-") + 1));
                Map<String, Integer> northWest = new HashMap<>();
                northWest.put("lBorder", lBorder);
                northWest.put("rBorder", rBorder);

                compass = new Compass(north, northEast, east, southEast, south, southWest, west, northWest);
                break;

            default:

                compass = null;
                break;

        }

    }

    public String getSide(int degree) {

        boolean isSideFound = false;
        String side = "Unknown";

        if (degree < 360 && degree >= 0) {

            for (Map<String, Integer> border : compass.getBorders()) {

                if (degree >= border.get("lBorder") && degree <= border.get("rBorder")) {

                    isSideFound = true;
                    side = compass.getSides().get(border.get("lBorder"));

                }

            }

            if (!isSideFound) {

                side = "North";

            }

        }

        return side;

    }

}
