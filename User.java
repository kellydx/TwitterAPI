import java.lang.*;
import java.util.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class User
{
    private int count;
    private int followers;  
    HashMap <String, User> userList = new HashMap<String, User>();  
    List<String> txt= new ArrayList<String>();	
    tweet t = new tweet(txt); 

    public User(List<String> text)
    {
        txt = text;       
        this.count = count;
        this.followers = followers; 
    }
    
    public int getCount (){
        return this.count;
    }
    
    public void setCount(int c){
        this.count = c;
    }
    
   	public int getFollower (){
        return this.followers;
    }
    
     public void setFollower (String c){
        this.followers = Integer.parseInt(c);
    }    
    
    public void getData()
    {
        String name ="";  	     
        String patternString1 = ".*\\[.*\\]\\s.*\\s\\d{0,}\\s\\d{0,}.*";    
        Pattern pattern = Pattern.compile(patternString1);
        String arr = ""; 
        String flw = "";
            for (int j = 0; j < txt.size(); j++){  
                Matcher matcher = pattern.matcher(txt.get(j));
                if(matcher.find()) {
                    name = matcher.group().split("\\[")[0].trim();					  
                    if (userList.get(name) == null) {
                        User u = new User(txt);                    
                        u.setCount(1);
                        arr = matcher.group().split("\\]\\s")[1].trim();  
                        String [] arr1 = arr.split(" ");
                        flw = flw = arr1[arr1.length-2];
                        u.setFollower(flw); 
                        userList.put(name,u);						
                    } 
                    else if (userList.get(name).getCount() >= 1) {
                        userList.get(name).setCount(userList.get(name).getCount()+1);						
                    }                    
                }               
            }         
            
    }
    
       	
}
