/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencycode;

import static java.awt.SystemColor.window;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author USER
 */
public class HomePageFXMLController implements Initializable {
    
    private Label label;
    @FXML
    private Button signup;
    @FXML
    private Button login;
    @FXML
    private Button adminlogin;
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    /*public void gotoSignUp()throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignUpFXML.fxml"));
        
        Stage stage= (Stage)(Window)signup.getScene().getWindow();
        //window.setScene(new Scene(root,500,700));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }*/
    public void SignUpMethod() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpFXML.fxml"));
        
        Stage stage= (Stage)(Window)signup.getScene().getWindow();
        //window.setScene(new Scene(root,500,700));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public void gotoLogIn()throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("LogInFXML.fxml"));
        
        Stage stage = (Stage)(Window)login.getScene().getWindow();
        //window.setScene(new Scene(root,500,500));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
 
    public void AdminLogin()throws Exception
    {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogInFXML.fxml"));
        
        Stage stage = (Stage)(Window)adminlogin.getScene().getWindow();
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
