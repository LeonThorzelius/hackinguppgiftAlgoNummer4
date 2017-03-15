package PoppyIlluminati;

import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author leho9818
 */
public class MainClass {
static ArrayList<Posts> postArray = new ArrayList<>();
static long startTime, stopTime, elapsedTime;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
       Filehandler fh = new Filehandler();
       Calculations c = new Calculations();
       TopSecretFolder ts = new TopSecretFolder();
     
       //startTime = System.nanoTime();                                         //tid
       postArray = fh.readFromCsv();
       c.getNumberOfPosts(postArray);
       c.getPostTypeNumbers(postArray);
       c.getMostSharedPost(postArray);
       c.getAvrageShares(postArray);
       c.getMostePostsedDate(postArray);
       c.mostUsedWord(postArray);
       c.getNumberOfChars(postArray);
       c.poppyMentionHerselfAndMore(postArray);
       //ts.superSecretOutPrint(); 
       //fixa så man kan se ur många ord hon har använt totalt.
       //stopTime = System.nanoTime();               
       //elapsedTime = stopTime - startTime;
       //System.out.println("det tog " + elapsedTime + " tidenheter");           //printar tiden
    }
  
    
}
