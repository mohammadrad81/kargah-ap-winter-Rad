/**
 * a class to save and show triangles
 * @author Mohammad Heydari Rad
 * @since 2021
 */

import java.util.ArrayList;

public class Triangle {
    private ArrayList<Double> sides;

    /**
     * a constructor of the triangle
     * the inputs are it's sides
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(double side1 , double side2 , double side3){
        sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
    }

    /**
     *
     * @return the arrayList of the sides
     */
    public ArrayList<Double> getSides(){
        return sides;
    }

    /**
     *
     * @return true if all sides of the triangle have same size
     */
    public boolean isEquilateral(){
        if(this.sides.get(0).equals(this.sides.get(1)) && this.sides.get(1).equals(this.sides.get(2))){
            return true;
        }
        else{
            return true;
        }
    }

    /**
     * calculates the perimeter of the triangle
     * @return the perimeter of the triangle
     */
    public double calculatePerimeter(){
        return (sides.get(0) + sides.get(1) + sides.get(2));
    }

    /**
     * calculates the area of the triangle
     * @return the area
     */
    public double calculateArea(){
        double p = (0.0 + sides.get(0) + sides.get(1) + sides.get(2))/2.0;
        double area = Math.sqrt(p * (p-(sides.get(0))) * (p- sides.get(1)) * (p- sides.get(2)));
        return area;
    }

    /**
     * draws the triangle
     */
    public void draw(){
        System.out.println("Triangle");
        int counter = 0;
//        for(double side : sides){
//            System.out.println("side " +counter + " : " + side);
//        }
        System.out.println("perimeter : " + calculatePerimeter());
        System.out.println("area : " + calculateArea());
        System.out.println();
    }

    /**
     * checks if two triangles have same sides
     * @param object is the input triangle
     * @return true if the triangles have same sides , else false
     */
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        else if(! (object instanceof Triangle)){
            return false;
        }
        Triangle other = (Triangle) object;
        if((this.sides.get(0).equals(other.getSides().get(0)) && this.sides.get(1).equals(other.getSides().get(1)) && this.sides.get(2).equals(other.getSides().get(2))) ||
                (this.sides.get(1).equals(other.getSides().get(0)) && this.sides.get(2).equals(other.getSides().get(1)) && this.sides.get(0).equals(other.getSides().get(2)))||
                (this.sides.get(2).equals(other.getSides().get(0)) && this.sides.get(0).equals(other.getSides().get(1)) && this.sides.get(1).equals(other.getSides().get(2))) ||
                (this.sides.get(0).equals(other.getSides().get(0)) && this.sides.get(2).equals(other.getSides().get(1)) && this.sides.get(1).equals(other.getSides().get(2))) ||
                (this.sides.get(1).equals(other.getSides().get(0)) && this.sides.get(0).equals(other.getSides().get(1)) && this.sides.get(2).equals(other.getSides().get(2))) ||
                (this.sides.get(2).equals(other.getSides().get(0)) && this.sides.get(1).equals(other.getSides().get(1)) && this.sides.get(0).equals(other.getSides().get(2)))){
            return true;
        }

        return false;
    }

    /**
     * creates a string that contains the kind of the shape
     * and it's sides
     * @return the described string
     */
    @Override
    public String toString(){
        return ("Triangle , sides : " + sides.get(0) + " , " + sides.get(1) + " , " + sides.get(2));
    }
}
