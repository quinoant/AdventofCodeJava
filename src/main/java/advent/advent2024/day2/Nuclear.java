package main.java.advent.advent2024.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Nuclear {
    File file;
    Scanner sc;
    // public static void main(String args[])throws FileNotFoundException {
    //     String input = "/Users/quinoant/Downloads/AdventofCodeJava/src/main/java/advent/advent2024/day2/input.txt";
    //     String test = "/Users/quinoant/Downloads/AdventofCodeJava/src/main/java/advent/advent2024/day2/test.txt";
    //     File file = new File(input);
    //     Scanner sc = new Scanner(file);
    //     System.out.println("x");
    // }

    public Nuclear(boolean test) throws FileNotFoundException{
        if(test){
            this.file = new File("src/main/java/advent/advent2024/day2/test.txt");
        }else{
            this.file = new File("src/main/java/advent/advent2024/day2/input.txt");
        }
        sc = new Scanner(file);
    }

    
}
