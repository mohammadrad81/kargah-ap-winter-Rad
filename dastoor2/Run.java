public class Run {
    public static void main(String[] args) {

        Student std1 = new Student("Ehsan","Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");

        Student std4 = new Student("Mohammad" , "Rad" , "9931017");
        Student std5 = new Student("Farhad" , "Farhadi" , "0011011");
        Student std6 = new Student("Babak" , "Babaki" , "1100100");

        College ceCollege = new College("computer engineering college");

        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFirstName("HamidReza");
        std3.print();

        std4.setGrade(19);
        std5.setGrade(20);
        std6.setGrade(18);

        Lab lb1 = new Lab(3 , "monday");
        lb1.enrollStudent(std1);
        lb1.enrollStudent(std2);
        lb1.enrollStudent(std3);
        System.out.println();
        lb1.print();

        Lab lb2 = new Lab(4 , "tuesday");
        lb2.enrollStudent(std4);
        lb2.enrollStudent(std5);
        lb2.enrollStudent(std6);
        System.out.println();

        ceCollege.addLab(lb1);
        ceCollege.addLab(lb2);

        ceCollege.printCollege();
    }
}