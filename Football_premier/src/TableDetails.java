import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableDetails {

    private SimpleStringProperty clubName;
    private SimpleIntegerProperty noOfWins;
    private SimpleIntegerProperty noOfDraws;
    private SimpleIntegerProperty noOfDefeats;
    private SimpleIntegerProperty currentPoint;
    private SimpleIntegerProperty noOfMatchesPlayed;
    private SimpleIntegerProperty noOfGoalsScored;
    private SimpleIntegerProperty noOfGoalsReceived;
    private SimpleIntegerProperty goalDif;


    public TableDetails(String clubName,int noOfWins,int noOfDraws,int noOfDefeats,int currentPoint,int noOfMatchesPlayed,int noOfGoalsScored,int noOfGoalsReceived,int goalDif) {
        this.clubName=new SimpleStringProperty(clubName);
        this.noOfWins=new SimpleIntegerProperty(noOfWins);
        this.noOfDraws=new SimpleIntegerProperty(noOfDraws);
        this.noOfDefeats=new SimpleIntegerProperty(noOfDefeats);
        this.currentPoint=new SimpleIntegerProperty(currentPoint);
        this.noOfMatchesPlayed=new SimpleIntegerProperty(noOfMatchesPlayed);
        this.noOfGoalsScored=new SimpleIntegerProperty(noOfGoalsScored);
        this.noOfGoalsReceived=new SimpleIntegerProperty(noOfGoalsReceived);
        this.goalDif= new SimpleIntegerProperty(goalDif);
    }

    public String getClubName() {

        return clubName.get();
    }

    public void setClubName(String cName) {

        clubName.set(cName);
    }

    public int getNoOfWins() {
        return noOfWins.get();
    }

    public void setNoOfWins(int nWins) {

        noOfWins.set(nWins);
    }

    public int getNoOfDraws() {

        return noOfDraws.get();
    }

    public void setNoOfDraws(int nDraws) {

        noOfDraws.set(nDraws);
    }

    public int getNoOfDefeats() {

        return noOfDefeats.get();
    }

    public void setNoOfDefeats(int nDefeats) {

        noOfDefeats.set(nDefeats);
    }

    public int getCurrentPoint() {
        return currentPoint.get();
    }

    public void setCurrentPoint(int cPoint) {
        currentPoint.set(cPoint);
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed.get();
    }

    public void setNoOfMatchesPlayed(int nMatchesPlayed) {
        noOfMatchesPlayed.set(nMatchesPlayed);
    }

    public int getNoOfGoalsScored() {
        return noOfGoalsScored.get();
    }

    public void setNoOfGoalsScored(int nGoalsScored) {
        noOfGoalsScored.set(nGoalsScored);
    }

    public int getNoOfGoalsReceived() {
        return noOfGoalsReceived.get();
    }

    public void setNoOfGoalsReceived(int nGoalsReceived) {
        noOfGoalsReceived.set(nGoalsReceived);
    }

    public int getGoalDif() {
        return goalDif.get();
    }

    public void setGoalDif(int nGoalDif) {
        goalDif.set(nGoalDif);
    }
}

