
/**
 *
 * @author colleenrothe
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

//DICTIONARY FILE SHARED BY: YI XU
//MD5 research from: http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash/421696#421696
public class Driver {

    private static ArrayList<String> pwd = new ArrayList<>();              //holds the hashes to search for
    private static ArrayList<String> hashes = new ArrayList<>();           //holds the hashes to search for
    private static long startTime;                                          //start time

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        //start the timer
        startTime = System.currentTimeMillis();
        //add the passwords to the list
        pwd.add("6f047ccaa1ed3e8e05cde1c7ebc7d958");
        pwd.add("275a5602cd91a468a0e10c226a03a39c");
        pwd.add("b4ba93170358df216e8648734ac2d539");
        pwd.add("dc1c6ca00763a1821c5af993e0b6f60a");
        pwd.add("8cd9f1b962128bd3d3ede2f5f101f4fc");
        pwd.add("554532464e066aba23aee72b95f18ba2");

        BufferedReader reader = null;
        try {
            //read the file
            reader = new BufferedReader(new FileReader("passwords.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                //convert to the hash
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.reset();
                md.update(line.getBytes());
                byte[] digest = md.digest();
                BigInteger big = new BigInteger(1, digest);
                String hash = big.toString(16);

                //if the array of hashes we are looking for contains this hashed line...
                if (pwd.contains(hash)) {
                    //Found! end the timer
                    long endTime = System.currentTimeMillis();
                    //print out message
                    System.out.println("The password for hash value " + hash + " is " + line
                            + ", it takes the program " + (((double) endTime - startTime) / 1000) + " sec to recover this password");

                }

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
