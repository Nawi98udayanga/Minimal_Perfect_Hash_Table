import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        KeywordOddText objOne = new KeywordOddText();
        TestOddText objTwo = new TestOddText();
        System.out.println("Text File result: "+objOne.readKeywordOdd());
        System.out.println("Character Count: "+objOne.frequencies());
        System.out.println("word count for each: "+objOne.sumOfEachWord());
        System.out.println("Sorting result in descending order: "+objOne.sortingHashMap());
        System.out.println("Set the Character Count into zero: " + objOne.arrayListToZero());
        System.out.println("HASH TABLE: " + objOne.hashTable(objOne.sortingHashMap(),objOne.arrayListToZero()));

        long startTime = System.currentTimeMillis();
        objOne.readKeywordOdd();
        objOne.frequencies();
        objOne.sumOfEachWord();
        objOne.sumOfEachWord();
        objOne.sortingHashMap();
        objOne.arrayListToZero();
        objOne.hashTable(objOne.sortingHashMap(),objOne.arrayListToZero());

        //keywords count and statistic part
        HashMap<String, Integer> valueInsertHash = new HashMap<>(objOne.hashTable(objOne.sortingHashMap(), objOne.arrayListToZero()));
        HashMap<String, Integer>  hash2 = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>(objTwo.readTestOdd());
        int total = 0;


        for (String pas:valueInsertHash.keySet()) {
            hash2.put(pas,0);

        }
        for (String v:arr) {
            if (hash2.containsKey(v)){
                hash2.put(v,hash2.get(v)+1);
            }

        }
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        System.out.println("Total lines read: " + objTwo.lineCount());
        System.out.println("Total words read: " + objTwo.wordCount());
        for (String value: hash2.keySet()) {
            System.out.println(value+ " : " + hash2.get(value));
            total = total + hash2.get(value);

        }
        System.out.println("Total Keywords: " + total);
        System.out.println("Execution time: " + executeTime + " milliseconds");

    }
}
