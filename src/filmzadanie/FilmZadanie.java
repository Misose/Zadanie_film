/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filmzadanie;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author R7
 */
public class FilmZadanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        System.out.println("Current Date: " + Film.ft.format(new Date()));
        
        
        
        JSONObject obj = new JSONObject();
	obj.put("name", "mkyong.com");
	obj.put("age", new Integer(100));
 
	JSONArray list = new JSONArray();
	list.add("msg 1");
	list.add("msg 2");
	list.add("msg 3");
 
	obj.put("messages", list);
 
	try {
 
		FileWriter file = new FileWriter("c:\\test.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();
 
	} catch (IOException error) {
		error.printStackTrace();
	}
 
	System.out.print(obj);
        
        
        
        
        
        
        
        
        JSONParser parser = new JSONParser();
 
	try {
		Object obja = parser.parse(new FileReader("c:\\test.json"));
 
		JSONObject jsonObject = (JSONObject) obja;
 
		String name = (String) jsonObject.get("name");
		System.out.println(name);
 
		long age = (Long) jsonObject.get("age");
		System.out.println(age);
 
		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("messages");
		Iterator<String> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
        
        
        
        
        
        
        
 
        
        
        
        
    
    }
}
