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
    public void testInput() throws FileNotFoundException{
        CrosswordHelper ch = new CrosswordHelper(true);
        assertEquals(18,ch.XMASFinder());
    }
}
