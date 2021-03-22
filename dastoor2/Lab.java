public class Lab {
    private Student[] students = new Student[20];
    private int avg;
    private String day = new String();
    private int capacity;
    private int currentSize;

    /** sets capacity and the day of the lab
     * @param cap sets the capacity of the lab
     * @param d sets the day of the lab
     */
    public Lab(int cap, String d) {
        this.capacity = cap;
        this.day = d;
    }

    /**
     * adding new student
     * @param std is the student we try to add to the lab
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * printing students of the lab
     */
    public void print() {

        for (int i = 0 ; i < currentSize ; i++){
            students[i].print();
        }
        System.out.println("the average of the students grade : " + getAvg());
    }

    /**
     * @return the students array
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students sets the students to the lab
     */
    public void setStudents(Student[] students) {
       this.students = students;
    }

    /**
     *
     * @return the average
     */
    public int getAvg() {
        calculateAvg();
        return avg;
    }

    /**
     * calculates the average
     */
    public void calculateAvg() {
        int sum = 0;
        int count = 0;
        for (int i = 0 ; i < currentSize ; i++) {
            sum += students[i].getGrade();
            count ++;
        }
        avg = sum / count;
    }

    /**
     *
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @param day sets the day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     *
     * @return the lab capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @param capacity sets the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
