/**
 * a Main class to show an example of usage of the project
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Circle circle1 = new Circle(5);

        Triangle triangle = new Triangle(3, 4, 5);
        Triangle triangle1 = new Triangle(5 , 5 , 5);

        Rectangle rectangle = new Rectangle(3 , 2 );
        Rectangle rectangle1 = new Rectangle(4 , 4 );

        Paint paint = new Paint();

        paint.addShape(circle);
        paint.addShape(circle1);
        paint.addShape(triangle);
        paint.addShape(triangle1);
        paint.addShape(rectangle);
        paint.addShape(rectangle1);

        paint.drawAll();

        paint.printAll();

        paint.describeEqualShapes();
    }
}
