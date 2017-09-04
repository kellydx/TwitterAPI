import java.io.*;
import java.util.*;

/**
 * Driver to test methods perform the following:
 *	1)	The top n users who have tweeted the most related to the search string for the entire timeline 
 *	Write the ouput in the file "maxTweets.txt"
 *	2)	The top n users who have tweeted the most for every hour
 *		Write the ouput in the file "maxTweetperHour.txt"
 *  3)	The top n users who have the maximum followers
 *		Write the ouput in the file "maxFollowers.txt"
 *  4)	The top n tweets which have the maximum retweet count
 *		Write the ouput in the file "maxRetweets.txt"
 */
public class Driver{       
   	public static List<String> txt= new ArrayList<String>();  
    public static void main(String [] args)throws IOException {
     	List<String> postHour= new ArrayList<String>();		
      	try{
            FileInputStream fstream = new FileInputStream("noodle.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;             
            //read text line by line and replace " with space
            while ((strLine = br.readLine()) != null)   {                
                txt.add(strLine.replace("\""," ").trim());           
            }       
            in.close();        
        }    
        catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
      }      
    
	 System.out.println("Enter the number of record to be displayed: ");
		Scanner scanner = new Scanner(System. in); 
		int n = scanner.nextInt();
	UserListperHour h = new UserListperHour();
	  	h.maxTweetperHour(txt,n);
	}
}