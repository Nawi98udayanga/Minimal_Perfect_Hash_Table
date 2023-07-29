import java.io.*;
import java.util.*;

public class KeywordOddText {

    //reading the text file and return it to array list
    public ArrayList<String> readKeywordOdd(){
        //create read List object
        ArrayList<String> read = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\Users\\Ruwanpura Suranga\\Desktop\\LEVEL 4\\Courses\\Compulsory Courses\\EEX4465-Data structures and algorithms\\EEX4465- MINI PROJECT\\Nawam\\src\\kywrdsOdd.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ( (line = br.readLine()) != null) {
                //System.out.println(line);
                read.add(line);
            }
            br.close();
        }catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return read;
    }

    //find the frequencies of the first and last letter of each word to find
    //get the frequency of the current character
    public HashMap<Character,Integer> frequencies(){

        //return the  ArrayList<String> to the read array from the textRead()
        ArrayList<String> arrayFreq = readKeywordOdd();

        //look the count of each character
        //create a new Hash map
        HashMap<Character,Integer> frequency = new HashMap<>();

        for (String b : arrayFreq) {
            //firstly  get the character in the 0th position in arrayFreq to the b
            int c = 0;
            while (c < b.length()) {
                if (c == 0) {
                    if (!frequency.containsKey(b.charAt(c))) {
                        frequency.put(b.charAt(c), 1);
                    } else {
                        int d = frequency.get(b.charAt(c));
                        d++;
                        frequency.put(b.charAt(c), d);
                    }
                } else if (c == b.length() - 1) {
                    if (!frequency.containsKey(b.charAt(c))) {
                        frequency.put(b.charAt(c), 1);
                    } else {
                        int e = frequency.get(b.charAt(c));
                        e++;
                        frequency.put(b.charAt(c), e);
                    }
                }
                c++;
            }
        }
        return frequency;

    }

    //find the sum of the first and last letter of each word
    //combine each frequency of character to each word
    public HashMap<String,Integer> sumOfEachWord(){


        ArrayList<String> array3 = readKeywordOdd();
        //passing the previous hashmap
        HashMap<Character,Integer> frequencyPasser = frequencies();
        HashMap<String,Integer> wordCombinerHashMap = new HashMap<>();


        for (String word : array3) {
            int g = frequencyPasser.get(word.charAt(0)) + frequencyPasser.get(word.charAt(word.length() - 1));
            wordCombinerHashMap.put(word, g);

        }
        return wordCombinerHashMap;

    }

    //Sorting the keywords in hashtable decreasing frequency yields
    public HashMap<String, Integer> sortingHashMap(){
        HashMap<String, Integer> unSortedHashMap = sumOfEachWord();
        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        unSortedHashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedHashMap.put(x.getKey(), x.getValue()));
        return sortedHashMap;
    }

    //Change the arraylist values into zero
    public HashMap<Character, Integer> arrayListToZero(){

        HashMap<Character, Integer> zeroHash = frequencies();
        zeroHash.replaceAll((key, value) -> 0);
        return zeroHash;

    }




        public int indicateHashTable(String word, HashMap<Character, Integer> wordValue, int size, String[] anArray, String[] strings) {


        int length = word.length();
        int gValueFirst = wordValue.get(word.charAt(0));
        int gLastValue = wordValue.get(word.charAt(word.length() - 1));
        int tableValueOne = (length + gValueFirst + gLastValue) % size;

        if (anArray[tableValueOne] != null && gValueFirst <= 4){
            wordValue.put(word.charAt(0), gValueFirst + 1);
            tableValueOne = indicateHashTable(word, wordValue, size, anArray, strings);
        }

        else if (anArray[tableValueOne] != null && gValueFirst > 4) {
            int prevIndex = (Arrays.asList(strings).indexOf(word)) - 1;
            try {
                String prevElement = strings[prevIndex];
                wordValue.put(prevElement.charAt(0), gValueFirst + 1);
                tableValueOne = indicateHashTable(prevElement, wordValue, size, anArray, strings);
                anArray[tableValueOne] = prevElement;
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }
        return tableValueOne;
    }

    //Generate the hash table
    public Hashtable<String, Integer> hashTable(HashMap<String, Integer> sortedWords, HashMap<Character, Integer> wordValue){

        int wordSize = sortedWords.size();
        String[] anArray = new String[wordSize];
        int tableValueTwo = 0;
        Hashtable<String, Integer> hashTableOfMinimal = new Hashtable<>();
        String[] strings = sortedWords.keySet().toArray(new String[0]);

        for (String word : sortedWords.keySet()) {
            tableValueTwo = indicateHashTable(word, wordValue, wordSize, anArray, strings);
            anArray[tableValueTwo] = word;
        }

        for (int i = 0; i < anArray.length; i++) {
            hashTableOfMinimal.put(anArray[i], i);
        }
        return hashTableOfMinimal;
    }

}
