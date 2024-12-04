package main.java.advent.advent2024.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrosswordHelper {
    public File file;
    public Scanner sc;
    public String day = "4";

    public CrosswordHelper(boolean test) throws FileNotFoundException{
        if(test){
            this.file = new File("src/main/java/advent/advent2024/day" + day + "/test.txt");
        }else{
            this.file = new File("src/main/java/advent/advent2024/day" + day + "/input.txt");
        }
        sc = new Scanner(file);
    }

    /*
     * Checks Horizontle
     */

    /*
     * Checks Verticle
     */

    /*
     * Checks Diagonal
     */

    /*
     * Runs everything runs the above 3 in situations where X or S are found in the correct area
     * Like if X is found in the top left corner I only want to check if it works to the right
     * down and right down diagonals
     */
    public int XMASFinder(){
        int total = 0;
        return total;
    }
}
