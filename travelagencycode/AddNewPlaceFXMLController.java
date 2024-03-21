/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencycode;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class AddNewPlaceFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    Statement stm = null;
    ResultSet rs = null;
    @FXML
    private TextField place;
    @FXML
    private TextField price;
    @FXML
    private TextField adress;
    @FXML
    private Button backbtn;
    
    @FXML
    public void AddPlacesButtonAction(ActionEvent event)
    {
        String Place = place.getText();
        String Price = price.getText();
        String Adress = adress.getText();
        
        try{
            con = DBConnection.dbconnect();
            String query = "Insert into places(Place,Price,Adress)"+"Values(?,?,?)";
            
            pst = (PreparedStatement)con.prepareStatement(query);
            pst.setString(1,Place);
            pst.setString(2,Price);
            pst.setString(3,Adress);
            pst.executeUpdate();
            
            
            place.setText("");
            price.setText("");
            adress.setText("");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void BackButtonAction(ActionEvent event)
    {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanelFXML.fxml"));
        
        Stage stage = (Stage)(Window)backbtn.getScene().getWindow();
        //window.setScene(new Scene(root,500,500));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
