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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */

public class LogInFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection con = null;
    PreparedStatement pst;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label forgotpassword;
    @FXML
    private Button backbtn;
    
    public static String Username = null;
    public static String Password = null;
    
    @FXML
    private Button login;
    @FXML
    public void loginButtonAction(ActionEvent event) throws SQLException, IOException
    {
        String name = null,pass = null;
        Username = username.getText();
        Password = password.getText();
        

        try{
        con = DBConnection.dbconnect();
        Statement stm = con.createStatement();
        String query = "Select* From signup where Name='"+Username+"' and Password='"+Password+"'";
        ResultSet rs = stm.executeQuery(query);
        
           if(rs.next())
           {
               System.out.println("You Are right");
               name = rs.getString("Name");
               pass = rs.getString("Password");
               
           }
        }catch(Exception e)
        {
            System.out.println("Code jiboner Shotru");
        }
        if(Username.equals(name) && Password.equals(pass))
        {
            
            Parent root = FXMLLoader.load(getClass().getResource("HomePageFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        }
        else
        {
            System.out.println("Errrroooorrrr!!!!!!"); 
        }
    }
    
    @FXML
    public void backButtonAction() throws IOException
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
