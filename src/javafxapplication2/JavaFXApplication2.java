/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author dylan
 */
public class JavaFXApplication2 extends Application {
    public static Connection conn=null;
    public static String UserName;
    static boolean NF[]={false,false,false};
    static boolean AD[]={false,false};
     static boolean SD[]={false,false};
     private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ScreenLoader.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
       
        BorderPane root1 = new BorderPane(root);

        root1.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root1.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
//        Extras.ResizeHelper.addResizeListener(stage);
         Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        
        
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        

        //Scene scene = new Scene(root, 800, 600);
       // primaryStage.setScene(scene);
        //primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         conn = DBMS.Connect.ConnectDb();
         
        launch(args);
    }
    
    public void switchScene(String fxmlFile,Stage stage)
{

    FXMLLoader loader = new FXMLLoader(getClass()
            .getResource(fxmlFile));
    Parent root;
    try 
    {
        root = (Parent)loader.load();
        if(fxmlFile.equals("StudentPage.fxml"))
        {
            StudentPageController controller = (StudentPageController)loader.getController();
           // controller.setModel(new BasicCalculatorModelTest(controller));
           // controller.setLogic(this);
        }
        else if(fxmlFile.equals("TestSwitch.fxml"))
        {
            //TestSwitch controller = (TestSwitch)loader.getController();
            //controller.setLogic(this);
        }
        stage.setScene(new Scene(root));
    } 
    catch (IOException e)
    {
        e.printStackTrace();
    }

}
  
    
}
   