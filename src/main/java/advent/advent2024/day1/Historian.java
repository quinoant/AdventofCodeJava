package main.java.advent.advent2024.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Historian{
    public static void main(String args[])throws FileNotFoundException {
        File file = new File("/Users/quinoant/Downloads/AdventofCodeJava/src/main/java/advent/advent2024/day1/input.txt");
        Scanner sc = new Scanner(file);
        System.out.println(checker(sc));
    }

    public static Integer checker(Scanner sc){
        int listSize = 1000;
        int[] listOne = new int[listSize];
        int[] listTwo = new int[listSize];
        int i = 0;
        String[] currLine = new String[2];
        while(sc.hasNextLine()){
            currLine = sc.nextLine().split("   ");
            listOne[i] = Integer.parseInt(currLine[0]);
            listTwo[i] = Integer.parseInt(currLine[1]);
            //System.out.println(listOne[i] + " : " + listTwo[i]);
            i++;
        }
        // differenceCalc(listOne,listTwo,listSize);
        return simularityScore(listOne,listTwo,listSize);
    }

    public static Integer simularityScore(int[] listOne, int[] listTwo, int listSize){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int toReturn = 0;
        int currVal = 0;
        for(int i = 0; i < listSize; i++){
            map.compute(listTwo[i], (k, current) -> current == null ? 1 : current + 1);
            //System.out.println(listTwo[i] + " : " + map.get(listTwo[i]));
        }
        for(int i = 0; i < listSize; i++){
            toReturn += map.get(listOne[i]) != null ? map.get(listOne[i]) * listOne[i] : 0;
        }
        return toReturn;
    }

    public static Integer differenceCalc(int[] listOne, int[] listTwo, int listSize){
        Arrays.sort(listOne);
        Arrays.sort(listTwo);
        int toReturn = 0;
        for(int j = 0; j < listSize; j++){
            toReturn += Math.abs(listOne[j] - listTwo[j]);
        }
        return toReturn;
    }
}