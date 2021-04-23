/**
 * a class that is used to save and show shapes to the client
 * @author Mohammad Heydari Rad
 * @since 2021
 */

import java.util.ArrayList;

public class Paint {
    private ArrayList<Shape> shapes;

    /**
     * constructor of the class
     */
    public Paint (){
        shapes = new ArrayList<>();
    }

    /**
     * adds a shape to the arrayList of the shapes
     * @param shape the adding shape
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * draws all of the shapes
     */
    public void drawAll(){
        for(Shape shape : shapes){
            shape.draw();
        }
    }

    /**
     * prints all of the shapes
     */
    public void printAll(){
        for(Shape shape : shapes){
            System.out.println(shape.toString());
        }
    }

    /**
     * prints the equal sides shapes
     */
    public void describeEqualShapes(){

        System.out.println("Equal sides shapes : ");
        for(int i = 0 ; i < shapes.size() ; i++){
            Shape shape = shapes.get(i);
            if(shape instanceof Rectangle){
                Rectangle rectangle = (Rectangle) shape;
                if(rectangle.isSquare())
                    System.out.println(shape);
            }

            else if(shape instanceof Triangle){
                Triangle triangle = (Triangle) shape;
                if(triangle.isEquilateral())
                    System.out.println(shape);
            }
        }
    }
}
