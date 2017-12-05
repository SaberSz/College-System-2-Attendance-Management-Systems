/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static boolean tock=true;
    static int rowcount=1;
    @FXML
    private JFXTreeTableView<Stud> StudentTable;

    @FXML
    private JFXTextField USN1;

    @FXML
    private JFXTextField sem1;

    @FXML
    private JFXDatePicker addDob;

    @FXML
    private JFXTextField sec1;

    @FXML
    private JFXTextField dep1;

    @FXML
    private JFXButton updateStudent;

    @FXML
    private JFXTextField usn2;

    @FXML
    private JFXDatePicker dob2;

    @FXML
    private JFXTreeTableView<Fac> FacultyTable;

    @FXML
    private JFXTextField fname1;

    @FXML
    private JFXTextField sem3;

    @FXML
    private JFXDatePicker dob3;

    @FXML
    private JFXTextField sec3;

    @FXML
    private JFXTextField dep3;

    @FXML
    private JFXButton updateStudent1;

    @FXML
    private JFXTextField fid2;

    @FXML
    private JFXDatePicker dob4;

    @FXML
    private JFXTextField fid1;

    @FXML
    private JFXTextField sem4;

    @FXML
    private JFXTextField sec4;

    @FXML
    private JFXTreeTableView<Dept> HODTable;

    @FXML
    private JFXTextField fname11;

    @FXML
    private JFXDatePicker dob31;

    @FXML
    private JFXTextField dep31;

    @FXML
    private JFXButton updateStudent11;

    @FXML
    private JFXTextField fid21;

    @FXML
    private JFXDatePicker dob41;

    @FXML
    private JFXTextField fid11;

    @FXML
    private JFXTextField sem41;

    @FXML
    private JFXTreeTableView<Class> ClassTable;

    @FXML
    private JFXTextField fname111;

    @FXML
    private JFXTextField dep311;

    @FXML
    private JFXButton updateStudent111;

    @FXML
    private JFXTextField fid211;

    @FXML
    private JFXTextField fid111;

    @FXML
    private JFXTextField sem411;

    @FXML
    private JFXTextField fid2111;

    @FXML
    private JFXTextField fid1111;
     @FXML
    private JFXTextField fid69;

    @FXML
    private JFXTreeTableView<Subjects> SubjectTable;

    @FXML
    private JFXTextField fname1111;

    @FXML
    private JFXTextField dep3111;

    @FXML
    private JFXButton updateStudent1111;

    @FXML
    private JFXTextField fid11111;

    @FXML
    private JFXDrawer AdminDrawer;
    
    @FXML
    private JFXTextField subcode10;
    
    @FXML
    private JFXTextField fid21111;
    @FXML
    private JFXTextField HT1;
    @FXML
    private JFXTextField filter1;
    @FXML
    private JFXTextField filter11;
    @FXML
    private JFXTextField filter12;
    @FXML
    private JFXTextField filter13;
    @FXML
    private JFXTextField filter14;
    @FXML
    private JFXHamburger AdminHam;
    @FXML
    private JFXButton logoutButton;
    //messages
    @FXML
    private AnchorPane StudPane;
    @FXML
    private JFXButton Compose;
    @FXML
    private AnchorPane msg1;
    @FXML
    private AnchorPane msg2;
    @FXML
    private AnchorPane msg3;
    @FXML
    private AnchorPane msg4;
    @FXML
    private AnchorPane msg5;
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
    private AnchorPane MesPane;
    @FXML
    private JFXButton displayinbox;
    @FXML
    private Label msg1from;
    @FXML
    private JFXTextField msg1sub;
    @FXML
    private Label msg2from;
    @FXML
    private JFXTextField msg2sub;
    @FXML
    private Label msg3from;
    @FXML
    private JFXTextField msg3sub;
    @FXML
    private Label msg4from;
    @FXML
    private JFXTextField msg4sub;
    @FXML
    private Label msg5from;
    @FXML
    private JFXTextField msg5sub;
    static String msgs[][]=new String[5][3];
    @FXML
    private Label inboxfrom;
    static int randomInt=0;
    public void threadtock() {
   
    System.out.println("Started....");
    
final java.util.Timer timer = new java.util.Timer();
    final TimerTask delayedThreadStartTask = new TimerTask() {
        

        public void run() {
System.out.println("Started..123131..");
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
                    if(JavaFXApplication2.AD[0])
                        {//AboutME
                            System.out.println("HelloMessages selected");
                           StudPane.setDisable(true);
                             StudPane.setVisible(false);
                          MesPane.setDisable(false);
                               MesPane.setVisible(true);
                              JavaFXApplication2.AD[0]=false;
                              displaymessages();
                              INBOX.setDisable(true);
        INBOX.setVisible(false);
        COMPOSEPane.setDisable(false);
         COMPOSEPane.setVisible(true);
         
                              
                        }
                    else if(JavaFXApplication2.AD[1]){
                        System.out.println("HelloAtt selected");
                        MesPane.setDisable(true);
                              MesPane.setVisible(false);
                       StudPane.setDisable(false);
                              StudPane.setVisible(true);
                              JavaFXApplication2.AD[1]=false;

                    }


                }
               // else if(factype[1])
                {
                    //classTeacher
                }
                //else if(factype[2])
                {
                       //hod
                } 
            }
            else{
                System.out.println("Hello");
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
           // e.printStackTrace();
            AlertBox.showErrorMessage(e);
        }
                    
                }
       //     }).start();
       // }
    };

    timer.schedule(delayedThreadStartTask, 500);//0.5 second
}
    
    public void FacultyFill()
    {
        
        
                     try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Fac, String> c1 = new JFXTreeTableColumn<>("FID");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) -> param.getValue().getValue().FID);
                    
                    JFXTreeTableColumn<Fac, String> c6 = new JFXTreeTableColumn<>("Name");
                    c6.setPrefWidth(100);
                    c6.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) -> param.getValue().getValue().Name);
                    
                    JFXTreeTableColumn<Fac, String> c2 = new JFXTreeTableColumn<>("Date of Birth");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) -> param.getValue().getValue().DOB);
                    
                    JFXTreeTableColumn<Fac, String> c7 = new JFXTreeTableColumn<>("Subject Code");
                    c7.setPrefWidth(82);
                    c7.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) -> param.getValue().getValue().SubCode);
                    
                    JFXTreeTableColumn<Fac, String> c3 = new JFXTreeTableColumn<>("Semester");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) -> param.getValue().getValue().Sem);
                    
                    JFXTreeTableColumn<Fac, String> c4 = new JFXTreeTableColumn<>("Section");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) ->  param.getValue().getValue().Sec);
                    
                     JFXTreeTableColumn<Fac, String> c5 = new JFXTreeTableColumn<>("Department");
                    c5.setPrefWidth(82);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) ->  param.getValue().getValue().Dep);
                    
                    JFXTreeTableColumn<Fac, String> c8 = new JFXTreeTableColumn<>("Hours Taken");
                    c8.setPrefWidth(82);
                    c8.setCellValueFactory((TreeTableColumn.CellDataFeatures<Fac, String> param) ->  param.getValue().getValue().HT);
                    
                    ObservableList<Fac> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select * from faculty;";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Fac(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                        }
                        
                        
                        
                        final TreeItem<Fac> root = new RecursiveTreeItem<Fac>(users, RecursiveTreeObject::getChildren);
                        FacultyTable.getColumns().setAll(c1,c6,c2,c7,c3,c4,c5);
                        FacultyTable.setRoot(root);
                        FacultyTable.setShowRoot(false);
                        
                        //For Filtering
                        filter11.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            FacultyTable.setPredicate((TreeItem<Fac> t) -> {
                                Boolean flag =t.getValue().FID.getValue().contains(newValue.toUpperCase())||t.getValue().DOB.getValue().contains(newValue)||t.getValue().Sem.getValue().contains(newValue)||t.getValue().Sec.getValue().contains(newValue.toUpperCase())||t.getValue().Dep.getValue().contains(newValue.toUpperCase())||t.getValue().Name.getValue().contains(newValue)||t.getValue().HT.getValue().contains(newValue)||t.getValue().SubCode.getValue().contains(newValue.toUpperCase());
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        AlertBox.showErrorMessage(e);
                        //AlertBox.display("Error",e.toString());
                    }
                    /*catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }*/
        }
        catch(SQLException ex)
        {
            AlertBox.showErrorMessage(ex);
            //AlertBox.display("Error",ex.toString());
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        
   public void DepFill(){
       
       
                     try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Dept, String> c1 = new JFXTreeTableColumn<>("FID");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Dept, String> param) -> param.getValue().getValue().FID);
                    
                    JFXTreeTableColumn<Dept, String> c2 = new JFXTreeTableColumn<>("Date of Birth");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Dept, String> param) -> param.getValue().getValue().DOB);
                    
                    JFXTreeTableColumn<Dept, String> c3 = new JFXTreeTableColumn<>("Name");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Dept, String> param) -> param.getValue().getValue().Name);
                    

                    
                     JFXTreeTableColumn<Dept, String> c5 = new JFXTreeTableColumn<>("Department");
                    c5.setPrefWidth(82);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Dept, String> param) ->  param.getValue().getValue().Branch);
                    
                    ObservableList<Dept> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select * from department;";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Dept(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Dept> root = new RecursiveTreeItem<Dept>(users, RecursiveTreeObject::getChildren);
                        HODTable.getColumns().setAll(c1,c3,c2,c5);
                        HODTable.setRoot(root);
                        HODTable.setShowRoot(false);
                        
                        //For Filtering
                        filter12.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            HODTable.setPredicate((TreeItem<Dept> t) -> {
                                Boolean flag =t.getValue().FID.getValue().contains(newValue.toUpperCase())||t.getValue().DOB.getValue().contains(newValue)||t.getValue().Name.getValue().contains(newValue)||t.getValue().Branch.getValue().contains(newValue.toUpperCase());
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        AlertBox.showErrorMessage(e);
                       // AlertBox.display("Error",e.toString());
                    }
                    /*catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }*/
        }
        catch(SQLException ex)
        {
            AlertBox.showErrorMessage(ex);
           // AlertBox.display("Error",ex.toString());
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
   }
           
    public void ClassFill(){
       
                     try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Class, String> c1 = new JFXTreeTableColumn<>("Semester");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Class, String> param) -> param.getValue().getValue().Sem);
                    
                    JFXTreeTableColumn<Class, String> c2 = new JFXTreeTableColumn<>("Section");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Class, String> param) -> param.getValue().getValue().Sec);
                    
                    JFXTreeTableColumn<Class, String> c3 = new JFXTreeTableColumn<>("Department");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Class, String> param) -> param.getValue().getValue().Dep);
                    

                    
                     JFXTreeTableColumn<Class, String> c5 = new JFXTreeTableColumn<>("Class Teacher Id");
                    c5.setPrefWidth(82);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Class, String> param) ->  param.getValue().getValue().CTID);
                    
                    ObservableList<Class> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select * from Class;";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Class(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Class> root = new RecursiveTreeItem<Class>(users, RecursiveTreeObject::getChildren);
                        ClassTable.getColumns().setAll(c1,c2,c3,c5);
                        ClassTable.setRoot(root);
                        ClassTable.setShowRoot(false);
                        
                        //For Filtering
                        filter13.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            ClassTable.setPredicate((TreeItem<Class> t) -> {
                                Boolean flag =t.getValue().Sem.getValue().contains(newValue)||t.getValue().Sec.getValue().contains(newValue.toUpperCase())||t.getValue().Dep.getValue().contains(newValue.toUpperCase())||t.getValue().CTID.getValue().contains(newValue.toUpperCase());
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        AlertBox.showErrorMessage(e);
                       // AlertBox.display("Error",e.toString());
                    }
                    /*catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }*/
        }
        catch(SQLException ex)
        {
            AlertBox.showErrorMessage(ex);
            //AlertBox.display("Error",ex.toString());
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }
    
       public void SubFill(){
       
                     try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Subjects, String> c1 = new JFXTreeTableColumn<>("Subject");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Subjects, String> param) -> param.getValue().getValue().Sub);
                    
                    JFXTreeTableColumn<Subjects, String> c2 = new JFXTreeTableColumn<>("Subject Code");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Subjects, String> param) -> param.getValue().getValue().SubCode);
                    
                    JFXTreeTableColumn<Subjects, String> c3 = new JFXTreeTableColumn<>("Department");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Subjects, String> param) -> param.getValue().getValue().Dep);
                    

                    
                     JFXTreeTableColumn<Subjects, String> c5 = new JFXTreeTableColumn<>("Semester");
                    c5.setPrefWidth(82);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Subjects, String> param) ->  param.getValue().getValue().Sem);
                    
                    ObservableList<Subjects> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select * from subjects;";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Subjects(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                        }
                        
                        
                        
                        final TreeItem<Subjects> root = new RecursiveTreeItem<Subjects>(users, RecursiveTreeObject::getChildren);
                        SubjectTable.getColumns().setAll(c1,c2,c3,c5);
                        SubjectTable.setRoot(root);
                        SubjectTable.setShowRoot(false);
                        
                        //For Filtering
                        filter14.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            SubjectTable.setPredicate((TreeItem<Subjects> t) -> {
                                Boolean flag =t.getValue().Sem.getValue().contains(newValue)||t.getValue().Sub.getValue().contains(newValue)||t.getValue().Dep.getValue().contains(newValue.toUpperCase())||t.getValue().SubCode.getValue().contains(newValue.toUpperCase());
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        AlertBox.showErrorMessage(e);
                        //AlertBox.display("Error",e.toString());
                    }
                    /*catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }*/
        }
        catch(SQLException ex)
        {
            AlertBox.showErrorMessage(ex);
           // AlertBox.display("Error",ex.toString());
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
    }

    public void StudentFill()
    {
             
        
                     try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            
            ResultSet rs = null;
                    
                    JFXTreeTableColumn<Stud, String> c1 = new JFXTreeTableColumn<>("USN");
                    c1.setPrefWidth(100);
                    c1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Stud, String> param) -> param.getValue().getValue().USN);
                    
                    JFXTreeTableColumn<Stud, String> c2 = new JFXTreeTableColumn<>("Date of Birth");
                    c2.setPrefWidth(93);
                    c2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Stud, String> param) -> param.getValue().getValue().DOB);
                    
                    JFXTreeTableColumn<Stud, String> c3 = new JFXTreeTableColumn<>("Semester");
                    c3.setPrefWidth(82);
                    c3.setCellValueFactory((TreeTableColumn.CellDataFeatures<Stud, String> param) -> param.getValue().getValue().Sem);
                    
                    JFXTreeTableColumn<Stud, String> c4 = new JFXTreeTableColumn<>("Section");
                    c4.setPrefWidth(82);
                    c4.setCellValueFactory((TreeTableColumn.CellDataFeatures<Stud, String> param) ->  param.getValue().getValue().Class);
                    
                     JFXTreeTableColumn<Stud, String> c5 = new JFXTreeTableColumn<>("Department");
                    c5.setPrefWidth(82);
                    c5.setCellValueFactory((TreeTableColumn.CellDataFeatures<Stud, String> param) ->  param.getValue().getValue().Dep);
                    
                    ObservableList<Stud> users = FXCollections.observableArrayList();
                    try{
                        
                        String sql ="Select * from student;";
                        rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            users.add(new Stud(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                        }
                        
                        
                        
                        final TreeItem<Stud> root = new RecursiveTreeItem<Stud>(users, RecursiveTreeObject::getChildren);
                        StudentTable.getColumns().setAll(c1,c2,c3,c4,c5);
                        StudentTable.setRoot(root);
                        StudentTable.setShowRoot(false);
                        
                        //For Filtering
                        filter1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            StudentTable.setPredicate((TreeItem<Stud> t) -> {
                                Boolean flag =t.getValue().USN.getValue().contains(newValue.toUpperCase())||t.getValue().DOB.getValue().contains(newValue)||t.getValue().Sem.getValue().contains(newValue)||t.getValue().Class.getValue().contains(newValue)||t.getValue().Dep.getValue().contains(newValue);
                                return flag;
                            });
                        });
                        
                    }
                    catch(SQLException e)
                    {
                        AlertBox.showErrorMessage(e);
                       // AlertBox.display("Error",e.toString());
                    }
                    /*catch(java.lang.NullPointerException k)
                    {
                        AlertBox.notificationWarn("Error","Please make sure you have selected a particular value from all the beautifully and well designed ComboBoxes ");
                    }*/
        }
        catch(SQLException ex)
        {
            AlertBox.showErrorMessage(ex);
            //AlertBox.display("Error",ex.toString());
             Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    public void refreshTable(){
        StudentFill();
        FacultyFill();
        DepFill();
        ClassFill();
        SubFill();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
                            tock=true;
                           StudPane.setDisable(true);
                             StudPane.setVisible(false);
                          MesPane.setDisable(false);
                               MesPane.setVisible(true);
                              JavaFXApplication2.AD[0]=false;
                            AdminDrawer.setDisable(false);
                            AdminDrawer.setVisible(true);
                            AdminDrawer.toBack();
                            try{
                             VBox box = FXMLLoader.load(getClass().getResource("AdminDraw.fxml"));
                           System.out.println(2);
                            AdminDrawer.setSidePane(box);
                            } catch (IOException ex) {
                                AlertBox.showErrorMessage(ex);
                               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                           }
                            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition( AdminHam);//for left arrow
                           // HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(StudentHam);//For X Mark
                           transition.setRate(-1);
                            AdminHam.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED,(e)->{
                            transition.setRate(transition.getRate()*-1);
                            transition.play();
                            if(AdminDrawer.isShown())
                            {
                               
                          AdminDrawer.close(); 
                           AdminDrawer.toBack();
                          
                            }
                            else
                            {
                                 AdminDrawer.toFront();
                          AdminDrawer.open();
                          
                            }
                            
                            
                            });
                             refreshTable();
                             displaymessages();
                             threadtock();
                              COMPOSEPane.setDisable(true);
        COMPOSEPane.setVisible(false);
        INBOX.setDisable(false);
         INBOX.setVisible(true);

    }    

    @FXML
    private void handleaddStudent(javafx.scene.input.MouseEvent event) {
         try{
        if(USN1.getText().trim().equals("")||addDob.getValue().toString().trim().equals("")||sem1.getText().trim().equals("")||sec1.getText().trim().equals("")||dep1.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = " INSERT INTO `student`(`USN`, `DOB`, `Class`, `SEM`, `Dep`) VALUES ('"+USN1.getText().trim()+"','"+addDob.getValue().toString().trim()+"','"+sec1.getText().trim()+"','"+sem1.getText().trim()+"','"+dep1.getText().trim()+"'); ";
                 
                stmt.executeUpdate(sql);
                refreshTable();
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this USN isn't already beimng used by someone else.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
    }

    @FXML
    private void handleupdateStudent(javafx.scene.input.MouseEvent event) {
        
        try{
        if(USN1.getText().trim().equals("")||addDob.getValue().toString().trim().equals("")||sem1.getText().trim().equals("")||sec1.getText().trim().equals("")||dep1.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "UPDATE `student` SET `DOB`='"+addDob.getValue().toString().trim()+"',`Class`='"+sec1.getText().trim()+"',`SEM`='"+sem1.getText().trim()+"',`Dep`='"+dep1.getText().trim()+"' WHERE USN='"+USN1.getText().trim()+"'";
                stmt.executeUpdate(sql);refreshTable();
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
    }

    @FXML
    private void handleremStudent(javafx.scene.input.MouseEvent event) {
        
        try{
        if(usn2.getText().trim().equals("")||dob2.getValue().toString().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "DELETE FROM `student` WHERE USN='"+usn2.getText().trim()+"' AND DOB='"+dob2.getValue().toString().trim()+"' ;";
                if (AlertBox.alertoption("Deletion","Deletion of a Student","Are you sure you want to delete student "+usn2.getText().trim()+" ?"))
                {        
                stmt.executeUpdate(sql);refreshTable();
                }
                
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
               // AlertBox.display1("Error",e.toString());
        }
        
        
        
    }

    @FXML
    private void handleaddFaculty(javafx.scene.input.MouseEvent event) {
        
         try{
        if(fname1.getText().trim().equals("")||dob3.getValue().toString().trim().equals("")||sem3.getText().trim().equals("")||sec3.getText().trim().equals("")||dep3.getText().trim().equals("")||subcode10.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                String sql1="Select k.FID from (Select f.FID, f.Branch as dep from department as f UNION Select d.FID, d.Dep as dep from faculty as d) as k  where k.dep = '"+dep3.getText()+"' Order BY FID DESC; ";
               ResultSet rs= stmt.executeQuery(sql1);
               rs.absolute(1);
               String last=rs.getString(1);
               int z=Integer.valueOf(last.substring(7))+1;
               String curr;
               if(z<10)
               {
                    curr=last.substring(0,7)+"00"+z;
               }
               else if(z<100)
               {
                   curr=last.substring(0,7)+"0"+z;
               }
               else
               {
                   curr=last.substring(0,7)+z;
               }
               
                 String sql = " INSERT INTO `faculty`(`FID`, `Name`, `DOB`, `Section`, `Subject Code`, `SEM`, `Dep`, `Hours Taken`) VALUES ('"+curr+"','"+fname1.getText()+"','"+dob3.getValue().toString().trim()+"','"+sec3.getText().trim()+"','"+subcode10.getText().trim()+"','"+sem3.getText().trim()+"','"+dep3.getText().trim()+"','0'); ";
                stmt.executeUpdate(sql);
                //fid1.setPromptText("Faculty Identification");
               //fid1.setEditable(false);
               fid1.setText(curr);refreshTable();
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure the entered Department, Semester , Subject Code and Section exist.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
            //  AlertBox.display("Error",e.toString());
        }
    }

    @FXML
    private void handleupdateFaculty(javafx.scene.input.MouseEvent event) {
        
         try{
        if(fname1.getText().trim().equals("")||fid1.getText().trim().equals("")||dob3.getValue().toString().trim().equals("")||sem3.getText().trim().equals("")||sec3.getText().trim().equals("")||dep3.getText().trim().equals("")||subcode10.getText().trim().equals("")||HT1.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                
                 String sql = "UPDATE `faculty` SET `Name`='"+fname1.getText()+"',`DOB`='"+dob3.getValue().toString()+"',`Section`='"+sec3.getText()+"',`Subject Code`='"+subcode10.getText().trim()+"',`SEM`='"+sem3.getText().trim()+"',`Dep`='"+dep3.getText().trim()+"',`Hours Taken`='"+HT1.getText().trim()+"' WHERE FID='"+fid1.getText().trim()+"';";
                stmt.executeUpdate(sql);refreshTable();
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure the entered Department, Semester , Subject Code and Section exist.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
              //  AlertBox.display("Error",e.toString());
        }
    }

    @FXML
    private void handleremFaculty(javafx.scene.input.MouseEvent event) {
        try{
        if(fid2.getText().trim().equals("")||dob4.getValue().toString().trim().equals("")||sem4.getText().trim().equals("")||sec4.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "DELETE FROM `faculty` WHERE FID='"+fid2.getText().trim()+"' AND DOB='"+dob4.getValue().toString().trim()+"' AND SEM='"+sem4.getText().trim()+"' AND Section ='"+sec4.getText().trim()+"';";
                if (AlertBox.alertoption("Deletion","Deletion of a Faculty","Are you sure you want to delete faculty "+fid2.getText().trim()+" from "+sem4.getText()+" "+sec4.getText()+"?"))
                {        
                stmt.executeUpdate(sql);refreshTable();
                }
                
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\nTo completely delete an existing class teacher first replace the class teacher with another teacher in the Class tab.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
                //AlertBox.display("Error",e.toString());
        }
        
    }

    @FXML
    private void handleaddHOD(javafx.scene.input.MouseEvent event) {
          
         try{
        if(fname11.getText().trim().equals("")||dob31.getValue().toString().trim().equals("")||dep31.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
            
        }
        else
        {
            try {
                ResultSet rs=null;
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                String sql2="Select * from department f where f.branch ='"+dep31.getText().trim().equals("")+"';";
               rs= stmt.executeQuery(sql2);
                if(!rs.absolute(1)){
                String sql1="Select k.FID from (Select f.FID, f.Branch as dep from department as f UNION Select d.FID, d.Dep as dep from faculty as d) as k  where k.dep = '"+dep31.getText().trim().equals("")+"' Order BY FID DESC; ";
             String curr; 
                rs= stmt.executeQuery(sql1);
               if(rs.next()){
               String last=rs.getString(1);
               int z=Integer.valueOf(last.substring(7))+1;
               
               if(z<10)
               {
                    curr=last.substring(0,7)+"00"+z;
               }
               else if(z<100)
               {
                   curr=last.substring(0,7)+"0"+z;
               }
               else
               {
                   curr=last.substring(0,7)+z;
               }
               }
               else
               {
                  curr="FID17"+dep31.getText().trim().substring(0,2)+"001";
               }
                    
               
                 String sql = " INSERT INTO `department`(`FID`, `Name`, `DOB`, `Branch`)  VALUES ('"+curr+"','"+fname11.getText()+"','"+dob31.getValue().toString().trim()+"','"+dep31.getText().trim()+"'); ";
                stmt.executeUpdate(sql);
                //fid1.setPromptText("Faculty Identification");
               //fid1.setEditable(false);
               fid11.setText(curr);refreshTable();
                }
                else
                {
                   
                     AlertBox.notificationWarn("Error","Duplicate Department values.\nThis department name already exists. Please pick another name for the department to be added.");
                    
                    
                }
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
            
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
               // AlertBox.display("Error",e.toString());
                e.printStackTrace();
        }
    }

    @FXML
    private void handleupdateHOD(javafx.scene.input.MouseEvent event) {
          try{
        if(fname11.getText().trim().equals("")||fid11.getText().trim().equals("")||dob31.getValue().toString().trim().equals("")||dep31.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                
                 String sql = "UPDATE `department` SET "
                         + " `Name`='"+fname11.getText()+"',`DOB`='"+dob31.getValue().toString()+"',`Branch`='"+dep31.getText()+"' WHERE `FID`='"+fid11.getText()+"' ;";
                 System.out.println(sql);
                stmt.executeUpdate(sql);refreshTable();
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure the entered Faculty Identification is a HOD of the entered department.\nAlso make sure that the department names haven't been repeated, unless it's for the same Head of Department.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
              //  AlertBox.display("Error",e.toString());
        }
    }

    @FXML
    private void handleremHOD(javafx.scene.input.MouseEvent event) {
         try{
        if(fid21.getText().trim().equals("")||dob41.getValue().toString().trim().equals("")||sem41.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "DELETE FROM `department` WHERE FID='"+fid21.getText().trim()+"' AND DOB='"+dob41.getValue().toString().trim()+"' AND Branch='"+sem41.getText().trim()+"';";
                if (AlertBox.alertoption("Deletion","Deletion of a Department","Are you sure you want to delete department "+sem41.getText().trim()+"?.\nAll students, faculty, classes and subjects that belong to the department will be deleted too."))
                {        
                stmt.executeUpdate(sql);refreshTable();
                }
                
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\nPlease check if the department exits.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
              //  AlertBox.display("Error",e.toString());
        }
    }

    @FXML
    private void handleaddClass(javafx.scene.input.MouseEvent event) {
         try{
        if(fname111.getText().trim().equals("")||dep311.getText().trim().equals("")||fid111.getText().trim().equals("")||fid69.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
            System.out.println("Hell Yeah"+fname111.getText()+dep311.getText()+fid111.getText()+fid69.getText());
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                String sql1="Select FID from faculty where `FID`='"+fid69.getText().trim()+"';";
               ResultSet rs= stmt.executeQuery(sql1);
               if(rs.absolute(1)){
                 String sql = " INSERT INTO `Class`(`Semester`, `Section`, `Department`, `CTID`) VALUES ('"+dep311.getText().trim()+"','"+fid111.getText().trim()+"','"+fname111.getText().trim()+"','"+fid69.getText().trim()+"'); ";
                 
                stmt.executeUpdate(sql);refreshTable();
               }
               else
               {
                   AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this class doesn't already exist, class teacher id and department already exists.");
               }
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this class doesn't already exist, class teacher id and department already exists.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
          //    AlertBox.display("Error",e.toString());
              e.printStackTrace();
             //  System.out.println("Hell Yeah"+fname111.getText()+dep311.getText()+fid111.getText()+fid69.getText());
        }
    }

    @FXML
    private void handleupdateClass(javafx.scene.input.MouseEvent event) {
         try{
        if(fname111.getText().trim().equals("")||dep311.getText().trim().equals("")||fid111.getText().trim().equals("")||fid69.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql2="Select FID from faculty where `FID`='"+fid69.getText().trim()+"';";
               ResultSet rs= stmt.executeQuery(sql2);
               if(rs.absolute(1)){
                 String sql = " UPDATE `Class` SET `CTID`='"+fid69.getText().trim()+"' WHERE `Semester`='"+dep311.getText().trim()+"' AND"
                         + "`Section`='"+fid111.getText().trim()+"' AND `Department`='"+fname111.getText().trim()+"'; ";
                 String sql1="Select * from Class where CTID='"+fid69.getText().trim()+"';";
                 rs=stmt.executeQuery(sql1);
                 if(rs.absolute(1)){
                     AlertBox.notificationWarn("A teacher can only handle a single class","This teacher appears to already be the class teacher of another class.");
                 }else
                 {
                      stmt.executeUpdate(sql);
                      sql="Update `faculty` set `SEM`= '"+dep311.getText().trim()+"',`Section`='"+fid111.getText().trim()+"' where  `Sem`='"+dep311.getText().trim()+"' AND"
                         + "`Section`='"+fid111.getText().trim()+"' AND `Dep`='"+fname111.getText().trim()+"';";
                       stmt.executeUpdate(sql);
                      refreshTable();
                 }
               }
               else
               {
                    AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this class doesn't already exist, class teacher id and department already exists.");
               }
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this class doesn't already exist, class teacher id and department already exists.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
             //   AlertBox.display("Error",e.toString());
        }
    }

    @FXML
    private void handleremClass(javafx.scene.input.MouseEvent event) {
        
          try{
        if(fid211.getText().trim().equals("")||fid211.getText().trim().equals("")||fid21111.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                
                 String sql = "DELETE FROM `Class` WHERE Section ='"+fid21111.getText().trim()+"' AND semester='"+fid211.getText().trim()+"' AND department='"+sem411.getText().trim()+"';";
                 System.out.println(sql);
                if (AlertBox.alertoption("Deletion","Deletion of a Class","Are you sure you want to delete this class ?.\nAll students and faculty belongng to this class will be deleted too."))
                {      
                    System.out.println(fid21111.getText().trim()+fid211.getText().trim()+sem411.getText().trim());
                stmt.executeUpdate(sql);
                 sql="Delete from `faculty` where  `Sem`='"+dep311.getText().trim()+"' AND"
                         + "`Section`='"+fid111.getText().trim()+"' AND `Dep`='"+fname111.getText().trim()+"';";
                refreshTable();
                }
                
                
            } catch (SQLException ex) {
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\nPlease check if the department, semester and section exist.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
            //    AlertBox.display("Error",e.toString());
        }
        
    }

    @FXML
    private void handleaddSubject(javafx.scene.input.MouseEvent event) {
         try{
        if(fname1111.getText().trim().equals("")||dep3111.getText().trim().equals("")||fid1111.getText().trim().equals("")||fid11111.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "INSERT INTO `Subjects`(`Subject`, `Subject Code`, `Dep`, `Sem`) "
                         + " VALUES ('"+fid1111.getText()+"','"+dep3111.getText().trim()+"','"+fname1111.getText().trim()+"',"
                         + "'"+fid11111.getText().trim()+"'); ";
                 
                stmt.executeUpdate(sql);
                refreshTable();
            } catch (SQLException ex) {
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this subject code doesnt already exist.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
               // AlertBox.display("Error",e.toString());
        }
    }

    @FXML
    private void handleupdateSubject(javafx.scene.input.MouseEvent event) {
         try{
        if(fname1111.getText().trim().equals("")||dep3111.getText().trim().equals("")||fid1111.getText().trim().equals("")||fid11111.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "UPDATE `Subjects` SET `Subject`='"+fid1111.getText()+"',`Dep`='"+fname1111.getText().trim()+"',`Sem`='"+fid11111.getText().trim()+"' WHERE `Subject Code`='"+dep3111.getText().trim()+"' ; ";
                
                stmt.executeUpdate(sql);
                refreshTable();
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\n Please make sure this subject code exists.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
               // AlertBox.display("Error",e.toString());
        }
        
    }

    @FXML
    private void handleremSubject(javafx.scene.input.MouseEvent event) {
        
         try{
        if(fid2111.getText().trim().equals("")){
            AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
        }
        else
        {
            try {
                Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
                 String sql = "DELETE FROM `Subjects` where `Subject Code`='"+fid2111.getText().trim()+"';";
                if (AlertBox.alertoption("Deletion","Deletion of a Class","Are you sure you want to delete this Subject ?"))
                {        
                stmt.executeUpdate(sql);
                refreshTable();
                }
                
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                 AlertBox.notificationWarn("Error", "There happens to be an error in your input. Please check it.\nPlease check if the department, semester and section exist.");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
              AlertBox.notificationWarn("A Gentle Request", "Please make sure to fill all the fields");
              //  AlertBox.display("Error",e.toString());
        }
    }

         private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private void logout(javafx.scene.input.MouseEvent event) {
        try {
            Stage stage;
            Parent root = null;
            
            tock=false;
            
            stage=(Stage)logoutButton.getScene().getWindow();
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
        } catch (IOException ex) {
            AlertBox.showErrorMessage(ex);
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static String ids;
    static String oldcon;
    @FXML
    private void handleCompose(MouseEvent event) {
         INBOX.setDisable(true);
        INBOX.setVisible(false);
        COMPOSEPane.setDisable(false);
         COMPOSEPane.setVisible(true);
    }


    @FXML
    private void handleReply(MouseEvent event) {
        try{
        if(replymsg.getText().trim().equals("")){
            AlertBox.notificationWarn("Error", "You can't send blank messages.");
        }else{
           try {
                ResultSet rs=null;
               
                
                   // String newc= "Admin \n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String f="Admin";
                    String sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,inboxfrom.getText());
                    pstmt.setString(2,f);
                    pstmt.setString(3,replymsg.getText().trim());
                    pstmt.execute();
                    AlertBox.notificationInfo("Done", "Reply sent." );
                
            } catch (SQLException ex) {
                AlertBox.showErrorMessage(ex);
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
                    String newc= "Admin \n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String f="Admin";
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
                AlertBox.showErrorMessage(ex);
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
           AlertBox.notificationWarn("Error", "You can't leave the foward to or reply box empty.");
        }
        
        
        
    }

    @FXML
    private void handleImageShow(MouseEvent event) {
        File file = new File("MC"+randomInt+".jpg");
        
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
                AlertBox.showErrorMessage(ex);
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
             AlertBox.notificationInfo(null, "No Attachment found"); 
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
    
    public void displaymessages(){
        try {
            ResultSet rs=null;
            String sql = "Select FromID, Content,MsgID from Messages where ToID='Admin' order by MsgID DESC;";
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
            AlertBox.showErrorMessage(ex);
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fillmsg1(MouseEvent event) {
        
        showmsg(msgs[0][0],msgs[0][1],msgs[0][2]);
        forwardto.setText("");
        replymsg.setText("");
    }

    @FXML
    private void fillmsg2(MouseEvent event) {
        showmsg(msgs[1][0],msgs[1][1],msgs[1][2]);
        forwardto.setText("");
        replymsg.setText("");
    }

    @FXML
    private void fillmsg3(MouseEvent event) {
        showmsg(msgs[2][0],msgs[2][1],msgs[2][2]);
        forwardto.setText("");
        replymsg.setText("");
    }

    @FXML
    private void fillmsg4(MouseEvent event) {
        showmsg(msgs[3][0],msgs[3][1],msgs[3][2]);
        forwardto.setText("");
        replymsg.setText("");
    }

    @FXML
    private void fillmsg5(MouseEvent event) {
        showmsg(msgs[4][0],msgs[4][1],msgs[4][2]);
        forwardto.setText("");
        replymsg.setText("");
    }

    public void showmsg(String from,String Contents,String id){
       
            inboxfrom.setText(from);
            Content.setText(Contents);
           /* ResultSet rs=null;
            String sql = "Select Images from MessageImages where MsgID = '"+id+"';";
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            rs=stmt.executeQuery(sql);
            Random randomGenerator = new Random();
            randomInt = randomGenerator.nextInt(1000000000);
            File file = new File("MC"+randomInt+".jpg");
            FileOutputStream output=null;
            try {
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
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            /*try {
                output = new FileOutputStream(file);
                System.out.println("Writing to file " + file.getAbsolutePath());
            while (rs.next()) {
                InputStream input = rs.getBinaryStream(1);
                byte[] buffer = new byte[1024];
                try {
                    while (input.read(buffer) > 0) {
                        output.write(buffer);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            } catch (FileNotFoundException ex) {
                AlertBox.display("Error",ex.getMessage());
                AlertBox.notificationWarn("Error","Image file corrupted");
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 
            oldcon=Contents;
            ids=id;
            
            
       
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
            String sql = "Select count(*) from Messages where ToID='Admin';";
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
            AlertBox.showErrorMessage(ex);
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
                    String f="Admin";
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
                AlertBox.showErrorMessage(ex);
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.showErrorMessage(e);
          AlertBox.notificationWarn("Error", "You can't send blank messages.");  
        }
        
    }
    
    
    class Stud extends RecursiveTreeObject<Stud> {
        //This is used in the display about me table of normal faculty
        StringProperty USN;
        StringProperty DOB;
        StringProperty Class;
        StringProperty Sem;
        StringProperty Dep;
        

        public Stud(String USN,String DOB,String Class,String Sem,String Dep) {
            this.USN = new SimpleStringProperty(USN);
            this.DOB = new SimpleStringProperty(DOB);
            this.Class= new SimpleStringProperty(Class);
            this.Dep = new SimpleStringProperty(Dep);
            this.Sem = new SimpleStringProperty(Sem);
            
            
            
            
        }

    }   
    
    class Dept extends RecursiveTreeObject<Dept> {
        //This is used in the display about me table of normal faculty
        StringProperty FID;
        StringProperty Name;
        StringProperty DOB;
        StringProperty Branch;

        

        public Dept(String FID,String Name,String DOB,String Branch) {
            this.FID = new SimpleStringProperty(FID);
            this.DOB = new SimpleStringProperty(DOB);
            this.Name= new SimpleStringProperty(Name);
            this.Branch = new SimpleStringProperty(Branch);
            
            
            
            
            
        }

    }   
    
    class Fac extends RecursiveTreeObject<Fac> {
        //This is used in the display about me table of normal faculty
        StringProperty FID;
        StringProperty Name;
        StringProperty DOB;
        StringProperty Sec;
        StringProperty SubCode;
        StringProperty Sem;
        StringProperty Dep;
        StringProperty HT;
        

        public Fac(String FID,String Name,String DOB,String Sec,String SubCode,String Sem,String Dep,String HT) {
            this.FID = new SimpleStringProperty(FID);
            this.DOB = new SimpleStringProperty(DOB);
            this.Sec= new SimpleStringProperty(Sec);
            this.Dep = new SimpleStringProperty(Dep);
            this.Sem = new SimpleStringProperty(Sem);
            this.SubCode = new SimpleStringProperty(SubCode);
            this.HT = new SimpleStringProperty(HT);
            this.Name = new SimpleStringProperty(Name);
            
            
            
            
        }

    }
    
    class Class extends RecursiveTreeObject<Class> {
        //This is used in the display about me table of normal faculty
        StringProperty Sem;
        StringProperty Sec;
        StringProperty Dep;
        StringProperty CTID;

        

        public Class(String Sem,String Sec,String Dep,String CTID) {
            this.Sem = new SimpleStringProperty(Sem);
            this.Dep = new SimpleStringProperty(Dep);
            this.Sec= new SimpleStringProperty(Sec);
            this.CTID = new SimpleStringProperty(CTID);
            
            
            
            
            
        }

    }   
    
      class Subjects extends RecursiveTreeObject<Subjects> {
        //This is used in the display about me table of normal faculty
        StringProperty Sub;
        StringProperty SubCode;
        StringProperty Dep;
        StringProperty Sem;

        

        public Subjects(String Sub,String SubCode,String Dep,String Sem) {
            this.Sem = new SimpleStringProperty(Sem);
            this.Dep = new SimpleStringProperty(Dep);
            this.Sub= new SimpleStringProperty(Sub);
            this.SubCode = new SimpleStringProperty(SubCode);
            
            
            
            
            
        }

    }   
    
}
