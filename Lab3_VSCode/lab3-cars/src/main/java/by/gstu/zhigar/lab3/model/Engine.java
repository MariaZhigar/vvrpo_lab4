package by.gstu.zhigar.lab3.model;

/**
 * Класс {@code Engine} описывает двигатель автомобиля.
 * <p>
 * Двигатель характеризуется мощностью (в лошадиных силах)
 * и названием производителя.
 * </p>
 *
  */
public class Engine {

    /** Мощность двигателя в лошадиных силах. */
    private final int power;

    /** Производитель двигателя. */
    private final String manufacturer;

    /**
     * Создаёт новый двигатель.
     *
     * @param power        мощность в л.с. (должна быть больше нуля)
     * @param manufacturer производитель двигателя (не может быть пустым)
     * @throws IllegalArgumentException если мощность не положительна
     *                                  или производитель не указан
     */
    public Engine(int power, String manufacturer) {
        // Мощность двигателя должна быть положительной
        if (power <= 0) {
            throw new IllegalArgumentException("Мощность двигателя должна быть больше нуля");
        }
        // Производитель обязательно должен быть указан
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("Производитель двигателя не может быть пустым");
        }
        this.power = power;
        this.manufacturer = manufacturer;
    }

    /**
     * Возвращает мощность двигателя.
     *
     * @return мощность в лошадиных силах
     */
    public int getPower() {
        return power;
    }

    /**
     * Возвращает производителя двигателя.
     *
     * @return название производителя
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Возвращает строковое представление двигателя.
     *
     * @return строка вида «N л.с., производитель»
     */
    @Override
    public String toString() {
        return power + " л.с., " + manufacturer;
    }
}
