/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import static javafxapplication2.FXMLDocumentController.rootP;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class ScreenLoaderController implements Initializable {

private double xOffset = 0;
    private double yOffset = 0;

   public static AnchorPane rootP;
    @FXML
    private AnchorPane rootA;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        loadScreen(); 
       rootP=rootA;
    }    
    public void loadScreen() 
    { 
       try {
           StackPane p =FXMLLoader.load(getClass().getResource("Load.fxml"));
           rootA.getChildren().setAll(p);
           FadeTransition fi = new FadeTransition(Duration.seconds(5),p);
           fi.setFromValue(0);//first opaacity will be 0 
           fi.setToValue(1);////changes to 1
           fi.setCycleCount(1);//after one iteration of fade in  the fadeout will start
           
           FadeTransition fo = new FadeTransition(Duration.seconds(5),p);
           fo.setFromValue(1);//first opaacity will be 1 
           fo.setToValue(0);////changes to 0
           fo.setCycleCount(1);
           
           
           fi.play();
           fi.setOnFinished((e)->{
                
                   fo.play();// after fade in play fade out

           });
           
           //call login
           
            fo.setOnFinished((e)->{
                gotoLogin();
              
           });
           
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
  //  final AudioClip bar1Note = 
        //    new AudioClip(getClass().getResource("speech.wav").toString());
    public void gotoLogin(){
         try {
                   Stage stage;
                   Parent root;
                   
                   stage=(Stage)rootA.getScene().getWindow();
                   
                   root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                   BorderPane root1 = new BorderPane(root);
                   
                   root1.setOnMousePressed((MouseEvent event1) -> {
                       xOffset = event1.getSceneX();
                       yOffset = event1.getSceneY();
                   });
                   root1.setOnMouseDragged((MouseEvent event1) -> {
                       stage.setX(event1.getScreenX() - xOffset);
                       stage.setY(event1.getScreenY() - yOffset);
                   });
                   //create a new scene with root and set the stage
                   Scene scene = new Scene(root1);
                   stage.setScene(scene);
                   
                   stage.show();
                 //  bar1Note.play();
                   
                   
               } catch (IOException ex) {
                   Logger.getLogger(ScreenLoaderController.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
}
