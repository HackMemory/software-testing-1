package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainModelTest {
    static Creature[] creatures;
    static Universe[] universes;
    static Game game;
    static Debate debate;
    static SolvingProblem solvingProblem;

    @BeforeEach
    public void createAll() {
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

    @ParameterizedTest
    @CsvSource({"0, new_race1", "1, new_race2", "2, new_race3", "3, new_race4"})
    public void raceCheck(Integer index, String value){
        creatures[index].setRace(value);
        assertEquals(creatures[index].getRace(), value);
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
