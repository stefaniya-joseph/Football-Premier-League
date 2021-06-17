//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.Scene;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class PointsTable extends Application {
//
//    Stage window;
//    TableView<FootballClub>table;
//    private final ArrayList<FootballClub> footballClubArrayList=new ArrayList<>();
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        window=primaryStage;
//        window.setTitle("Premier League Table");
//
//        TableColumn<FootballClub,String> clubName = new TableColumn("Club Name");
//        clubName.setMinWidth(220);
//        clubName.setCellValueFactory(new PropertyValueFactory<>("clubname"));
//
//        TableColumn<FootballClub, Integer> matchesPlayed = new TableColumn("MP");
//        matchesPlayed.setMinWidth(50);
//        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("mp"));
//
//        TableColumn<FootballClub, Integer> wins = new TableColumn("W");
//        wins.setMinWidth(50);
//        wins.setCellValueFactory(new PropertyValueFactory<>("w"));
//
//        TableColumn<FootballClub, Integer> draw = new TableColumn("D");
//        draw.setMinWidth(50);
//        draw.setCellValueFactory(new PropertyValueFactory<>("d"));
//
//        TableColumn<FootballClub, Integer> loss = new TableColumn("L");
//        loss.setMinWidth(50);
//        loss.setCellValueFactory(new PropertyValueFactory<>("l"));
//
//        TableColumn<FootballClub, Integer> points = new TableColumn("Pts");
//        points.setMinWidth(50);
//        points.setCellValueFactory(new PropertyValueFactory<>("pts"));
//
//        TableColumn<FootballClub, Integer> goalsScored = new TableColumn("GS");
//        goalsScored.setMinWidth(50);
//        goalsScored.setCellValueFactory(new PropertyValueFactory<>("gs"));
//
//        TableColumn<FootballClub, Integer> goalsConceeded = new TableColumn("GC");
//        goalsConceeded.setMinWidth(50);
//        goalsConceeded.setCellValueFactory(new PropertyValueFactory<>("gc"));
//
//        TableColumn<FootballClub, Integer> goalDif = new TableColumn("GD");
//        goalDif.setMinWidth(50);
//        goalDif.setCellValueFactory(new PropertyValueFactory<>("gd"));
//
//        table=new TableView<>();
//        table.setItems(getClubs());
//        table.getColumns().addAll(clubName,matchesPlayed,wins,draw,loss,points,goalsScored,goalsConceeded,goalDif);
//
//
//
//
//        VBox vBox=new VBox();
//        vBox.getChildren().addAll();
//
//        Scene scene=new Scene(vBox);
//        window.setScene(scene);
//        window.show();
//    }
//    public ObservableList<FootballClub> getClubs() throws IOException {
//
//        ObservableList<FootballClub> footballClubs= FXCollections.observableArrayList();
//        footballClubs.add(new FootballClub("united","Mawanella","Ajmalista",777353428,1999,14,10,2,2,30,12,32,"Zidane","Nafees"));
//
////        FileInputStream fis=new FileInputStream("clubs.txt");
////        ObjectInputStream ois=new ObjectInputStream(fis);
////        for (;;){
////            try {
////                FootballClub cluby= (FootballClub) ois.readObject();
////                footballClubArrayList.add(cluby);
////                ObservableList<FootballClub> footballClubs= FXCollections.observableArrayList(footballClubArrayList);
////            }catch (EOFException | ClassNotFoundException e){
////                break;
////            }
////
////
////    }
////        fis.close();
////        ois.close();
////        return null ;
//        return footballClubs;
//    }
//}

