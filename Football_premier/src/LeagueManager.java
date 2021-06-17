import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    void addClub(FootballClub newFootballClub);
    void displayStatistics(String clubName);
    void premierLeagueTable();

    boolean deleteClub(String clubName1);
    void addMatch(String team1, String team2, int homegoals, int awaygoals, int year, int month, int day);

    void saveData(String fileName)throws IOException;
    void saveData2(String fileName)throws IOException;
    ArrayList<FootballClub> loadData(String fileName) throws IOException, ClassNotFoundException;
    void loadData2(String filename)throws IOException, ClassNotFoundException;



}