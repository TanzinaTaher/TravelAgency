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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SignUpFXMLController implements Initializable {

    Connection con;
    PreparedStatement pst;
    Statement stm = null;
    ResultSet rs = null;
    @FXML
    private TextField name;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField email;
    @FXML
    private TextField bankbalance;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private Button backbtn;

    public void signupButtonAction(ActionEvent event) throws SQLException {
        try {
            String Username = name.getText();
            String PhoneNumber = phonenumber.getText();
            String Email = email.getText();
            String BankBalance = bankbalance.getText();
            String Password = password.getText();
            String ConfirmPassword = confirmpassword.getText();

            con = DBConnection.dbconnect();
            String query = "Insert into signup(Name,PhoneNumber,Email,BankBalance,Password,ConfirmPassword)" + "Values(?,?,?,?,?,?)";
            PreparedStatement PreparedStatement;
            pst = (PreparedStatement) con.prepareStatement(query);

            boolean CorrectPass = true;
            boolean isGmail = true;
            boolean isnumber = true;
            boolean isbanknumber = true;
            /*StringBuilder sb = new StringBuilder(Email);
            sb = sb.reverse();
            String CheckGmail = sb.toString();
            String GmailFound = CheckGmail.substring(0,10);*/
             String GmailFound = "";
           
            System.out.println(GmailFound);

            try{
                if(Username.equals("") || PhoneNumber.equals("")|| Email.equals("")||BankBalance.equals("")||Password.equals("")||ConfirmPassword.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Fillup all the information");
                    throw new MyException("Empty Exception");
                }
            }catch(MyException e)
            {
                System.out.println(e);
            }
                
            try{
                 GmailFound = Email.substring(Email.length()-10,Email.length());
                if(Email.length()<=10)
                {
                    JOptionPane.showMessageDialog(null,"Please enter gmail with more length");
                    throw new MyException("Email length Exception");
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            try {
                if (!(Password.equals(ConfirmPassword))) {
                    CorrectPass = false;
                    JOptionPane.showMessageDialog(null, "Password and ConfirmPassword not matched!!");
                    throw new MyException("Password ConfirmPassword not matched!!");
                }

            } catch (MyException e) {
                System.out.println(e);
            }
            
            
            try {
                if (!(GmailFound.equals("@gmail.com"))) {
                    isGmail = false;
                    JOptionPane.showMessageDialog(null, "!!!@gmail.com!!!");
                    throw new MyException("Gmail Exception");
                }
            } catch (MyException e) {
                System.out.println(e);
            }

            try {
                int number = Integer.parseInt(PhoneNumber);
            } catch (NumberFormatException e) {
                isnumber = false;
                System.out.println(e);
            }
       
            try {
                if (isnumber == false) {
                    JOptionPane.showMessageDialog(null, "Phone number is not a number!!!");
                    throw new MyException("PhoneNumber Error");
                }
            } catch (MyException e) {
                System.out.println(e);
            }
            
            try{
                int banknumber = Integer.parseInt(BankBalance);
            }catch(NumberFormatException e)
            {
                isbanknumber = false;
                System.out.println(e);
            }
            
            try{
                if(isbanknumber==false)
                {
                    JOptionPane.showMessageDialog(null,"Bank Balance is not a number");
                    throw new MyException("Bank Balance Exception");
                }
            }catch(MyException e)
            {
                System.out.println(e);
            }
            
            
            try {
                if (CorrectPass == true && isGmail == true && isnumber == true && isbanknumber == true) {
                    pst.setString(1, Username);
                    pst.setString(2, PhoneNumber);
                    pst.setString(3, Email);
                    pst.setString(4, BankBalance);
                    pst.setString(5, Password);
                    pst.setString(6, ConfirmPassword);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Successfully Data Inserted");
                }
                else{
                    throw new MyException("All are incorrect");
                }
            } catch (MyException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*  public void GotoHomePage()throws Exception 
    {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("HomePageFXML.fxml"));
        
        Stage stage = new Stage();
       
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }*/
    @FXML
    public void BackButtonAction() throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomePageFXML.fxml"));

            Stage stage = (Stage) (Window) backbtn.getScene().getWindow();
            //window.setScene(new Scene(root,500,500));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
