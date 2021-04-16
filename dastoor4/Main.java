import java.util.*;

/**
 * this main is an example of use of these classes
 * @author Mohammad Heydari Rad
 * @since 2021
 */
public class Main {
    private static VotingSystem votingSystem = new VotingSystem();

    public static void main(String[] args) {
        menu();
    }

    /**
     * shows the main menu and gets the users input
     * and calls the required methods that user wants
     */
    public static void menu(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            int input;
            System.out.println("1.new voting");
            System.out.println("2.vote");
            System.out.println("3.results");
            System.out.println("4.exit");
            input = scanner.nextInt();
            if(input == 1){
                newVoting();
            }
            else if(input == 2){
                vote();
            }
            else if(input == 3){
                results();
            }
            else if(input == 4){
                return;
            }
            else {
                System.out.println("please Enter valid input.");
            }
        }

    }

    /**
     * makes a new voting for users
     */

    public static void newVoting(){
        Scanner scanner = new Scanner(System.in);
        char moreChoices;
        int type;
        String question;
        ArrayList<String> choices = new ArrayList<>();
        String choice;
        System.out.println("Enter the type of the voting (1 for multiple choices and 0 for single choice)");
        do{
            type = scanner.nextInt();
            if(type != 0 && type != 1){
                System.out.println("not valid input.");
            }
        }while(type != 0 && type != 1);
        System.out.println("Enter the question :");
        scanner.nextLine();
        question = scanner.nextLine();

        do{
            System.out.println("Enter the choice : ");
            choice = scanner.nextLine();
            choices.add(choice);
            System.out.println("more choices ? (y/n) ");
            moreChoices = scanner.next().charAt(0);
            scanner.nextLine();
        }while(moreChoices == 'y');
        Voting voting = new Voting(type , question);

        votingSystem.createVoting(question , type , choices);
    }

    /**
     * user can vote to a voting
     */
    public static void vote(){
            Scanner scanner = new Scanner(System.in);
            int counter = 1;
            int votingIndexPlus1;
            String firstName;
            String lastName;
            Iterator<Voting> votingIterator = votingSystem.getVotingList().iterator();
            while(votingIterator.hasNext()){
                Voting next = votingIterator.next();
                System.out.println(counter + " : " + next.getQuestion());
                counter ++;
            }
            System.out.println("which voting ?");
            votingIndexPlus1 = scanner.nextInt();
            scanner.nextLine();

            if(votingIndexPlus1 > votingSystem.getVotingList().size() || votingIndexPlus1 <=0){
                System.out.println("not valid input");
                return;
            }
            Voting voting = votingSystem.getVotingList().get(votingIndexPlus1-1);


            System.out.println("Enter your first name :");
            firstName = scanner.nextLine();

            System.out.println("Enter your last name : ");
            lastName = scanner.nextLine();

            if(didVoteBefore(firstName , lastName , voting)){
                System.out.println("you voted before .");
                System.out.println();
                return;
            }
                Person voter = new Person(firstName , lastName);
            Iterator<String> choices = voting.getPolls().keySet().iterator();
            int counter2 = 1;
            while(choices.hasNext()){

                String choice = choices.next();
                System.out.println("choice " + counter2 + "." + choice);
                counter2 ++;
            }
            ArrayList<String> votedOnes = new ArrayList<>();
            if (voting.getType() == 1){
                int votesNumber = 0;
                int votedIndex;
                System.out.println("Enter the count of your chosen ones : ");
                votesNumber = scanner.nextInt();
                System.out.println("Enter your chosen ones : ");
                for(int i = 0 ; i < votesNumber; i++){

                    votedIndex = scanner.nextInt();

                    if(votedIndex > voting.getPolls().keySet().size() || votedIndex <=0 ){
                        System.out.println("Not valid input");
                        return;
                    }

                    Iterator<String> iterator = voting.getPolls().keySet().iterator();
                    counter = 0;
                    String chosenOne = new String();
                    while(counter != votedIndex){
                        chosenOne = iterator.next();
                        counter ++;
                    }

                    votedOnes.add(chosenOne);
                }
            }
            else{
                String chosenOne = new String();

                System.out.println("random choice or manual ? (r / m) :");
                char randomOrNot = scanner.nextLine().charAt(0);
                if(randomOrNot == 'r'){
                   votedOnes = randomChoice(voting.getPolls().keySet());
                }
                else if(randomOrNot == 'm'){
                    System.out.println("Enter your choice");
                    int votedIndex = scanner.nextInt();

                    if(votedIndex > voting.getPolls().keySet().size() || votedIndex <= 0){
                        System.out.println("not valid input");
                        return;
                    }

                    Iterator<String> iterator = voting.getPolls().keySet().iterator();
                    counter = 0;

                    while(counter != votedIndex){
                        chosenOne = iterator.next();
                        counter ++;
                    }
                    votedOnes.add(chosenOne);
                }
                else{
                    System.out.println("not valid input .");
                    return;
                }

            }
            votingSystem.vote(votingIndexPlus1-1 , voter , votedOnes);
    }

    /**
     * user chooses the voting and sees the result
     */
    public static void results(){
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int votingIndexPlus1;

        Iterator<Voting> votingIterator = votingSystem.getVotingList().iterator();

        while(votingIterator.hasNext()){
            Voting next = votingIterator.next();
            System.out.println(counter + " : " + next.getQuestion());
            counter ++;
        }

        System.out.println("which voting ?");
        votingIndexPlus1 = scanner.nextInt();

        if(votingIndexPlus1 > votingSystem.getVotingList().size() || votingIndexPlus1 <=0){
            System.out.println("not valid input");
            return;
        }
        votingSystem.getResult(votingIndexPlus1 -1);
    }

    public static boolean didVoteBefore(String firstName , String lastName , Voting voting){
        Iterator<Person> voters = voting.getVoters().iterator();

        while(voters.hasNext()){
            Person voter = voters.next();
            if(voter.getFirstName().equals(firstName) && voter.getLastName().equals(lastName)){
                return true;
            }
        }

        return false;
    }

    /**
     * gets a set of choices and chooses a random choice instead of user
     * @param choices
     * @return an array list that only contains the random choice of the set
     */
    public static ArrayList<String> randomChoice(Set choices){
        int size = choices.size();
        int choiceIndex ;
        int counter = 0;
        String choice = new String();
        ArrayList<String> votedOnes = new ArrayList<>();
        Random random = new Random();
        choiceIndex = random.nextInt() % size;

        Iterator<String> iterator = choices.iterator();

        if(choiceIndex == 0){
            choice = iterator.next();
        }
        else {
            while(counter != choiceIndex){
                choice = iterator.next();
                counter ++;
            }
        }

        votedOnes.add(choice);
        return votedOnes;


    }
}
