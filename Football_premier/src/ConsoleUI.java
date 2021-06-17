import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI extends Application {
    static GUI gUIManager=new GUI();
    static LeagueManager manager=new PremierLeagueManager();
    final static Scanner s1=new Scanner(System.in);

    @Override
    public void start(Stage primaryStage)throws Exception{
        boolean exit=false;
        while (!exit){
            displayMenu();
        }
    }

    public static void main(String[] args)throws IOException, ClassNotFoundException {

        try { //this try catch is used in order to avoid errors while running the prgrm for te first time
            manager.loadData("clubs.txt");//loading data from the file
            manager.loadData2("matches.txt");
            System.out.println("Data retrieved successfully");

        }catch (Exception e){
            System.out.println("Welcome to Premier League for the first time");
        }

        Scanner userInput=new Scanner(System.in);


        menuLoop:
        while (true){
            displayMenu();//calling the menu loop
            int selection=0;

            try {
                selection= Integer.parseInt(userInput.next());
            }catch (Exception e ){
                System.out.println("Sorry! there is no such option for selection." +
                        "select again!");
            }

            switch (selection){//switch case for menu
                case 1:
                    addClub();
                    break;
                case 2:
                    deleteAClub();

                    break;
                case 3:
                    viewClubStat();
                    System.out.println();

                    manager.premierLeagueTable();
                    break;
                case 4:
                    // manager.premierLeagueTable();
                    launch(GUI.class);
                    //GUI.pointsTableGUI();

                    break;
                case 5:
                    addMatch();
                    break;
                case 6:
                    //saving the data entered by user in a file
                    manager.saveData("clubs.txt");
                    manager.saveData2("Matches.txt");
                    System.out.println("Data saved successfully.");
                    System.out.println("Thanks for giving updates!");
                    break menuLoop;

            }
        }

    }



    //console method fro display menu
    public static void displayMenu(){
        System.out.println("");
        System.out.println("WELCOME TO THE PREMIER LEAGUE");
        System.out.println("");
        System.out.println("Select from the following to proceed");
        System.out.println("1 - Add a new Club");
        System.out.println("2 - Delete an existing club");
        System.out.println("3 - View Statistics of a club");
        System.out.println("4 - View League standings");
        System.out.println("5 - Update a played match");
        System.out.println("6 - Save and Quit");
        System.out.println();
        System.out.print("Select your option  : ");
    }
    //console method to add a club
    public static void addClub()  {
        //declaring a new club
        FootballClub newFootballClub=null;

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter The club name :");
        String clubName=scanner.next();
        //validating user input
        while (!clubName.matches("[a-zA-Z]+")){
            System.out.println("Enter the club name without any errors!");
            System.out.print("Enter the club name  : ");
            clubName=scanner.next();
        }

        System.out.print("Enter The club office location : ");
        String clubLocation=scanner.next();
        while (!clubLocation.matches("[a-zA-Z]+")){
            System.out.println("Enter the club Location without any errors!");
            System.out.print("Enter the Location : ");
            clubLocation=scanner.next();
        }

        System.out.print("Enter The club president name: ");
        String clubPresidentName=scanner.next();
        while (!clubPresidentName.matches("[a-zA-Z]+")){
            System.out.println("Enter the club president name without any errors!");
            System.out.print("Enter the club president name  : ");
            clubPresidentName=scanner.next();
        }
        int clubContactNo=0;
        System.out.print("Enter The club contact number: ");

        boolean testCNo=false;
        while (!testCNo)  //reference :https://www.youtube.com/watch?v=2832YGSpbdk
            if (scanner.hasNextInt()) {
                clubContactNo = scanner.nextInt();
                testCNo = true;
            }else if (!scanner.hasNextInt()){
                System.out.println("Please enter number values only!");
                System.out.print("Enter the contact number again : ");
                scanner.next();
            }


        int clubEstYear=0;
        System.out.print("Enter The club established year : ");
        boolean testYr=false;
        while (!testYr)  //reference :https://www.youtube.com/watch?v=2832YGSpbdk
            if (scanner.hasNextInt()) {
                clubEstYear = scanner.nextInt();
                testYr = true;
            }else if (!scanner.hasNextInt()){
                System.out.println("Please enter number values only!");
                System.out.print("Enter the club established year again : ");
                scanner.next();
            }

        System.out.print("Enter The club manager name: ");
        String managerName=scanner.next();
        while (!managerName.matches("[a-zA-Z]+")){
            System.out.println("Enter the club manager name without any errors!");
            System.out.print("Enter the club manager name  : ");
            managerName=scanner.next();
        }


        System.out.print("Enter The captain name : ");
        String captainName=scanner.next();
        while (!captainName.matches("[a-zA-Z]+")){
            System.out.println("Enter the club captain name without any errors!");
            System.out.print("Enter the club captain name  : ");
            captainName=scanner.next();
        }

        int numberOfmatchesPlayed=0;
        int numberOfWins=0;
        int numberOfDefeats=0;
        int numberOfDraws=0;
        int numberOfGoalsScored=0;
        int numberOfGoalsConceded=0;

        //passing the values to the add method in premier league method and adding
        newFootballClub=  new FootballClub(clubName,clubLocation,clubPresidentName,clubContactNo,clubEstYear,
                numberOfmatchesPlayed, numberOfWins,numberOfDraws,numberOfDefeats,numberOfGoalsScored,
                numberOfGoalsConceded,(numberOfWins*3+numberOfDraws),managerName,captainName);
        manager.addClub(newFootballClub);

    }
    //delete method in console
    public static void deleteAClub(){
        Scanner scanner=new Scanner(System.in);
        //getting user input for club name
        System.out.print("Enter the club name which you want to remove : ");
        String fc1=scanner.next();
        while (!fc1.matches("[a-zA-Z]+")){//validating user input for string
            System.out.println("Enter the club  name without any errors!");
            System.out.print("Enter the club  name  : ");
            fc1=scanner.next();
        }
        manager.deleteClub(fc1);//calling delete method

    }
    //veiw club stat method
    public static void viewClubStat(){
        Scanner scanner=new Scanner(System.in);
        //getting useer input
        System.out.print("Enter the club name which you want to see the statistics : ");
        String clubName=scanner.next();
        //validating user input
        while (!clubName.matches("[a-zA-Z]+")){
            System.out.println("Enter the club name without any errors!");
            System.out.print("Enter the club name  : ");
            clubName=scanner.next();
        }
        manager.displayStatistics(clubName);
    }

    //method for adding a new match
    public static void addMatch(){
        //declaring a new match
        NewMatch playedMatch=null;
        Scanner scanner=new Scanner(System.in);
        System.out.println("provide the match held date in order");
        int year =0;
        //user input and validation
        System.out.print("Please Enter the Year : ");
        boolean testYr2=false;
        while (!testYr2)  //reference :https://www.youtube.com/watch?v=2832YGSpbdk
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                testYr2 = true;
            }else if (!scanner.hasNextInt()){
                System.out.println("Please enter number values only!");
                System.out.print("Enter the correct year again : ");
                scanner.next();
            }

        int month = 0;
        boolean testMnth=false;
        while (!testMnth) { //reference :https://www.youtube.com/watch?v=2832YGSpbdk
            try {
                System.out.print("Please Enter the Month (1-12) : ");
                month = scanner.nextInt();
                if(month> 0 && month < 13){
                    testMnth = true;
                } else {
                    System.out.println("the month is out of range.");

                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid month entered!!");
                System.out.print("Enter a valid month : ");
                scanner.next();
            }
        }


        int day = 0;
        boolean testDay=false;
        while(! testDay ) {

            try {
                System.out.print("Please Enter the Day (1-31) : ");
                day = scanner.nextInt();
                if(day >= 1 && day <= 31){
                    testDay = true;
                } else {
                    System.out.println("the day is out of range.");

                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid day!!");
                System.out.print("Enter a valid day : ");
                scanner.next();
            }
        }



        System.out.print("Enter the home team : ");
        String team1=scanner.next();
        while (!team1.matches("[a-zA-Z]+")){
            System.out.println("Enter the home club name without any errors!");
            System.out.print("Enter the club name  : ");
            team1=scanner.next();
        }

        System.out.print("Enter the away team: ");
        String team2=scanner.next();
        while (!team2.matches("[a-zA-Z]+")){
            System.out.println("Enter the away club name without any errors!");
            System.out.print("Enter the club name  : ");
            team2=scanner.next();
        }
        System.out.print("Enter Home goals scored : ");
        int homegoals=0;
        boolean testHGoals=false;
        while (!testHGoals)  //reference :https://www.youtube.com/watch?v=2832YGSpbdk
            if (scanner.hasNextInt()) {
                homegoals = scanner.nextInt();
                testHGoals = true;
            }else if (!scanner.hasNextInt()){
                System.out.println("Please enter number values only!");
                System.out.print("Enter the the home goals count : ");
                scanner.next();
            }
        System.out.print("Enter Away goals sored : ");
        int awaygoals=0;
        boolean testAGoals=false;
        while (!testAGoals)  //reference :https://www.youtube.com/watch?v=2832YGSpbdk
            if (scanner.hasNextInt()) {
                awaygoals = scanner.nextInt();
                testAGoals = true;
            }else if (!scanner.hasNextInt()){
                System.out.println("Please enter number values only!");
                System.out.print("Enter the the away goals count : ");
                scanner.next();
            }
        manager.addMatch(team1,team2,homegoals,awaygoals,year,month,day);
        System.out.println("Statistics updated successfully.!");
    }


}
