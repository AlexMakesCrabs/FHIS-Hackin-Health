package org.example;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.c
public class Main {
    public static void main(String[] args) throws Exception{

    Object obj = new JSONParser().parse(new FileReader("output.json"));

    JSONObject json = (JSONObject) obj;


    JSONArray get = (JSONArray) json.get("");




    System.out.println(get.toJSONString());


    }
}