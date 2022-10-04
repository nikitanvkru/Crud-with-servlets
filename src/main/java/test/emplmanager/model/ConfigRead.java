package test.emplmanager.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class ConfigRead {
    public static ArrayList<String> getLst(){
        try{
            Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Никита\\IdeaProjects\\Testfor1\\config.json"));
            JSONObject jo = (JSONObject) obj;
            ArrayList<String> lst = new ArrayList<>();
            String driver = (String) jo.get("driver");
            String url = (String) jo.get("url");
            String user = (String) jo.get("user");
            String password = (String) jo.get("password");
            lst.add(driver);
            lst.add(url);
            lst.add(user);
            lst.add(password);
            return lst;
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }
}
