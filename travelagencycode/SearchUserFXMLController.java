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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SearchUserFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection con = null;
    PreparedStatement pst = null;
    Statement stm = null;
    ResultSet rs = null;
    
    public static String Username;
    public static String Password;
    @FXML
    private TextField username;
    @FXML
    private Button search;
    @FXML
    private Button backbtn;
    
    @FXML
    public void searchButtonAction(ActionEvent event) throws SQLException
    {
       String UserName = username.getText();
       
       try{
       con = DBConnection.dbconnect();
       stm = con.createStatement();
       String query = "Select* From signup where Name = '"+UserName+"'";
       rs = stm.executeQuery(query);
       
       if(rs.next())
       {
           Username = rs.getString("Name");
           Password = rs.getString("Password");
       }
       }catch(Exception e)
       {
           System.out.println(e);
       }
       if(UserName.equals(Username))
       {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("SeeUserInfoFXML.fxml"));
        
        Stage stage = new Stage();/*(Stage)(Window)search.getScene().getWindow();*/
        //window.setScene(new Scene(root,500,500));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
        {  
            System.out.println(e);
        }
       }
       else
       {
           System.out.println("Please enter valid username ");
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
    }    
    
}
