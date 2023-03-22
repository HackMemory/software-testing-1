package task3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainModelTest {
    static Creature[] creatures;
    static Universe[] universes;

    static Game game;
    static Debate debate;
    static SolvingProblem solvingProblem;

    @BeforeAll
    public static void createAll() {
        universes = new Universe[]{
                new Universe("test_uni1", 3),
                new Universe("test_uni2", 4)
        };

        creatures = new Creature[]{
                new Creature("test_cre1", "race1", universes[0]),
                new Creature("test_cre2", "race1", universes[0]),
                new Creature("test_cre3", "race2", universes[1]),
                new Creature("test_cre4", "race2", universes[1]),
        };

        game = new Game("cricket");
        debate = new Debate("ecology");
        solvingProblem = new SolvingProblem("life");
    }

    @Test
    public void raceCheck(){
        assertEquals(creatures[0].getRace(), "race1");
        assertEquals(creatures[1].getRace(), "race1");
        assertEquals(creatures[2].getRace(), "race2");
        assertEquals(creatures[3].getRace(), "race2");

        creatures[0].setRace("new_race1");
        creatures[1].setRace("new_race1");
        creatures[2].setRace("new_race2");
        creatures[3].setRace("new_race2");

        assertEquals(creatures[0].getRace(), "new_race1");
        assertEquals(creatures[1].getRace(), "new_race1");
        assertEquals(creatures[2].getRace(), "new_race2");
        assertEquals(creatures[3].getRace(), "new_race2");
    }

    @Test
    public void gameCheck(){
        assertEquals(game.getStatus().toString(), "notStarted");
        assertEquals(game.startJustDoIt(), "Начали игру: cricket");
        assertEquals(game.getStatus().toString(), "inProcess");
        assertEquals(game.stopJustDoIt(), "Закончили игру: cricket");
        assertEquals(game.getStatus().toString(), "finished");
    }
}
