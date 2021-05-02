import java.util.ArrayList;

public class Client {
    private String name;
    private int id;
    private ArrayList<Seat> reservedSeats;

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
        this.reservedSeats = new ArrayList<>();
    }

    public void reserveSeat(Seat seat){

    }
    public void removeSeat(Seat seat){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
