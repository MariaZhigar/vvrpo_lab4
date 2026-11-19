package by.gstu.zhigar.lab3.model;

/**
 * Класс {@code Car} описывает автомобиль.
 * <p>
 * Автомобиль содержит марку, класс, вес, а также объекты
 * {@link Driver} (водитель) и {@link Engine} (двигатель).
 * Связь с водителем и двигателем реализована через <b>композицию</b>:
 * они являются составными частями автомобиля и хранятся в его полях.
 * </p>
 * <p>
 * Базовый класс описывает автомобиль зарубежного производства.
 * Для автомобилей советского производства используется
 * класс-наследник {@link SovietCar}.
 * </p>
 */
public class Car {

    /** Марка автомобиля. */
    private final String brand;

    /** Класс автомобиля (например, «B», «C», «Внедорожник»). */
    private final String carClass;

    /** Вес автомобиля в килограммах. */
    private final double weight;

    /** Водитель автомобиля (композиция). */
    private final Driver driver;

    /** Двигатель автомобиля (композиция). */
    private final Engine engine;

    /**
     * Создаёт новый автомобиль.
     *
     * @param brand    марка автомобиля
     * @param carClass класс автомобиля
     * @param weight   вес автомобиля в кг (должен быть больше нуля)
     * @param driver   водитель автомобиля (не может быть {@code null})
     * @param engine   двигатель автомобиля (не может быть {@code null})
     * @throws IllegalArgumentException если какой-либо параметр некорректен
     */
    public Car(String brand, String carClass, double weight, Driver driver, Engine engine) {
        // Проверяем корректность всех входных данных
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Марка автомобиля не может быть пустой");
        }
        if (carClass == null || carClass.isBlank()) {
            throw new IllegalArgumentException("Класс автомобиля не может быть пустым");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес автомобиля должен быть больше нуля");
        }
        if (driver == null || engine == null) {
            throw new IllegalArgumentException("Водитель и двигатель должны быть заданы");
        }
        // Сохраняем значения, в том числе составные части автомобиля
        this.brand = brand;
        this.carClass = carClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    /**
     * Возвращает марку автомобиля.
     *
     * @return марка автомобиля
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Возвращает класс автомобиля.
     *
     * @return класс автомобиля
     */
    public String getCarClass() {
        return carClass;
    }

    /**
     * Возвращает вес автомобиля.
     *
     * @return вес в килограммах
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Возвращает водителя автомобиля.
     *
     * @return объект {@link Driver}
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Возвращает двигатель автомобиля.
     *
     * @return объект {@link Engine}
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Возвращает страну (тип) производства автомобиля.
     * Метод переопределяется в классах-наследниках.
     *
     * @return строка «Зарубежное производство»
     */
    public String getProductionCountry() {
        return "Зарубежное производство";
    }

    /**
     * Проверяет, является ли автомобиль автомобилем советского производства.
     * Базовый класс всегда возвращает {@code false};
     * в классе {@link SovietCar} метод переопределён.
     *
     * @return {@code false} для автомобиля базового класса
     */
    public boolean isSoviet() {
        return false;
    }

    /**
     * Возвращает строковое представление автомобиля со всеми его составными частями.
     *
     * @return подробное описание автомобиля
     */
    @Override
    public String toString() {
        // Метод getProductionCountry() вызывается полиморфно:
        // для SovietCar будет вызвана переопределённая версия
        return String.format("%s, класс %s, %.0f кг, двигатель: %s, водитель: %s, %s",
                brand, carClass, weight, engine, driver, getProductionCountry());
    }
}
