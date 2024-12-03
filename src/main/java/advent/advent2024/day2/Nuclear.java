package main.java.advent.advent2024.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Nuclear {
    public File file;
    public Scanner sc;
    

    public Nuclear(boolean test) throws FileNotFoundException{
        if(test){
            this.file = new File("src/main/java/advent/advent2024/day2/test.txt");
        }else{
            this.file = new File("src/main/java/advent/advent2024/day2/input.txt");
        }
        sc = new Scanner(file);
    }
    
    public int SafteyCheck(String[] report, int skip){
        int currLevel = Integer.parseInt(report[0]);
        boolean up = (currLevel - (Integer.parseInt(report[1]))) < 0;
        int start = 1;
        if(skip == 1){
            currLevel = Integer.parseInt(report[1]);
            up = (currLevel - (Integer.parseInt(report[2]))) < 0;
            start = 2;
        }else if(skip == 2){
            currLevel = Integer.parseInt(report[0]);
            up = (currLevel - (Integer.parseInt(report[2]))) < 0;
            start = 2;
        }
        for(int i = start; i < report.length;i++){
            int diff = currLevel - Integer.parseInt(report[i]);
            if(up){
                if(diff < -3 || diff > -1 ){
                    return 0;
                }
            }else{
                if(diff < 1 || diff > 3){
                    return 0;
                }
            }
            currLevel = Integer.parseInt(report[i]);
        }
        return 1;
    }
    public int SafteyCheckWithDampner(String[] report){
        boolean damp = true;
        int currLevel = Integer.parseInt(report[0]);
        boolean up = (currLevel - (Integer.parseInt(report[1]))) < 0;
        for(int i = 1; i < report.length;i++){
            int diff = currLevel - Integer.parseInt(report[i]);
            if(up){
                if(diff < -3 || diff > -1 ){
                    if(damp){
                        damp = false;
                        continue;
                    }
                    if(SafteyCheck(report,1) == 1 || SafteyCheck(report,2) == 1){
                        return 1;
                    }
                    return 0;
                }
            }else{
                if(diff < 1 || diff > 3){
                    if(damp){
                        damp = false;
                        continue;
                    }
                    if(SafteyCheck(report,1) == 1 || SafteyCheck(report,2) == 1){
                        return 1;
                    }
                    return 0;
                }
            }
            currLevel = Integer.parseInt(report[i]);
        }
        return 1;
    }

    public int LevelCheck(boolean problemDampnerOn){
        int safe = 0;
        String[] report;
        while(sc.hasNextLine()){
            report = sc.nextLine().split(" ");
            if(problemDampnerOn){
                safe += SafteyCheckWithDampner(report);
            }else{
                safe += SafteyCheck(report,0);
            }
            
        }
        return safe;
    }

    
}
