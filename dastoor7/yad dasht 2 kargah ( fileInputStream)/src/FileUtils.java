import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * handles the file saving and loading operations
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public class FileUtils {
    private File notesFolder  = null;
    private File filesInFolder[] =null;

    public FileUtils(){

        notesFolder = new File("Notes");
        if(! notesFolder.exists()){
            notesFolder.mkdir();
        }

        filesInFolder = notesFolder.listFiles();
    }
    /**
     * saves a new note to the Notes folder
     * @param nameOfNote is the title of the note and the path of it
     * @param text is the ArrayList of the lines of the diary
     */

    public void saveNewNote(String nameOfNote , ArrayList<String> text)  {

        nameOfNote = "Notes/" + nameOfNote + ".txt";
        FileOutputStream fileOutputStream= null;
        try {
           fileOutputStream = new FileOutputStream(nameOfNote);

            for(String sentence : text){

                fileOutputStream.write(sentence.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            refreshFilesInFolder();

        }
    }

    /**
     * shows the list of notes to the client
     */

    public void showNotesList(){
        refreshFilesInFolder();
        try {
            int counter = 1;
            for (File file : filesInFolder){
                System.out.println(counter +"- "+ file.getName());
                counter++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
   checks if the input index is valid or not
    */

    private boolean isIndexValid(int index){
        refreshFilesInFolder();
        if(index > 0 && index <= filesInFolder.length){
            return true;
        }
        return false;
    }

    /**
     * shows a note to the client by the input index
     * @param index is the input index
     */

    public void showNote(int index){
        refreshFilesInFolder();
        if(isIndexValid(index)){
            try {
                printNote(filesInFolder[index-1].getCanonicalPath());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        else{
            System.out.println("the index is not valid");
        }
    }


    /*
      prints the note by the path of it
     */

    private void printNote(String notePath){
        FileInputStream fileInputStream = null;
        int n = 0;
        try{
            fileInputStream = new FileInputStream(notePath);
            while ((n = fileInputStream.read()) != -1){
                System.out.print((char) n);
            }

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * deletes a note by the index of it
     * @param deletingNoteIndex is the index of deleting note
     */
    public void deleteNoteByIndex(int deletingNoteIndex){
        refreshFilesInFolder();
        if(!isIndexValid(deletingNoteIndex)){
            System.out.println("not valid index to delete");
            return;
        }
        filesInFolder[deletingNoteIndex-1].delete();
    }
    /*
        refreshes the array of files
     */
    private void refreshFilesInFolder(){
        filesInFolder = notesFolder.listFiles();
    }
    /**
     * checks if the client has any notes or not
     * @return true if the client has any note , else false
     */
    public boolean hasNotes(){
        if(filesInFolder.length == 0){
            return false;
        }
        return true;
    }
}
