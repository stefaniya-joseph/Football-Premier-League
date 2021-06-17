import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class GUI extends Application {

    ConsoleUI console=new ConsoleUI();

    private final static PremierLeagueManager manager2=new PremierLeagueManager();


    public static void pointsTableGUI() throws IOException, ClassNotFoundException {
        Stage window = new Stage(); //
        window.setTitle("Premier League");
//        Label lb1 = new Label("List of clubs");
//        lb1.setLayoutX(300);
//        lb1.setLayoutY(20);
        TableView<TableDetails> table = new TableView<TableDetails>();
        ObservableList<TableDetails> data = FXCollections.observableArrayList();


        TableColumn clubName = new TableColumn("Club Name");

        clubName.setCellValueFactory(new PropertyValueFactory<>("clubname"));

        TableColumn matchesPlayed = new TableColumn("MP");

        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("mp"));

        TableColumn wins = new TableColumn("W");

        wins.setCellValueFactory(new PropertyValueFactory<>("w"));

        TableColumn draw = new TableColumn("D");

        draw.setCellValueFactory(new PropertyValueFactory<>("d"));

        TableColumn loss = new TableColumn("L");

        loss.setCellValueFactory(new PropertyValueFactory<>("l"));

        TableColumn points = new TableColumn("Pts");

        points.setCellValueFactory(new PropertyValueFactory<>("pts"));

        TableColumn goalsScored = new TableColumn("GS");

        goalsScored.setCellValueFactory(new PropertyValueFactory<>("gs"));

        TableColumn goalsConceeded = new TableColumn("GC");

        goalsConceeded.setCellValueFactory(new PropertyValueFactory<>("gc"));

        TableColumn goalDif = new TableColumn("GD");

        goalDif.setCellValueFactory(new PropertyValueFactory<>("gd"));

        table.setItems(data);
        table.getColumns().addAll(clubName,matchesPlayed,wins,draw,loss,points,goalsScored,goalsConceeded,goalDif);
        ArrayList<FootballClub> clubList= manager2.loadData("clubs.txt");
        for (FootballClub club: clubList) {
            TableDetails addRecord = new TableDetails(club.getClubName(),club.getNumberOfMatchesPlayed(),club.getNumberOfWins(),club.getNumberOfDraws(),club.getNumberOfDefeats(),club.getTotalPoints(),club.getNumberOfGoalsScored(),club.getNumberOfGoalsConceeded(),(club.getNumberOfGoalsScored()-club.getNumberOfGoalsConceeded()));
            table.getItems().add(addRecord);
        }

        table.setPrefSize(910,450);
        table.setLayoutX(100);
        table.setLayoutY(100);

        Pane root=new Pane();
        root.setStyle("-fx-background-color:#cc66ff");
        //lb1.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:30; -fx-pref-height:80; -fx-pref-width: 250;");
        root.getChildren().addAll(table);
        //Setting the scene
        Scene scene = new Scene(root, 950, 600);
        window.setTitle("List of Members.");
        window.setScene(scene);
        window.show();

    }
    public static void main(String[] args){
        launch (args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //boolean exit=false;

        Pane root2 = new Pane();

        GUI.setScene(new Scene(root2, 1000, 800));
        GUI.pointsTableGUI();

//        while (!exit){
//            exit=console.
//        }

    }

    private static void setScene(Scene scene) {
    }


}
