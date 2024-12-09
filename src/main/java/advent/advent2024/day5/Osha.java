package main.java.advent.advent2024.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Osha{
    public File file;
    public Scanner sc;
    public String day = "5";

    public Osha(boolean test) throws FileNotFoundException{
        if(test){
            this.file = new File("src/main/java/advent/advent2024/day" + day + "/test.txt");
        }else{
            this.file = new File("src/main/java/advent/advent2024/day" + day + "/input.txt");
        }
        sc = new Scanner(file);
    }

    public static void main(String args[]) throws FileNotFoundException {
        Osha osha = new Osha(true);
    }
}