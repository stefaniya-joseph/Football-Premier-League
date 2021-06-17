public class FootballClub extends SportsClub {

    //instance variables
    private int numberOfMatchesPlayed;
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfDefeats;
    private int numberOfGoalsScored;
    private int numberOfGoalsConceded;
    private int totalPoints;
    private String managerName;
    private String captainName;

    //constructors
    //public FootballClub(){}

    //argument constructors
    public FootballClub(String clubName, String clubLocation, String clubPresidentName, int clubContactNo, int clubEstYear, int numberOfMatchesPlayed, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsScored, int numberOfGoalsConceded, int totalPoints, String managerName, String captainName) {
        super(clubName,clubLocation,clubPresidentName,clubContactNo,clubEstYear);

        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        this.numberOfWins = numberOfWins;
        this.numberOfDraws = numberOfDraws;
        this.numberOfDefeats = numberOfDefeats;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfGoalsConceded = numberOfGoalsConceded;
        this.totalPoints = totalPoints;
        this.managerName=managerName;
        this.captainName=captainName;

    }

    //getters and setters
    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }


    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getNumberOfGoalsConceeded() {
        return numberOfGoalsConceded;
    }

    public void setNumberOfGoalsConceeded(int numberOfGaolsConceeded) {
        this.numberOfGoalsConceded = numberOfGaolsConceeded;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getCaptainName(){
        return captainName;
    }

    public void setCaptainName(String captainName){
        this.captainName=captainName;
    }


    @Override
    public String toString() {
        return "FootballClub{" + super.toString()  +"number of Wins=" + numberOfWins +", number of Draws=" + numberOfDraws +", number of Defeats=" + numberOfDefeats +", number of Goals Scored=" + numberOfGoalsScored +", number of Goals Conceded=" + numberOfGoalsConceded +", total Points=" + totalPoints +", number of Matches Played=" + numberOfMatchesPlayed +", Manager name=" + managerName+", Captain Name="+ captainName +'}';
    }


//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (!(o instanceof FootballClub)) return false;
//    if (!super.equals(o)) return false;
//    FootballClub that = (FootballClub) o;
//    return numberOfMatchesPlayed == that.numberOfMatchesPlayed &&
//            numberOfWins == that.numberOfWins &&
//            numberOfDraws == that.numberOfDraws &&
//            numberOfDefeats == that.numberOfDefeats &&
//            numberOfGoalsScored == that.numberOfGoalsScored &&
//            numberOfGoalsConceded == that.numberOfGoalsConceded &&
//            totalPoints == that.totalPoints &&
//            Objects.equals(managerName, that.managerName) &&
//            Objects.equals(captainName, that.captainName);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(super.hashCode(), numberOfMatchesPlayed, numberOfWins, numberOfDraws, numberOfDefeats, numberOfGoalsScored, numberOfGoalsConceded, totalPoints, managerName, captainName);
//  }
}

//refferences
//https://www.geeksforgeeks.org/constructors-in-java/
//https://www.tutorialspoint.com/what-is-the-difference-between-getter-setter-methods-and-constructor-in-java
//https://www.edureka.co/blog/pojo-in-java/
//https://data-flair.training/blogs/pojo-class-in-java/
//https://www.geeksforgeeks.org/pojo-vs-java-beans/

