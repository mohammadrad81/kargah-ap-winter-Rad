import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param file The file to be added.
     */
    public void addFile(Music file)
    {
        files.add(file);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)){
            System.out.println("Music name : " + files.get(index).getFileName());
            System.out.println("Artist name : " + files.get(index).getProducerName());
            System.out.println("Published at : " + files.get(index).getPublishYear());
        }
        else{
            System.out.println("Not valid index");
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {

        for(int i = 0; i < files.size(); i++){
            System.out.println();
            System.out.printf("Music %d : ", i+1 );
            listFile(i);
        }

    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)){
            files.remove(index);
        }
        else {
            System.out.println("Not valid index to remove");
        }

    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        System.out.println();
        if(validIndex(index)){
            player.startPlaying(files.get(index).getFileName());
        }
        else {
            System.out.println("Not valid index");
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
       if(index >= 0 && index < files.size()){
           return true;
       }

       return false;
    }

    /**
     * searches the input string in file names and producer names and displays them
     * @param str the input string
     */
    public void searchAndDisplay(String str){
        System.out.println("You searched : " + str);
        System.out.println("search results : ");
        boolean foundAtLeastOneResult = false;
        for(int i = 0; i < files.size() ; i++){
            if(search(str , files.get(i).getFileName()) || search(str , files.get(i).getProducerName())){
                foundAtLeastOneResult = true;

                System.out.printf("Music number %d int this collection : \n" , i+1 );
                listFile(i);

                System.out.println();
            }
        }

        if(foundAtLeastOneResult == false){
            System.out.println("No results");
        }
    }

    /**
     * searches the small string in the big string
     * @param small
     * @param big
     * @return if found small in big , true , else , false
     */
    private boolean search(String small , String big){
        if(big.indexOf(small) != -1){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * prints all musics that are favorites
     * (their isFavorite is true)
     */
    public void printFavorites(){
        for(int i = 0 ; i < files.size() ; i++ ){
            if(files.get(i).getIsFavorite()){
                listFile(i);
            }
        }
    }
}