/**
 * a class that gets used to save and show triangles
 * @author Mohammad Heydari Rad
 * @since 2021
 * @see Polygon
 */
public class Triangle extends Polygon {
    /**
     * a constructor to create a triangle
     * with 3 sides as parameter
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(int side1, int side2, int side3) {
        super(side1 , side2 , side3);
    }

    /**
     * checks that the triangle is equilateral or not
     * @return true if triangle is equilateral , else false
     */
    public boolean isEquilateral() {
        if (super.getSides().get(0).equals(super.getSides().get(1)) &&
                super.getSides().get(1).equals(super.getSides().get(2))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * calculates the perimeter of the Triangle
     * @return the calculated perimeter
     */
    @Override
    public double calculatePerimeter() {
        return (getSides().get(0) +
                getSides().get(1) +
                getSides().get(2));
    }

    /**
     * calculates the area of the triangle
     * @return the area of the triangle
     */
    @Override
    public double calculateArea() {
        double p = (getSides().get(0) +
                getSides().get(1) +
                getSides().get(2)) / 2.0;
        return (Math.sqrt(p * (p - getSides().get(0)) * (p - getSides().get(1)) * (p - getSides().get(2))));
    }

    /**
     * checks that a triangle has same sides to this triangle
     * @param o is an Object ( probably a triangle)
     * @return true if this triangle and input triangle have same sides , else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Triangle)) {
            return false;
        } else {
            Triangle other = (Triangle) o;
            if ((this.getSides().get(0).equals(other.getSides().get(0)) && this.getSides().get(1).equals(other.getSides().get(1)) && this.getSides().get(2).equals(other.getSides().get(2))) ||
                    (this.getSides().get(1).equals(other.getSides().get(0)) && this.getSides().get(2).equals(other.getSides().get(1)) && this.getSides().get(0).equals(other.getSides().get(2))) ||
                    (this.getSides().get(2).equals(other.getSides().get(0)) && this.getSides().get(0).equals(other.getSides().get(1)) && this.getSides().get(1).equals(other.getSides().get(2))) ||
                    (this.getSides().get(0).equals(other.getSides().get(0)) && this.getSides().get(2).equals(other.getSides().get(1)) && this.getSides().get(1).equals(other.getSides().get(2))) ||
                    (this.getSides().get(1).equals(other.getSides().get(0)) && this.getSides().get(0).equals(other.getSides().get(1)) && this.getSides().get(2).equals(other.getSides().get(2))) ||
                    (this.getSides().get(2).equals(other.getSides().get(0)) && this.getSides().get(1).equals(other.getSides().get(1)) && this.getSides().get(0).equals(other.getSides().get(2)))) {
                return true;
            }
            return false;
        }

    }

    /**
     * draws the shape
     * prints the kind
     * then prints the perimeter , then area
     */
    @Override
    public void draw() {
        System.out.println("Triangle : ");
        System.out.println("perimeter : " +this.calculatePerimeter());
        System.out.println("area : " + this.calculateArea());
        System.out.println();
    }

    /**
     * creates a string that contains the kind and the sides of the shape
     * @return the described string
     */
    @Override
    public String toString(){
        String  str = "Triangle : \n";
        str += super.toString();
        return str;
    }
}
