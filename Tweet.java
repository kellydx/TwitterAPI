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
public class Tweet
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
      public void maxRetweet(int n){
        
         try {
            FileWriter writer = new FileWriter("maxRetweet.txt", true);        
            List<Integer> retweetCount = new ArrayList<Integer>();     
            for (String key: tweetList.keySet()){
                retweetCount.add(tweetList.get(key).getRetweet());
                Collections.sort(retweetCount,Collections.reverseOrder());
            }
            List<String> list = new ArrayList<String>();
            writer.write("Top"+ n+" tweets have the most retweet\r\n");  
            for (int i=0; i<n; i++){                          
                for (String key : tweetList.keySet()) {                   
                    if ((tweetList.get(key)).getRetweet()== retweetCount.get(i)){   
                        if (list.size()>n-1) 
							break;    
						if (!list.contains(key))                    			
							list.add(key);	  
                     }            
                    }   
            }
            
            for (int i = 0; i < list.size(); i++) {					
					writer.write(list.get(i)+"    Retweeted " +retweetCount.get(i)+" times\r\n"); 				
			}
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}    

