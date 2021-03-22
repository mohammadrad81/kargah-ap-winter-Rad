/**
@author mohammad rad
 @version 1.0
 */
public class Student {
    private String firstName = new String();
    private String lastName = new String();
    private String id = new String() ;
    private int grade;


    /**
     * constructor , creates object and sets first name , last name , id of a student
     * @param firstName
     * @param lastName
     * @param id
     */
    public Student(String firstName ,String lastName ,String id){
          setFirstName(firstName);
          setLastName(lastName);
          setId(id);
    }
    /**
     * get the first name of student
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param fName set first name of a student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * @param lName set last name of a student
     */
    public void setLastName(String lName){
        lastName = lName;
    }
    /**
     * @param iden set id of a student
     */
    public void setId(String iden){
        id = iden;
    }
    /**
     * @param stuGrade set grade of a student
     */
    public void setGrade(int stuGrade){
        grade = stuGrade;
    }
    /**
     * get the grade of the student
     * @return the average of the student
     */
    public int getGrade(){
        return grade;
    }
    /**
     * Print the student’s last name and ID number to the
     output terminal.
     */


    public void print() {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }

}
