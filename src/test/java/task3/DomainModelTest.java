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
    public void toStringCheck(){
        for(Creature c : creatures){
            assertEquals(c.toString(), c.getName() + ", раса: " + c.getRace() + ", вселенная: " + c.getUniverse().getName());
        }

        for(Universe u : universes){
            assertEquals(u.toString(), "Вы находитесь здесь: " + u.getName());
        }

        assertEquals(game.toString(), "Игра: " + game.getName() + ", статус: " + game.getStatus().name());
        assertEquals(debate.toString(), "Тема дебатов: " + debate.getTheme() + ", статус: " + debate.getStatus().name());
        assertEquals(solvingProblem.toString(), "Проблема: " + solvingProblem.getProblem() + ", статус: " + solvingProblem.getStatus().name());
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
        assertEquals(game.getStatus(), PastimeStatus.notStarted);
        assertEquals(game.startJustDoIt(), "Начали игру: " + game.getName());
        assertEquals(game.getStatus(), PastimeStatus.inProcess);
        assertEquals(game.stopJustDoIt(), "Закончили игру: " + game.getName());
        assertEquals(game.getStatus(), PastimeStatus.finished);
    }

    @Test
    public void debateCheck(){
        assertEquals(debate.getStatus(), PastimeStatus.notStarted);
        assertEquals(debate.startJustDoIt(), "Начали дебаты: " + debate.getTheme());
        assertEquals(debate.getStatus(), PastimeStatus.inProcess);
        assertEquals(debate.stopJustDoIt(), "Закончили дебаты: " + debate.getTheme());
        assertEquals(debate.getStatus(), PastimeStatus.finished);
    }

    @Test
    public void problemCheck(){
        assertEquals(solvingProblem.getStatus(), PastimeStatus.notStarted);
        assertEquals(solvingProblem.startJustDoIt(), "Приступили к решению проблемы: " + solvingProblem.getProblem());
        assertEquals(solvingProblem.getStatus(), PastimeStatus.inProcess);
        assertEquals(solvingProblem.stopJustDoIt(), "Проблема: " + solvingProblem.getProblem() + ", решена");
        assertEquals(solvingProblem.getStatus(), PastimeStatus.finished);
    }
}
