package week05$arraylists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ReverseWordsTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t  R  E  V  E  R  S  E    F  I  L  E    T  E  S  T");
        System.out.println(" \t \t      T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
    }

    public static void read(String inputLocation, List<String> list) throws FileNotFoundException{
        //TODO: READ IN DATA FROM INPUT FILE LOCATION
        File    file        = new File(inputLocation);
        Scanner scanner     = new Scanner(file);

        //TODO: REVERSE LINES
        //TODO: REVERSE WORDS
        // Loop through each line in the input file
        while(scanner.hasNextLine()){
            // Read the current line from the input file
            String line = scanner.nextLine();

            // Split the line into individual words
            String[] words = line.split(" ");

            // Use a StringBuilder to construct a new string with the words in reverse order
            StringBuilder sb = new StringBuilder();
            for(int i=words.length-1; i>=0; i--){
                sb.append(words[i]).append(" ");
            }

            // Remove the trailing space from the reversed line
            String reversedLine = sb.toString().trim();

            // Add the reversed line to the list
            list.add(reversedLine);
        }

        scanner.close();
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{
        //TODO : WRITE TO OUTPUT FILE LOCATION
        PrintStream writer  = new PrintStream(outputLocation);

        writer.close();
    }


    public static void main(String[] args) throws FileNotFoundException{
        String inputLocation    = "." + File.separator + "data"
                + File.separator + "words.txt";

        String outputLocation   = "." + File.separator + "results"
                + File.separator + "reverse_words.txt";

        //TODO: update program to use an Array List
        //TODO: process items in file

    }
}
