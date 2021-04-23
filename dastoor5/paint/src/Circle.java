/**
 * a class that is used to save and show circles
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public  class Circle extends Shape {
    private double radius;

    /**
     * a constructor for the circle
     * @param radius is the input radius of this circle
     */
    public Circle (double radius){
        super();
        this.radius = radius;
    }

    /**
     *
     * @return this circles radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * calculates the perimeter of this circle
     * @return the perimeter
     */
    @Override
    public double calculatePerimeter(){
        return (2 * 3.14 * radius);
    }

    /**
     * calculates the area of this circle
     * @return the area
     */
    @Override
    public double calculateArea(){
        return (3.14 * radius * radius);
    }

    /**
     * prints that this shape is a circle
     * prints it's perimeter
     * prints it's area
     */
    @Override
    public void draw(){
        System.out.println("Circle : ");
        System.out.println("perimeter : " + this.calculatePerimeter());
        System.out.println("area : "+ this.calculateArea());
        System.out.println();
    }

    /**
     * checks that the input circle has same radius to this circle
     * @param o is the input object ( probably a circle
     * @return true if the input circle has same radius to this circle , else false
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        else if(!(o instanceof Circle)){
            return false;
        }
        else{
            Circle circle = (Circle) o;
            if(this.radius == circle.radius){
                return true;
            }

        }
        return false;
    }

    /**
     * creates a string that contains the kind of this shape (circle)
     * and its radius
     * @return the described string
     */
    @Override
    public String toString(){
        String str = "Circle\n";
            str += "Radius : " + radius+ "\n";
            return str;
    }
}
