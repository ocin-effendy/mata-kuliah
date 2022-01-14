package sample;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Login_Controler implements Initializable {








    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Label wrongLogin;


    @FXML
    private Button button;

    @FXML
    private Label bt_Login;

    @FXML
    private Label register;

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public static String usernamee ;
    public static String pasword;

    public void userlogin(MouseEvent event) throws IOException {
        if (login().equals("Success")){
            Parent loader = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(loader);

            Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        }
    }

    public Login_Controler() {
        con = ConnectionMySQL.conDB();
    }
    private String login() {
        String status = "Success";
        usernamee = username.getText();
        pasword = password.getText();
        if(usernamee.isEmpty() || pasword.isEmpty()) {
            wrongLogin.setText("Please enter your data.");
            status = "Error";
        } else {
            //query
            String sql = "SELECT * FROM loginadmin Where username = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, usernamee);
                preparedStatement.setString(2, pasword);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    wrongLogin.setText("Wrong username or password!");

                    status = "Eror";
                } else {
                    wrongLogin.setText("login sucsess");


                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }

        return status;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (con == null) {

            System.out.println("Server Error : Check");
        } else {

            System.out.println("Server is up : Good to go");
        }

    }

    public void register(MouseEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(loader);

        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }


}
