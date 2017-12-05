/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import static javafx.scene.effect.BlurType.GAUSSIAN;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.DragEvent;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import static javafxapplication2.StudentPageController.CTID;
import org.controlsfx.control.ListSelectionView;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class FacultyController implements Initializable {
static String kd;
static boolean tock =true;
       static String UserName;
       static boolean factype[]={false,false,false};//0 is normal faculty. 1 is class teacher. 2 is HOD
       static String secname;
       static String semno;
       static String depname;
       //static boolean tock=true;
   // public static String CTID;
    //public  static String USN; 
     static String ids;
    static String oldcon;
    static int randomInt=0;
    static int rowcount=1;
    static String msgs[][]=new String[5][3];
    @FXML
    private AnchorPane NormalFaculty;
    @FXML
    private JFXHamburger NFHam;
    @FXML
    private JFXDrawer NFDrawer;
     @FXML
    private AnchorPane NFAboutMePane;

    @FXML
    private Label NFName;

    @FXML
    private Label NFFID;

    @FXML
    private Label NFDOB;

    @FXML
    private Label NFDEP;

    @FXML
    private Label NFJY;

    @FXML
    private Label NFsub1;

    @FXML
    private Label NFsub2;

    @FXML
    private Label NFsub3;

    @FXML
    private Label NFsub4;

    @FXML
    private Label NFsub5;

    @FXML
    private Label NFsub6;
    @FXML
    private Label Classtea;

    @FXML
    private JFXTreeTableView<Teacher1> NFAboutMeTable;

    @FXML
    private JFXTextField NFAboutMeFilter;

    @FXML
    private JFXTextField NFAboutMeChnagesName;

    @FXML
    private JFXDatePicker NFAboutMeChangesDOB;

    @FXML
    private JFXButton NFAboutMeChangesButton;

    @FXML
    private JFXTextArea NFAboutMeTextArea;

    @FXML
    private JFXButton NFAboutMeMoreChangesButton;
    
    
        
   
   //Student Attendance Pane

    @FXML
    private AnchorPane NFStudAttPane;
    @FXML
    private JFXComboBox<String> NFSAc1;

    @FXML
    private JFXComboBox<String> NFSAc2;

    @FXML
    private JFXComboBox<String> NFSAc3;

    @FXML
    private JFXComboBox<String> NFSAc4;

    @FXML
    private JFXTreeTableView<Teacher2> NFSAdisTable;
    @FXML
    private JFXTreeTableView<Teacher4> NFSAdisTable1;

    @FXML
    private JFXTextField NFSAfilter;

    @FXML
    private JFXComboBox<String> NFSAUAsemester;

    @FXML
    private JFXComboBox<String> NFSAUAsection;

    @FXML
    private JFXComboBox<String> NFSAUAdep;

    @FXML
    private JFXComboBox<String> NFSAUAsubject;

    @FXML
    private JFXTreeTableView<Teacher2> NFSAUAdisTable;

    @FXML
    private JFXTextField NFSAUAfilter;

    @FXML
    private JFXTextField NFSAUAhours;

    @FXML
    private JFXTextArea NFSAUAdisdates;

    @FXML
    private JFXTextArea NFSAUAnewdates;

        @FXML
    private JFXButton NFSASearch1;
    
     @FXML
    private JFXButton UploadCSV;
      @FXML
    private JFXComboBox<String> NFSAUAsemester1;

    @FXML
    private JFXComboBox<String> NFSAUAsection1;

    @FXML
    private JFXComboBox<String> NFSAUAdep1;

    @FXML
    private JFXComboBox<String> NFSAUAsubject1;

    @FXML
    private JFXButton search2;

    @FXML
    private ListSelectionView<Label> Attselection;

    @FXML
    private JFXButton subtmit2;

   @FXML
    private JFXDatePicker AttDate;
   @FXML
    private JFXButton NFSAUAtick1;

    @FXML
    private JFXButton NFSASearch11;

static String a=null,b=null,c=null,d=null;
    @FXML
    private AnchorPane MesPane;
    @FXML
    private JFXButton displayinbox;
    @FXML
    private JFXButton Compose;
    @FXML
    private AnchorPane msg1;
    @FXML
    private Label msg1from;
    @FXML
    private JFXTextField msg1sub;
    @FXML
    private AnchorPane msg2;
    @FXML
    private Label msg2from;
    @FXML
    private JFXTextField msg2sub;
    @FXML
    private AnchorPane msg3;
    @FXML
    private Label msg3from;
    @FXML
    private JFXTextField msg3sub;
    @FXML
    private AnchorPane msg4;
    @FXML
    private Label msg4from;
    @FXML
    private JFXTextField msg4sub;
    @FXML
    private AnchorPane msg5;
    @FXML
    private Label msg5from;
    @FXML
    private JFXTextField msg5sub;
    @FXML
    private JFXButton UP;
    @FXML
    private JFXButton Down;
    @FXML
    private AnchorPane INBOX;
    @FXML
    private JFXButton reply;
    @FXML
    private JFXButton forward;
    @FXML
    private JFXTextField forwardto;
    @FXML
    private Label inboxfrom;
    @FXML
    private JFXTextArea Content;
    @FXML
    private JFXButton ImageShow;
    @FXML
    private JFXTextArea replymsg;
    @FXML
    private AnchorPane COMPOSEPane;
    @FXML
    private JFXButton sendcompose;
    @FXML
    private JFXTextField Composeto;
    @FXML
    private JFXTextArea composeContent;
    @FXML
    private AnchorPane locklogin;
    @FXML
    private JFXDatePicker locklogindob;
    
 @FXML
     private void handleNFAboutMeChangesButton1(MouseEvent event) {
         try{
            
             
             
         
        System.out.println(" handleNFAboutMeChangesButton Clicked");
        System.out.println(NFAboutMeChnagesName.getText());
        System.out.println(NFAboutMeChangesDOB.getValue().toString());
         if(NFAboutMeChnagesName.getText().trim().equals("")&& NFAboutMeChangesDOB.getValue().toString().trim().equals(""))
              {
                  AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
                   //AlertBox.display("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
              }
         else{
             
             if(NFAboutMeChnagesName.getText().trim().equals(""))
             {
                 try {
                     String sql=" Update Faculty " +
                    " set DOB='"+NFAboutMeChangesDOB.getValue().toString()+"'" +
                    " where FID='"+UserName+"';";
                     Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement(); 
                     stmt.executeUpdate(sql);
                     
                 } catch (SQLException ex) {
                     AlertBox.notificationWarn("Error", "Error changing your name");
                    // AlertBox.display("SQLException",ex.toString());
                 }
             }
             else if (NFAboutMeChangesDOB.getValue().toString().trim().equals(""))
             {
                 try {
                     String sql=" Update Faculty " +
                    " set Name='"+NFAboutMeChnagesName.getText()+"'" +
                    " where FID='"+UserName+"';";
                     Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement(); 
                     stmt.executeUpdate(sql);
                     
                 } catch (SQLException ex) {
                      AlertBox.notificationWarn("Error", "Error changing your Date of Birth");
                    // AlertBox.display("SQLException",ex.toString());
                 }
             }
             else
             {
                 try {
                     String sql=" Update Faculty " +
                    " set Name='"+NFAboutMeChnagesName.getText()+"'" +
                    ", DOB='"+NFAboutMeChangesDOB.getValue().toString()+"' where FID='"+UserName+"';";
                     Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement(); 
                     stmt.executeUpdate(sql);
                     
                 } catch (SQLException ex) {
                      AlertBox.notificationWarn("Error", "Error changing your detials");
                    // AlertBox.display("SQLException",ex.toString());
                 }
             }
             fillAboutMeNF(UserName);
             fillAboutMeNFTable(UserName);
         }
         }
         catch(java.lang.NullPointerException e)
         {
             
             if(NFAboutMeChnagesName.getText().trim().equals("")){
                 AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
                  //AlertBox.display("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
             }
             else
             {
                 try {
                     String sql=" Update Faculty " +
                    " set Name='"+NFAboutMeChnagesName.getText()+"'" +
                    ", DOB='"+kd+"' where FID='"+UserName+"';";
                     Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement(); 
                     stmt.executeUpdate(sql);
                     fillAboutMeNF(UserName);
             fillAboutMeNFTable(UserName);
                     
                 } catch (SQLException ex) {
                      AlertBox.notificationWarn("Error", "Error in updating your details");
                    // AlertBox.display("SQLException",ex.toString());
                 }
             }
             
         }
         
                   
    }

    @FXML
     private void handleNFAboutMeMoreChangesButton1(MouseEvent event) {
        System.out.println("handleNFAboutMeMoreChangesButton Clicked");
        if(NFAboutMeTextArea.getText().trim().equals(""))
        {
             AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
        } else {
            WFile(NFAboutMeTextArea.getText());
            AlertBox.notificationInfo("Done","We will look into this matter and get back to you shortly.");
            
        }
    }
    @FXML
    private JFXButton logoutButton;
private double xOffset = 0;
    private double yOffset = 0;
   

    @FXML
    void handlelogout(MouseEvent event) throws IOException {
 Stage stage;
        Parent root;
        tock=false;
        kd=null;

       UserName=null;
       factype[1]=factype[1]=factype[1]=false;//0 is normal faculty. 1 is class teacher. 2 is HOD
       secname=null;
       semno=null;
       depname=null;
        stage=(Stage)logoutButton.getScene().getWindow();
                       //load up OTHER FXML document
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
    }
    
    
       @FXML
    private void handleSAsearch1(MouseEvent event) {
        if(factype[0]){
            NFSAdisTable1.setDisable(true);
              NFSAdisTable1.setVisible(false);
               NFSAdisTable.setDisable(false);
              NFSAdisTable.setVisible(true);
        try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Teacher2, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Teacher2, String> c2 = new JFXTreeTableColumn<>("Hours Taken");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().HT);
                    
                    JFXTreeTableColumn<Teacher2, String> c3 = new JFXTreeTableColumn<>("Attended Hours");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().AT);
                    
                    JFXTreeTableColumn<Teacher2, String> c4 = new JFXTreeTableColumn<>("Dates of Absence");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) ->  param.getValue().getValue().AD);
                    
                    
                    ObservableList<Teacher2> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select s.USN, f.`Hours Taken`, sa.`Attendance`, sa.`Absent Days`\n" +
"From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section\n" +
"Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM\n" +
"JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem\n" +
"JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code`\n" +
"where f.FID='"+UserName+"' AND f.SEM='"+NFSAc1.getValue()+"' AND f.Section='"+NFSAc2.getValue()+"' AND ss.Subject='"+NFSAc4.getValue()+"' AND s.Dep='"+NFSAc3.getValue()+"';";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Teacher2(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Teacher2> root = new RecursiveTreeItem<Teacher2>(users, RecursiveTreeObject::getChildren);
                        NFSAdisTable.getColumns().setAll(c1,c2,c3,c4);
                        NFSAdisTable.setRoot(root);
                        NFSAdisTable.setShowRoot(false);
                        
                        //For Filtering
                        NFSAfilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            NFSAdisTable.setPredicate((TreeItem<Teacher2> t) -> {
                                Boolean flag =t.getValue().USN.getValue().contains(newValue)||t.getValue().AT.getValue().contains(newValue)||t.getValue().AD.getValue().contains(newValue);
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                         AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                        //AlertBox.display("Error",e.toString());
                    }
                    catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }
        }
        catch(SQLException ex)
        {
            AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        else if(factype[1])
        {
            //class teacher
            if(!NFSAc4.getValue().equals("Class Teacher Overrule")){
             try{
                 NFSAdisTable1.setDisable(true);
              NFSAdisTable1.setVisible(false);
               NFSAdisTable.setDisable(false);
              NFSAdisTable.setVisible(true);
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Teacher2, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Teacher2, String> c2 = new JFXTreeTableColumn<>("Hours Taken");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().HT);
                    
                    JFXTreeTableColumn<Teacher2, String> c3 = new JFXTreeTableColumn<>("Attended Hours");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().AT);
                    
                    JFXTreeTableColumn<Teacher2, String> c4 = new JFXTreeTableColumn<>("Dates of Absence");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) ->  param.getValue().getValue().AD);
                    
                    
                    ObservableList<Teacher2> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select s.USN, f.`Hours Taken`, sa.`Attendance`, sa.`Absent Days`\n" +
"From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section\n" +
"Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM\n" +
"JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem\n" +
"JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code`\n" +
"where f.FID='"+UserName+"' AND f.SEM='"+NFSAc1.getValue()+"' AND f.Section='"+NFSAc2.getValue()+"' AND ss.Subject='"+NFSAc4.getValue()+"' AND s.Dep='"+NFSAc3.getValue()+"';";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Teacher2(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Teacher2> root = new RecursiveTreeItem<Teacher2>(users, RecursiveTreeObject::getChildren);
                        NFSAdisTable.getColumns().setAll(c1,c2,c3,c4);
                        NFSAdisTable.setRoot(root);
                        NFSAdisTable.setShowRoot(false);
                        
                        //For Filtering
                        NFSAfilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            NFSAdisTable.setPredicate((TreeItem<Teacher2> t) -> {
                                Boolean flag =t.getValue().USN.getValue().contains(newValue)||t.getValue().AT.getValue().contains(newValue)||t.getValue().AD.getValue().contains(newValue);
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        
                       AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    }
                    catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }
            }
            catch(SQLException ex)
            {
                AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
                 Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
            
            
            else
                
                
            {
                //dislay all in class
                //NFSAdisTable1 Teacher 4
                NFSAdisTable1.setDisable(false);
              NFSAdisTable1.setVisible(true);
               NFSAdisTable.setDisable(true);
              NFSAdisTable.setVisible(false);
                try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    JFXTreeTableColumn<Teacher4, String> c5 = new JFXTreeTableColumn<>("Teacher");
                    c5.setPrefWidth(100);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().Name);
                    
                    JFXTreeTableColumn<Teacher4, String> c6 = new JFXTreeTableColumn<>("Subject");
                    c6.setPrefWidth(100);
                    c6.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().Subject);
                    JFXTreeTableColumn<Teacher4, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Teacher4, String> c2 = new JFXTreeTableColumn<>("Hours Taken");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().HT);
                    
                    JFXTreeTableColumn<Teacher4, String> c3 = new JFXTreeTableColumn<>("Attended Hours");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().AT);
                    
                    JFXTreeTableColumn<Teacher4, String> c4 = new JFXTreeTableColumn<>("Dates of Absence");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) ->  param.getValue().getValue().AD);
                    
                    
                    ObservableList<Teacher4> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select s.USN, f.`Hours Taken`, sa.`Attendance`, sa.`Absent Days`, f.Name,ss.Subject " +
"From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section " +
"Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM " +
"JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem " +
"JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code` " +
"where  f.SEM='"+semno+"' AND f.Section='"+secname+"' AND s.Dep='"+depname+"';";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Teacher4(rs.getString(5),rs.getString(6),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Teacher4> root = new RecursiveTreeItem<Teacher4>(users, RecursiveTreeObject::getChildren);
                        NFSAdisTable1.getColumns().setAll(c5,c6,c1,c2,c3,c4);
                        NFSAdisTable1.setRoot(root);
                        NFSAdisTable1.setShowRoot(false);
                        
                        //For Filtering
                        NFSAfilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            NFSAdisTable1.setPredicate((TreeItem<Teacher4> t) -> {
                                Boolean flag =t.getValue().USN.getValue().contains(newValue)||t.getValue().AT.getValue().contains(newValue)||t.getValue().AD.getValue().contains(newValue)||t.getValue().Name.getValue().contains(newValue)||t.getValue().Subject.getValue().contains(newValue);
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        
                        AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    }
                    catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }
            }
            catch(SQLException ex)
            {
                AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
                 Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            } 
                
                
            }
            
        }
        else if(factype[2])
        {
            //HOD
            //display all in department
             NFSAdisTable1.setDisable(false);
              NFSAdisTable1.setVisible(true);
               NFSAdisTable.setDisable(true);
              NFSAdisTable.setVisible(false);
            try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    JFXTreeTableColumn<Teacher4, String> c5 = new JFXTreeTableColumn<>("Teacher");
                    c5.setPrefWidth(100);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().Name);
                    
                    JFXTreeTableColumn<Teacher4, String> c6 = new JFXTreeTableColumn<>("Subject");
                    c6.setPrefWidth(100);
                    c6.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().Subject);
                    JFXTreeTableColumn<Teacher4, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Teacher4, String> c2 = new JFXTreeTableColumn<>("Hours Taken");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().HT);
                    
                    JFXTreeTableColumn<Teacher4, String> c3 = new JFXTreeTableColumn<>("Attended Hours");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) -> param.getValue().getValue().AT);
                    
                    JFXTreeTableColumn<Teacher4, String> c4 = new JFXTreeTableColumn<>("Dates of Absence");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher4, String> param) ->  param.getValue().getValue().AD);
                    
                    
                    ObservableList<Teacher4> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select s.USN, f.`Hours Taken`, sa.`Attendance`, sa.`Absent Days`, f.Name,ss.Subject " +
"From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section " +
"Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM " +
"JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem " +
"JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code` " +
"where  f.SEM='"+NFSAc1.getValue()+"' AND f.Section='"+NFSAc2.getValue()+"' AND ss.Subject='"+NFSAc4.getValue()+"' AND s.Dep='"+NFSAc3.getValue()+"';";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Teacher4(rs.getString(5),rs.getString(6),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Teacher4> root = new RecursiveTreeItem<Teacher4>(users, RecursiveTreeObject::getChildren);
                        NFSAdisTable1.getColumns().setAll(c5,c6,c1,c2,c3,c4);
                        NFSAdisTable1.setRoot(root);
                        NFSAdisTable1.setShowRoot(false);
                        
                        //For Filtering
                        NFSAfilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            NFSAdisTable1.setPredicate((TreeItem<Teacher4> t) -> {
                                Boolean flag =t.getValue().USN.getValue().contains(newValue)||t.getValue().AT.getValue().contains(newValue)||t.getValue().AD.getValue().contains(newValue)||t.getValue().Name.getValue().contains(newValue)||t.getValue().Subject.getValue().contains(newValue);
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        
                       AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    }
                    catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }
            }
            catch(SQLException ex)
            {
                AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
                 Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
    



    @FXML
    void handleNFSAUAtick1(MouseEvent event) {
        
        
        try {
        String sql1 = "Select sa.`Attendance` , sa.`Subject Code`" +
                "From `Student Attendance` as sa JOIN Subjects as s ON sa.`Subject Code`=s.`Subject Code` " +
                "where sa.USN ='"+NFSAUAfilter.getText()+"' AND s.Subject='"+NFSAUAsubject.getValue()+"' ;";
        Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql1); 
        if(rs.absolute(1))
        {
            String subCode= rs.getString(2);
            int a=Integer.valueOf(rs.getString(1));
            int b=Integer.valueOf(NFSAUAhours.getText());
        String sql ="Update `Student Attendance` as sa join Subjects as s " +
                "on sa.`Subject Code` = s.`Subject Code` " +
                "set sa.Attendance = "+(rs.getInt(1)+Integer.valueOf(NFSAUAhours.getText()))+", sa.`Absent Days`= '"+NFSAUAnewdates.getText()+"', sa.USN = '"+NFSAUAfilter.getText().toUpperCase()+"', sa.`Subject Code` = '"+subCode+"'" +
        "where sa.USN = '"+NFSAUAfilter.getText()+"' AND s.Subject = '"+NFSAUAsubject.getValue()+"';";
        if(AlertBox.alertoption("Updation" ,"Are you sure you want to change the attendance ?","Attendance = "+(a+b)+" Absent Days = "+NFSAUAnewdates.getText()))
        {
           // AlertBox.display("Input","---------"+(a+b));
            stmt.executeUpdate(sql);
            NFStudentAttendanceUpdateTable();
        }
        
        
        
        }
        else
        {
            AlertBox.notificationWarn("Error", "Mass cannot be created or destroyed, Similarly USNs cannot be created atleast at this momnet of time. Please check the USN entered.");
        }
        } catch (SQLException ex) {
            AlertBox.notificationWarn("Error","Please check your input.");
       // AlertBox.display("Error",ex.toString());
        Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

   

    @FXML
    void handleSAsearch11(MouseEvent event) {
    
        NFStudentAttendanceUpdateTable();
  
    }
    
 

   

    @FXML
    void handlesearch2(MouseEvent event) {
    try {
        a=NFSAUAsemester1.getValue();
        b=NFSAUAsection1.getValue();
        c=NFSAUAsubject1.getValue();
        d=NFSAUAdep1.getValue();
        Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
        
        ResultSet rs = null;
        String sql ="Select s.USN " +
                "From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section " +
                "Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM " +
                "JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem " +
                "JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code` " +
                "where f.FID='"+UserName+"' AND f.SEM='"+NFSAUAsemester1.getValue()+"' AND f.Section='"+NFSAUAsection1.getValue()+"' AND ss.Subject='"+NFSAUAsubject1.getValue()+"' AND s.Dep='"+NFSAUAdep1.getValue()+"';";
        rs = stmt.executeQuery(sql);
        ObservableList<Label> users = FXCollections.observableArrayList();
        Attselection.getSourceItems().clear();
        Attselection.getTargetItems().clear();
        while(rs.next())
        {
            System.out.println("asdafasdfasdfasd "+rs.getString(1).toUpperCase());
             users.add(new Label(rs.getString(1).toUpperCase()));
             
            //   users.add(new Teacher2(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        Label l =new Label("Present");
         l.setTextFill(WHITE);
        Attselection.setSourceHeader(l);
         l =new Label("Absent");
         l.setTextFill(WHITE);
         //abc.setSourceItems(users);
           Attselection.setTargetHeader(l);
           
       // Attselection.setSourceItems(users);
       Attselection.getSourceItems().addAll(users);
      
        
    } catch (SQLException ex) {
        Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch(java.lang.NullPointerException k)
    {
         AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes.");
    }
    }//Entry of Attendance of NF (ListSelectionView)

    @FXML
    void handlesubmit2(MouseEvent event) {
    if(AlertBox.alertoption("Attendance entry" ,"Do you wanna check again?"," It's always good to be sure. Isnt't it?"))
    {      
                try {
                String date=AttDate.getValue().toString();
                ObservableList<Label> users1 =Attselection.getSourceItems();
                ObservableList<Label> users12 =Attselection.getTargetItems();
                HashMap<String,Integer> oldValues=new HashMap<String,Integer>();
                HashMap<String,String> oldValuesplusDate=new HashMap<String,String>();
                String sql ="Select s.USN, sa.`Attendance`, sa.`Absent Days` " +
                        "From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section " +
                        "Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM " +
                        "JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem " +
                        "JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code` " +
                        "where f.FID='"+UserName+"' AND f.SEM='"+a+"' AND f.Section='"+b+"' AND ss.Subject='"+c+"' AND s.Dep='"+d+"';";
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                
                ResultSet rs = null;
                try{
                String sql1= "Select f.`Hours Taken` " +
" From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section " +
" Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM " +
" JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem " +
" JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code` " +
" where f.FID='"+UserName+"' AND f.SEM='"+a+"' AND f.Section='"+b+"' AND ss.Subject='"+c+"' AND s.Dep='"+d+"';";
                rs = stmt.executeQuery(sql1);
                
                rs.absolute(1);
                try{
                System.out.println("Hey!!!!!---------------------------------------------------------------------------");
                String sql2= "Update Faculty as f join Subjects as s " +
"ON s.`Subject Code`= f.`Subject Code` Join Class as c " +
"ON c.`Semester`= f.Sem AND c.Section =f.Section " +
"SET f.`Hours Taken` = "+(rs.getInt(1)+1)+" " +
"where f.FID='"+UserName+"' AND s.Subject='"+c+"' AND f.Section='"+b+"' AND f.SEM='"+a+"' AND s.Dep='"+d+"';";
                stmt.executeUpdate(sql2);
                }
                catch(Exception e)
                {
                    //AlertBox.display("error in updation of no attendance2", e.toString());
                    AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    e.printStackTrace();
                }
                }
                catch(Exception e)
                {
                    //AlertBox.display("error in updation of no attendance3", e.toString());
                    AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    e.printStackTrace();
                }
                rs = stmt.executeQuery(sql);
                while(rs.next())
                {
                    oldValues.put(rs.getString(1).toUpperCase(),rs.getInt(2));
                    oldValuesplusDate.put(rs.getString(1).toUpperCase(),rs.getString(3));
                }
                //updating attendance column
                System.out.println("Hey!!!!!---------------------------------------------------------------------------");
                try{
                int att;//String temp;
                for(int i =0; i<users1.size(); i++)
                {

                    Label k=users1.get(i);
                   att =oldValues.get(k.getText().toUpperCase());
                   //temp=" OR sa.USN = '"+k.getText()+"' ";
                    sql ="Update `Student Attendance` as sa join Subjects as s " +
                        "on sa.`Subject Code` = s.`Subject Code` " +
                        "set sa.Attendance = "+(att+1)+"  "+
                "where sa.USN = '"+k.getText()+"' AND s.Subject = '"+c+"';";
                    stmt.executeUpdate(sql);


                }
                System.out.println("Hey!!!!!---------------------------------------------------------------------------");
                }
                catch(Exception e)
                {
                  //AlertBox.display("error in updation of attendance1", e.toString());
                    AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    
                  e.printStackTrace();
                }

                try{
               String temp;
               try{
                for(int i =0; i<users12.size(); i++)
                {
                    Label k=users12.get(i);
                    //System.out.println(k.getText());
                     temp =oldValuesplusDate.get(k.getText().toUpperCase());
                     if(!temp.equals("0")){
                     sql ="Update `Student Attendance` as sa join Subjects as s " +
                        "on sa.`Subject Code` = s.`Subject Code` " +
                        "set sa.`Absent Days` = '"+temp+" "+date+"'  "+
                "where sa.USN = '"+k.getText()+"' AND s.Subject = '"+c+"';";
                     stmt.executeUpdate(sql);
                     String kx="";
                    kx+="You were absent today for "+c+" Class.";
                    String f=k.getText();
                   String  sql3= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql3);
                    pstmt.setString(1,f);
                    pstmt.setString(2,"Admin");
                    pstmt.setString(3,kx);
                    pstmt.execute();
                     }
                     else
                     {
                         sql ="Update `Student Attendance` as sa join Subjects as s " +
                        "on sa.`Subject Code` = s.`Subject Code` " +
                        "set sa.`Absent Days` = '"+date+"'  "+
                "where sa.USN = '"+k.getText()+"' AND s.Subject = '"+c+"';";
                     stmt.executeUpdate(sql);
                     }
                }
               }
                catch(Exception e)
                {
                    AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    e.printStackTrace();
                }
                System.out.println("Hey!!!!!---------------------------------------------------------------------------");
                
               
                System.out.println("Hey!!!!!---------------------------------------------------------------------------");
                }
                
                catch(Exception e)
                {
                   AlertBox.notificationWarn("Error", "Error in updation of attendance");
                         e.printStackTrace();
                    e.printStackTrace();
                }
              AlertBox.notificationInfo("Success","The University encourages you to interact with the students and advise accordingly");
             
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(java.lang.NullPointerException k)
            {
                 AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes and also set a Date for the Attendance in the Date Field given.");
            }
                
    }
     else
    {
        AlertBox.notificationInfo("It's fine","Everyone makes a mistake, so don't sweat it. Everyone other than me of course.");
    }

    }


    @FXML
    private JFXButton upload;


     @FXML
    private JFXTreeTableView<Teacher3> CSVtable; 
     
static String CSVfilename;


    @FXML
    void handleupload(MouseEvent event) {
         FileChooser fc = new FileChooser();
         fc.getExtensionFilters().addAll(new ExtensionFilter("CSV Files","*.csv"));
         File selectedFile = fc.showOpenDialog(null);
         
         if(selectedFile!=null)
         {
            String f= selectedFile.getAbsolutePath();
            FileInputStream instream = null;
	FileOutputStream outstream = null;
        
    	try{
    	    File infile =new File(f);
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(1000000000);
    	    File outfile =new File("CSV"+randomInt+".csv");
            CSVfilename= "CSV"+randomInt+".csv";
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    instream.close();
    	    outstream.close();

    	    System.out.println("File copied successfully!!");
            CSVTableFill();
    	}catch(IOException ioe){
    		ioe.printStackTrace();
    	 }
         }
         else
         {
             AlertBox.notificationWarn("Error", "No such file found");
         }
    }
    
    @FXML
    void handleCSVdrag(DragEvent event) {
        if(event.getDragboard().hasFiles()){
        event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleCSVdropped(DragEvent event)  {
        try{
        List<File> files =event.getDragboard().getFiles();
            try {
                FileInputStream n=  (new FileInputStream(files.get(0)));
                Random randomGenerator = new Random();
      int randomInt = randomGenerator.nextInt(1000000000);
        File file = new File("CSV"+randomInt+".csv");
        CSVfilename= "CSV"+randomInt+".csv";
        
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
                                
			}
                        FileOutputStream   outstream = new FileOutputStream(file);
                        int length;
                        byte[] buffer = new byte[1024];
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = n.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    n.close();
    	    outstream.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
                        
                      
         AlertBox.notificationInfo("Done","CSV Uploaded");
         CSVTableFill();
        }
        catch(Exception e)
        {
            AlertBox.notificationWarn("Error", "Error in CSV file read.");
        }
        
    
    }          
    
    public void CSVTableFill()
    {
        String id=null;
         
            
                    
                    JFXTreeTableColumn<Teacher3, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher3, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Teacher3, String> c2 = new JFXTreeTableColumn<>("Subject Code");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher3, String> param) -> param.getValue().getValue().SC);
                    
                    JFXTreeTableColumn<Teacher3, String> c3 = new JFXTreeTableColumn<>("Attended Hours");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher3, String> param) -> param.getValue().getValue().AT);
                    
                    JFXTreeTableColumn<Teacher3, String> c4 = new JFXTreeTableColumn<>("Dates of Absence");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher3, String> param) ->  param.getValue().getValue().AD);
                    
                    
                    ObservableList<Teacher3> users = FXCollections.observableArrayList();
                    try{
                        String csvFile = CSVfilename;
       

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile)); 
                     String line = "";
        String cvsSplitBy = ",";
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] csvfl = line.split(cvsSplitBy);

                users.add(new Teacher3(csvfl[0],csvfl[1],csvfl[2],csvfl[3]));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
                        
                        
                        
                        
                        final TreeItem<Teacher3> root = new RecursiveTreeItem<Teacher3>(users, RecursiveTreeObject::getChildren);
                        CSVtable.getColumns().setAll(c1,c2,c3,c4);
                       CSVtable.setRoot(root);
                       CSVtable.setShowRoot(false);
                        
                                               
                    }
                    catch(Exception e)
                    {
                        
                        
                        AlertBox.notificationWarn("Opps", "Looks like we have encountered an error while reading your CSV file. Please check the CSV file.");
                        e.printStackTrace();
                    }
                 /*   catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }*/
        
        
        //display dates
   
    }
    
    
    
    @FXML
    void uploadcsvDB(MouseEvent event) {
    try {
        //Upload the csv file to the database
        BufferedReader br = new BufferedReader(new FileReader(CSVfilename));
        String line;
        try {
            while((line=br.readLine())!=null)
            {
                
                try {
                    String[] value= line.split(",");
                String sql="Insert into `Student Attendance` (`USN`, `Subject Code`, `Attendance`, `Absent Days`) "+
                        " Values('"+value[0]+"','"+value[1]+"','"+value[2]+"','"+value[3]+"') ;";
                System.out.println(sql);
                    Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                    stmt.executeUpdate(sql);
                    ResultSet rs = null;
                    AlertBox.notificationWarn("Hurray!", "The CSV file has been successfully uploaded. You can now use this software on a regular basis.");
                } catch (SQLException ex) {
                    AlertBox.notificationWarn("Error in CSV File", "Please check that the format of CSV follows the given rules.");
                    Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
                
                
            }
            br.close();
            //SEND MESSAGE TO THE ADMIN TELLING ABOUT THE UPDATE IN DATABASE
            
        } catch (IOException ex) {
            AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (FileNotFoundException ex) {
        AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
        Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    
    public void NFStudentAttendanceUpdateTable()
    {
        String id=null;
         try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Teacher2, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Teacher2, String> c2 = new JFXTreeTableColumn<>("Hours Taken");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().HT);
                    
                    JFXTreeTableColumn<Teacher2, String> c3 = new JFXTreeTableColumn<>("Attended Hours");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) -> param.getValue().getValue().AT);
                    
                    JFXTreeTableColumn<Teacher2, String> c4 = new JFXTreeTableColumn<>("Dates of Absence");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher2, String> param) ->  param.getValue().getValue().AD);
                    
                    
                    ObservableList<Teacher2> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select s.USN, f.`Hours Taken`, sa.`Attendance`, sa.`Absent Days` " +
"From Faculty as  f JOIN Student as s ON s.SEM=f.Sem And s.Class=f.Section " +
"Join Class as c On c.Section = s.Class AND c.Department=s.Dep AND c.Semester=s.SEM " +
"JOIN SUbjects as ss ON ss.`Subject Code`=f.`Subject Code` AND ss.Dep=s.Dep AND ss.Sem =f.Sem " +
"JOIN `Student Attendance` as sa on s.USN=sa.USN AND sa.`Subject Code`=f.`Subject Code` " +
"where f.FID='"+UserName+"' AND f.SEM='"+NFSAUAsemester.getValue()+"' AND f.Section='"+NFSAUAsection.getValue()+"' AND ss.Subject='"+NFSAUAsubject.getValue()+"' AND s.Dep='"+NFSAUAdep.getValue()+"';";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Teacher2(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Teacher2> root = new RecursiveTreeItem<Teacher2>(users, RecursiveTreeObject::getChildren);
                        NFSAUAdisTable.getColumns().setAll(c1,c2,c3,c4);
                       NFSAUAdisTable.setRoot(root);
                       NFSAUAdisTable.setShowRoot(false);
                        
                        //For Filtering
                        NFSAUAfilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            NFSAUAdisTable.setPredicate((TreeItem<Teacher2> t) -> {
                                Boolean flag =t.getValue().USN.getValue().contains(newValue.toUpperCase());
                                
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        
                        AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
                    }
                    catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }
        }
        catch(SQLException ex)
        {
           AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        //display dates
   
    }
    
    
    
    
      public void threadtock() {
   
    //System.out.println("Started....");
    
final java.util.Timer timer = new java.util.Timer();
    final TimerTask delayedThreadStartTask = new TimerTask() {
        

        public void run() {
//System.out.println("Started..123131..");
            //captureCDRProcess();
            //moved to TimerTask
            //new Thread(new Runnable() {
               
             //   public void run() {
try
        {
            if(tock){
                //if(factype[0])
                {
                    //NormalFaculty
                    if(JavaFXApplication2.NF[0])
                        {//AboutME
                             MesPane.setDisable(true);
                               MesPane.setVisible(false);
                            NFStudAttPane.setDisable(true);
                              NFStudAttPane.setVisible(false);
                           NFAboutMePane.setDisable(false);
                              NFAboutMePane.setVisible(true);
                              JavaFXApplication2.NF[0]=false;
                        }
                    else if(JavaFXApplication2.NF[1]){
                         MesPane.setDisable(true);
                               MesPane.setVisible(false);
                        NFAboutMePane.setDisable(true);
                              NFAboutMePane.setVisible(false);
                        NFStudAttPane.setDisable(false);
                              NFStudAttPane.setVisible(true);
                              JavaFXApplication2.NF[1]=false;

                    }
                    else if(JavaFXApplication2.NF[2]){
                        //System.out.println("HelloMessages selected");
                            NFStudAttPane.setDisable(true);
                              NFStudAttPane.setVisible(false);
                               NFAboutMePane.setDisable(true);
                              NFAboutMePane.setVisible(false);
                          MesPane.setDisable(false);
                               MesPane.setVisible(true);
                              JavaFXApplication2.NF[2]=false;
                             // displaymessages();
                              INBOX.setDisable(true);
        INBOX.setVisible(false);
        COMPOSEPane.setDisable(false);
         COMPOSEPane.setVisible(true);
         
                        
                    }


                }
               // else if(factype[1])
                {
                    //classTeacher
                }
                //else if(factype[2])
                {
                       //hodx
                } 
            }
            else{
                //System.out.println("Hello");
                timer.cancel();  // Terminates this timer, discarding any currently scheduled tasks.
timer.purge();   // Removes all cancelled tasks from this timer's task queue.
            }
            
                       if(tock)
                        {
                           threadtock();
                        }
                         
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                    
                }
       //     }).start();
       // }
    };

    timer.schedule(delayedThreadStartTask, 500);//0.5 second
}
    /**
     * Initializes the controller class.
     */
 
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tock=true;
        UserName=JavaFXApplication2.UserName;
        System.out.println("Light of the Seven: "+UserName+ "\n"+UserName.substring(0, 3).toUpperCase());
       
        try
        {
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
             String sql = "Select * from Class as c WHERE CTID='"+UserName+"';";
             ResultSet rs = stmt.executeQuery(sql); 
             if(rs.absolute(1))
             {
                 System.out.println("Class Teacher");factype[1]=true;factype[0]=factype[2]=false;
                // AlertBox.display("","ClassTeacher");
                // NormalFaculty.setDisable(true);
                // NormalFaculty.setVisible(false);
                // threadtock();
                 
             }
             else
             {
                 //Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
             String sql1 = "Select * from department as c WHERE FID='"+UserName+"';";
              rs = stmt.executeQuery(sql1); 
                if(rs.absolute(1))
                 {
                     System.out.println("HOD");factype[2]=true;factype[0]=factype[1]=false;
                     //HOD
                     //AlertBox.display("","HOD");
                    // threadtock();
                 }
                 else
                 {
                      factype[0]=true;factype[1]=factype[2]=false;
                     // AlertBox.display("","Normal fac");
                 }  
             }         
                     //NormalTecher
                     //System.out.println("Normal Fac");
                     
                     try{
                         NFDrawer.setDisable(false);
                         NFDrawer.setVisible(true);
                         NormalFaculty.setDisable(false);
                          NormalFaculty.setVisible(true);
                         
                          NFAboutMePane.setDisable(false);
                          NFAboutMePane.setVisible(true);
                          MesPane.setDisable(true);
                          MesPane.setVisible(false);
                           NFStudAttPane.setDisable(true);
                              NFStudAttPane.setVisible(false);
                            VBox box = FXMLLoader.load(getClass().getResource("NormalFacultyNavi.fxml"));
                           System.out.println(2);
                            NFDrawer.setSidePane(box);
                            } catch (IOException ex) {
                               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                           }
                            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(NFHam);//for left arrow
                           // HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(StudentHam);//For X Mark
                           transition.setRate(-1);
                            NFHam.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
                            transition.setRate(transition.getRate()*-1);
                            transition.play();
                            if(NFDrawer.isShown())
                            {
                               
                          NFDrawer.close(); 
                           NFDrawer.toBack();
                          
                            }
                            else
                            {
                                NFDrawer.toFront();
                          NFDrawer.open();
                          
                            }
                            
                            
                            });
                            fillAboutMeNF(UserName);
                            fillAboutMeNFTable(UserName);
                            fillStudentAttendaceNF(UserName);
                            threadtock();
                             
         
                            NFSAUAhours.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, 
                            String newValue) {
                            if (!newValue.matches("\\d*")) {
                                NFSAUAhours.setPromptText("Enter a numeric value!!!");//newValue.replaceAll("[^\\d]", "")
                                NFSAUAhours.setFocusColor(RED);
                                
                            }
                            else
                            {
                                 NFSAUAhours.setFocusColor(GREEN);
                            }
    }
}); 
                 
        msg1.setDisable(true);
            msg1.setVisible(false);
            msg2.setDisable(true);
            msg2.setVisible(false);
            msg3.setDisable(true);
            msg3.setVisible(false);
            msg4.setDisable(true);
            msg4.setVisible(false);    
             msg5.setDisable(true);
            msg5.setVisible(false);
           
             
             
        }
        catch(SQLException e)
        {
          
            AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
        }
        
        
        
        
    }    
    public void fillAboutMeNF(String id)
    {
        int count=0;
        String sql;
           try {
               if(!factype[2]){
                sql="Select f.Name,f.DOB,f.Dep" +
                       " From Faculty As f " +
                       "Where f.FID = '"+id+"';";
                 Classtea.setText("Head of Deapartment");
               }
        else
        {
            sql="Select Name, DOB, Branch from Department where FID = '"+id+"';";
        }
               System.out.println(sql);
               Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
               ResultSet rs = stmt.executeQuery(sql); 
               rs.absolute(1);
               NFName.setText("Name : "+ rs.getString(1));
                NFDOB.setText("Date of Birth : "+ rs.getString(2));
                 NFFID.setText("FID : "+ id.toUpperCase());
                  NFDEP.setText("Department : "+ rs.getString(3));
                   NFJY.setText("Joined Year : "+ joinDate(id));
                sql= "Select DISTINCT s.Subject" +
                " From Faculty As f JOIN  Subjects s ON s.`Subject Code`=f.`Subject Code`" +
                " Where f.FID = '"+id+"';" ;
                System.out.println(sql);
               kd=rs.getString(2);
               rs = stmt.executeQuery(sql); 
               while(rs.next())
               {
                   count++;
                   switch(count)
                   {
                       case 1: NFsub1.setText(rs.getString(1));break;
                       case 2: NFsub2.setText(rs.getString(1));break;
                       case 3: NFsub3.setText(rs.getString(1));break;
                        case 4: NFsub4.setText(rs.getString(1)); break;  
                        case 5:  NFsub5.setText(rs.getString(1));  break;      
                         case 6:  NFsub6.setText(rs.getString(1));  break;
                         
                   }
                   
               }
               if(factype[1]){
                   sql="Select Semester, Section, Department from Class where CTID='"+id+"';";
                   rs = stmt.executeQuery(sql); 
                   rs.absolute(1);
                   secname=rs.getString(2);
                   semno=rs.getString(1);
                   depname=rs.getString(3);
                   Classtea.setText("Class Teacher : "+semno+" "+secname);
               }
               
                   
           } catch (SQLException e) {
            
              AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
           }
        
        
    }
    
    public String joinDate(String id)
    {
        Integer i =Integer.valueOf(id.substring(3, 5));
           if(i>0 && i<40)
           {
               return "20"+i;
           }
           return "19"+i;
        
    }
    
    public void fillAboutMeNFTable(String id){
      /* JFXTreeTableColumn<Teacher1, String> c1 = new JFXTreeTableColumn<>("Name");
       c1.setPrefWidth(100);
        c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().Name);*/
        
        JFXTreeTableColumn<Teacher1, String> c2 = new JFXTreeTableColumn<>("Subject Code");
       c2.setPrefWidth(93);
        c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().subCode);

        JFXTreeTableColumn<Teacher1, String> c3 = new JFXTreeTableColumn<>("Subject");
        c3.setPrefWidth(82);
        c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().Sub);
        
        JFXTreeTableColumn<Teacher1, String> c4 = new JFXTreeTableColumn<>("Hours Taken");
        c4.setPrefWidth(82);
        c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) ->  param.getValue().getValue().HT);
        
        JFXTreeTableColumn<Teacher1, String> c5 = new JFXTreeTableColumn<>("Department");
        c5.setPrefWidth(82);
        c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().Dep);
        
        JFXTreeTableColumn<Teacher1, String> c6 = new JFXTreeTableColumn<>("Semester");
        c6.setPrefWidth(82);
        c6.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().Sem);
        
        JFXTreeTableColumn<Teacher1, String> c7 = new JFXTreeTableColumn<>("Section");
        c7.setPrefWidth(82);
        c7.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().Sec);
        
        JFXTreeTableColumn<Teacher1, String> c8 = new JFXTreeTableColumn<>("Class Teacher");
        c8.setPrefWidth(82);
        c8.setCellValueFactory((TreeTableColumn.CellDataFeatures<Teacher1, String> param) -> param.getValue().getValue().CT);
        
        ObservableList<Teacher1> users = FXCollections.observableArrayList();
        try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            String sql ="Select f.Name, f.`Subject Code` , s.Subject ,f.`Hours Taken`,c.Department,f.Sem , f.Section , c.CTID" +
            " FROM Faculty as f JOIN Subjects as s ON s.`Subject Code`=f.`Subject Code` " +
            " JOIN Class AS c ON c.Semester=f.Sem AND c.Section=f.Section AND s.Dep=c.Department" +
            " Where f.FID='"+id+"';";
            ResultSet rs = stmt.executeQuery(sql); 
            while(rs.next())
            {
                users.add(new Teacher1(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),genName(rs.getString(8))));
            }
            
           

            final TreeItem<Teacher1> root = new RecursiveTreeItem<Teacher1>(users, RecursiveTreeObject::getChildren);
            NFAboutMeTable.getColumns().setAll(c2,c3,c4,c5,c6,c7,c8);
            NFAboutMeTable.setRoot(root);
            NFAboutMeTable.setShowRoot(false);
            
           //For Filtering
            NFAboutMeFilter.textProperty().addListener(new ChangeListener<String>(){
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    NFAboutMeTable.setPredicate(new Predicate<TreeItem<Teacher1>>(){
                        @Override
                        public boolean test(TreeItem<Teacher1> t) {
                            Boolean flag =t.getValue().Sub.getValue().contains(newValue)||t.getValue().subCode.getValue().contains(newValue.toUpperCase())||t.getValue().HT.getValue().contains(newValue)||t.getValue().Dep.getValue().contains(newValue.toUpperCase())||t.getValue().Sem.getValue().contains(newValue)||t.getValue().Sec.getValue().contains(newValue.toUpperCase());
                            return flag;
                        }
                        
                    });
                }
                
            });
            
        }
        catch(SQLException e)
        {
            
             AlertBox.notificationWarn("Error", "Error");
                         e.printStackTrace();
        } 
        
        
    }
    public String genName(String id)
    {
           try {
               Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
               String sql ="Select DISTINCT f.Name" +
                " From Faculty As f" +
                " Where f.FID = '"+id+"';" ; 
               ResultSet rs = stmt.executeQuery(sql);
               rs.absolute(1);
               return rs.getString(1);
           } catch (SQLException ex) {
             AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
           }
        
        return null;
    }
    public void WFile(String z)
{
    /*BufferedWriter bw = null;
		FileWriter fw = null;
                try {
                        
			//String data = " This is new content";
                        
                        String k="";
			File file = new File("AdminRequest.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
                                k= "---------------------------UPDATES----------------------------\n\n";
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
                        k+=DBMS.Date.Date()+"------------------"+DBMS.Time.Time()+"\n"+UserName+"\n"+z;
                        k+="\n\n-------------------------------------------------------------------\n\n";
			bw.write(k);

			System.out.println("Done");

		} catch (IOException e) {
                        AlertBox.display("Error",e.toString());
			e.printStackTrace();
                }finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

                            AlertBox.display("Error",ex.toString());
				ex.printStackTrace();

			}
                }*/
    try {
                ResultSet rs=null;
               
                
                //rs=stmt.executeQuery(sql);
               // if(rs.next()){
                   // String newc= "Admin \n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String k="";
                    k+=DBMS.Date.Date()+"------------------"+DBMS.Time.Time()+"\n"+UserName+"\n"+z;
                        k+="\n\n-------------------------------------------------------------------\n\n";
                    String f=UserName;
                   String  sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,"Admin");
                    pstmt.setString(2,f.trim());
                    pstmt.setString(3,k);
                    pstmt.execute();
                    AlertBox.notificationInfo("Done", "Message sent." );
              //  }
               // else
               // {
                //    AlertBox.notificationWarn("Error", "No such receiptant. Please check the entered ID again." );
                    
                //}
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
                        

    
                
    
}   

    public void fillStudentAttendaceNF(String id)  {
    try {
        AttDate.setValue(LocalDate.now());
        //To fill the display Attendace tab
        //4 combo boxes, 1 filter and a display table
        String sql1 = " Select DISTINCT c.Department" +
                " from Subjects as s JOin Class as c ON s.DEP=c.Department AND s.SEM=c.Semester " +
                " JOIN Faculty as F on f.Sem=c.Semester AND f.Section=c.Section AND f.`Subject Code`=s.`Subject Code` " +
                " where f.FID='"+id+"';";
        Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
           // NFSAc3.getItems().add(rs.getString(1));
            NFSAUAdep.getItems().add(rs.getString(1));
            NFSAUAdep1.getItems().add(rs.getString(1));
        }
         sql1 = " Select DISTINCT f.SEM " +
" from Faculty as f " +
" where f.FID='"+id+"'; ";
        
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
           // NFSAc1.getItems().add(rs.getString(1));
            NFSAUAsemester.getItems().add(rs.getString(1));
            NFSAUAsemester1.getItems().add(rs.getString(1));
        }
        
        sql1 = " Select DISTINCT f.Section " +
" from Faculty as f " +
" where f.FID='"+id+"'; ";
        
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
           // NFSAc2.getItems().add(rs.getString(1));
            NFSAUAsection.getItems().add(rs.getString(1));
              NFSAUAsection1.getItems().add(rs.getString(1));
        }
        
          sql1 = " Select DISTINCT s.Subject " +
" from Faculty as f JOIN Subjects as s on s.`Subject Code`=f.`Subject Code` " +
" where f.FID='"+id+"';";
        
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
           // NFSAc4.getItems().add(rs.getString(1));
            NFSAUAsubject.getItems().add(rs.getString(1));
             NFSAUAsubject1.getItems().add(rs.getString(1));
        }
        if(factype[1])
        {                                boolean xyz=true;
                                    sql1 = " Select DISTINCT c.Department" +
                                       " from Subjects as s JOin Class as c ON s.DEP=c.Department AND s.SEM=c.Semester " +
                                       " JOIN Faculty as F on f.Sem=c.Semester AND f.Section=c.Section AND f.`Subject Code`=s.`Subject Code` " +
                                       " where f.FID='"+id+"';";
                               //Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                                rs = stmt.executeQuery(sql1); 
                               while(rs.next())
                               {
                                   if(rs.getString(1).equals(depname)){
                                       xyz=false;
                                   }
                                   NFSAc3.getItems().add(rs.getString(1));

                               }
                               if(xyz) NFSAc3.getItems().add(depname);
                               xyz=true;
                                sql1 = " Select DISTINCT f.SEM " +
                       " from Faculty as f " +
                       " where f.FID='"+id+"'; ";
                                   
                                rs = stmt.executeQuery(sql1); 
                               while(rs.next())
                               {
                                   if(rs.getString(1).equals(semno)){
                                       xyz=false;
                                   }
                                   NFSAc1.getItems().add(rs.getString(1));

                               }
                               if(xyz)NFSAc1.getItems().add(semno);
                               xyz=true;
                               sql1 = " Select DISTINCT f.Section " +
                       " from Faculty as f " +
                       " where f.FID='"+id+"'; ";

                                rs = stmt.executeQuery(sql1); 
                               while(rs.next())
                               {
                                   if(rs.getString(1).equals(secname)){
                                       xyz=false;
                                   }
                                   NFSAc2.getItems().add(rs.getString(1));

                               }
                                if(xyz)NFSAc2.getItems().add(secname);
                                xyz=true;
                                 sql1 = " Select DISTINCT s.Subject " +
                       " from Faculty as f JOIN Subjects as s on s.`Subject Code`=f.`Subject Code` " +
                       " where f.FID='"+id+"';";
                                 
                                rs = stmt.executeQuery(sql1); 
                               while(rs.next())
                               {
                                   NFSAc4.getItems().add(rs.getString(1));

                               }
                               NFSAc4.getItems().add("Class Teacher Overrule");
            
        }
        else if(factype[0])
        {
                                
                                sql1 = " Select DISTINCT c.Department" +
                " from Subjects as s JOin Class as c ON s.DEP=c.Department AND s.SEM=c.Semester " +
                " JOIN Faculty as F on f.Sem=c.Semester AND f.Section=c.Section AND f.`Subject Code`=s.`Subject Code` " +
                " where f.FID='"+id+"';";
       // Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
            NFSAc3.getItems().add(rs.getString(1));
           // NFSAUAdep.getItems().add(rs.getString(1));
           // NFSAUAdep1.getItems().add(rs.getString(1));
        }
         sql1 = " Select DISTINCT f.SEM " +
" from Faculty as f " +
" where f.FID='"+id+"'; ";
        
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
            NFSAc1.getItems().add(rs.getString(1));
            //NFSAUAsemester.getItems().add(rs.getString(1));
           // NFSAUAsemester1.getItems().add(rs.getString(1));
        }
        
        sql1 = " Select DISTINCT f.Section " +
" from Faculty as f " +
" where f.FID='"+id+"'; ";
        
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
            NFSAc2.getItems().add(rs.getString(1));
           // NFSAUAsection.getItems().add(rs.getString(1));
              //NFSAUAsection1.getItems().add(rs.getString(1));
        }
        
          sql1 = " Select DISTINCT s.Subject " +
" from Faculty as f JOIN Subjects as s on s.`Subject Code`=f.`Subject Code` " +
" where f.FID='"+id+"';";
        
         rs = stmt.executeQuery(sql1); 
        while(rs.next())
        {
            NFSAc4.getItems().add(rs.getString(1));
            //NFSAUAsubject.getItems().add(rs.getString(1));
             //NFSAUAsubject1.getItems().add(rs.getString(1));
        }
        }
        else if(factype[2])
        {
            
                                sql1 = " Select DISTINCT c.Department" +
                                   " from Subjects as s JOin Class as c ON s.DEP=c.Department AND s.SEM=c.Semester " +
                                   " JOIN Faculty as F on f.Sem=c.Semester AND f.Section=c.Section AND f.`Subject Code`=s.`Subject Code` " +
                                   " where f.FID='"+id+"';";
                                
                                sql1="Select Branch from department where FID='"+id+"' ;";
                            String k;    
                           //Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                            rs = stmt.executeQuery(sql1); 
                           while(rs.next())
                           {
                               NFSAc3.getItems().add(rs.getString(1));
                              
                           }
                           rs.absolute(1);
                            k=rs.getString(1);
                            sql1 = " Select DISTINCT f.Semester " +
                   " from class as f " +
                   " where f.department='"+k+"'; ";

                            rs = stmt.executeQuery(sql1); 
                           while(rs.next())
                           {
                               NFSAc1.getItems().add(rs.getString(1));

                           }

                           sql1 = " Select DISTINCT f.Section " +
                   " from class as f " +
                   " where f.department='"+k+"'; ";

                            rs = stmt.executeQuery(sql1); 
                           while(rs.next())
                           {
                               NFSAc2.getItems().add(rs.getString(1));

                           }

                             sql1 = " Select  s.Subject " +
                   " from   Subjects as s  " +
                   " where s.dep='"+k+"';";

                            rs = stmt.executeQuery(sql1); 
                           while(rs.next())
                           {
                               NFSAc4.getItems().add(rs.getString(1));

                           }
            
            
        }
        
        
        
        
        
    } catch (SQLException ex) {
        AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
    }
        
        
    }

    @FXML
    private void handleinbox(MouseEvent event) {
         COMPOSEPane.setDisable(true);
        COMPOSEPane.setVisible(false);
        INBOX.setDisable(false);
         INBOX.setVisible(true);
         rowcount=1;
         displaymessages();
    }

    @FXML
    private void handleCompose(MouseEvent event) {
        INBOX.setDisable(true);
        INBOX.setVisible(false);
        COMPOSEPane.setDisable(false);
         COMPOSEPane.setVisible(true);
    }

    @FXML
    private void fillmsg1(MouseEvent event) {
        randomInt=0;
        System.out.println("hey look here!!!!!!!!!!!!!! "+msgs[0][0]+msgs[0][1]+msgs[0][2]);
        showmsg(msgs[0][0],msgs[0][1],msgs[0][2]);
        forwardto.setText("");
        replymsg.setText("");
        
    }

    @FXML
    private void fillmsg2(MouseEvent event) {
        randomInt=0;
        showmsg(msgs[1][0],msgs[1][1],msgs[1][2]);
        forwardto.setText("");
        replymsg.setText("");
        
    }

    @FXML
    private void fillmsg3(MouseEvent event) {
        randomInt=0;
          showmsg(msgs[2][0],msgs[2][1],msgs[2][2]);
        forwardto.setText("");
        replymsg.setText("");
        
    }

    @FXML
    private void fillmsg4(MouseEvent event) {
        randomInt=0;
          showmsg(msgs[3][0],msgs[3][1],msgs[3][2]);
        forwardto.setText("");
        replymsg.setText("");
        
    }

    @FXML
    private void fillmsg5(MouseEvent event) {
        randomInt=0;
        showmsg(msgs[4][0],msgs[4][1],msgs[4][2]);
    }

    @FXML
    private void handleup(MouseEvent event) {
        if(rowcount>5){
           
            if(rowcount%5==0) {
                rowcount=rowcount-(9);
            }else{
                rowcount=rowcount-((rowcount%5)+5)+1;
            }
            System.out.println(rowcount+"----------------------------------------------------------------------");
            displaymessages();
        }
         else
            {
                AlertBox.notificationInfo("All done!!","No more messages to display.");
            }
    }

    @FXML
    private void handledown(MouseEvent event) {
        try {
            ResultSet rs=null;
            String sql = "Select count(*) from Messages where ToID='"+UserName+"';";
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            rs=stmt.executeQuery(sql);
            rs.absolute(1);
            int no = rs.getInt(1);
            if((no-rowcount+1)>0){
               displaymessages(); 
            }
            else
            {
                AlertBox.notificationInfo("All done!!","No more messages to display.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleReply(MouseEvent event) {
        try{
        if(replymsg.getText().trim().equals("")){
            AlertBox.notificationWarn("Error", "You can't send blank messages.");
        }else{
           try {
                ResultSet rs=null;
                    String f=UserName;
                    String sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,inboxfrom.getText());
                    pstmt.setString(2,f);
                    pstmt.setString(3,replymsg.getText().trim());
                    pstmt.execute();
                    AlertBox.notificationInfo("Done", "Reply sent." );
                
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        }
        catch(java.lang.NullPointerException e)
        {
            
            AlertBox.notificationWarn("Error", "You can't send blank messages."); 
        }
    }

    @FXML
    private void handleForward(MouseEvent event) {
        
        try{
        if(replymsg.getText().trim().equals("")||forwardto.getText().trim().equals("")){
           AlertBox.notificationWarn("Error", "You can't leave the foward to or reply box empty.");
            
            
        }
        else
        {
            try {
                ResultSet rs=null;
                String sql = "Select k.id from (Select f.FID as id from faculty as f UNION"
                        + " Select h.fid as id from department as h UNION Select s.USN as id from STudent as s ) as k where"
                        + " k.id='"+forwardto.getText().trim()+"';";
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                rs=stmt.executeQuery(sql);
                if(rs.next()){
                    String newc= UserName+"\n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String f=UserName;
                    sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,forwardto.getText().trim());
                    pstmt.setString(2,f);
                    pstmt.setString(3,newc);
                    pstmt.execute();
                    AlertBox.notificationInfo("Done", "Message forwarded." );
                }
                else
                {
                    AlertBox.notificationWarn("Error", "No such receiptant. Please check the entered ID again." );
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        }
        catch(java.lang.NullPointerException e)
        {
            
           AlertBox.notificationWarn("Error", "You can't leave the foward to or reply box empty.");
        }
    }

    @FXML
    private void handleImageShow(MouseEvent event) {
         // File file = new File("MC"+randomInt+".jpg");
       
         File file = new File(inboxfrom.getText()+" Medical Certificate.jpg");       
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            AlertBox.notificationInfo("Error", "Not Supported. Please contact Tech Support"); 
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) 
        {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
             AlertBox.notificationInfo(null, "No Attachment found"); 
        }
        
    }

    @FXML
    private void handlesendcompose(MouseEvent event) {
        try{
        if(composeContent.getText().trim().equals("")||Composeto.getText().trim().equals("")){
           AlertBox.notificationWarn("Error", "You can't send blank messages.");  
        }
        else
        {
            try {
                ResultSet rs=null;
                String sql = "Select k.id from (Select f.FID as id from faculty as f UNION"
                        + " Select h.fid as id from department as h UNION Select s.USN as id from STudent as s ) as k where"
                        + " k.id='"+Composeto.getText().trim()+"';";
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                rs=stmt.executeQuery(sql);
                if(rs.next()){
                   // String newc= "Admin \n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String f=UserName;
                    sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,Composeto.getText().trim());
                    pstmt.setString(2,f);
                    pstmt.setString(3,composeContent.getText().trim());
                    pstmt.execute();
                    AlertBox.notificationInfo("Done", "Message sent." );
                }
                else
                {
                    AlertBox.notificationWarn("Error", "No such receiptant. Please check the entered ID again." );
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        }
        catch(java.lang.NullPointerException e)
        {
            
          AlertBox.notificationWarn("Error", "You can't send blank messages.");  
        }
    }
    
    public void showmsg(String from,String Contents,String id){
            try {
                System.out.println("hey showing now!!!!!!!!!!!!!! "+from+Contents+id);
                inboxfrom.setText(from);
                Content.setText(Contents);
                ResultSet rs=null;
                String sql = "Select Images from MessageImages where MsgID = '"+id+"';";
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                rs=stmt.executeQuery(sql);
                
                Random randomGenerator = new Random();
                randomInt = randomGenerator.nextInt(1000000000);
                File file = new File("MC"+randomInt+".jpg");
                FileOutputStream output=null;
               /* try {
                    //  File file=new File("E:\\image1.png");
                    FileOutputStream fos=new FileOutputStream(file);
                    byte b[];
                    Blob blob;
                    while(rs.next()){
                        blob=rs.getBlob(1);
                        b=blob.getBytes(1,(int)blob.length());
                        try {
                            output.write(b);
                        } catch (IOException ex) {
                            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }*/
                try {
                output = new FileOutputStream(file);
                System.out.println("Writing to file " + file.getAbsolutePath());
                    try {
                        while (rs.next()) {
                            InputStream input = rs.getBinaryStream(1);
                            byte[] buffer = new byte[1024];
                            try {
                                while (input.read(buffer) > 0) {
                                    output.write(buffer);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }   } catch (SQLException ex) {
                        Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
               
                         ex.printStackTrace();
                AlertBox.notificationWarn("Error","Image file corrupted");
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                oldcon=Contents;
                ids=id;
                 
                
            } catch (SQLException ex) {
                Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }  
    public void displaymessages(){
        try {
            ResultSet rs=null;
            String sql = "Select FromID, Content,MsgID from Messages where ToID='"+UserName+"' order by MsgID DESC;";
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            rs=stmt.executeQuery(sql);
            
            msg1.setDisable(true);
            msg1.setVisible(false);
            msg2.setDisable(true);
            msg2.setVisible(false);
            msg3.setDisable(true);
            msg3.setVisible(false);
            msg4.setDisable(true);
            msg4.setVisible(false);
            msg5.setDisable(true);
            msg5.setVisible(false);
           
            if(rs.absolute(rowcount)){
                System.out.println("Hey--------------------------------------------");
            if(true)//rs.next())
            {
                System.out.println("Hey--------------------------------------------");
                msg1.setDisable(false);
            msg1.setVisible(true);
                msg1from.setText(rs.getString(1));
             if(rs.getString(2).length()>40)
                    msg1sub.setText(rs.getString(2).substring(0,40)+".....");
                else
                    msg1sub.setText(rs.getString(2));
                msgs[0][0]=rs.getString(1);
                msgs[0][1]=rs.getString(2);
                msgs[0][2]=rs.getString(3);
               rowcount++; 
            }
            if(rs.next())
            {
                msg2.setDisable(false);
            msg2.setVisible(true);
                msg2from.setText(rs.getString(1));
                if(rs.getString(2).length()>40)
                    msg2sub.setText(rs.getString(2).substring(0,40)+"........");
                else
                    msg2sub.setText(rs.getString(2));
                msgs[1][0]=rs.getString(1);
                msgs[1][1]=rs.getString(2);
                msgs[1][2]=rs.getString(3);
               rowcount++;  
            }
            if(rs.next())
            {
                msg3.setDisable(false);
            msg3.setVisible(true);
                msg3from.setText(rs.getString(1));
               if(rs.getString(2).length()>40)
                    msg3sub.setText(rs.getString(2).substring(0,40)+"........");
                else
                    msg3sub.setText(rs.getString(2));
                msgs[2][0]=rs.getString(1);
                msgs[2][1]=rs.getString(2);
                msgs[2][2]=rs.getString(3);
               rowcount++;  
            }
            if(rs.next())
            {
                msg4.setDisable(false);
            msg4.setVisible(true);
                msg4from.setText(rs.getString(1));
                if(rs.getString(2).length()>40)
                    msg4sub.setText(rs.getString(2).substring(0,40)+".......");
                else
                    msg4sub.setText(rs.getString(2));
                msgs[3][0]=rs.getString(1);
                msgs[3][1]=rs.getString(2);
                msgs[3][2]=rs.getString(3);
               rowcount++;  
            }
            if(rs.next())
            {
                msg5.setDisable(false);
            msg5.setVisible(true);
                msg1from.setText(rs.getString(1));
                if(rs.getString(2).length()>40)
                    msg5sub.setText(rs.getString(2).substring(0,40)+".......");
                else
                    msg5sub.setText(rs.getString(2));
                msgs[4][0]=rs.getString(1);
                msgs[4][1]=rs.getString(2);
                msgs[4][2]=rs.getString(3);
               rowcount++;  
            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlelock(MouseEvent event) {
        NormalFaculty.setEffect(new GaussianBlur(20));
         NormalFaculty.setDisable(true);
         locklogin.setDisable(false);
         locklogin.setVisible(true);
         locklogindob.setValue(LocalDate.now());
    }

    @FXML
    private void handleunblur(MouseEvent event) {
         DBMS.CheckPer pers=new DBMS.CheckPer();
         try{
        if(pers.checkFaculty(UserName,locklogindob.getValue().toString())){
            System.out.println("Success"); 
            locklogin.setDisable(true);
         locklogin.setVisible(false);
           NormalFaculty.setEffect(new ColorAdjust());  
            NormalFaculty.setDisable(false);
            locklogindob.setValue(LocalDate.now());
           
        }
        else
        {
            System.out.println(UserName);
            System.out.println(locklogindob.getValue().toString());
            System.out.println(" NOt Success"); 
            locklogindob.setValue(LocalDate.now());
        }
         }
         catch(NullPointerException e)
         { 
             
         }
         catch(Exception e)
         {
            AlertBox.showErrorMessage(e);
         }
         
         
        
    }
             
    class Teacher1 extends RecursiveTreeObject<Teacher1> {
        //This is used in the display about me table of normal faculty
        
        StringProperty subCode;
        StringProperty Sub;
        StringProperty HT;
        StringProperty Dep;
        StringProperty Sem;
        StringProperty Sec;
        StringProperty CT;

        public Teacher1(String subCode,String Sub,String HT,String Dep,  String Sem,String Sec,String CT) {
            this.subCode = new SimpleStringProperty(subCode);
            this.Sub = new SimpleStringProperty(Sub);
            this.HT = new SimpleStringProperty(HT);
            this.Dep = new SimpleStringProperty(Dep);
            this.Sem = new SimpleStringProperty(Sem);
            this.Sec = new SimpleStringProperty(Sec);
            this.CT = new SimpleStringProperty(CT);
            
            
            
        }

    }   
     class Teacher4 extends RecursiveTreeObject<Teacher4> {
        
        
        StringProperty Name; 
        StringProperty USN;
        StringProperty Subject;
        StringProperty HT;//hours taken
        StringProperty AT;//attendance 
        StringProperty AD;//absent days
        
        public Teacher4( String Name,String Subject,String USN,String HT,String AT,String AD) {
            this.Name = new SimpleStringProperty(Name);
            this.Subject = new SimpleStringProperty(Subject);
            this.USN = new SimpleStringProperty(USN);
            this.AT = new SimpleStringProperty(AT);
            this.AD = new SimpleStringProperty(AD);
            this.HT = new SimpleStringProperty(HT);
            
            
            
        }
            
            
        }
 

    } 

    class Teacher2 extends RecursiveTreeObject<Teacher2> {
        //This is used in the display student attendance table of normal faculty
        StringProperty USN;
        StringProperty HT;//hours taken
        StringProperty AT;//attendance 
        StringProperty AD;//absent days
        
        public Teacher2(String USN,String HT,String AT,String AD) {
            this.USN = new SimpleStringProperty(USN);
            this.AT = new SimpleStringProperty(AT);
            this.AD = new SimpleStringProperty(AD);
            this.HT = new SimpleStringProperty(HT);
            
            
            
        }

    } 
    class Teacher3 extends RecursiveTreeObject<Teacher3> {
        //This is used in the display student attendance table of normal faculty
        StringProperty USN;
        StringProperty SC;//hours taken
        StringProperty AT;//attendance 
        StringProperty AD;//absent days
        
        public Teacher3(String USN,String SC,String AT,String AD) {
            this.USN = new SimpleStringProperty(USN);
            this.AT = new SimpleStringProperty(AT);
            this.AD = new SimpleStringProperty(AD);
            this.SC = new SimpleStringProperty(SC);
            
            
            
        }

    } 
    

