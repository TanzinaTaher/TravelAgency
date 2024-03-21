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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UpdateUserFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    String Username = SeacrhUserUpdateFXMLController.Username;
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
    private Button backbtn;
    @FXML
    private Label showupdate;
    
    public void allset() throws SQLException
    {
        try{
        con = DBConnection.dbconnect();
        stm = con.createStatement();
        String query = "Select* From signup where Name = '"+Username+"'";
        rs = stm.executeQuery(query);
        
        if(rs.next())
        {
            String Username = rs.getString("Name");
            username.setText(Username);
            String Phonenumber = rs.getString("PhoneNumber");
            phonenumber.setText(Phonenumber);
            String Bankbalance = rs.getString("BankBalance");
            bankbalance.setText(Bankbalance);
            String Email = rs.getString("Email");
            email.setText(Email);
        }
        }catch(Exception e)
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
    
    @FXML
    public void UpdateData() throws SQLException
    {
        String USERName = username.getText();
        String PHONENumber = phonenumber.getText();
        String BANKBalance = bankbalance.getText();
        String EMAIL = email.getText();
        
        int bank = Integer.parseInt(BANKBalance);
        int phone = Integer.parseInt(PHONENumber);
       try{ 
        con = DBConnection.dbconnect();
        stm = con.createStatement();
        
        String query = "UPDATE signup SET Name='"+USERName+"' and PhoneNumber='"+phone+"' and BankBalance='"+bank+"' and Email='"+EMAIL+"' where Name='"+Username+"'";
        stm.executeUpdate(query);
        showupdate.setText("Update Successfully");
       }catch(Exception e)
       {
           System.out.println(e);
       }
    }
    
    public void DeleteUser() throws SQLException
    {
        try{
        con = DBConnection.dbconnect();
        stm = con.createStatement();
        String query = "DELETE FROM signup where Name='"+Username+"'";
        stm.executeUpdate(query);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            allset();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
