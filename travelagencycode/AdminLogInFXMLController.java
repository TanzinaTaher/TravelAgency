/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencycode;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdminLogInFXMLController implements Initializable {

    @FXML
    private Button backbtn;
    Connection con = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    /**
     * Initializes the controller class.
     */
    public static String Username;
    public static String Password;
    
    public void LoginButtonAction(ActionEvent event)throws IOException, SQLException
    {
        String UserName = username.getText();
        String PassWord = password.getText();
        try{
        con = DBConnection.dbconnect();
        st = con.createStatement();
        String query = "Select* From signup where Name = '"+UserName+"' and Password = '"+PassWord+"'";
        rs = st.executeQuery(query);
        if(rs.next())
        {
           Username = rs.getString("Name");
           Password = rs.getString("Password");
        }
        else{
            System.out.println("Not Matched");
        }
        if((UserName.equals(Username))&&(PassWord.equals(Password)))
        {
            Parent root = FXMLLoader.load(getClass().getResource("AdminPanelFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    @FXML
    public void backButtonAction(ActionEvent event)throws Exception
    {
                Parent root = FXMLLoader.load(getClass().getResource("HomePageFXML.fxml"));
        
        Stage stage = (Stage)(Window)backbtn.getScene().getWindow();
        //window.setScene(new Scene(root,500,500));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
