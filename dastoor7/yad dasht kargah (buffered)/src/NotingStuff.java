import java.util.ArrayList;
import java.util.Scanner;

/**
 * the class that handles the noting stuff
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public class NotingStuff {

    private FileUtils fileUtils = new FileUtils();

    /**
     * shows the list of the notes
     */

    public void showNotesList(){
        if(fileUtils.hasNotes()){
            fileUtils.showNotesList();
        }
        else {
            System.out.println("You have no notes");
        }

    }

    /**
     * creates a new note for the client
     */
    public void newNote(){
        Scanner scanner = new Scanner(System.in);
        String name = null;
        ArrayList<String> text = new ArrayList<>();
        String input = null;
        System.out.println("enter the title :");

        name = scanner.nextLine();
        System.out.println("Enter the text (enter -1 after the last line): ");
        do {
            input = scanner.nextLine();

            if(!(input.equals("-1"))){
                text.add(input);
            }
        }while (!(input.equals("-1")));
        fileUtils.saveNewNote(name , text);
    }
    /**
     * deletes a note for the client
     */
    public void deleteNote(){
        Scanner scanner = new Scanner(System.in);
        if(fileUtils.hasNotes()){
            int deletingNoteIndex;
            fileUtils.showNotesList();
            System.out.println("which note to delete ? : ");
            deletingNoteIndex = scanner.nextInt();
            fileUtils.deleteNoteByIndex(deletingNoteIndex);
        }
        else {
            System.out.println("You have no notes");
        }


    }
    /**
     * shows a note to the client
     */
    public void showOneNote(){
        Scanner scanner = new Scanner(System.in);

        if(fileUtils.hasNotes()){
            int input;
            fileUtils.showNotesList();
            System.out.println("which note to show ? :");
            input = scanner.nextInt();
            fileUtils.showNote(input);

        }
        else {
            System.out.println("You have no notes");
        }

    }





}
