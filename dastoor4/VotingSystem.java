import java.util.ArrayList;
import java.util.Iterator;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    public VotingSystem (){
        votingList = new ArrayList<>();
    }

    /**
     * creates a new voting and adds to this voting system
     * @param question
     * @param type
     * @param choices
     */
    public void createVoting(String question , int type , ArrayList<String> choices){
        Voting voting = new Voting(type , question);

        Iterator<String> iterator = choices.iterator();
        while (iterator.hasNext()){
            voting.createPoll(iterator.next());
        }

        votingList.add(voting);
    }

    /**
     * the getter for the voting list
     * @return voting list (array list)
     */
    public ArrayList<Voting> getVotingList(){
        return votingList;
    }

    public Voting getVoting (int index){
        return votingList.get(index);
    }

    /**
     * a new vote gets added in the specific voting
     * @param index
     * @param person
     * @param choices
     */
    public void vote(int index , Person person , ArrayList<String> choices){
        Voting voting = getVoting(index);
            voting.vote(person, choices);
    }

    /**
     * shows the result of the specific voting
     * @param index
     */
    public  void getResult(int index){
        votingList.get(index).printResult();
    }
}
