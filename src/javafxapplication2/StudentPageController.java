/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import DBMS.Connect;
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
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import org.apache.commons.lang.StringUtils;

/**
 * FXML Controller class
 *
 * @author dylan
 */
public class StudentPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static boolean tock=true,bar=false;
    public static String CTID;
    public  static String USN; 
     static String ids;
    static String oldcon;
    static int randomInt=0;
    static int rowcount=1;
    static String msgs[][]=new String[5][3];
   @FXML
    private JFXHamburger StudentHam;

    @FXML
    private Label USNLabel;

    @FXML
    private Label DOBLabel;

    @FXML
    private Label SecLab;

    @FXML
    private Label SemLabel;

    @FXML
    private Label DepLabel;

    @FXML
    private Label ClassTeacherLabel;

    @FXML
    private Label ClubLabel;

    @FXML
    private JFXDrawer StudentDraw;

    @FXML
    private JFXTreeTableView<Student> AttendanceTable;

    @FXML
    private JFXTreeTableView<AnalysisDT> AnalysisTable;
    @FXML
    private JFXTextField incorrectCodes;

    @FXML
    private JFXTextField NoofMissedClasses;

    
    @FXML
    private JFXTextArea RequestForLeave;

    @FXML
    private JFXDatePicker LeaveDate;

     @FXML
    private JFXButton IncorrectAttendanceButton;


    @FXML
    private JFXButton RequestLeaveButton;

    @FXML
    private JFXTextField NoOfDays;

    @FXML
    private JFXButton logoutButton;
    @FXML
    private AnchorPane DragPane;
    @FXML
    private AnchorPane StudPane;
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
    private AnchorPane Analysis;
    @FXML
    private BarChart<?, ?> StackedBar;
    @FXML
    private NumberAxis yaxis;
    @FXML
    private CategoryAxis xaxis;
    @FXML
    private AnchorPane Aboutme;
    @FXML
    private void handleIncorrectAttendanceButton(MouseEvent event)
    {
//         AlertBox.display("","Input");
        if(incorrectCodes.getText().trim().equals("") || NoofMissedClasses.getText().trim().equals(""))
        {
            AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
        }
        else
        {
            
            WFile(USNLabel.getText().trim(),incorrectCodes.getText(),NoofMissedClasses.getText());
            AlertBox.notificationInfo("Done","We will look into this matter and get back to you shortly.");
            incorrectCodes.setText("");
            NoofMissedClasses.setText("");
        }    
            
            
            
      
        
    }
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private void handlelogout(MouseEvent event) throws IOException {
        Stage stage;
        Parent root;
        tock=false;
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
    private void handleRequestLeave(MouseEvent event){
        //AlertBox.display("","Input");
        try{
        if((LeaveDate.getValue().toString().equals("") || RequestForLeave.getText().trim().equals("")) || StringUtils.isEmpty(NoOfDays.getText()) ||  !StringUtils.isNumeric(NoOfDays.getText()))
        {
            
             AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
        } else {
            WFile1(LeaveDate.getValue().toString(),RequestForLeave.getText(),NoOfDays.getText());
            AlertBox.notificationInfo("Done","We will look into this matter and get back to you shortly.");
            LeaveDate.setValue(null);
            RequestForLeave.setText("");
            NoOfDays.setText("");
        }
        }
        catch(java.lang.NullPointerException e)
        {
            AlertBox.notificationWarn("A Gentle Request", "Please stop clicking every button you see pointlessly. I'm not in the mood of catching Null Pointer Exceptions ");
        }
    }
    public void fillDetails(String usn)  
    {
        try
        {
             System.out.println("dfasdfbklfusullVOMAi   "+usn );
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            String sql= "Select s.USN,s.DOB,s.Class,s.SEM,s.Dep,f.Name,f.FID From Student as s JOIN Class AS c ON c.Department=s.Dep AND c.Semester=s.SEM AND c.Section=s.Class JOIN Faculty as f ON f.FID=c.CTID AND f.Dep=s.Dep AND f.Sem=s.SEM AND f.Section=s.Class where s.USN = '"+usn+"';";
            ResultSet rs = stmt.executeQuery(sql); 
            rs.absolute(1);
            System.out.println("dfasdfbklfusullVOMAi");
            USN=rs.getString(1).toUpperCase();
            USNLabel.setText("USN : "+ rs.getString(1).toUpperCase());
            DOBLabel.setText("Date of Birth : "+rs.getString(2));
            SecLab.setText("Section : "+rs.getString(3));
            SemLabel.setText("Semester : "+rs.getString(4));
            DepLabel.setText("Department : "+rs.getString(5).toUpperCase());
            ClassTeacherLabel.setText("Class Teacher : "+rs.getString(6));
            CTID=rs.getString(7);
            
            ClubLabel.setText("Club : Currently not in any Club");
        }
        catch(SQLException e )
        {
            //AlertBox.display("Error",e.toString());
           
             AlertBox.notificationWarn("Error", "error in fetching your details from the database");
            e.printStackTrace();
        }
    }
    public void filltable(String usn) 
    {
         JFXTreeTableColumn<Student, String> subject = new JFXTreeTableColumn<>("Subject");
        subject.setPrefWidth(100);
        subject.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().Subject);
        
        JFXTreeTableColumn<Student, String> attended = new JFXTreeTableColumn<>("Attended");
        attended.setPrefWidth(93);
        attended.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().Attended);

        JFXTreeTableColumn<Student, String> total = new JFXTreeTableColumn<>("Total");
        total.setPrefWidth(82);
        total.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().Total);
        
        ObservableList<Student> users = FXCollections.observableArrayList();
        try{
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            String sql ="Select ss.Subject, sa.Attendance, f.`Hours Taken` FROM Student as s Join `Student Attendance` as sa ON s.USN=sa.USN JOIN Faculty as f on s.SEM=f.Sem AND s.Class=f.Section And sa.`Subject Code`=f.`Subject Code` JOIN Subjects as ss on s.DEP=ss.Dep AND s.SEM=ss.Sem AND sa.`Subject Code`=ss.`Subject Code` where s.USN = '"+usn+"';";
            ResultSet rs = stmt.executeQuery(sql); 
            while(rs.next())
            {
                users.add(new Student(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            
           

            final TreeItem<Student> root = new RecursiveTreeItem<Student>(users, RecursiveTreeObject::getChildren);
            AttendanceTable.getColumns().setAll(subject, attended, total);
            AttendanceTable.setRoot(root);
            AttendanceTable.setShowRoot(false);
             subject.setStyle( "-fx-alignment: CENTER-LEFT;");
        }
        catch(SQLException e)
        {
            
             AlertBox.notificationWarn("Error", "error in fetching your details from the database");e.printStackTrace();
             //AlertBox.display("Error",e.toString());
        }
    }
    
    
    
     public void threadtock() {
   
  //  System.out.println("Started....");
    
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
                    if(JavaFXApplication2.SD[1])
                        {//AboutME
                            System.out.println("HelloMessages selected");
                           StudPane.setDisable(true);
                             StudPane.setVisible(false);
                          MesPane.setDisable(false);
                               MesPane.setVisible(true);
                              JavaFXApplication2.SD[1]=false;
                             // displaymessages();
                              INBOX.setDisable(true);
        INBOX.setVisible(false);
        COMPOSEPane.setDisable(false);
         COMPOSEPane.setVisible(true);
         
                              
                        }
                    else if(JavaFXApplication2.SD[0]){
                        System.out.println("HelloAtt selected");
                        MesPane.setDisable(true);
                              MesPane.setVisible(false);
                       StudPane.setDisable(false);
                              StudPane.setVisible(true);
                              JavaFXApplication2.SD[0]=false;

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
               // System.out.println("Hello");
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tock=true;
        StudPane.setDisable(false);
                             StudPane.setVisible(true);
                          MesPane.setDisable(true);
                               MesPane.setVisible(false);
                              JavaFXApplication2.SD[0]=false;
                           StudentDraw.setDisable(false);
                            StudentDraw.setVisible(true);
                            StudentDraw.toBack();
        try{
        VBox box = FXMLLoader.load(getClass().getResource("StudentD.fxml"));
       System.out.println(2);
        StudentDraw.setSidePane(box);
        } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(StudentHam);//for left arrow
       // HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(StudentHam);//For X Mark
       transition.setRate(-1);
        StudentHam.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
        transition.setRate(transition.getRate()*-1);
        transition.play();
        if(StudentDraw.isShown()){
      StudentDraw.close(); 
      StudentDraw.toBack();
        }
        else{
            StudentDraw.toFront();
            StudentDraw.open();
        }
      
         
        });
       
       
       fillDetails( JavaFXApplication2.UserName); 
       filltable(JavaFXApplication2.UserName);
       USN=JavaFXApplication2.UserName;
       msg1.setDisable(true);
            msg1.setVisible(false);
            msg2.setDisable(true);
            msg2.setVisible(false);
            msg3.setDisable(true);
            msg3.setVisible(false);
            msg4.setDisable(true);
            msg4.setVisible(false);
           
         threadtock();
       
    }
    public void WFile1(String LD,String RFL, String NOD)
{/*
   BufferedWriter bw = null;
		FileWriter fw = null;
                try {
                        
			//String data = " This is new content";
                        
                        String k="";
			//File file = new File("LeaveRequest"+CTID.toUpperCase()+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
                                k= "---------------------------REQUESTS FOR LEAVE----------------------------\n\n";
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
                        k+=DBMS.Date.Date()+"------------------"+DBMS.Time.Time()+"\n"+USN+"\n Leave Date : "+LD+"\n Number of Days : "+NOD+"\n Request :\n"+RFL;
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
                }
    */
    try {
                ResultSet rs=null;
               
                
                //rs=stmt.executeQuery(sql);
               // if(rs.next()){
                   // String newc= "Admin \n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String k="";
                    k+="Request for leave\n"+DBMS.Date.Date()+"----------"+DBMS.Time.Time()+"\n"+USN+"\n Leave Date : "+LD+"\n Number of Days : "+NOD+"\n Request :\n"+RFL;
                    String f=USN;
                   String  sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,CTID);
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
                AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
                
            }
                        

   /* try {
         String k=FacComplaint.getText();
            k=FacultyData.eName+"\n"+Time.Time()+k+"\n\n";
            
            char buffer[]=new char [k.length()];
            k.getChars(0,k.length(),buffer,0);
            FileWriter f = new FileWriter ("FacultyComplaint.docx");
            for(int i=0;i<buffer.length;i+=2)
            {
                f.write(buffer[i]);
            }
    }
    
     catch(Exception e)
        {
            e.printStackTrace();
        }*/
    
}   
    public void WFile(String abc,String Sub, String Miss)
{
    /*BufferedWriter bw = null;
		FileWriter fw = null;
                try {
                        
			//String data = " This is new content";
                        
                        String k="";
			File file = new File("IncorrectAttendance"+CTID.toUpperCase()+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
                                k= "Subject \t Number of Missed Classes\n\n";
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
                        k+=DBMS.Date.Date()+"------------------"+DBMS.Time.Time()+"\n"+USN;
            k+=Sub+"\t"+Miss+"\n-------------------------------------------------------------------------------------\n";
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
                }
                   */     
try {
                ResultSet rs=null;
               
                
                //rs=stmt.executeQuery(sql);
               // if(rs.next()){
                   // String newc= "Admin \n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String k="";
                    k+="Incorrect Attendance\n"+DBMS.Date.Date()+"------------------"+DBMS.Time.Time()+"\n"+USN;
            k+=Sub+"\t"+Miss;
                    String f=USN;
                   String  sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,CTID);
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
                AlertBox.notificationWarn("Error", "Error");
                         ex.printStackTrace();
            }
                        

   /* try {
         String k=FacComplaint.getText();
            k=FacultyData.eName+"\n"+Time.Time()+k+"\n\n";
            
            char buffer[]=new char [k.length()];
            k.getChars(0,k.length(),buffer,0);
            FileWriter f = new FileWriter ("FacultyComplaint.docx");
            for(int i=0;i<buffer.length;i+=2)
            {
                f.write(buffer[i]);
            }
    }
    
     catch(Exception e)
        {
            e.printStackTrace();
        }*/
    
}   
    public void stackedgraph(){
        
        try {
            xaxis.getCategories().clear();
            XYChart.Series dataSeries1 = new XYChart.Series();
            dataSeries1.setName("Classes Attended");
            XYChart.Series dataSeries2 = new XYChart.Series();
            dataSeries2.setName("Average Attendance");
            XYChart.Series dataSeries3 = new XYChart.Series();
            dataSeries3.setName("Required Attendance");
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            String sql="Select a2.code, a1.sub,a1.att,a2.avgatt,a1.HT " +
"from (select sa.Attendance as att, sa.`Subject Code` as code, s.Subject as sub, f.`Hours Taken` as HT " +
"from `Student Attendance` as sa JOIN Subjects as s  " +
"ON sa.`Subject Code`=s.`Subject Code` " +
"JOIN Student ss ON ss.USN=sa.USN JOIN Faculty f on f.Sem=ss.Sem AND f.Section=ss.Class AND f.`Subject Code`=s.`Subject Code` " +
"where sa.USN='"+USN+"')  a1 JOIN  " +
"(Select ak.`Subject Code` as code,AVG(ak.Attendance) as avgatt " +
"from `Student Attendance` as ak  " +
"group by ak.`Subject Code`) a2 " +
"ON a1.code=a2.code ;";
            dataSeries1.getData().clear();
             dataSeries2.getData().clear();
              dataSeries3.getData().clear();
              StackedBar.getData().clear();
              //StackedBar.getData().add(new XYChart.Series(FXCollections.observableArrayList(new XYChart.Data("",0))));
              //StackedBar.getData().clear();
              xaxis.setAnimated(false);
              yaxis.setAnimated(true);
              StackedBar.setAnimated(true);
            xaxis.getCategories().addAll("Classes Attended", "Average Attendance", "Required Attendance");
            ResultSet rs = stmt.executeQuery(sql); 
            while(rs.next()){
              dataSeries1.getData().add(new XYChart.Data(rs.getString(1),rs.getInt(3)));  //my Attendance
               dataSeries2.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(4)));  //average attendance
               if((rs.getInt(5)*0.8)>=rs.getInt(3)){
                dataSeries3.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(5)*0.8)); 
               }//80%
               // System.out.println(rs.getString(1)+" "+ rs.getInt(5)*0.8);
            }
            
            StackedBar.getData().add(dataSeries1);
            StackedBar.getData().add(dataSeries2);
            StackedBar.getData().add(dataSeries3); 
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

     public String getto80(int att,int HT){
        String end="";
        
        if(att>Math.round(HT*0.8))
        {
           end+="Above 80%"; 
            
        }
        else
        {
            int need=0;
          /*double curr=(att/HT)*100;
          double nec=HT*0.8;
          double c =100/HT;
          
          while(nec>=curr){
              curr+=c;
              need++;
          }*/
         
          
          need=  (int) (Math.round(HT*0.8)-att);
           end+=need;
           
        }
        
        return end;
    }
    public void analysistabfill()
    {
        JFXTreeTableColumn<AnalysisDT, String> subject = new JFXTreeTableColumn<>("Subject");
        subject.setPrefWidth(100);
        subject.setCellValueFactory((TreeTableColumn.CellDataFeatures<AnalysisDT, String> param) -> param.getValue().getValue().Subject);
        
        JFXTreeTableColumn<AnalysisDT, String> code = new JFXTreeTableColumn<>("Subject Code");
        code.setPrefWidth(93);
        code.setCellValueFactory((TreeTableColumn.CellDataFeatures<AnalysisDT, String> param) -> param.getValue().getValue().SubjectCode);
        
        JFXTreeTableColumn<AnalysisDT, String> attended = new JFXTreeTableColumn<>("Attended");
        attended.setPrefWidth(83);
        attended.setCellValueFactory((TreeTableColumn.CellDataFeatures<AnalysisDT, String> param) -> param.getValue().getValue().Attended);

        JFXTreeTableColumn<AnalysisDT, String> total = new JFXTreeTableColumn<>("Total");
        total.setPrefWidth(52);
        total.setCellValueFactory((TreeTableColumn.CellDataFeatures<AnalysisDT, String> param) -> param.getValue().getValue().Total);

        JFXTreeTableColumn<AnalysisDT, String> need1 = new JFXTreeTableColumn<>("To get to 80%");
        need1.setPrefWidth(100);
        need1.setCellValueFactory((TreeTableColumn.CellDataFeatures<AnalysisDT, String> param) -> param.getValue().getValue().need);
        
        ObservableList<AnalysisDT> users1 = FXCollections.observableArrayList();
        try{  
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            String sql ="Select ss.Subject,sa.`Subject Code`, sa.Attendance, f.`Hours Taken`"
                    + " FROM Student as s Join `Student Attendance` as sa ON s.USN=sa.USN JOIN Faculty as f on "
                    + "s.SEM=f.Sem AND s.Class=f.Section And sa.`Subject Code`=f.`Subject Code` "
                    + "JOIN Subjects as ss on s.DEP=ss.Dep AND s.SEM=ss.Sem AND sa.`Subject Code`=ss.`Subject Code` where s.USN = '"+USN+"';";
            ResultSet rs = stmt.executeQuery(sql); 
            while(rs.next())
            {
                users1.add(new AnalysisDT(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),getto80(rs.getInt(3),rs.getInt(4))));
            }
            final TreeItem<AnalysisDT> root = new RecursiveTreeItem<AnalysisDT>(users1, RecursiveTreeObject::getChildren);
            AnalysisTable.getColumns().setAll(subject,code,attended,total,need1);
            AnalysisTable.setRoot(root);
            AnalysisTable.setShowRoot(false);
            subject.setStyle( "-fx-alignment: CENTER-LEFT;");
            need1.setStyle( "-fx-alignment: CENTER-LEFT;");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
             //AlertBox.display("Error",e.toString());
        }
        
        
        
    }
   
    @FXML
    private void handleDragOver(DragEvent event) {
        //we need to accept only a file
        if(event.getDragboard().hasFiles()){
        event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDrop(DragEvent event)  {
        try{
        List<File> files =event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0))); 
        File file = new File(USN+" Medical Certificate.jpg");
        
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
                                
			}
                        BufferedImage image = SwingFXUtils.fromFXImage(img, null);
         ImageIO.write((RenderedImage) image, "jpg", file); 
         System.out.println("We got the file. But there seems to be an error while uploading it");
          File filek=new File(USN+" Medical Certificate.jpg");
            FileInputStream fis=new FileInputStream(file);
            
             String  sql= "{ call sendmessageImage(?,?,?,?)}";
                    CallableStatement ps = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
            ps.setString(1,CTID);
             ps.setString(2,USN);
              ps.setString(3," Submission of Medical Certificate\n"+DBMS.Date.Date()+"\t"+DBMS.Time.Time());
            ps.setBinaryStream(4,fis,(int)filek.length());
            ps.execute();
 
            ps.close();
            fis.close();

         AlertBox.notificationInfo("Done","Your certificate has been uploaded");
        }
        catch(Exception e)
        {
           // AlertBox.display("Error",e.getMessage());
            AlertBox.notificationWarn("Error", "Only jpg fies are uploaded.");
            e.printStackTrace();
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
        System.out.println("hey look here!!!!!!!!!!!!!! "+msgs[0][0]+msgs[0][1]+msgs[0][2]);
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
    public void showmsg(String from,String Contents,String id){
              System.out.println("hey showing now!!!!!!!!!!!!!! "+from+Contents+id);
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
                    Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            } catch (FileNotFoundException ex) {
                AlertBox.display("Error",ex.getMessage());
                AlertBox.notificationWarn("Error","Image file corrupted");
                Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 
            oldcon=Contents;
            ids=id;
            
            
    }  
    

    @FXML
    private void handleup(MouseEvent event) {
        System.out.println(rowcount+"----------------------------------------------------------------------");
          if(rowcount>4){
            if(rowcount%4==0) {
                rowcount=rowcount-(7);
            }else{
                rowcount=rowcount-((rowcount%4)+4)+1;
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
            String sql = "Select count(*) from Messages where ToID='"+USN+"';";
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
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
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
                    String f=USN;
                    String sql= "{ call sendmessage(?,?,?)}";
                    CallableStatement pstmt = javafxapplication2.JavaFXApplication2.conn.prepareCall(sql);
                    pstmt.setString(1,inboxfrom.getText());
                    pstmt.setString(2,f);
                    pstmt.setString(3,replymsg.getText().trim());
                    pstmt.execute();
                    AlertBox.notificationInfo("Done", "Reply sent." );
                
            } catch (SQLException ex) {
                Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
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
                    String newc= USN+"\n"+replymsg.getText().trim()+"\n"+inboxfrom.getText()+"\n"+oldcon;
                    String f=USN;
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
                Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
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
                    String f=USN;
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
                Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        }
        catch(java.lang.NullPointerException e)
        {
            
          AlertBox.notificationWarn("Error", "You can't send blank messages.");  
        }
    }
     public void displaymessages(){
        try {
            ResultSet rs=null;
            String sql = "Select FromID, Content,MsgID from Messages where ToID='"+USN+"'order by MsgID DESC;";
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
            else{
                rs.previous();
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
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openAnalysis(MouseEvent event) {
     Aboutme.setDisable(true);
        Aboutme.setEffect(new GaussianBlur(20));
         Analysis.setDisable(false);
         Analysis.setVisible(true);
         //if(!bar){
         stackedgraph();
        // stackedgraph();
          analysistabfill();
        // analysistabfill();
         //bar=true;
         //}
         
    }

    @FXML
    private void handleAnalysisclose(MouseEvent event) {
        Analysis.setDisable(true);
         Analysis.setVisible(false);
       Aboutme.setEffect(new ColorAdjust()); 
       Aboutme.setDisable(false);
       
    }


    
    class AnalysisDT extends RecursiveTreeObject<AnalysisDT> {

        StringProperty Subject;
        StringProperty SubjectCode;
        StringProperty Attended;
        StringProperty Total;
        StringProperty need;

        public AnalysisDT(String Subject,String SubjectCode, String Attended, String Total,String need) {
            this.Subject = new SimpleStringProperty(Subject);
            this.Attended = new SimpleStringProperty(Attended);
            this.Total = new SimpleStringProperty(Total);
            this.SubjectCode= new SimpleStringProperty(SubjectCode);
            this.need= new SimpleStringProperty(need);
            
        }

    }    
    
class Student extends RecursiveTreeObject<Student> {

        StringProperty Subject;
        StringProperty Attended;
        StringProperty Total;

        public Student(String Subject, String Attended, String Total) {
            this.Subject = new SimpleStringProperty(Subject);
            this.Attended = new SimpleStringProperty(Attended);
            this.Total = new SimpleStringProperty(Total);
        }

    }    
    
}
