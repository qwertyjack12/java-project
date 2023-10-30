package core.room;

public class RoomImpl implements Room{
    private final String name;
    private final double height;
    private final double width;

    public RoomImpl(double width, double height, String name){
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public String toString(){
        var area = this.calculateArea();
        if (area < 70) {
            return "bad room";
        } else if ((area > 70) | (area < 100)) {
            return "not bad room";
        } else {
            return "excellent room";
        }
    }
}
