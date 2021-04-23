/**
 * an abstract class that is used to save and show the shapes
 * @author Mohammad Heydari Rad
 */

public  abstract class Shape {
    /**
     * calculates the perimeter of the shape
     * @return the area of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * calculates the area of the shape
     * @return the area of the shape
     */
    public abstract double calculateArea();

    /**
     * draws the shape
     */
    public abstract void draw();

    /**
     * checks that two shapes have same details or not
     * @param o is the input shape
     * @return true if two shape have same details , else false
     */
    @Override
    public abstract boolean equals(Object o);

    /**
     * creates a string that contains the kind of the shape
     * and its details
     * @return the described string
     */
    @Override
    public abstract String toString();



}
