/**
 *
 * @author colleenrothe
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//DICTIONARY FILE SHARED BY: YI XU

public class Driver {
    private static ArrayList <String> pwd = new ArrayList<>();              //holds the hashes to search for
    private static String [] hashes;                                        //holds the dictionary 
    private static long startTime;                                          //start time

    public static void main(String[] args) throws IOException {
        startTime = System.currentTimeMillis();                             //start the timer
        //add the passwords to the list, upper case because our dictionary file is in all uppercase
        pwd.add("6f047ccaa1ed3e8e05cde1c7ebc7d958".toUpperCase());
        pwd.add("275a5602cd91a468a0e10c226a03a39c".toUpperCase());
        pwd.add("b4ba93170358df216e8648734ac2d539".toUpperCase());
        pwd.add("dc1c6ca00763a1821c5af993e0b6f60a".toUpperCase());
        pwd.add("8cd9f1b962128bd3d3ede2f5f101f4fc".toUpperCase());
        pwd.add("554532464e066aba23aee72b95f18ba2".toUpperCase());
  
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("hashDictionary.txt"));//read the file
            String line;
            while ((line = reader.readLine()) != null) {
                hashes = line.split(" ");                                     //file is split by spaces
                
            }
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            test();                                                 

    }
    
    //helper method to search for hashes in the file
    public static void test(){
        for(int i = 0; i<hashes.length; i++){
            if(pwd.contains(hashes[i])){                                    //if hash is found in the file,
                long endTime = System.currentTimeMillis();                  //stop timer...found
                System.out.println("The password for hash value "+hashes[i].toLowerCase()+" is "+hashes[i-1]+
                        ", it takes the program "+(((double)endTime-startTime)/1000)+" sec to recover this password");
            }
        }
    }
}

    