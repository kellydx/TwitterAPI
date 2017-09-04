import java.util.*;

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
        
	}
}
