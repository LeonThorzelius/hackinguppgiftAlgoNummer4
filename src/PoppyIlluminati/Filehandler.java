package PoppyIlluminati;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leho9818
 */
public class Filehandler {

    public ArrayList<Posts> readFromCsv() throws FileNotFoundException, IOException {
        ArrayList<Posts> postArray = new ArrayList<>();
        String line = "";
        String[] tmpArray;

        Scanner scanner = new Scanner(new File("impoppyJava.csv"));

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            tmpArray = line.split(";");
            if (tmpArray.length == 6) {
                Posts tmpPost = new Posts(tmpArray[0], tmpArray[1], tmpArray[2], tmpArray[3], tmpArray[4], tmpArray[5]);
                postArray.add(tmpPost);
            }
        }
        scanner.close();

        return postArray;
    }

}
