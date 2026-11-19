package by.gstu.zhigar.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.gstu.zhigar.lab3.model.Car;
import by.gstu.zhigar.lab3.model.Driver;
import by.gstu.zhigar.lab3.model.Engine;
import by.gstu.zhigar.lab3.model.SovietCar;

import java.util.List; // nесты работают со списками

import org.junit.jupiter.api.Test; // аннотация JUnit 5, помечающая метод как тест

/**
 * Модульные тесты для классов иерархии и методов приложения {@link App}.
*/
class AppTest {

    /** Проверка: советский автомобиль определяется через наследника SovietCar. */
    @Test
    void sovietCarIsSoviet() {
        Car car = new SovietCar("ВАЗ-2101", "B", 955,
                new Driver("Иванов И.И.", 10), new Engine(64, "АвтоВАЗ"));
        assertTrue(car.isSoviet());
        assertEquals("СССР", car.getProductionCountry());
    }

    /** Проверка: обычный автомобиль не является советским. */
    @Test
    void foreignCarIsNotSoviet() {
        Car car = new Car("BMW X5", "Внедорожник", 2135,
                new Driver("Петров П.П.", 3), new Engine(340, "BMW"));
        assertFalse(car.isSoviet());
    }

    /** Проверка выборки советских автомобилей. */
    @Test
    void findSovietCars() {
        assertEquals(3, App.findSovietCars(App.createCars()).size());
    }

    /** Проверка: отрицательный стаж недопустим. */
    @Test
    void negativeExperienceThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Driver("Иванов И.И.", -1));
    }
}
