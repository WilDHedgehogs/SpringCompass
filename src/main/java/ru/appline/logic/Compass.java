package ru.appline.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compass {

    //lBorder, 316
    //rBorder, 45
    private Map<String, Integer> north;
    private Map<String, Integer> northEast;
    private Map<String, Integer> east;
    private Map<String, Integer> southEast;
    private Map<String, Integer> south;
    private Map<String, Integer> southWest;
    private Map<String, Integer> west;
    private Map<String, Integer> northWest;
    private List<Map<String, Integer>> borders;
    private Map<Integer, String> sides;

    public Compass() {
    }

    public Compass(Map<String, Integer> north, Map<String, Integer> east, Map<String, Integer> south, Map<String, Integer> west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;

        borders = new ArrayList<>();
        sides = new HashMap<>();

        //Заполнение границ и наименования сторон
        borders.add(north);
        sides.put(north.get("lBorder"), "North");
        borders.add(east);
        sides.put(east.get("lBorder"), "East");
        borders.add(south);
        sides.put(south.get("lBorder"), "South");
        borders.add(west);
        sides.put(west.get("lBorder"), "West");

    }

    public Compass(Map<String, Integer> north, Map<String, Integer> northEast, Map<String, Integer> east, Map<String, Integer> southEast, Map<String, Integer> south, Map<String, Integer> southWest, Map<String, Integer> west, Map<String, Integer> northWest) {

        this(north, east, south, west);

        borders.add(northEast);
        sides.put(northEast.get("lBorder"), "North-East");
        borders.add(southEast);
        sides.put(southEast.get("lBorder"), "South-East");
        borders.add(southWest);
        sides.put(southWest.get("lBorder"), "South-West");
        borders.add(northWest);
        sides.put(northWest.get("lBorder"), "North-West");

    }

    public Map<String, Integer> getNorth() {
        return north;
    }

    public Map<String, Integer> getNorthEast() {
        return northEast;
    }

    public Map<String, Integer> getEast() {
        return east;
    }

    public Map<String, Integer> getSouthEast() {
        return southEast;
    }

    public Map<String, Integer> getSouth() {
        return south;
    }

    public Map<String, Integer> getSouthWest() {
        return southWest;
    }

    public Map<String, Integer> getWest() {
        return west;
    }

    public Map<String, Integer> getNorthWest() {
        return northWest;
    }

    public void setNorth(Map<String, Integer> north) {
        this.north = north;
    }

    public void setNorthEast(Map<String, Integer> northEast) {
        this.northEast = northEast;
    }

    public void setEast(Map<String, Integer> east) {
        this.east = east;
    }

    public void setSouthEast(Map<String, Integer> southEast) {
        this.southEast = southEast;
    }

    public void setSouth(Map<String, Integer> south) {
        this.south = south;
    }

    public void setSouthWest(Map<String, Integer> southWest) {
        this.southWest = southWest;
    }

    public void setWest(Map<String, Integer> west) {
        this.west = west;
    }

    public void setNorthWest(Map<String, Integer> northWest) {
        this.northWest = northWest;
    }

    public List<Map<String, Integer>> getBorders() {
        return borders;
    }

    public Map<Integer, String> getSides() {
        return sides;
    }

}
