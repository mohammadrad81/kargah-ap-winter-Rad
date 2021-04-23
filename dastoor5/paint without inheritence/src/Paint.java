/**
 * a class that is used to show the shapes to the client
 * @author Mohammad Heydari Rad
 * @since 2021
 */

import java.util.ArrayList;

public class Paint {

    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;
    private ArrayList<Circle> circles;

    /**
     * a constructor of the class
     */
    public Paint(){
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
        circles = new ArrayList<>();
    }

    /**
     * adds a triangle to the arrayList of the triangles
     * @param triangle is the input - adding triangle
     */
    public void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }

    /**
     * adds a circle to the arrayList of the circles
     * @param circle is the input - adding circle
     */
    public void addCircle(Circle circle){
        circles.add(circle);
    }

    /**
     * adds a rectangle to the arrayList of the rectangles
     * @param rectangle
     */
    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }

    /**
     * prints all shapes of the arrayLists
     */
    public void printAll(){
        for (Triangle triangle : triangles) {
            System.out.println(triangle.toString());
        }
        for (Circle circle : circles) {
            System.out.println(circle.toString());
        }
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.toString());
        }
    }

    /**
     * draws all shapes of the arrayList
     */
    public void drawAll(){
        for (Triangle triangle : triangles) {
            triangle.draw();
        }
        for (Circle circle : circles) {
            circle.draw();
        }
        for(Rectangle rectangle : rectangles){
            rectangle.draw();
        }
    }
}
