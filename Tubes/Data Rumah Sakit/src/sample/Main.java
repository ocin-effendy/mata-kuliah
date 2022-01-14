package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * <h1>Penjualan pulsa</h1>
 * program untuk penjualan pulsa
 * login menggunakan mysql dan data transaksi disimpan di file
 * @author tim tubes
 * @version 1.0
 * @since 2021-06-25
 */

public class Main extends Application {


    /**
     * untuk inisialisasi stage javafx pertama
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Tubes");
        primaryStage.setScene(new Scene(root, 652, 392));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     *untuk memanggil objek di kelas pilhan meu dan login
     */




    public static void main(String[] args) {
        launch(args);
    }
}
