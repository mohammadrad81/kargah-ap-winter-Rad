import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * a class that is used to store a note
 * @author Mohammad Heydari Rad
 * @since 2021
 */
public class Note implements Serializable {

    private String title;
    private LocalDate localDate;
    private ArrayList<String> text;

    public Note (String title , ArrayList<String> text){
        this.title = title;
        this.text = text;
        this.localDate = LocalDate.now();
    }

    /**
     * shows the title , the date and the first line of the note
     */
    public void showForList(){
        System.out.println(title);
        System.out.println("Date : " + localDate.toString());
        if(text.size() > 0){
            System.out.println(text.get(0));
        }
    }

    /**
     * prints all things of the note (title , date , text)
     */
    public void completeShow(){
        System.out.println( "Title : " + title);
        System.out.println("Date : " + localDate.toString());
        System.out.println("Text :");
        for(String line : text){
            System.out.println(line);
        }
    }

    /**
     *
     * @return the title of the note
     */
    public String getTitle() {
        return title;
    }

}
