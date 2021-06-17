public class Test {
    static public void main(String[] args) {
        LeagueManager manager = new PremierLeagueManager();
        FootballClub F1=new FootballClub("united","Mawanella","Ajmalista",777353428,1999,14,10,2,2,30,12,32,"Zidane","Nafees");
        FootballClub F2=new FootballClub("serendip","Mawanella","Ajmalista",777353428,1999,14,10,3,1,30,12,33,"Zidane","Nafees");
        FootballClub F3=new FootballClub("riverside","Mawanella","Ajmalista",777353428,1999,14,10,3,1,30,12,33,"Zidane","Nafees");
        //  System.out.println(F1);
        manager.addClub(F1);
        // System.out.println(F2);
        manager.addClub(F2);
        manager.addClub(F3);

        // manager.deleteClub("serendip");
        manager.displayStatistics("serendip");
        System.out.println();
        // manager.premierLeagueTable();
        //manager.deleteClub("serendip");
        //manager.deleteTeam();
        manager.premierLeagueTable();
        //manager.addMatch("united","serendip",2,1);
        manager.premierLeagueTable();

    }
}

