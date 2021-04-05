import java.util.Scanner;

/**
 * this Main class is an example of using this project
 */
public class Main {
    private static MusicCollection pop = new MusicCollection();
    private static MusicCollection jazz = new MusicCollection();
    private static MusicCollection rock = new MusicCollection();
    private static MusicCollection country = new MusicCollection();

    private static MusicCollection favorites = new MusicCollection();
//    private static MusicCollection favorites = new MusicCollection();
    private static MusicCollection chosenCollection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Music pop1 = new Music("salam" , "javad yasari" , 1980);
        Music pop2 = new Music("khoda hafez" , "javad yasari" , 1982);

        Music jazz1 = new Music("jazz rooz" , "ghorban ali" , 1970);

        Music rock1 = new Music("funeral" , "sleep dealer" , 2009);

        Music country1 = new Music("country music" , "country artist" , 2000);

        pop.addFile(pop1);
        pop.addFile(pop2);

        jazz.addFile(jazz1);

        rock.addFile(rock1);

        country.addFile(country1);

        pop.searchAndDisplay("javad");

        pop.searchAndDisplay("khoda");

        pop.searchAndDisplay("akbar abdi");

        jazz.startPlaying(5); // invalid index

        jazz.startPlaying(0);

        jazz.stopPlaying();

        pop1.setIsFavorite(true);

        jazz1.setIsFavorite(true);

        printAllFavorites();

        System.out.println("the pop list file before removing");
        pop.listAllFiles();

        pop.removeFile(0);

        System.out.println("the pop list after removing index 0");
        pop.listAllFiles();






    }

    /**
     * prints all favorites of each collection
     */
    private static void printAllFavorites(){
        System.out.println();
        System.out.println();

        System.out.println("Favorites in pop : ");
        pop.printFavorites();

        System.out.println("Favorites in jazz : ");
        jazz.printFavorites();

        System.out.println("Favorites in rock : ");
        rock.printFavorites();

        System.out.println("Favorites in country : ");
        country.printFavorites();

    }


}
