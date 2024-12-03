package main.java.advent.advent2024.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorruptionFixer {
    public File file;
    public Scanner sc;
    public boolean partTwo;
    

    public CorruptionFixer(boolean test,boolean partTwoCheck) throws FileNotFoundException{
        if(test){
            this.file = new File("src/main/java/advent/advent2024/day3/test.txt");
        }else{
            this.file = new File("src/main/java/advent/advent2024/day3/input.txt");
        }
        this.partTwo = partTwoCheck;
        sc = new Scanner(file);
    }

    /*
     * Finds correctly formatted bits
     */
    public int NumberFinder(String lineToParse){
        StringBuilder total = new StringBuilder();
        if(partTwo){
            lineToParse = lineToParse.replaceAll("don't\\(\\).*?do\\(\\)","");
        }
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(lineToParse);
        while (matcher.find()) {
            // Append the matched substring to the total
            total.append(matcher.group()).append(";");
        }
        // Remove "mul(" and split the content
        String cleanedTotal = total.toString().replace("mul(", "").replace(")", "");
        String[] values = cleanedTotal.split(";");

        // Pass the values array to the Multiplier method
        return Multiplier(values);
    }

    /*
     * Calculates the result
     */
    public int Multiplier(String[] toMult){
        int total = 0;
        for(int i = 0; i < toMult.length; i++){
            String[] mult = toMult[i].split(",");
            total += Integer.parseInt(mult[0]) * Integer.parseInt(mult[1]);
        }
        return total;
    }

    /*
     * Runs everything
     */
    public int AntiCorruptionCore(){
        int finalScore = 0;
        String input = "";
        while(sc.hasNextLine()){
            input += sc.nextLine();
        }
        return NumberFinder(input);
    }
}
