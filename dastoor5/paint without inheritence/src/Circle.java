/**
 * a class that is used for circles
 */

public class Circle {
    private double radius;

    /**
     * constructor  of the Circle
     * @param radius is the radius of the circle
     */
    public Circle(double radius){
        this.radius = radius;
    }

    /**
     *
     * @return radius of the circle
     */
    public double getRadius(){
        return this.radius;
    }

    /**
     * calculates the perimeter of the circle
     * @return the perimeter
     */
    public double calculatePerimeter(){
        return ( 3.14 * 2.0 * radius);
    }

    /**
     * calculates the area of the circle
     * @return the area of the circle
     */
    public double calculateArea(){
        return (radius * radius * 3.14);
    }

    /**
     * draws the circle
     */
    public void draw(){
        System.out.println("Circle");
        System.out.println("radius : " + this.radius);
        System.out.println("perimeter : " +calculatePerimeter());
        System.out.println("area : " + calculateArea());
        System.out.println();
    }

    /**
     * checks if two circles are equal
     * @param object is the input circle
     * @return true if two circles have same radius , else false
     */
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        else if(! (object instanceof Circle)){
            return false;
        }
        Circle other = (Circle) object;
        if(other.getRadius() == this.getRadius()){
            return true;
        }

        return false;
    }

    /**
     * creates a string that contains the kind of the shape
     * and it's radius
     * @return
     */
    @Override
    public String toString(){
        return ("Circle ," + "radius : " + this.radius  );

    }
}
