import java.util.ArrayList;

/**
 * an example of rectangle class
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public class Rectangle {
    private ArrayList<Double> sides;

    /**
     * a constructor for the triangle
     * inputs are it's sides
     * @param side1
     * @param side2
     * @param side3
     * @param side4
     */
   public Rectangle(double side1 , double side2 , double side3 , double side4){
       sides = new ArrayList<>();

       if(side1 == side2){
           sides.add(side1);
           sides.add(side3);
           sides.add(side2);
           sides.add(side4);
       }
       else if(side1 == side3){
           sides.add(side1);
           sides.add(side2);
           sides.add(side3);
           sides.add(side4);
       }
       else{
           sides.add(side1);
           sides.add(side2);
           sides.add(side4);
           sides.add(side3);
       }
   }

    /**
     * a getter for the array of rectangle sides array
     * @return rectangle sides array
     */
   public ArrayList<Double> getSides(){
       return sides;
   }

    /**
     *
     * @return true if rectangle is a square , false if not
     */
   public boolean isSquare(){
       if(sides.get(0) == sides.get(1)){
           return true;
       }
       else{
           return false;
       }
   }

    /**
     *
     * @return the perimeter of the rectangle
     */
   public double calculatePerimeter(){
       return (0.0 + 2* sides.get(0) + 2* sides.get(1));
   }

    /**
     *
     * @return the area of the rectangle
     */
   public double calculateArea(){
       return (0.0 + sides.get(0) * sides.get(1));
   }

   public void draw(){
       System.out.println("Rectangle");
//       int counter = 1;
//       for(Double side : sides){
//           System.out.println("side number " + counter + " : " + side );
//           counter++;
//       }
       System.out.println("the area : " + this.calculateArea());
       System.out.println("the perimeter : " + this.calculatePerimeter());
       System.out.println();
   }

    /**
     * checks if two Rectangles have same sides
     * @param object is the input (probably a rectangle)
     * @return true if they have same sides , else false
     */
   @Override
    public boolean equals(Object object){

       if(this == object){
           return true;
       }
       else if(! (object instanceof Rectangle)){
           return false;
       }
       Rectangle other = (Rectangle) object;
       if(this.sides.get(0).equals(other.getSides().get(0)) && this.sides.get(1).equals(other.getSides().get(1)) ||
               this.sides.get(0).equals(other.getSides().get(1)) && this.sides.get(1).equals(other.getSides().get(0))){
           return true;
       }
       return false;
   }

    /**
     * creates a string that contains the kind of the shape and its sides
     * @return
     */
   @Override
   public String toString(){
       return ("Rectangle ," + "side 1 : " + sides.get(0) + "| side 2 : " + sides.get(1) + "| side 3 : " + sides.get(2) + "| side 4 : " + sides.get(3));
   }
}
