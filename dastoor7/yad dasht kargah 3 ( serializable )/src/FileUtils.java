import java.io.*;

/**
 * handles the file saving and loading operations
 * @author Mohammad Heydari Rad
 * @since 2021
 */

public class FileUtils {
    private File notesFolder = null;
    private File filesInFolder[] = null;

    public FileUtils(){
        notesFolder = new File("Notes");
        if(! notesFolder.exists()){
            notesFolder.mkdir();
        }

        filesInFolder = notesFolder.listFiles();
    }

    /**
     * saves a new note to the Notes folder
     * @param note is the saving note
     */
    public void saveNewNote(Note note){
        String nameOfNote = note.getTitle();
        nameOfNote = "Notes/" + nameOfNote + ".bin";
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
             fileOutputStream = new FileOutputStream(nameOfNote);
             objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(note);
            objectOutputStream.flush();
            objectOutputStream.close();

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
            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;
            Note note = null;
            for (File file : filesInFolder) {
                System.out.println(" note number " + counter + " :");
                counter++;
                try {
                    fileInputStream = new FileInputStream(file.getCanonicalPath());
                    objectInputStream = new ObjectInputStream(fileInputStream);

                    note = (Note) objectInputStream.readObject();
                    note.showForList();

                    objectInputStream.close();
                    fileInputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            refreshFilesInFolder();
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
            } catch (IOException e) {
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
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(notePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Note note = (Note) objectInputStream.readObject();

            note.completeShow();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            refreshFilesInFolder();
        }
    }

    /**
     * deletes a note by the index of it
     * @param deletingNoteIndex
     */
    public void deleteNoteByIndex(int deletingNoteIndex){
        refreshFilesInFolder();
        if(! isIndexValid(deletingNoteIndex)){
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
