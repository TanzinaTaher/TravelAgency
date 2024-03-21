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
public class SeeUserInfoFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection con = null;
    PreparedStatement pst = null; 
    Statement stm = null;
    ResultSet rs = null;
    @FXML
    private TextField username;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField bankbalance;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button backbtn;
    
    public void SeeUser()
    {
        String UserName = SearchUserFXMLController.Username;
        String PassWord = SearchUserFXMLController.Password;
        
        try{
            con = DBConnection.dbconnect();
            stm = con.createStatement();
            String query = "Select* From signup where Name = '"+UserName+"' and Password = '"+PassWord+"'";
            rs = stm.executeQuery(query);
            
            if(rs.next())
            {
                String Username = rs.getString("Name");
                username.setText(Username);
                String Phonenumber = rs.getString("PhoneNumber");
                phonenumber.setText(Phonenumber);
                String Bankbalance = rs.getString("BankBalance");
                bankbalance.setText(Bankbalance);
                String EmaiLAd = rs.getString("Email");
                email.setText(EmaiLAd);
                String Password = rs.getString("Password");
                password.setText(Password);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
     @FXML
    public void backButtonAction() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanelFXML.fxml"));
        
        Stage stage = (Stage)(Window)backbtn.getScene().getWindow();
        //window.setScene(new Scene(root,500,500));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SeeUser();
    }    
    
}
