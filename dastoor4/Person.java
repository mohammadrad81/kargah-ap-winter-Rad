

public class Person {
    private String firstName;
    private String lastName;

    /**
     * creates a new person by input first name and last name
     * @param firstName
     * @param lastName
     */
    public Person(String firstName , String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * the getter for person's first name
     * @return this person's first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * the getter for person's last name
     * @return
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * overrided "to string" method
     * @return a string that includes person's first name and last name with a space between them
     */
    @Override
    public String toString() {
        return (firstName + " " + lastName);
    }
}
