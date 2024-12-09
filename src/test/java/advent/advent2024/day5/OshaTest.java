package test.java.advent.advent2024.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import main.java.advent.advent2024.day5.Osha;


public class OshaTest {
    @Test
    void initialization() throws FileNotFoundException{
        Osha osha = new Osha(true);
        assertNotNull(osha.file);
    }

    @Test
    void recieving() throws FileNotFoundException{
        Osha osha = new Osha(true);
        assertEquals(osha.sc.nextLine(), "47|53");
    }
}
