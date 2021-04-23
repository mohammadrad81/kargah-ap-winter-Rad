/**
 * a Main class that is used to show the performance of the project
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public class Main {
    public static void main(String[] args) {
        Paint paint = new Paint();

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);

        Rectangle rectangle1 = new Rectangle(2,3,2,3);
        Rectangle rectangle2 = new Rectangle(5,5,5,5);

        Triangle triangle1 = new Triangle(1,1,1);
        Triangle triangle2 = new Triangle(3,4,5);

        paint.addCircle(circle1);
        paint.addCircle(circle2);

        paint.addRectangle(rectangle1);
        paint.addRectangle(rectangle2);

        paint.addTriangle(triangle1);
        paint.addTriangle(triangle2);

        paint.drawAll();

        paint.printAll();

    }

}
