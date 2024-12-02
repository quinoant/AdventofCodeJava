package test.java.advent.advent2024.day2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import main.java.advent.advent2024.day2.Nuclear;

public class NuclearTester {
    @Test
    void initialization() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(true);
        assertNotNull(nuclear.file);
    }

    @Test
    void recieving() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(true);
        assertEquals(nuclear.sc.nextLine(), "7 6 4 2 1");
    }
    @Test
    void testReport() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(true);
        //String[] safe = "7 6 4 2 1".split(" ");
        String[] safeTwo = {"7","6","4","2","1"};
        //String[] unsafe = "1 2 7 8 9".split(" ");

        assertEquals(1,nuclear.SafteyCheck(safeTwo));
        //assertEquals(0,nuclear.safteyCheck(unsafe));
    }

    @Test
    void testReportWithDampner() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(true);
        String[] safe = {"2","6","5","6"};
        assertEquals(1,nuclear.SafteyCheckWithDampner(safe));
        //assertEquals(0,nuclear.safteyCheck(unsafe));
    }

    @Test
    void testTestData() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(true);
        assertEquals(2,nuclear.LevelCheck(false));
        //assertEquals(0,nuclear.safteyCheck(unsafe));
    }

    @Test
    void testTestDataWithDampner() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(true);
        assertEquals(4,nuclear.LevelCheck(true));
        //assertEquals(0,nuclear.safteyCheck(unsafe));
    }

    @Test
    void testInputData() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(false);
        assertEquals(359,nuclear.LevelCheck(false));
        //assertEquals(0,nuclear.safteyCheck(unsafe));
    }

    @Test
    void testInputDataWithDampner() throws FileNotFoundException{
        Nuclear nuclear = new Nuclear(false);
        assertEquals(359,nuclear.LevelCheck(true));
        //assertEquals(0,nuclear.safteyCheck(unsafe));
    }
}
