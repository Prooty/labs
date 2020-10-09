public class Lab1 {
    //Точка входа в программу
    public static void main(String[] args) {
        Point3d[] points = new Point3d[3];
        for (int i = 0; i < args.length; i += 3) {
            points[i / 3] = new Point3d(
                    Double.parseDouble(args[i]),
                    Double.parseDouble(args[i + 1]),
                    Double.parseDouble(args[i + 2])
            );
        }

        if ((points[0].equals(points[1])) || (points[0].equals(points[2])) || (points[1].equals(points[2]))){
            System.out.println("Some of points are equals, it is not a triangle");
            return;
        }

        System.out.printf("Area of triangle: %.2f \n", computeArea(points[0], points[1], points[2]));
    }

    //Метод вычисляющий площадь треугольника по трем точкам
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);
        double p = (a + b + c) / 2.0;
        double s = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(s);
    }
}
