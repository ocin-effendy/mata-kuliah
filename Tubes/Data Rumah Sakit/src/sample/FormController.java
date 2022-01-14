package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private TextField nmPasien;


    @FXML
    private TextField alamat;

    @FXML
    private TextField namaWali;

    @FXML
    private TextField umur;

    @FXML
    private TextArea rekamM;

    PreparedStatement pst =null;

    @FXML
    private TextField visible;
    public String pasien;

    public void displayname(  String psn,String  almt,String walii,String umr,String medis){
        pasien =psn;
        visible.setText(pasien);
        alamat.setText(almt);
        namaWali.setText(walii);
         umur.setText(umr);
        rekamM.setText(medis);

    }
    Connection con = null;

    Alert setinfo = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    public void buttonDelete(){


        con = ConnectionMySQL.conDB();
        String sql = "delete from datapasien where namaPasien = ?";
        try {
            pst =  con.prepareStatement(sql);
            pst.setString(1,pasien);
            pst.execute();
            setinfo.setContentText("Berhasil di delete");
            setinfo.showAndWait();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    public void buttonUpdate(){



        con = ConnectionMySQL.conDB();

        String sql = "update datapasien set namaPasien= '"+visible.getText()+"',Alamat='"+alamat.getText()+"', namaWali= '"+namaWali.getText()+"',Umur = '"+umur.getText()+"',RekamMedis= '"+rekamM.getText()+"' where namaPasien = '"+visible.getText()+"'";

        try {

            pst =  con.prepareStatement(sql);

            pst.execute();

            setinfo.setContentText("Berhasil di update");
            setinfo.showAndWait();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




    }
}
