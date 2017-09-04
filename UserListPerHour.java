import java.lang.*;
import java.util.*; 
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserListperHour
{
    private int count;
    private String name;
 	List<String> txt= new ArrayList<String>();  
    List<String> hours= new ArrayList<String>();      
    HashMap <String, Integer> users= new HashMap <String, Integer>();  
	     
    public void maxTweetperHour(List<String> txt, int n)  {
		try {                          
			String name = "";     
        	String hour = "";       
        	String patternString1 = ".*\\[.*\\]\\s.*\\s\\d{0,}\\s\\d{0,}.*";    
        	Pattern pattern = Pattern.compile(patternString1);       
			
            for (int j = 0; j < txt.size(); j++){  
                Matcher matcher = pattern.matcher(txt.get(j));
                if(matcher.find()) {                    
                    hour = matcher.group().split("\\[")[1].split("\\:")[0].trim()+":"+matcher.group().split("\\[")[1].split("\\:")[1].trim();
					if (!hours.contains(hour)){					
						hours.add(hour);
					}
				}			
			}
						
			for (int x = 0; x < hours.size(); x++){				
				users.clear();
				for (int i = 0; i < txt.size(); i++){  
					Matcher matcher = pattern.matcher(txt.get(i));
					if(matcher.find()) { 
						if (txt.get(i).contains(hours.get(x))){
               				name = matcher.group().split("\\[")[0].trim(); 
							if (users.get(name) == null){
								users.put(name,1);
							}
							else{
								users.put(name, users.get(name)+1);
               				}	
						}
					}
				}				
        	} 			
        } 
	catch (IOException e) {
            e.printStackTrace();
		}
	}
}
	

