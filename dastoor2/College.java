public class College {
    private String collegeName = new String();
    private Lab [] labs = new Lab[10];
    private double totalAerage;
    int collegeLabNumbers = 0;

    public College (String collegeName){
        this.collegeName = collegeName;
    }

    /**
     * adds a lab to the college if ther is an empty lab
     * @param lab
     */
    public void addLab(Lab lab){
        if (collegeLabNumbers == 10){
            System.out.println("there is no more empty lab !");
        }
        else{
            labs [collegeLabNumbers] = lab;
            collegeLabNumbers ++ ;
        }

    }

    /**
     *
     * @return the average of the grades of the students of college
     */
    public double getTotalAerage(){
        double sum = 0;
        for (int i = 0 ; i < collegeLabNumbers ; i++){
            sum += (double) labs[i].getAvg();
        }
        totalAerage = sum / (double) collegeLabNumbers;
        return totalAerage;
    }

    /**
     * prints the students of the college
     */
    public void printCollege(){
        System.out.println();
        System.out.println("the students of college : " + collegeName );
        System.out.println();
        for (int i = 0 ; i < collegeLabNumbers ; i++){
            System.out.println("students of lab number "+ (i+1) + " : ");
            labs[i].print();
        }
    }

}
