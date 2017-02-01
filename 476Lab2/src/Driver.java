/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author colleenrothe
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    private static ArrayList <String> pwd = new ArrayList<>();
    private static String regex="(^[a-zA-Z0-9].*):";


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        pwd.add("6f047ccaa1ed3e8e05cde1c7ebc7d958");
        pwd.add("275a5602cd91a468a0e10c226a03a39c");
        pwd.add("b4ba93170358df216e8648734ac2d539");
        pwd.add("dc1c6ca00763a1821c5af993e0b6f60a");
        pwd.add("8cd9f1b962128bd3d3ede2f5f101f4fc");
        pwd.add("554532464e066aba23aee72b95f18ba2");
  
        // TODO code application logic here
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("hashDictionary.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            
                
                
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
        
    }
}

    