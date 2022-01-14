package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class DashboarDokterController implements Initializable {
    @FXML
    private Label nameAdmin;
    @FXML
    private Label coba;
    @FXML
    private TextField Search;

    @FXML
    private ListView<String> listviewDokter;

    @FXML
    private Label dataPasien;

    Alert setadd = new Alert(Alert.AlertType.ERROR);




    private final HashMap<String,String> student= new HashMap<>();
    public static String[] doctorName;

    public static String[] namaDokter = {"Lala Arifah Sania", "Nico Ardia Effendi", "Dandy Rachmad", "Zahrah Geraldi"};
    public static String[] tempDokter;
    public static int status =0 ;

    public static FileReader fileInput;
    public static BufferedReader bufferedReader;
    public static File file;
    public static LineNumberReader lineNumberReader;

    public static String tempJamPagi,tempJamSiang,tempJamMalam,alamatt,key;

    @FXML
    public void buttonDataPasien(MouseEvent e)throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
    @FXML
    void buttonSearch(MouseEvent r)throws IOException {
        key = Search.getText();


        System.out.println(key);
        int left = 0;
        int right = doctorName.length - 1;


        while(left <= right) {
            int mid = left + (right - left) / 2;

            //divide and conquer
            if(key.equals(doctorName[mid])) {
                System.out.println("Data ditemukan!");
                status=1;

                try {
                    fileInput = new FileReader("dataDokter.txt");
                    bufferedReader = new BufferedReader(fileInput);
                }catch (Exception e){
                    System.out.println("file cannot opened");
                    return;
                }

                String data = bufferedReader.readLine();
                while(data != null){
                    StringTokenizer stringToken = new StringTokenizer(data,"_");
                    if (key.equals(stringToken.nextToken())){
                        tempJamPagi = stringToken.nextToken();
                        tempJamMalam = stringToken.nextToken();
                        tempJamSiang = stringToken.nextToken();
                        alamatt = stringToken.nextToken();
                    }

                    data = bufferedReader.readLine();
                }



                try{
                    fileInput.close();
                    bufferedReader.close();
                }catch (IOException e){
                    System.out.println("file cannot closed");
                }



                Parent loader = FXMLLoader.load(getClass().getResource("formDokter.fxml"));
                Scene scene = new Scene(loader);

                Stage stage= new Stage();

                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);

                stage.show();
                return;
            } else if(key.compareTo(doctorName[mid])>0) {
                left = mid + 1;
            } else if(key.compareTo(doctorName[mid])<0){
                right = mid - 1;
            }


        }

        if (!doctorName.equals(key)){
            setadd.setContentText("Data tidak ditemukan");
            setadd.showAndWait();
        }


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



        //list view dijalankan pertama kali
        try{
            toArray();

        }catch (Exception e){
            System.out.println("not opened");
        }
        selectionSort(doctorName);

        listviewDokter.getItems().addAll(tempDokter);
    }

    public static void toArray() throws IOException{

        try {
            fileInput = new FileReader("dataDokter.txt");
            bufferedReader = new BufferedReader(fileInput);
            file = new File("dataDokter.txt");
            lineNumberReader = new LineNumberReader(new FileReader(file));
        }catch (Exception e){
            System.out.println("file cannot opened");
            return;
        }

        lineNumberReader.skip(Long.MAX_VALUE);
        int lines = lineNumberReader.getLineNumber();

        doctorName = new String[lines+1];
        tempDokter = new String[doctorName.length];

        String data = bufferedReader.readLine();
        int count = 0;
        while(data != null){
            StringTokenizer stringToken = new StringTokenizer(data,"_");
            doctorName[count] = stringToken.nextToken();

            count++;
            data = bufferedReader.readLine();


        }
        try{
            fileInput.close();
            bufferedReader.close();
            lineNumberReader.close();
        }catch (IOException e){
            System.out.println("file cannot closed");
        }





    }

    public static void selectionSort(String[] datadokter) {
        int indexMin = 0; //index untuk nilai terkecil

        for(int i = 0; i < datadokter.length; i++) {
            indexMin = i;
            for(int j = i + 1; j < datadokter.length; j++) {
                //< Ascending / > Descending
                if(datadokter[j].compareTo(datadokter[indexMin]) < 0) {
                    indexMin = j;
                }
            }

            //proses swap
            String temp = datadokter[i];
            datadokter[i] = datadokter[indexMin];
            datadokter[indexMin] = temp;
        }


        for(int i = 0; i < datadokter.length; i++) {

            tempDokter[i] = datadokter[i];
        }
    }
}
