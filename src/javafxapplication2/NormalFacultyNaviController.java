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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class NormalFacultyNaviController implements Initializable {

    @FXML
    private JFXButton StudAttendance;
    @FXML
    private JFXButton Messages;
    @FXML
    private JFXButton AboutMe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleAboutMe(MouseEvent event) {
         System.out.println("HelloAbboutMe selected");
       JavaFXApplication2.NF[0]=true;
    }

    @FXML
    private void handleStudAttendance(MouseEvent event) {
        System.out.println("Helloattendanceselected");
        JavaFXApplication2.NF[1]=true;
    }

    @FXML
    private void handleMessages(MouseEvent event) {
        JavaFXApplication2.NF[2]=true;
    }
    
}
