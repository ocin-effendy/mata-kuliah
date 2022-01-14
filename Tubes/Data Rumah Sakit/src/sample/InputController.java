package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InputController implements Initializable {

    Connection con=null;
    ResultSet rs = null;
    PreparedStatement pst =null;


    @FXML
    private TextField namaPasien;

    @FXML
    private TextField alamat;

    @FXML
    private TextField namaWali;

    @FXML
    private TextField umur;

    @FXML
    private TextArea rekamM;



    ObservableList<ModalTable> Dlist = FXCollections.observableArrayList();
    Alert setadd = new Alert(Alert.AlertType.ERROR);

    Alert sucsess = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    void submit(MouseEvent event) {
        if(namaPasien.getText().equals("")){
            setadd.setContentText("Field Ini Harus diisi");
            setadd.showAndWait();
        }else if (alamat.getText().equals("")){
            setadd.setContentText("Field Ini Harus diisi");
            setadd.showAndWait();
        }else if (namaWali.getText().equals("")){
            setadd.setContentText("Field Ini Harus diisi");
            setadd.showAndWait();
        }else if (umur.getText().equals("")){
            setadd.setContentText("Field Ini Harus diisi");
            setadd.showAndWait();
        }else if (rekamM.getText().equals("")){
            setadd.setContentText("Field Ini Harus diisi");
            setadd.showAndWait();
        }else {

            con = ConnectionMySQL.conDB();
            String Sql = "insert into datapasien (namaPasien, Alamat, namaWali, Umur, RekamMedis) values(?,?,?,?,?)";

            String pasien = namaPasien.getText();
            String almt = alamat.getText();
            String wali = namaWali.getText();
            String umr = umur.getText();
            String Rm = rekamM.getText();
            try {
                pst =  con.prepareStatement(Sql);
                pst.setString(1,pasien);
                pst.setString(2,almt);
                pst.setString(3,wali);
                pst.setString(4,umr);
                pst.setString(5,Rm);
                pst.execute();
                sucsess.setContentText("Sucsess");
                sucsess.showAndWait();

            }catch (Exception e){
                e.printStackTrace();

            }



        }


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
