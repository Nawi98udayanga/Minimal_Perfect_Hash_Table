import java.io.*;
import java.util.*;

public class TestOddText {
    int variableOne=0;
    int variableTwo = 0;
    //reading the text file and return it to array list
    public ArrayList<String> readTestOdd(){
        //create testOdd List object
        ArrayList<String> testOdd = new ArrayList<>();
        ArrayList<String> testOddHash = new ArrayList<>();

        try {
            FileReader fr = new FileReader("D:\\Users\\Ruwanpura Suranga\\Desktop\\LEVEL 4\\Courses\\Compulsory Courses\\EEX4465-Data structures and algorithms\\EEX4465- MINI PROJECT\\Nawam\\src\\tstOdd.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ( (line = br.readLine()) != null) {
                line = line.replaceAll("[(,.?)]", "")
                        .replaceAll("\\d+", "")
                        .replaceAll("-", ",")
                        .replaceAll("=", "")
                        .replaceAll("\n","");
                testOdd.add(line);
            }
            br.close();
            variableOne = testOdd.size();
            for (String value : testOdd) {
                ArrayList<String> array2 = new ArrayList<>(Arrays.asList(value.split(" ")));
                for (String variableThree : array2) {
                    variableTwo++;
                    testOddHash.add(variableThree);
                }
            }

        }catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return testOddHash;
    }

    public int wordCount(){
        return variableTwo;
    }
    public int lineCount(){
        return variableOne;
    }



}
