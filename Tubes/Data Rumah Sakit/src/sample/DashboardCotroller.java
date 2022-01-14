package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DashboardCotroller implements Initializable {


    private static Stage stage;
    private static Scene scene;
    private static Parent root;


    @FXML
    private Label nameAdmin;

    @FXML
    private Button ButtonAdd;
    @FXML
    public TableView<ModalTable> Tabeldata;

    @FXML
    public TableColumn<ModalTable, String> col_pasien;

    @FXML
    public TableColumn<ModalTable, String> col_alamat;

    @FXML
    public TableColumn<ModalTable, String> col_wali;

    @FXML
    public TableColumn<ModalTable, String> umur;

    @FXML
    public TableColumn<ModalTable, String> rekammedis;

    @FXML
    private Button refresh;

    @FXML
    private Label dataDokter;

    ObservableList<ModalTable> Dlist = FXCollections.observableArrayList();

    int index = -1;

    @FXML
    void Add(MouseEvent event) throws IOException {

        Parent loader = FXMLLoader.load(getClass().getResource("Inputdata.fxml"));
        Scene scene = new Scene(loader);

        Stage stage= new Stage();

        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();

    }

    public void refresh(MouseEvent event) throws IOException{

        Dlist.clear();
        col_pasien.setCellValueFactory(new PropertyValueFactory<>(null));
        col_pasien.setCellValueFactory(new PropertyValueFactory<>(null));
        col_alamat.setCellValueFactory(new PropertyValueFactory<>(null));
        col_wali.setCellValueFactory(new PropertyValueFactory<>(null));
        umur.setCellValueFactory(new PropertyValueFactory<>(null));
        rekammedis.setCellValueFactory(new PropertyValueFactory<>(null));
        Tabeldata.setItems(Dlist);
        refreshTable();

    }


    public void buttonDataDokter(MouseEvent e)throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource("DashboardDokter.fxml"));
        Scene scene = new Scene(loader);

        Stage stage= (Stage) ((Node)e.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void buttonLogout(MouseEvent e)throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(loader);

        Stage stage= (Stage) ((Node)e.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }
    Connection con = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        con = ConnectionMySQL.conDB();
        //String sql = "SELECT * FROM login Where username = ? and password = ?";

        String sql = "SELECT * FROM loginadmin Where username = '"+Login_Controler.usernamee+"' and password = '"+Login_Controler.pasword+"'";


        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                nameAdmin.setText(rs.getString(1));

            }else {
                System.out.println("something wrong");
            }

        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }

        refreshTable();

    }

    public void getSelected(MouseEvent event) throws IOException {



        index = Tabeldata.getSelectionModel().getSelectedIndex();
        if (index<=-1){
            System.out.println("tidk masuk");
            return;
        }

        String pasien = col_pasien.getCellData(index).toString();
        System.out.println(pasien);
        String wali = col_wali.getCellData(index).toString();
        String almt = col_alamat.getCellData(index).toString();
        String umrrr = umur.getCellData(index).toString();
        String rekamMedis =    rekammedis.getCellData(index).toString();







        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormUpdate.fxml"));
        root = loader.load();
        FormController Formcontroller = loader.getController();
        Formcontroller.displayname(pasien,wali,almt,umrrr,rekamMedis);
        Stage stage= new Stage();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();




    }

    public void refreshTable() {
        con = ConnectionMySQL.conDB();

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from datapasien");

            while (rs.next()){

                Dlist.add(new ModalTable(rs.getString("namaPasien"),rs.getString("Alamat")
                        ,rs.getString("namaWali"), rs.getString("Umur"),rs.getString("RekamMedis")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_pasien.setCellValueFactory(new PropertyValueFactory<>("pasien"));
        col_alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        col_wali.setCellValueFactory(new PropertyValueFactory<>("nmWali"));
        umur.setCellValueFactory(new PropertyValueFactory<>("umurr"));
        rekammedis.setCellValueFactory(new PropertyValueFactory<>("rekamMedis"));
        Tabeldata.setItems(Dlist);


    }
}
