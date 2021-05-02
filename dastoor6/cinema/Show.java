import java.util.Date;

public class Show {
    private String showName;
    private Date showDate;
    private Theater theater;

    public Show(String showName, Date showDate ,Theater theater) {
        this.showName = showName;
        this.showDate = showDate;
        this.theater = theater;
    }

    public void presentDetailsOfTheater(){

    }

    public void presentationDetailsOfCapacity(){

    }

    public void reserveSeats(Seat... seats){

    }


    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }


}
