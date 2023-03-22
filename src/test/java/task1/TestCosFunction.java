package task1;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;

public class TestCosFunction {
    static CosFunction cosFunction;
    private static final double DELTA = 0.01;

    @BeforeAll
    static void init() {
        cosFunction = new CosFunction();
    }

    //проверка нулевого значения
    @ParameterizedTest
    @ValueSource(doubles = {0d})
    public void zeroCheck(double value) {
        Assertions.assertEquals(Math.cos(value), cosFunction.cos(value), DELTA);
    }

    //проверка правой стороны
    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6, Math.PI / 4, Math.PI / 3, Math.PI / 2})
    public void rightCheck(double value){
        Assertions.assertEquals(Math.cos(value), cosFunction.cos(value), DELTA);
    }

    //проверка левой стороны (на четность)
    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI / 6, -Math.PI / 4, -Math.PI / 3, -Math.PI / 2})
    public void leftCheck(double value){
        Assertions.assertEquals(Math.cos(value), cosFunction.cos(value), DELTA);
    }

    //проверка граничных значений
    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, Math.PI})
    public void cosBoundaryCheck(double value){
        Assertions.assertEquals(Math.cos(value), cosFunction.cos(value), DELTA);
    }

    //тестирование NaN, Infinity
    @ParameterizedTest
    @ValueSource(doubles = {NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    public void cosNonFiniteCheck(double value){
        Assertions.assertEquals(Math.cos(value), cosFunction.cos(value), DELTA);
    }

    //тестовые значения вне границы покрытия
    @ParameterizedTest
    @ValueSource(doubles = {10*Math.PI, -10*Math.PI})
    public void cosOutOfRangeCheck(double value){
        Assertions.assertEquals(Math.cos(value), cosFunction.cos(value));
    }
}
