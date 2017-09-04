import java.lang.*;
import java.util.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
/**
 * 
 */
{
    private String tweetContent;    
    private int retweet;
    HashMap <String, tweet> tweetList = new HashMap<String, tweet>();  
    List<String> txt= new ArrayList<String>();
    
    /**
     * Constructor for objects of class tweet
     */
    public tweet(List<String> text)
    {
        txt = text;        
        this.retweet = retweet;        
    }

     public int getRetweet (){
        return this.retweet;
    }
    
     public void setRetweet (String c){
        this.retweet = Integer.parseInt(c);
    }
    
     public void setTweetContent (String c){
        this.tweetContent = c;
    }
    
     public String getTweetContent (){
        return this.tweetContent;
    }    
        
        public void getTweetData()
    {       
        String date = "";
        String tweetContent = "";        
        String rt= "";      
        String patternString1 = ".*\\[.*\\]\\s.*\\s\\d{0,}\\s\\d{0,}.*";    
        Pattern pattern = Pattern.compile(patternString1);
        String arr = ""; 
            for (int j = 0; j < txt.size(); j++){  
                Matcher matcher = pattern.matcher(txt.get(j));
                if(matcher.find()) {    
                    tweet t = new tweet(txt);                  
    
                    arr = matcher.group().split("\\]\\s")[1].trim(); 
                    arr.replace("]"," ");
                    String [] arr1 = arr.split(" "); 
                    tweetContent = arr.replace(arr1[arr1.length-2]+" "+arr1[arr1.length-1]," ").trim();                                                     
                    rt = arr1[arr1.length-1];             
                   
                    t.setRetweet(rt);
                    tweetList.put(tweetContent,t);
                }                     
            }                
    }
   
}    


