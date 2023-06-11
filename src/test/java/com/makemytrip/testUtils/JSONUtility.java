package com.makemytrip.testUtils;

import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * 6/5/2023
 * 6:55 PM
 */
public class JSONUtility {
    private static String value;
    public static  String readJSON()throws Exception{
        JSONParser parser=new JSONParser();
        JSONObject config=(JSONObject) parser.parse (new FileReader ("src/test/resources/testData/"+"single.conf.json") );
        JSONObject envs=(JSONObject)config.get("environments");
        String username=(String)config.get ( "user" );
        System.out.println ( "username = " + username );
        
        System.out.println ( "envs = " + envs );


        return value;
    }

    public static void main(String[] args) throws Exception{
        System.out.println (readJSON ());
    }


}
