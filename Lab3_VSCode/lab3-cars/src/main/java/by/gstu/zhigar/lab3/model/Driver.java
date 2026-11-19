package by.gstu.zhigar.lab3.model;

/**
 * Класс {@code Driver} описывает водителя автомобиля.
 * <p>
 * Водитель характеризуется ФИО и стажем вождения (в полных годах).
 * Объект класса является неизменяемым: значения полей задаются один раз
 * в конструкторе и далее только читаются через геттеры.
 * </p>
*/
public class Driver {

    /** ФИО водителя. */
    private final String fullName;

    /** Стаж вождения в полных годах. */
    private final int drivingExperience;

    /**
     * Создаёт нового водителя.
     *
     * @param fullName                  ФИО водителя (не может быть пустым)
     * @param drivingExperience         стаж вождения в годах (не может быть отрицательным)
     * @throws IllegalArgumentException если ФИО пустое или стаж отрицательный
     */
    public Driver(String fullName, int drivingExperience) {
        // Проверяем, что ФИО задано: водитель без имени не имеет смысла
        // "".isBlank()        // true  — пустая строка
        //"   ".isBlank()     // true  — только пробелы
        //"\t\n  ".isBlank()  // true  — табы и переводы строк тоже считаются
        //"abc".isBlank()     // false — есть непробельные символы
        //"  a  ".isBlank()   // false — есть буква 'a'
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("ФИО водителя не может быть пустым");
        }
        // Стаж не может быть отрицательным числом
        if (drivingExperience < 0) {
            throw new IllegalArgumentException("Стаж вождения не может быть отрицательным");
        }
        // Сохраняем значения в поля объекта
        this.fullName = fullName;
        this.drivingExperience = drivingExperience;
    }

    /**
     * Возвращает ФИО водителя.
     *
     * @return ФИО водителя
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Возвращает стаж вождения.
     *
     * @return стаж вождения в годах
     */
    public int getDrivingExperience() {
        return drivingExperience;
    }

    /**
     * Возвращает строковое представление водителя.
     *
     * @return строка вида «ФИО (стаж: N г.)»
     */
    @Override
    public String toString() {
        // Формируем удобную для вывода в консоль строку
        return fullName + " (стаж: " + drivingExperience + " г.)";
    }
}
