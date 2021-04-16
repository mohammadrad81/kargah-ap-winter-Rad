import java.util.Objects;

public class Vote {
    private Person person;
    private String date;

    /**
     * creates a new vote by the input person and date
     * @param person
     * @param date
     */
    public Vote(Person person,String date){
        this.person = person;
        this.date = date;
    }

    public Person getPerson(){
        return this.person;
    }
    public String getDate(){
        return this.date;
    }

    /**
     * if a person votes twice , it should be the same voting
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if( o == this){
            return true;
        }
        if(!(o instanceof Vote)){
            return false;
        }
        Vote other = (Vote) o;
        if((other.person.toString().equals(this.person.toString()))){
            return true;
        }
        return false;
    }

    /**
     * returns the same hashcode for all objects
     * @return
     */
   @Override
    public int hashCode(){
        return 1;
   }
}
