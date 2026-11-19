package by.gstu.zhigar.lab3.model;

/**
 * Класс {@code SovietCar} описывает автомобиль советского производства.
 * <p>
 * Является наследником класса {@link Car} (<b>наследование</b>)
 * и переопределяет методы, связанные со страной производства.
 * </p>
  */
public class SovietCar extends Car {

    /**
     * Создаёт новый автомобиль советского производства.
     *
     * @param brand    марка автомобиля
     * @param carClass класс автомобиля
     * @param weight   вес автомобиля в кг
     * @param driver   водитель автомобиля
     * @param engine   двигатель автомобиля
     */
    public SovietCar(String brand, String carClass, double weight, Driver driver, Engine engine) {
        // Вызываем конструктор родительского класса Car,
        // который выполнит проверку и сохранение всех полей
        super(brand, carClass, weight, driver, engine);
    }

    /**
     * Возвращает страну производства — СССР.
     *
     * @return строка «СССР»
     */
    @Override
    public String getProductionCountry() {
        return "СССР";
    }

    /**
     * Признак советского производства.
     *
     * @return всегда {@code true}
     */
    @Override
    public boolean isSoviet() {
        return true;
    }
}
