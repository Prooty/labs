//Класс трехмерной точки
public class Point3d {
    //X координата
    private double x;
    //Y координата
    private double y;
    //Z координата
    private double z;

    //Конструктор по умолчанию, делает точку с координатами (0,0,0)
    public Point3d() {
        this(0.0, 0.0, 0.0);
    }

    //Конструктор, делает точку с координатами (x,y,z)
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Метод для получения X координаты
    public double getX() {
        return x;
    }

    //Метод для получения Y координаты
    public double getY() {
        return y;
    }

    //Метод для получения Z координаты
    public double getZ() {
        return z;
    }

    //Метод для установления X координаты
    public void setX(double x) {
        this.x = x;
    }

    //Метод для установления Y координаты
    public void setY(double y) {
        this.y = y;
    }

    //Метод для установления Z координаты
    public void setZ(double z) {
        this.z = z;
    }

    //Метод для сравнения значений двух объектов Point3d
    public boolean equals(Point3d p) {
        return x == p.x && y == p.y && z == p.z;
    }

    //Расстояние между двумя точками
    public double distanceTo(Point3d p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
    }


}
