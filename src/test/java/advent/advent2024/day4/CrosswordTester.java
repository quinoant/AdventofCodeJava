package test.java.advent.advent2024.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import main.java.advent.advent2024.day4.CrosswordHelper;
public class CrosswordTester {

    @Test
    void initialization() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(true);
        assertNotNull(ch.file);
    }

    @Test
    void recieving() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(true);
        assertEquals(ch.sc.nextLine(), "MMMSXXMASM");
    }

    @Test
    public void wordchek() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(true);
        assertEquals(1,ch.XMASWordCheck("XMAS"));
        assertEquals(1,ch.XMASWordCheck("SAMX"));
        assertEquals(0,ch.XMASWordCheck("HOLI"));
    }

    @Test
    public void testInput() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(true);
        assertEquals(18,ch.XMASFinder(false));
    }

    @Test
    public void testRealInput() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(false);
        assertEquals(2613,ch.XMASFinder(false));
    }

    @Test
    public void testTestOnMAS() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(true);
        assertEquals(9,ch.XMASFinder(true));
    }

    @Test
    public void testRealOnMAS() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(false);
        assertEquals(1905,ch.XMASFinder(true));
    }
}
