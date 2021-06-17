import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PremierLeagueManager implements LeagueManager {

    private ArrayList<FootballClub> footballClubList=new ArrayList<>();

    // private List<FootballClub> footballClubList=new ArrayList<>();//array list to store clu details
    private final int clubCount=footballClubList.size(); //variable which stores no of regsted clubs
    private final ArrayList<NewMatch> matchList=new ArrayList<>();

    public ArrayList<FootballClub> getList() {
        return footballClubList;
    }

    @Override
    public void addClub(FootballClub newFootballClub){ //logic for adding a new club

        if (footballClubList.contains(newFootballClub)){ //checking whether any club is already stored with the same name
            System.out.println("This club is already registered under premier league.");
        }
        else if (clubCount==20){ //since PL is conducted with 20 teams, a checker for total clubs
            System.out.println("league is full");
        }
        else if (clubCount==19){ //this checker is used to give the user a high experience
            footballClubList.add(newFootballClub);

            System.out.println("Successfully registered");
            System.out.println("Number of registered clubs : "+footballClubList.size() );
            System.out.println("there is space for another one club to register");

        }
        else{
            footballClubList.add(newFootballClub);

            System.out.println("Successfully registered");
            System.out.println("Number of registered clubs : "+footballClubList.size() );
            System.out.println("there is space for another "+(20 -footballClubList.size()) +" clubs to register");
        }
    }
//    @Override
//    public void deleteClub(){
//        int size=footballClubList.size();
//        footballClubList.remove(size -1);
//    }

//    @Override
//    public FootballClub deleteClub(String clubName){ //logic to delete a club
//        FootballClub delClub=null; //initializing a club
//        for (FootballClub fc1:footballClubList){
//            String clubName1=fc1.getClubName();
//            if (clubName1.equals(clubName)){ ////checking the array list for matching club names
//                delClub=fc1;
//                footballClubList.remove(fc1);//if it exists, we delete
//                System.out.println("removed");
//
//                System.out.println("there is space for another "+(20 -footballClubList.size()) +" clubs to register");
//                break;
//
//            }else {
//                System.out.println("There is no such club registed");
//            }
//        }
//        //return delClub;
//        return delClub;
//    }
//    @Override
//    public void deleteClub(String clubName1){
//        FootballClub delClub=null;
//        if (footballClubList.isEmpty()){
//            System.out.println("There is no clubs registered here still");
//        }
//        else {
//
//            for (FootballClub footballClub:footballClubList){
//
//                if (clubName1.equals(footballClub.getClubName())){
//                    delClub=footballClub;
//
//                    footballClubList.remove(footballClub);
//                    System.out.println("Club removed successfully");
//                    System.out.println("Total number of clubs : "+ footballClubList.size());;
//                }else {
//                    System.out.println("there is no such club with the provided name.");
//                }
//            }
//        }
//    }


    @Override
    public boolean deleteClub(String clubName1) {
        boolean found = false;
        if (footballClubList.isEmpty()) { //checking for existance of clubs in list
            System.out.println("No clubs are registered still");
        } else {
            for (FootballClub Club1 : footballClubList) {
                if (Club1.getClubName().equals(clubName1)) { //checking for similar objects
                    found = true;

                    footballClubList.remove(Club1);//removing the object from list
                    System.out.println("successfully removed the club");
                    System.out.println("No of clubs : " + footballClubList.size());
                    break;
                }
                System.out.println("Sorry! there is no such club with the provided name.");
            }

        }
        return found;

    }
    //    @Override
//    public void deleteTeam() {
//    Scanner sc=new Scanner(System.in);
//    System.out.println("Insert club name: ");
//    String line = sc.nextLine();
//    for(FootballClub club : footballClubList) {
//        if(club.getClubName().equals(line)){
//            footballClubList.remove(club);
//            System.out.println("Club "+ club.getClubName()+" removed");
//            return;
//        }
//    }
//    System.out.println("No such club in league");
//}
    @Override
    public void displayStatistics(String clubName){ //logic to display stat of a club
        if (footballClubList.isEmpty()){ //checking the arraylist, whether it contain any elemnt
            System.out.println("No clubs are registered still");
        }
        else {
            boolean found=false;

            for (FootballClub club:footballClubList){
                if (club.getClubName().equals(clubName)){ //checking for existance of club
                    found=true; //if it exists, the follwing stats will be shown

                    System.out.println("Club Name       : "+club.getClubName());
                    System.out.println("Matches played  : "+club.getNumberOfMatchesPlayed());
                    System.out.println("Number of Wins  : "+club.getNumberOfWins());
                    System.out.println("Number of Loss  : "+club.getNumberOfDefeats());
                    System.out.println("Number of Tie   : "+club.getNumberOfDraws());
                    System.out.println("Total points    : "+club.getTotalPoints());
                    System.out.println("Goals Scored    : "+club.getNumberOfGoalsScored());
                    System.out.println("Goals conceded  : "+club.getNumberOfGoalsConceeded());
                    System.out.println("Goal deference  : "+(club.getNumberOfGoalsScored()-club.getNumberOfGoalsConceeded()));
                    //System.out.println("Club Name : "+club.getClubName());
                    System.out.println();
                    //System.out.println(matchList.contains(club));
                }
            }if(!found){ //if the club didnt exist, the message will be shown
                System.out.println("Sorry! there is no such club registered here.");
            }
        }

    }

    @Override
    public void premierLeagueTable(){
        if (footballClubList.isEmpty()){ //method to dislpay table
            System.out.println("No clubs are registered still to display the table");
        }else {
            //getting the right formt for the table with printf
            System.out.printf("%10s  %5s  %5s  %5s  %5s  %8s  %5s  %5s  %5s  \n", "Club Name", "MP", "W", "L", "T", "Points", "GS", "GC", "GD");

            Collections.sort(footballClubList, new PointsSorting());//sorting the values according to the points
            for (FootballClub club : footballClubList) {//getting out put
                System.out.printf("%10s  %5s  %5s  %5s  %5s  %5s  %8s  %5s  %5s  \n", club.getClubName(), club.getNumberOfMatchesPlayed(), club.getNumberOfWins(), club.getNumberOfDefeats(), club.getNumberOfDraws(), (club.getNumberOfWins()*3+club.getNumberOfDraws()), club.getNumberOfGoalsScored(), club.getNumberOfGoalsConceeded(), (club.getNumberOfGoalsScored() - club.getNumberOfGoalsConceeded()));
            }
        }
    }
    //"%-20s  %-5d  %-5d  %-5d  %-5d  %-8d  %-5d  %-5d  %-5d
    //%-20s  %-5s  %-5s  %-5s  %-5s  %-8s  %-5s  %-5s  %-5s

    @Override
    public void addMatch(String team1, String team2, int homegoals, int awaygoals, int year, int month, int day){
        if (footballClubList.isEmpty()){
            System.out.println("No clubs are registered still");
        }
        else{
            //initializing two club objects
            FootballClub home=null;
            FootballClub away=null;
            for (FootballClub club1:footballClubList) {
                if (club1.getClubName().equals(team1)) //checking for equal object in array list

                    home = club1; //if the clubs with same name exists, assigning it to the object created

            }

            if (home==null){ //if such club is not found, the error msg
                System.out.println("No such club in the premier league called " + team1);
                return;
            }
            for (FootballClub club2 : footballClubList) {
                if (club2.getClubName().equals(team2))
                    away = club2;

            }
            if (away==null){
                System.out.println("No such club in the premier league called " + team2);
                return;
            }else if (away==home){
                System.out.println("the clubs you entered are the same. please enter different clubs");
                return;
            }

            int homeGoals=-1; //assigning a default value for error handling
            try {
                homeGoals=(homegoals); //assigning the useer input value
            }catch (Exception e){
                System.out.println("Please enter the number of goals scored by home side : ");

            }
            if (homeGoals<0){ //error msgs for negative value
                System.out.println("expected to enter number of goals scored");
                return;
            }

            int awayGoals=-1;
            try {
                awayGoals=(awaygoals);
            }catch (Exception e){
                System.out.println("Please enter the number of goals scored by away side : ");

            }
            if (awayGoals<0){
                System.out.println("expected to enter number of goals scored");
                return;
            }

            //creating a match instance and assiging values for statistics of both the clubs
            NewMatch match =new NewMatch(home,away,homeGoals,awayGoals,new DateTime(year,month,day));
            match.setTeamA(home);
            match.setTeamB(away);
            match.setTeamAScore(homeGoals);
            match.setTeamBScore(awayGoals);
            matchList.add(match);
            assert home != null;
            home.setNumberOfGoalsScored(home.getNumberOfGoalsScored()+homeGoals);
            assert away != null;
            away.setNumberOfGoalsScored(away.getNumberOfGoalsScored()+awayGoals);
            home.setNumberOfGoalsConceeded(home.getNumberOfGoalsConceeded()+awayGoals);
            away.setNumberOfGoalsConceeded(away.getNumberOfGoalsConceeded()+homeGoals);
            home.setNumberOfMatchesPlayed(home.getNumberOfMatchesPlayed()+1);
            away.setNumberOfMatchesPlayed(away.getNumberOfMatchesPlayed()+1);

            //checking for win side and allocating points
            if (homeGoals>awayGoals){
                home.setTotalPoints(home.getTotalPoints()+3);
                home.setNumberOfWins(home.getNumberOfWins()+1);
                away.setNumberOfDefeats(away.getNumberOfDefeats()+1);
            }
            else if (awayGoals>homeGoals){
                away.setTotalPoints(away.getTotalPoints()+3);
                away.setNumberOfWins(away.getNumberOfWins()+1);
                home.setNumberOfDefeats(home.getNumberOfDefeats()+1);
            }
            else {
                home.setTotalPoints(home.getTotalPoints()+1);
                away.setTotalPoints(away.getTotalPoints()+1);
                home.setNumberOfDraws(home.getNumberOfDraws()+1);
                away.setNumberOfDraws(away.getNumberOfDraws()+1);
            }

        }


    }
    public void saveData(String fileName)throws IOException {
        FileOutputStream fos=new FileOutputStream(fileName);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        for (FootballClub clubx:footballClubList){
            oos.writeObject(clubx);//writing each instance of arraylist into the txt file
        }
//        for (NewMatch match:matchList){
//            oos.writeObject(match);
//        }
        oos.flush();
        fos.close();
        oos.close();



    }
    public void saveData2(String fileName)throws IOException {
        FileOutputStream fos=new FileOutputStream(fileName);
        ObjectOutputStream oos=new ObjectOutputStream(fos);


        for (NewMatch match:matchList){
            oos.writeObject(match);
        }
        oos.flush();
        fos.close();
        oos.close();



    }//retreiving data from the text file
    public ArrayList<FootballClub> loadData(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> footballClubList=new ArrayList<>();
        FileInputStream fis=new FileInputStream(fileName);
        ObjectInputStream ois=new ObjectInputStream(fis);
        for (;;){
            try {
                FootballClub cluby= (FootballClub) ois.readObject();
                footballClubList.add(cluby);
            }catch (EOFException e){
                break;
            }
//            try {
//                NewMatch match1=(NewMatch) ois.readObject();
//                matchList.add(match1);
//            }catch (EOFException e){
//                break;
//            }
        }
        fis.close();
        ois.close();
        //System.out.println("Data retrieved successfully");
        return footballClubList;
    }
    public void loadData2(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream(fileName);
        ObjectInputStream ois=new ObjectInputStream(fis);
        for (;;){

            try {
                NewMatch match1=(NewMatch) ois.readObject();
                matchList.add(match1);
            }catch (EOFException e){
                break;
            }
        }
        fis.close();
        ois.close();
        // System.out.println("Data retrieved successfully");
    }


    private static class PointsSorting implements Comparator<FootballClub> {//comparable interface to sort

        @Override
        public int compare(FootballClub club1, FootballClub club2) {

            if(club1.getTotalPoints() > club2.getTotalPoints()) //comparing two clubs points
                return -1;
            else
            if (club1.getTotalPoints() < club2.getTotalPoints())
                return 1;
            else {//when point are equal, checking for goal difference
                int goalDif = club1.getNumberOfGoalsScored()-club1.getNumberOfGoalsConceeded();
                int goalDif1 = club2.getNumberOfGoalsScored()-club2.getNumberOfGoalsConceeded();
                if(goalDif > goalDif1)
                    return -1;
                else
                if(goalDif < goalDif1)
                    return 1;
                else return 0;
            }

        }
    }



}
