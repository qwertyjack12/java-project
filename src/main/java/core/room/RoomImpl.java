package core.room;

import java.io.Serializable;

/**
 * Класс RoomImpl, реализующий интерфейс Room
 */
public class RoomImpl implements Room, Serializable {
    private final String name;
    private final double height;
    private final double width;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param width  - width
     * @param height - height
     * @param name   - name
     * @see RoomImpl (double, double, String)
     */
    public RoomImpl(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    /**
     * геттеры для работы с полями класса RoomImpl
     */
    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    /**
     * Переопределение функции calculateArea Room
     */
    @Override
    public double calculateArea() {
        return width * height;
    }

    /**
     * Переопределение функции toString базового класса Object
     */
    public String toString() {
        var area = this.calculateArea();
        if (area < 70) {
            return name + ". Bad room";
        } else if ((area > 70) | (area < 100)) {
            return name + ". Not bad room";
        } else {
            return name + ". Excellent room";
        }
    }
}
