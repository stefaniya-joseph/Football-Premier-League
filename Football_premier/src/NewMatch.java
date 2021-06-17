import java.io.Serializable;
import java.util.Objects;

public class NewMatch implements Serializable {

    private FootballClub teamA;
    private FootballClub teamB;
    private int teamAScore;
    private int teamBScore;
    private DateTime date;

    public NewMatch(FootballClub teamA, FootballClub teamB, int teamAScore, int teamBScore, DateTime date) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.date = date;
    }


    public FootballClub getTeamA() {
        return teamA;
    }

    public FootballClub getTeamB() {
        return teamB;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public DateTime getDate() {
        return date;
    }

    public void setTeamA(FootballClub teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(FootballClub teamB) {
        this.teamB = teamB;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "New Match{" +
                "Home side=" + teamA +
                ", away=" + teamB +
                ", Home goals=" + teamAScore +
                ", away goals=" + teamBScore +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewMatch)) return false;
        NewMatch newMatch = (NewMatch) o;
        return Objects.equals(teamA, newMatch.teamA) &&
                Objects.equals(teamB, newMatch.teamB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamA, teamB);
    }
}
