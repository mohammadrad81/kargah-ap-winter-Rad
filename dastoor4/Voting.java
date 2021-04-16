import ir.huri.jcal.JalaliCalendar;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.compare;
import static java.lang.Integer.parseInt;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String , HashSet<Vote>> polls;

    public Voting (int type , String question){
        this.type = type;
        this.question = question;
        voters = new ArrayList<>();
        polls = new HashMap<>();
    }

    public String getQuestion() {
        return question;
    }

    public int getType(){
        return this.type;
    }

    /**
     * creates a new hashset of votes for the poll
     * @param poll
     */
    public void createPoll(String poll){
        polls.put(poll , new HashSet<>());
    }

    /**
     * new vote gets added to the chosen poll
     * @param person
     * @param choices
     */
    public void vote (Person person , ArrayList<String> choices){
        voters.add(person);

        Iterator<String> iterator = choices.iterator();
        while (iterator.hasNext()){
            int year = java.time.LocalDate.now().getYear();
            int month = java.time.LocalDate.now().getMonthValue();
            int day = java.time.LocalDate.now().getDayOfMonth();



            GregorianCalendar gregorianCalendar = new GregorianCalendar(year , month , day);
            JalaliCalendar jalaliCalendar = new JalaliCalendar();
            jalaliCalendar.fromGregorian(gregorianCalendar);
            Vote vote = new Vote(person , jalaliCalendar.toString());

            polls.get(iterator.next()).add(vote);
        }
    }

    public ArrayList<Person> getVoters(){
        return voters;
    }

    /**
     * shows the result of the voting
     * if there were more than 1 most voted , shows them all
     */
    public void printResult(){
        int mostVotedChoiceCounter = 0;
        String mostVotedChoice = null;
        System.out.println("The question is : " + question);
        Iterator<Person> iterator = voters.iterator();

        Set<String> keys = polls.keySet();
        Iterator<String> key = keys.iterator();
        System.out.println("the choices and their votes are : ");
        int counter = 0;
        while (key.hasNext()){
            String choice = key.next();
            System.out.println(choice + ": ");

            Iterator<Vote> votes = polls.get(choice).iterator();
            counter = 0;
            while (votes.hasNext()){
                Vote vote = votes.next();
                counter ++;
                System.out.println(vote.getPerson().toString() + "   " +vote.getDate());

            }

            if(counter > mostVotedChoiceCounter ){
                mostVotedChoiceCounter = counter;

            }

        }

        System.out.println("the most voted choices are : ");
        int counter2 = 0;
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String choice = it.next();
            Iterator<Vote> voteIterator = polls.get(choice).iterator();
            counter2 = 0;
            Vote vote;
            while(voteIterator.hasNext()){
                vote = voteIterator.next();
                counter2 ++;
            }
            if(counter2 == mostVotedChoiceCounter) {
                System.out.println(choice);
            }
        }
    }

    /**
     * the getter fot the hash map of polls
     * @return the polls
     */
    public HashMap<String, HashSet<Vote>> getPolls(){
        return polls;
    }
}
