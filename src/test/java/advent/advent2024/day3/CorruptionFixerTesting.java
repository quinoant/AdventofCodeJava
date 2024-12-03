package test.java.advent.advent2024.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import main.java.advent.advent2024.day3.CorruptionFixer;

public class CorruptionFixerTesting {

    @Test
    void initialization() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(true,false);
        assertNotNull(corr.file);
    }

    @Test
    void recieving() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(true,false);
        assertEquals(corr.sc.nextLine(), "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
    }

    @Test
    void MultiplicationFunctionality() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(true,false);
        assertEquals(60,corr.Multiplier("11,5 5,1".split(" ")));
    }

    @Test
    void NumberFinderFunctionality() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(true,false);
        assertEquals(161, corr.NumberFinder("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"));
    }

    @Test
    void BigTestOne() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(true,false);
        assertEquals(161,corr.AntiCorruptionCore());
    }

    @Test
    void PartOne() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(false,false);
        assertEquals(192767529,corr.AntiCorruptionCore());
    }

    @Test
    void PartTwo() throws FileNotFoundException{
        CorruptionFixer corr = new CorruptionFixer(false,true);
        assertEquals(104083373,corr.AntiCorruptionCore());
    }
}
