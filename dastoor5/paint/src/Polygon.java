/**
 * a class to save and show the polygons
 * @author Mohammad Heydari Rad
 * @since 2021
 */

import java.util.ArrayList;

public abstract class Polygon extends Shape{

    private ArrayList<Integer> sides ;

    /**
     * a constructor for the polygon
     * saves the sides in an arrayList
     * @param sidesArray is the polygon's sides in an array
     */
    public Polygon(int ... sidesArray){
        super();
        sides = new ArrayList<>();
        for(int side : sidesArray){
            sides.add(side);
        }
    }

    /**
     * prints the kind of the shape and its perimeter and area
     * it's an abstract method so it is written in children  source codes
     */
    @Override
    public abstract void draw();

    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * creates a string that contains the sides of the polygon
     * @return the described string
     */
    @Override
    public String toString(){
        String  str = "";
        for(int i = 0; i < sides.size() ; i++ ){
            str += "| side " + i + " : " +sides.get(i);
        }
        str += "\n";
        return str;
    }


}
