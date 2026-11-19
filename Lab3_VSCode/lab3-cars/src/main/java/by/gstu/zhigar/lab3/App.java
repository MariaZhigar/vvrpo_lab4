/*Указывает, что класс принадлежит пакету by.gstu.zhigar.lab3. Все классы этого пакета лежат в папке by/gstu/zhigar/lab3/. */
package by.gstu.zhigar.lab3;

import by.gstu.zhigar.lab3.model.Car;
import by.gstu.zhigar.lab3.model.Driver;
import by.gstu.zhigar.lab3.model.Engine;
import by.gstu.zhigar.lab3.model.SovietCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Консольное приложение для демонстрации работы иерархии классов
 * {@link Car}, {@link SovietCar}, {@link Driver} и {@link Engine}.
 * <p>
 * Приложение создаёт список автомобилей, выводит всю информацию о них,
 * затем выводит водителей со стажем более 5 лет
 * и автомобили советского производства.
 * </p>
 *
 */

public class App {

    /** Минимальный стаж, начиная с которого водитель считается опытным.
     * public — доступна всем;
    static — принадлежит классу, а не объекту;
    final — изменить нельзя (константа);
    int — целочисленный тип.
     */
    public static final int MIN_EXPERIENCE = 5;

    /**
     * Закрытый конструктор: класс содержит только статические методы,
     * поэтому создавать его объекты не требуется.
     */
    private App() {
    }

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        clearScreen();
        // Создаём список автомобилей для демонстрации
        List<Car> cars = createCars();

        System.out.println("=============================================== СПИСОК АВТОМОБИЛЕЙ ===============================================");
        System.out.println();
        printCars(cars);

        System.out.println();
        System.out.println("========================= ВОДИТЕЛИ СО СТАЖЕМ БОЛЕЕ " + MIN_EXPERIENCE + " ЛЕТ =========================");
        // Выводим водителей, стаж которых превышает 5 лет
        for (Driver driver : findExperiencedDrivers(cars, MIN_EXPERIENCE)) {
            System.out.println(" - " + driver);
        }

        System.out.println();
        System.out.println("========================= АВТОМОБИЛИ СОВЕТСКОГО ПРОИЗВОДСТВА =========================");
        // Выводим только советские автомобили
        printCars(findSovietCars(cars));
    }

    /**
     * Создаёт тестовый набор автомобилей с водителями и двигателями.
     *
     * @return список автомобилей
     */
    // возвращает List<Car>
    public static List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        // Советские автомобили создаются как объекты класса-наследника SovietCar
        cars.add(new SovietCar("ВАЗ-2101", "B", 955,
                new Driver("Иванов Иван Иванович", 12), new Engine(64, "АвтоВАЗ")));
        cars.add(new SovietCar("ГАЗ-24 Волга", "D", 1420,
                new Driver("Петров Пётр Сергеевич", 3), new Engine(95, "ЗМЗ")));
        cars.add(new SovietCar("Москвич-412", "C", 1045,
                new Driver("Сидорова Анна Викторовна", 7), new Engine(75, "УЗАМ")));
        // Остальные автомобили — зарубежного производства (базовый класс Car)
        cars.add(new Car("Toyota Camry", "D", 1550,
                new Driver("Козлов Дмитрий Андреевич", 2), new Engine(181, "Toyota")));
        cars.add(new Car("BMW X5", "Внедорожник", 2135,
                new Driver("Новикова Елена Павловна", 9), new Engine(340, "BMW")));
        cars.add(new Car("Volkswagen Polo", "B", 1160,
                new Driver("Морозов Алексей Игоревич", 5), new Engine(110, "Volkswagen")));
        return cars;
    }

    /**
     * Находит водителей, стаж которых строго больше заданного.
     *
     * @param cars           список автомобилей
     * @param minExperience пороговое значение стажа в годах
     * @return список водителей со стажем больше {@code minExperience}
     */
    public static List<Driver> findExperiencedDrivers(List<Car> cars, int minExperience) {
        List<Driver> result = new ArrayList<>();
        for (Car car : cars) {
            // Получаем водителя автомобиля (составную часть объекта Car)
            Driver driver = car.getDriver();
            // Условие «более 5 лет» — строгое сравнение
            if (driver.getDrivingExperience() > minExperience) {
                result.add(driver);
            }
        }
        return result;
    }

    /**
     * Находит автомобили советского производства.
     *
     * @param cars список автомобилей
     * @return список автомобилей, для которых {@link Car#isSoviet()} возвращает {@code true}
     */
    public static List<Car> findSovietCars(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            // Полиморфный вызов: для SovietCar вернётся true, для Car — false
            if (car.isSoviet()) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * Выводит список автомобилей в консоль с порядковыми номерами.
     *
     * @param cars список автомобилей для вывода
     */
    public static void printCars(List<Car> cars) {
        int number = 1;
        for (Car car : cars) {
            System.out.println(number + ". " + car);
            number++;
        }
    }
    public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}
}
