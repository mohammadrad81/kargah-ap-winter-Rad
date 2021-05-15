import java.util.Scanner;

/**
 * this is the Main class of usage of the diary
 * @author Mohammad Heydari Rad
 * @since 2021
 */
public class Main {

    private static NotingStuff notingStuff = new NotingStuff();

    public static void main(String[] args) {

        mainMenu();
    }

    /**
     * the main menu of the project
     */
    private static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (input != 5){
            System.out.println();
            System.out.println("1- show the list of notes");
            System.out.println("2- show a note");
            System.out.println("3- add new note");
            System.out.println("4- delete a note");
            System.out.println("5- exit");

            input = scanner.nextInt();
            scanner.nextLine();
            if(!(isIndexValid(1 , 5 , input))){
                System.out.println("not valid input");
                continue;
            }

            if(input == 1){
                notingStuff.showNotesList();
            }
            else if(input == 2){
                notingStuff.showOneNote();
            }
            else if(input == 3){
                notingStuff.newNote();
            }
            else if (input == 4){
                notingStuff.deleteNote();
            }
            else if(input == 5){
                return;
            }
        }

    }

    /**
     * checks if the input index is in the scale or not
     * @param least is the least valid amount of input
     * @param most is the most valid amount of input
     * @param index is the input index
     * @return if the input index is valid or not
     */
    public static boolean isIndexValid(int least , int most , int index){
        if(index <= most && index >= least){
            return true;
        }
        return false;
    }
}
