/**
 * the class that is used to save and show Rectangles
 * @author Mohammad Heydari Rad
 * @since 2021
 * @see Polygon
 */

public class Rectangle extends Polygon{
    /**
     * constructor of the rectangle
     * @param length is the large side
     * @param width is the small side
     */
    public Rectangle(int length , int width){
        super(length , width , length , width);
    }

    /**
     * checks that the rectangle is a square or not
     * @return true if all sides have same size , else false
     */
    public boolean isSquare(){
        if(super.getSides().get(0).equals(super.getSides().get(1)) &&
                super.getSides().get(1).equals(super.getSides().get(2)) &&
                super.getSides().get(2).equals(super.getSides().get(3))){
            return true;
        }
        return false;
    }

    /**
     * calculates the perimeter of the Rectangle
     * @return the sum of sides
     */
    @Override
    public double calculatePerimeter(){
        return (getSides().get(0) +
                getSides().get(1) +
                getSides().get(2) +
                getSides().get(3));
    }

    /**
     * calculates the area of the Rectangle
     * @return the calculated area
     */
    @Override
    public double calculateArea(){
        return (getSides().get(0) * getSides().get(1));
    }

    /**
     * checks that a rectangle has same sides to this rectangle
     * @param o is an object ( probably a Rectangle instance)
     * @return true if the  input rectangle and this rectangle have same sides , else false
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        else if(! (o instanceof  Rectangle)){
            return false;
        }
        else{
            Rectangle rectangle = (Rectangle) o;
            if((rectangle.getSides().get(0).equals(this.getSides().get(0)) && rectangle.getSides().get(1).equals(this.getSides().get(1))) ||
                    ( rectangle.getSides().get(0).equals(this.getSides().get(1)) && rectangle.getSides().get(1).equals(this.getSides().get(0)))){
                return true;
            }
        }
        return false;
    }

    /**
     * prints that this is a Rectangle
     * prints the perimeter and the area of the rectangle
     */
    @Override
    public  void draw(){
        System.out.println("Rectangle: ");
        System.out.println("perimeter : " + this.calculatePerimeter() );
        System.out.println("area : " + this.calculateArea());
        System.out.println();
    }

    /**
     * creates a string that contains the kind of the shape
     * and it's sides
     * @return the described string
     */
    @Override
    public String toString(){
        String  str = "Rectangle : \n";
        str += super.toString();
        return str;
    }

}
