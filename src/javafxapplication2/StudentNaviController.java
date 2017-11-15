/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class StudentNaviController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton b4;
    @FXML
    private Label StudentUSN;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         System.out.println("Helo");
        System.out.println(FXMLDocumentController.USN);
        System.out.println("Helo");
         StudentUSN.setText(FXMLDocumentController.USN);
    }    
    
}
