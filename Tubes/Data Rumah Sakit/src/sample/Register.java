package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {



    Connection con=null;
    ResultSet rs = null;
    PreparedStatement pst =null;
    static String displayEmail;




    @FXML
    private Label wrongLogin;

    @FXML
    private Label register;

    @FXML
    private Label backlogin;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField Cpassword;

    @FXML
    private TextField name;

    @FXML
    private TextField username;
    @FXML
    private TextField email;

    public boolean cek(){
        con = ConnectionMySQL.conDB();
            String sql = "SELECT * FROM loginadmin Where email = '"+email.getText()+"'";
            try {
                Statement st = con.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()){
                    displayEmail= rs.getString(5);
                    return true;

                }else {
                    System.out.println("oke email tidak ada");
                    //System.out.println(displayEmail);
                }

            }catch (SQLException ex){
                System.err.println(ex.getMessage());
            }


        return false;
    }
    private static boolean isContain(String source, String subItem){
        String pattern = "\\b"+subItem+"\\b";
        Pattern p=Pattern.compile(pattern); //subitem
        Matcher m=p.matcher(source); //mencocokkan source dengan subitem
        return m.find();
    }




    public void register(MouseEvent event) {


        Alert setregister = new Alert(Alert.AlertType.ERROR);
        setregister.setTitle("Something Wrong");
        setregister.setHeaderText(null);

        String subitem = "@gmail.com";
        String emaill = email.getText();
        boolean containEmail = isContain(emaill,subitem);

        String pass= password.getText();
        String Cpass = Cpassword.getText();
        if (name.getText().equals("")){
            setregister.setContentText("nama tidak boleh kosong");
            setregister.showAndWait();
        }else if (username.getText().equals("")){
            setregister.setContentText("username tidak boleh kosong");
            setregister.showAndWait();
        }else if(password.getText().equals("")){
            setregister.setContentText("password tidak boleh kosong");
            setregister.showAndWait();
        }else if(!pass.equals(Cpass)){
            setregister.setContentText("password tidak sesuai");
            setregister.showAndWait();
            System.out.println(pass);
            System.out.println(Cpass);
        }else if(email.getText().equals("")){
            setregister.setContentText("email tidak boleh kosong");
            setregister.showAndWait();

        }  else if (!containEmail){
            setregister.setContentText("email tidak valid");
            setregister.showAndWait();

        } else{


            if (cek()==false||displayEmail==null||!displayEmail.equals(email.getText())){
                con = ConnectionMySQL.conDB();
                String nama = name.getText();
                String user = username.getText();
                String Sql = "insert into loginadmin (name, username, password, Cpassword,email) values(?,?,?,?,?)";
                try {
                    pst =  con.prepareStatement(Sql);
                    pst.setString(1,nama);
                    pst.setString(2,user);
                    pst.setString(3,pass);
                    pst.setString(4,Cpass);
                    pst.setString(5,emaill);
                    pst.execute();
                    wrongLogin.setText("Succses");
                }catch (Exception e){
                    e.printStackTrace();

                }

            }else if (cek()==true||displayEmail.equals(email.getText())){
                setregister.setContentText("email sudah ada");
                setregister.showAndWait();

            }




        }



    }

    public void backlogin(MouseEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(loader);

        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }




}
