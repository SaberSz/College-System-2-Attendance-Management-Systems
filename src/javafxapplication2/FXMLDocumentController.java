/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.jfoenix.validation.RequiredFieldValidator;
import static java.awt.Color.BLACK;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author dylan
 */
public class FXMLDocumentController implements Initializable {
   static boolean roboCounter=false;
   public static String USN;
   
    @FXML
    private  JFXTextField eUser;
      @FXML
    private  JFXButton Faculty,Student,Login2,Login21;
      @FXML
    private  JFXDatePicker eDOB;
      @FXML
    private  AnchorPane FacultyLogIn,StudentLogIn;
    static int k=0;  
    static int l[]={0,0,0,0,0,0,0,0,0,0};
    @FXML
    private JFXCheckBox notRobot;
    
   // @FXML
   // private JFXButton abc;
    @FXML
    private JFXButton l1;
    @FXML
    private JFXButton l2;
    @FXML
    private JFXButton l3;
    @FXML
    private JFXButton l4;
    @FXML
    private JFXButton l5;
    @FXML
    private JFXButton l9;
    @FXML
    private JFXButton l7;
    @FXML
    private JFXButton l8;
    @FXML
    private JFXButton l6;
    @FXML
    private JFXButton l10;
private double xOffset = 0;
    private double yOffset = 0;
      

   // @FXML
  //  private JFXDrawer StudentDraw;
    @FXML
    private AnchorPane r;
     public static AnchorPane rootP;

    
    
    @FXML
    private void handleFacultyEntry(MouseEvent event) {
     eUser.setText("");
     eUser.setPromptText("Faculty Identificcation Number");
         StudentLogIn.setVisible(false);

       StudentLogIn.setDisable(true);
              FacultyLogIn.setVisible(true);
       FacultyLogIn.setDisable(false);
  
    }
    @FXML
    private void handleStudentEntry(MouseEvent event) {
        eUser.setText("");
        eUser.setPromptText("University Seat Number");
       FacultyLogIn.setDisable(true);
       FacultyLogIn.setVisible(false);
       StudentLogIn.setVisible(true);
       StudentLogIn.setDisable(false);
        
           
    }
    
     @FXML
    private void handleClose(MouseEvent event) {
        
        System.exit(0);
    }
    
     @FXML
    private void handlemin(MouseEvent event) {
        Stage stage;
        stage= stage=(Stage)Student.getScene().getWindow();
        stage.setIconified(true);
        
    }
    
     @FXML
    private void handleLoginButton(MouseEvent event) throws IOException {
        try{
            
        
        DBMS.CheckPer per=new DBMS.CheckPer();
        Stage stage; 
     Parent root;
        if(event.getSource()==Login21)
        {
            System.out.println(roboCounter);
            //Faculty Login
            if(roboCounter)
            {
                roboCounter=false;// After the swicthing of scenes this Controller will still be running.
                // That leads to all the variables (atleast the static ones) still retaining their values.
                notRobot.setSelected(true);
                if(eUser.getText().substring(0, 3).toUpperCase().equals("FID")){
              if(eUser.getText().equals("")|| eDOB.getValue().toString().equals("") || !(per.checkFaculty(eUser.getText(),eDOB.getValue().toString())))
              {
                  
                    AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
                   
             } else {
                   AlertBox.notificationInfo("Welcome", "Hello "+eUser.getText().toUpperCase());
                  JavaFXApplication2.UserName=eUser.getText().toUpperCase();
                  stage=(Stage)Login21.getScene().getWindow();
                     //load up OTHER FXML document
                    root = FXMLLoader.load(getClass().getResource("Faculty.fxml"));
                  BorderPane root1 = new BorderPane(root);

        root1.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
        root1.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });
                  USN=eUser.getText().toUpperCase();
                  System.out.println(USN);
                  System.out.println(eDOB.getValue().toString());
                  //System.out.println(abc.getText());
                  //create a new scene with root and set the stage
                    Scene scene = new Scene(root1);
                    stage.setScene(scene);
                    stage.show();
                   AlertBox.notificationInfo("Hello?", "You know a simple Hello would be nice.\n If you did say Hello, what were you thinking? ");
                }
            }
                else
                {
                    //check HOD
                    if(eUser.getText().equals("")|| eDOB.getValue().toString().equals("") || !(per.checkFaculty(eUser.getText(),eDOB.getValue().toString())))
              {
                 
                   AlertBox.notificationInfo("Error", "Error in input");
                   
             } else {
                  JavaFXApplication2.UserName=eUser.getText().toUpperCase();
                  stage=(Stage)Login21.getScene().getWindow();
                     //load up OTHER FXML document
         
                    root = FXMLLoader.load(getClass().getResource("Faculty.fxml"));
                  //AlertBox.display("Success", "Hello "+eUser.getText().toUpperCase());
                  USN=eUser.getText().toUpperCase();
                  System.out.println(USN);
                  System.out.println(eDOB.getValue().toString());
                   BorderPane root1 = new BorderPane(root);

        root1.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
        root1.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });
                  //System.out.println(abc.getText());
                  //create a new scene with root and set the stage
                    Scene scene = new Scene(root1);
                    stage.setScene(scene);
                    stage.show();
                }
                    
                    
                    
                    
                    
                    
                    
                    
                }
                
           }
           else
            {
                AlertBox.notificationWarn("Robot","Mr.Robot please get back to work. Your show is failing");
                
            }
        } 
        else if(event.getSource()==Login2)
        {
            
              
             System.out.println(roboCounter);
            //Student Login
             if(roboCounter)
            {
               
                roboCounter=false;
                 notRobot.setSelected(true);
              if(eUser.getText().trim().equals("")|| eDOB.getValue().toString().equals("") || !(per.checkStudent(eUser.getText().trim(),eDOB.getValue().toString())))
              {
                  System.out.println(eUser.getText());
                  System.out.println(eDOB.getValue().toString());
                AlertBox.notificationInfo("Error", "Error in input");
                     
             } else {
                  AlertBox.notificationInfo("Welcome", "Hello "+eUser.getText().toUpperCase());
                 JavaFXApplication2.UserName=eUser.getText().toUpperCase();
                 /* stage=(Stage)Login2.getScene().getWindow();
                  root = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                  Scene scene = new Scene(root);
                  ScreenController screenController = new ScreenController(scene);
                screenController.addScreen("StudentPage", FXMLLoader.load(getClass().getResource( "StudentPage.fxml" )));
              //  screenController.add("testSwitch", FXMLLoader.load(getClass().getResource( "TestSwitch.fxml" )));
                screenController.activate("calculator");
                  */
                    //JavaFXApplication2 k =new JavaFXApplication2();
                   // k.switchScene("SudentPage.fxml", stage);
                      //get reference to the button's stage         
                      stage=(Stage)Login2.getScene().getWindow();
                       //load up OTHER FXML document
                    root = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                  //AlertBox.display("Success", "Hello "+eUser.getText().toUpperCase());
                 
                  System.out.println(JavaFXApplication2.UserName);
                  System.out.println(eDOB.getValue().toString());
                  //create a new scene with root and set the stage
                   
                  BorderPane root1 = new BorderPane(root);

        root1.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
        root1.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });
                    Scene scene = new Scene(root1);
                    stage.setScene(scene);
                    AlertBox.notificationInfo("Hello?", "You know a simple Hello would be nice.\n If you did say Hello, what were you thinking? ");
                    stage.show();
                     
                    // AlertBox.notificationInfo("Welcome", "Hello "+eUser.getText().toUpperCase());
                    //studPageinit();
                  
                  
                  //System.out.println(abc.getText());
                }
           }
           else
            {
               AlertBox.notificationWarn("Robot","Mr.Robot please get back to work. Your show is failing");
                
            }
        } 
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
        }
    }
    
    
    @FXML
    private void handleNotRobot(MouseEvent event) {
        roboCounter = !roboCounter; 
         //System.out.println(notRobo.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
    }  
    
    public void studPageinit()
    {
       // try {
           // TODO
         /*  System.out.println(1);
           VBox box = FXMLLoader.load(getClass().getResource("StudentNavi.fxml"));
       System.out.println(2);
        StudentDrawer.setSidePane(box);
        } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        System.out.println(3);
        StudentUSN.setText(USN);System.out.println(4);
        {
            
                sDB1.setText("Feedback");
                sDB2.setText("Clubs");
                sDB3.setText("Results");
               // sDB1.setDisable(true);
                sDB2.setDisable(true);
                sDB3.setDisable(true);
        
        }
        System.out.println(4);
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(StudentHam);//for left arrow
       // HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(StudentHam);//For X Mark
       transition.setRate(-1);
        StudentHam.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
        transition.setRate(transition.getRate()*-1);
        transition.play();
        //The action to be performed on transition
        //open or close drawer
        if(StudentDrawer.isShown())
      StudentDrawer.close();                
        else
      StudentDrawer.open();
        });*/
        
        
    }

    @FXML
    private void handlel1(MouseEvent event) {
        l[k]=1; if(k<9)k++;      
    }

    @FXML
    private void handlel2(MouseEvent event) {
        l[k]=2; if(k<9)k++;   
    }

    @FXML
    private void handlel3(MouseEvent event) {
         l[k]=3; if(k<9)k++; 
    }

    @FXML
    private void handlel4(MouseEvent event) {
        l[k]=4; if(k<9)k++; 
    }

    @FXML
    private void handlel5(MouseEvent event) {
        l[k]=5; if(k<9)k++; 
    }

    @FXML
    private void handlel9(MouseEvent event) {
        l[k]=9; if(k<9)k++; 
    }

    @FXML
    private void handlel7(MouseEvent event) {
        l[k]=7; if(k<9)k++; 
    }

    @FXML
    private void handlel8(MouseEvent event) {
        l[k]=8; if(k<9)k++;  
    }

    @FXML
    private void handlel6(MouseEvent event) {
        l[k]=6; if(k<9)k++; 
    }

    @FXML
    private void handlel10(MouseEvent event) {
        l[k]=10;
        if(k<9)k++; 
        boolean count = true;
        for(int i=0;i<10;i++)
        {
            if(l[i]!=i+1)
            {
                count=false;
                break;
            }
            
        }
        if(count)
        {
            try {
                for(int i=0;i<10;i++)
        {
            l[i]=0;
            
        }
                k=0;
                Stage stage;
                Parent root;
                stage=(Stage)Login21.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                //AlertBox.display("Success", "Hello "+eUser.getText().toUpperCase());
                BorderPane root1 = new BorderPane(root);
            root1.setOnMousePressed((MouseEvent event1) -> {
                xOffset = event1.getSceneX();
                yOffset = event1.getSceneY();
            });
            root1.setOnMouseDragged((MouseEvent event1) -> {
                stage.setX(event1.getScreenX() - xOffset);
                stage.setY(event1.getScreenY() - yOffset);
            });
            
                //System.out.println(abc.getText());
                //create a new scene with root and set the stage
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handleGit(MouseEvent event) {
         try {
             String u="https://github.com/SaberSz";
             String k ="https://github.com/SaberSz/College-System-2-Attendance-Management-Systems";
                            Desktop desktop = java.awt.Desktop.getDesktop();
                            URI oURL = new URI(u);
                             desktop.browse(oURL);
                              URI iURL = new URI(k);
                             desktop.browse(iURL);
                            } catch (Exception e) { 
                                AlertBox.notificationInfo("Error",e.getMessage());
                                     e.printStackTrace();
                               }
    }

    
}
