/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ola
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void searchWorks() {
        assertEquals(stats.search("Lemieux").getName(), "Lemieux"); 
    }
    
    @Test
    public void searchWorksWithNonExistentName() {
        assertEquals(stats.search("wrong"), null);
    }
    
    @Test
    public void teamReturnsCorrectPlayersOfATeam() {
        assertEquals(stats.team("EDM").get(0).getName(), "Semenko");
        assertEquals(stats.team("EDM").get(1).getName(), "Kurri");
        assertEquals(stats.team("EDM").get(2).getName(), "Gretzky");
    }
    
    @Test
    public void topScorersReturnsCorrectTopScorer() {
        assertEquals(stats.topScorers(3).get(0).getName(), "Gretzky");
    }
    
    @Test
    public void topScorersReturnsTheCorrectAmountOfPlayers() {
        assertEquals(stats.topScorers(3).size(), 4);
    }
}
