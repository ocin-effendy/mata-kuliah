package sample;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;


//class BackSound {
//    MediaPlayer mediaPlayer;
//    Media media;
//    String backSound;
//    public void startSong(){
//        backSound = "soundEffect/backBj.wav";
//        media = new Media(Paths.get(backSound).toUri().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        mediaPlayer.play();
//    }
//    public void stopSong(){
//        mediaPlayer.stop();
//    }
//}

class Link{
    String dDdata;
    Link next;
    public Link(String data){
        dDdata = data;
    }
    public void displayLink(){
        System.out.print(dDdata + " ");
    }
}

class FirstLastList{
    public Link first;
    public Link last;
    int size;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(String data){
        Link newLink = new Link(data);
        if (isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last = newLink;
        size++;
    }

    public void delete(){
        if (first.next == null)  last = null;
        first = first.next;
        size--;
    }

    public String displayList(){
        Link current = first;
        String list = "";
        while(current != null){
//            current.displayLink();
            list = list  + current.dDdata + "\n";
            current = current.next;
        }

        return list;
    }

    public String peek(){
        return first.dDdata;
    }

}

class LinkQueue{
    public FirstLastList theList;

    public LinkQueue(){
        theList = new FirstLastList();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void enqueue(String data){
        theList.insert(data);
    }

    public void dequeue(){
        theList.delete();
    }

    public String peekQueue(){
        return theList.peek();
    }

    public String displayQueue(){
        return theList.displayList();
    }
    public int size(){
        return theList.size;
    }
}


public class Main extends Application {
   static LinkQueue queue = new LinkQueue();

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane stackMenu = new StackPane();
        Scene sceneMenu = new Scene(stackMenu, 700, 500);

        VBox left = new VBox(100);
        left.setPrefWidth(200);
        left.setStyle("-fx-background-color: #123;");
        Text title =  new Text("My Music");
        title.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
        title.setFill(Color.WHITE);
        title.setStrokeWidth(1);
        title.setStroke(Color.BLUE);
        title.setTranslateX(20);
        title.setTranslateY(30);
        VBox button = new VBox(25);
        Button listSong = new Button("List Song");
        Button nextSong = new Button("Next Song");
        Button mySong = new Button("My Song");
        listSong.setMinSize(200,50);
        nextSong.setMinSize(200,50);
        mySong.setMinSize(200,50);
        listSong.setStyle("-fx-background-color: #00ff00");
        nextSong.setStyle("-fx-background-color: #00ff00");
        mySong.setStyle("-fx-background-color: #00ff00");
        button.getChildren().addAll(listSong,nextSong,mySong);
        left.getChildren().addAll(title,button);



        VBox right = new VBox(10);
        right.setPrefWidth(500);
        right.setStyle("-fx-background-color: #222;");
        right.setAlignment(Pos.CENTER);

        HBox up = new HBox();
        up.setPrefHeight(430);
        up.getChildren().addAll(left,right);

        VBox underBox = new VBox();
        underBox.setPrefHeight(70);
        underBox.setStyle("-fx-background-color: #555;");

        HBox under = new HBox(20);
        Button exit = new Button("Exit");
        Button play = new Button("Play");
        Button next = new Button("Next");
        under.getChildren().addAll(exit,play,next);
        under.setAlignment(Pos.BOTTOM_CENTER);

        underBox.getChildren().add(under);


        VBox utama = new VBox();
        utama.getChildren().addAll(up,underBox);
        stackMenu.getChildren().add(utama);

        listSong.setOnAction(p -> {
            right.getChildren().clear();
            Text listSongText = new Text("List Song");
            listSongText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
            listSongText.setFill(Color.WHITE);
            listSongText.setTranslateY(-50);

            TextArea contentList = new TextArea();
            contentList.setPrefWidth(100);
            contentList.setDisable(true);
            contentList.setText(queue.displayQueue());


            right.getChildren().addAll(listSongText,contentList);

        });
        nextSong.setOnAction(p -> {
            right.getChildren().clear();
            Text nextText = new Text("Next Song");
            nextText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
            nextText.setFill(Color.WHITE);
            right.getChildren().add(nextText);

        });

        mySong.setOnAction(p -> {
            right.getChildren().clear();
            Text mySongText = new Text("My Song");
            mySongText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
            mySongText.setFill(Color.WHITE);
            mySongText.setTranslateY(-50);

            TextArea allSong = new TextArea();
            allSong.setPrefWidth(100);
            allSong.setDisable(true);
            allSong.setText(moveData());
            HBox addSong = new HBox(10);
            Label nameSong = new Label("Name Song : ");
            nameSong.setTextFill(Color.WHITE);
            TextField userTextField = new TextField();
            Button add = new Button("Add to List");
            addSong.getChildren().addAll(nameSong,userTextField, add);



            right.getChildren().addAll(mySongText,allSong,addSong);

            add.setOnAction(a -> {
                if (!userTextField.getText().equals("")){
                    queue.enqueue(userTextField.getText());
                    userTextField.clear();
                }else{
                    alertDisplay("Warning!");
                }
            });

        });



        primaryStage.setScene(sceneMenu);
        primaryStage.setTitle("My Music Player");
        primaryStage.show();
    }

    public static String moveData(){
        String contentFolder = "Song : \n";
        File directory = new File("audio");
        File[] listOfFiles = directory .listFiles();
        int fileCount= Objects.requireNonNull(directory.list()).length;
        for (int i = 0; i < fileCount; i++){
//            System.out.println(listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
//            queue.enqueue(listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
            contentFolder += (i+1)+ ". " + listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4) + "\n";
        }
        return contentFolder;
    }

    public static void alertDisplay(String title){
        Stage alert = new Stage();
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(title);
        alert.setMinWidth(300);

        Label text = new Label("Input Must to be Complite");
        Button oke = new Button("oke");
        oke.setOnAction(e -> alert.close());


        VBox alertBox = new VBox(8);
        alertBox.setAlignment(Pos.CENTER);
        alertBox.setPadding(new Insets(30,0,30,0));
        alertBox.getChildren().addAll(text,oke);

        Scene sceneAlert = new Scene(alertBox);
        alert.setScene(sceneAlert);
        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
