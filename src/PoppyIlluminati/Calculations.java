package PoppyIlluminati;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author leho9818
 */
public class Calculations {

    private static final String name = "Poppy";

    /**
     * Räknar ut hur många posts det finns i arrayen
     *
     * @param postArray behöver en array med posts
     */
    public void getNumberOfPosts(ArrayList postArray) {
        System.out.println("1. Antal poster av " + name + ": " + (postArray.size()) + " st");
    }

    /**
     * Kollar hur många av varje typ posterna är
     *
     * @param inArray Behöver en array med posts
     */
    public void getPostTypeNumbers(ArrayList<Posts> inArray) {
        String tmpString = "";
        for (Posts posts : inArray) {
            tmpString += posts.getType() + ";";
        }
        Map tmpHash = getFullMap(tmpString);

        System.out.println("\n2. Foton: " + tmpHash.get("photo") + " st"
                + "\n   Video: " + tmpHash.get("video") + " st"
                + "\n   Status: " + tmpHash.get("status") + " st"
                + "\n   Länkar: " + tmpHash.get("link") + " st"
                + "\n   Event: " + tmpHash.get("event") + " st");

    }

    /**
     * Kollar vilken post som blivit delad mest
     *
     * @param inArray array med posts
     */
    public void getMostSharedPost(ArrayList<Posts> inArray) {
        Posts mosteShared = new Posts("1", "1", "1", "1", "1", "1");
        for (Posts posts : inArray) {
            if (posts.getShares().equalsIgnoreCase("")) {
                posts.setShares("0");
            }
            if (Integer.parseInt(posts.getShares()) > Integer.parseInt(mosteShared.getShares())) {
                mosteShared = posts;
            }

        }

        System.out.println("\n3. Posten med  ID: " + mosteShared.getObject_id() + " har flest shares."
                + "\n   Texten är: " + mosteShared.getMessage()
                + "\n   Typ: " + mosteShared.getType());
    }

    /**
     * Get avrage shars of of the posts
     *
     * @param inArray - array with posts
     */
    public void getAvrageShares(ArrayList<Posts> inArray) {
        int allShares = 0;
        for (Posts posts : inArray) {
            if (posts.getShares().equalsIgnoreCase("")) {
                posts.setShares("0");
            }
            allShares += Integer.parseInt(posts.getShares());

        }
        System.out.println("\n4. I genomsnitt har posterna " + (allShares / inArray.size()) + " st shares");
    }

    /**
     * get most used word
     *
     * @param inArray array with posts
     */
    public void mostUsedWord(ArrayList<Posts> inArray) {
        String kalle = "";
        for (Posts posts : inArray) {
            kalle += posts.getMessage() + " ";
        }
        Map tmpMap = getFullMap(kalle);
        Map.Entry<String, Long> mostUsed = getMostUsed(tmpMap);
        System.out.println("\n6. Ordet: " + mostUsed.getKey() + " förekommer " + mostUsed.getValue() + " gånger");

    }

    /**
     * checks how many chars is given
     *
     * @param inArray array with posts
     */
    public void getNumberOfChars(ArrayList<Posts> inArray) {
        String tmpString = "";

        for (Posts posts : inArray) {
            tmpString += posts.getMessage();

        }
        tmpString.toCharArray();
        System.out.println("\n7. Totalt har användaren skrivit " + tmpString.length() + " tecken");
    }

    /**
     * find when most posts were posted
     *
     * @param inArray array with posts
     */
    public void getMostePostsedDate(ArrayList<Posts> inArray) {
        String allDates = "";
        String[] tmpArray;
        for (Posts posts : inArray) {
            tmpArray = posts.getCreated_time().split("-");
            allDates += (tmpArray[0] + tmpArray[1] + ";");

        }
        Map tmpMap = getFullMap(allDates);
        Map.Entry<String, Long> mostUsed = getMostUsed(tmpMap);
        System.out.println("\n5. I " + getMounth(mostUsed.getKey()) + " " + getYear(mostUsed.getKey()) + " publicerades " + mostUsed.getValue() + " poster");

    }

    private String getYear(String inDate) {
        String returnYear = "";
        returnYear = inDate.substring(0, 4);
        return returnYear;
    }

    private String getMounth(String inDate) {
        String returnMounth = "";
        returnMounth = inDate.substring(4, 6);

        switch (Integer.parseInt(returnMounth)) {
            case 1:
                returnMounth = "Januari";
                break;
            case 2:
                returnMounth = "Februari";
                break;
            case 3:
                returnMounth = "Mars";
                break;
            case 4:
                returnMounth = "April";
                break;
            case 5:
                returnMounth = "Maj";
                break;
            case 6:
                returnMounth = "Juni";
                break;
            case 7:
                returnMounth = "Juli";
                break;
            case 8:
                returnMounth = "Augusti";
                break;
            case 9:
                returnMounth = "September";
                break;
            case 10:
                returnMounth = "October";
                break;
            case 11:
                returnMounth = "November";
                break;
            case 12:
                returnMounth = "December";
                break;
            default:
                returnMounth = "Invalid month";
                break;
        }
        return returnMounth;
    }

    /**
     * checks how many time name was mentiond how many words she used and how many of her posts had text
     *
     * @param inArray array with posts
     */
    public void poppyMentionHerselfAndMore(ArrayList<Posts> inArray) {
        String tmpString = "";
        int j = 0;
        for (Posts posts : inArray) {
            tmpString += posts.getMessage() + " ";
        }
        Map tmpHash = getFullMap(tmpString);
        for (Posts posts : inArray) {
            if (!posts.getMessage().equalsIgnoreCase("")) {
                j++;

            }

        }

        System.out.println("\n8. " + name + " har nämt sig själv " + tmpHash.get(name.toLowerCase()) + " gånger." + 
                           "\n   Totald  använde hon " + tmpHash.size() + " olika ord." +
                           "\n   Bara " + j + " av hennes poster hade någon text.");
    }

    private Map getFullMap(String inString) {
        Stream<String> stream = Stream.of(inString.toLowerCase().split("\\W+")).parallel();
        Map<String, Long> wordFreq = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        return wordFreq;
    }

    private Entry<String, Long> getMostUsed(Map<String, Long> inHash) {
        Map.Entry<String, Long> mostUsed = null;
        Boolean tmpBoolean = true;
        for (Map.Entry<String, Long> posts : inHash.entrySet()) {
            if (tmpBoolean) {
                mostUsed = posts;
                tmpBoolean = false;
            }
            if (mostUsed.getValue() < posts.getValue()) {
                mostUsed = posts;
            }

        }
        return mostUsed;
    }
}
