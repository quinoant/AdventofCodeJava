package main.java.advent.advent2024.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrosswordHelper {
    public static File file;
    public static Scanner sc;
    public static String day = "4";

    public CrosswordHelper(boolean test) throws FileNotFoundException{
        if(test){
            this.file = new File("src/main/java/advent/advent2024/day" + day + "/test.txt");
        }else{
            this.file = new File("src/main/java/advent/advent2024/day" + day + "/input.txt");
        }
        sc = new Scanner(file);
    }

    /*
     * Is it MAS or SAM?
     */
    public static int MASWordCheck(String wordOne, String wordTwo){
        if((wordOne.equals("MAS") || wordOne.equals("SAM")) &&
        (wordTwo.equals("MAS") || wordTwo.equals("SAM"))){
            return 1;
        }
        return 0;
    }

    /*
     * Checks All
     */
    public static int MASChecker(char[] inputArray,int lineLen){
        int total = 0;
        int height = inputArray.length/lineLen;
        
        for(int i = 0; i < inputArray.length; i++){
            char currLetter = inputArray[i];
            if(currLetter == 'A' && (i%lineLen) <= lineLen - 2 && (i%lineLen) >= 1 && i/lineLen >= 1 && i/lineLen <= height - 2){
                //Up Left to bottom right
                String wordOne =  inputArray[i - (lineLen + 1)] + "" + inputArray[i] + inputArray[i + (lineLen + 1)];
                //Bottom left to top right
                String wordTwo =  inputArray[i + (lineLen - 1)] + "" + inputArray[i] + inputArray[i - (lineLen - 1)];
                total += MASWordCheck(wordOne,wordTwo);
            }
        }
        return total;
    }

    /*
     * Is it XMAS or SAMX?
     */
    public static int XMASWordCheck(String word){
        if(word.equals("XMAS") || word.equals("SAMX")){
            return 1;
        }
        return 0;
    }
    /*
     * Checks All
     */
    public static int XMASChecker(char[] inputArray,int lineLen){
        int total = 0;
        int height = inputArray.length/lineLen;
        String word = "";
        for(int i = 0; i < inputArray.length; i++){
            char currLetter = inputArray[i];
            if(currLetter == 'X' || currLetter == 'S'){
                //Up Right - i >= 3*len and i%len <= len-4
                if(i >= 3*lineLen && (i%lineLen) <= lineLen - 4){
                    word = inputArray[i] + "" + inputArray[i - (lineLen - 1)] + inputArray[i - (2 * (lineLen - 1))] + inputArray[i - (3 * (lineLen - 1))];
                    total += XMASWordCheck(word);
                }
                //Right - i%len <= len-4
                if((i%lineLen) <= lineLen - 4){
                    word = inputArray[i] + "" + inputArray[i + 1] + inputArray[i + 2] + inputArray[i + 3];
                    total += XMASWordCheck(word);
                }
                //Down Right - i/lineLen <= height - 3 and i%len <= len-4
                if(i/lineLen < height - 3 && (i%lineLen) <= lineLen - 4){
                    word = inputArray[i] + "" + inputArray[i + (lineLen + 1)] + inputArray[i + (2 * (lineLen + 1))] + inputArray[i + (3 * (lineLen + 1))];
                    total += XMASWordCheck(word);
                }
                //Down - i/lineLen <= height - 3
                if(i/lineLen < height - 3){
                    word = inputArray[i] + "" + inputArray[i + lineLen] + inputArray[i + (2 * lineLen)] + inputArray[i + (3 * lineLen)];
                    total += XMASWordCheck(word);
                }
            }
        }
        return total;
    }
    

    public static int XMASFinder(boolean partTwo){
        String inputString = sc.nextLine();
        int lineLen = inputString.length();
        while(sc.hasNextLine()){
            inputString += sc.nextLine();
        }
        char[] inputArray = inputString.toCharArray();
        if(partTwo){
            return MASChecker(inputArray, lineLen);
        }
        return XMASChecker(inputArray,lineLen);
    }

    /*
     * Runs everything runs the above 3 in situations where X or S are found in the correct area
     * Like if X is found in the top left corner I only want to check if it works to the right
     * down and right down diagonals
     */
    public static void main(String args[])throws FileNotFoundException {
        file = new File("src/main/java/advent/advent2024/day" + day + "/test.txt");
        sc = new Scanner(file);
        String inputString = sc.nextLine();
        int lineLen = inputString.length();
        while(sc.hasNextLine()){
            inputString += sc.nextLine();
        }
        char[] inputArray = inputString.toCharArray();
        System.out.println(MASChecker(inputArray,lineLen));
    }
    // /*
    //  * Runs everything runs the above 3 in situations where X or S are found in the correct area
    //  * Like if X is found in the top left corner I only want to check if it works to the right
    //  * down and right down diagonals
    //  */
    // public int XMASFinder(){
    //     int total = 0;
    //     ArrayList<char[]> inputArray = new ArrayList<char[]>();
    //     while(sc.hasNextLine()){
    //         inputArray.add(sc.nextLine().toCharArray());
    //     }
    //     int lineLen = inputArray.get(0).length;
    //     for(int i = 0; i < inputArray.size(); i++){
    //         char[] currLine = inputArray.get(i);
    //         for(int j = 0; j < lineLen; j++){
    //             char currLetter = currLine[j];
    //             if(currLetter == 'X'){
    //                 //do all besides up, left, and the diagonal between them

    //             }else if(currLetter == 'S'){

    //             }
    //         }
    //     }
    //     return total;
    // }
}
