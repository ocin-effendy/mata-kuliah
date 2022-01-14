package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class formDokterController implements Initializable {
    @FXML
    private Label getDokter;

    @FXML
    private Label jamPagi;

    @FXML
    private Label jamSiang;

    @FXML
    private Label jamMalam;

    @FXML
    private Label alamat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDokter.setText(DashboarDokterController.key);
        jamPagi.setText(DashboarDokterController.tempJamPagi);
        jamSiang.setText(DashboarDokterController.tempJamSiang);
        jamMalam.setText(DashboarDokterController.tempJamMalam);
        alamat.setText(DashboarDokterController.alamatt);
    }
}
