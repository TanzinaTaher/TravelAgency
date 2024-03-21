/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencycode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdminPanelFXMLController implements Initializable {

    @FXML
    private Button Seeuserinfo;
    @FXML
    private Button updateuser;
    @FXML
    private Button addplace;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void SeeUserInfoButtonAction(ActionEvent event) throws IOException
    {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("SearchUserFXML.fxml"));
        
        Stage stage = (Stage)(Window)Seeuserinfo.getScene().getWindow();
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
    
    @FXML
    public void UpdateUserButtonAction(ActionEvent event) throws IOException
    {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("SeacrhUserUpdateFXML.fxml"));
        
        Stage stage = (Stage)(Window)updateuser.getScene().getWindow();
        //window.setScene(new Scene(root,500,500));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void AddPlaceButtonAction()
    {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("AddNewPlaceFXML.fxml"));
        
        Stage stage = (Stage)(Window)addplace.getScene().getWindow();
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
