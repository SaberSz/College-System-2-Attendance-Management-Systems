package DBMS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBMS.Connect;
import java.util.*;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author rudolf
 */
public class CheckPer extends Connect 
{
    
    public boolean checkCompletion(String USN)
    {
        int zx=0;
        try
        {
            
             //Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
             Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
             String sql = "Select * FROM `Student Records` WHERE `USN`='"+USN+"';";
             ResultSet rs = stmt.executeQuery(sql); 
             rs.absolute(1);
           //  zx=rs.getInt(4+formNumber);
             if(zx>0)
             {
                 return false;
             }
             return true;
             
             
             
        }
        catch(Exception k)
        {
            k.printStackTrace();
        }
            
         return true;
    }
    public boolean checkStudent(String USN, String eDOB)
    {   
        //Scanner keyin =new Scanner(System.in);
        String tDOB,Dep,Sec,Sem;
        //int ch1;
        try
        {
             //Connection conn = DriverManager.getConnection(Connect.DB_URL,USER,PASS);
             Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            //conn.setAutoCommit(false);
            A:
            {    
                System.out.println("Student");
               // USN=keyin.next();
                //System.out.println();
                String sql = "Select * FROM `Student` WHERE `USN`='"+USN+"';";
                System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);  
                if(rs.absolute(1))
                {
                   // System.out.println("USN:");
                    tDOB=rs.getString(2);
                    
                    B : 
                    {
                        System.out.println("DOB (YYYY-MM-DD):");
                        //eDOB=keyin.next();
                        System.out.println();
                        if(tDOB.equals(eDOB))
                        {
                            System.out.println("Login Successful");
                            //Dep=Character.toString(USN.charAt(5))+Character.toString(USN.charAt(6));
                            Dep=rs.getString(3);
                            Sem=rs.getString(4);                                                    
                            Sec=rs.getString(5);
                            return true;
                            
                        }
                        else
                        {
                             System.out.println("DOB (YYYY-MM-DD): not successful");
                            return false;
                            /*System.out.println();
                            C:
                            {
                                System.out.println("1.Try Again\n2.Back to USN");
                                ch1=keyin.nextInt();
                                System.out.println();
                                switch(ch1)
                                {
                                    case 1: break C;
                                    case 2: break B;
                                    default: System.out.println("ERROR");
                                             
                                }
                            } */   
                        }
                    }    

                }
                else 
                {
                    return false;
                   // System.out.println();
                            /*C: while(true)
                            {
                                System.out.println("1.Try Again\n2.Back to Main Menu ");
                                ch1=keyin.nextInt();
                                switch(ch1)
                                {
                                    case 1: break C;
                                    case 2: return;
                                    default: System.out.println("ERROR");
                                }
                            }*/
                }
            }
            
            
            
            
        }
        catch(Exception k)
        {
              k.printStackTrace();
        }
        return false;
    }
    public boolean checkFaculty(String Name, String eDOB)
    {   
        //Scanner keyin =new Scanner(System.in);
        String tDOB,Dep="";
        int ch1;
        try
        {
              System.out.println("checkfaculty ");
            
            Statement stmt = javafxapplication2.JavaFXApplication2.conn.createStatement();
            ResultSet rs;
            String sql1="SELECT FID, DOB " +
"FROM faculty where FID = '"+Name+"' " +
"UNION ALL " +
"SELECT FID,DOB " +
"FROM department where FID = '"+Name+"';";
          //  String sql = "Select * FROM `Faculty` WHERE `FID`='"+Name+"';";
                             rs = stmt.executeQuery(sql1);  
                              if(rs.absolute(1))
                              {
                                  System.out.println("DOB (YYYY-MM-DD):"+eDOB+Name);
                                  tDOB=rs.getString(2);
                                    System.out.println("DOB (YYYY-MM-DD):"+tDOB+Name);
                                
                                      if(tDOB.equals(eDOB))
                                      {
                                          System.out.println("Login Successful");
                                          System.out.println();
                                          //System.out.println("\t\tTime of Login : "+Time.Time());
                                             System.out.println();
                                         // FacultyData k=new FacultyData();
                                          //k.accessOptions(Name,tDOB,Dep);
                                          return true;
                                          //break D;
                                      }
                                      else
                                      {
                                           System.out.println("Login Not Successful");
                                          // JOptionPane.showMessageDialog(null, "Entered Date or Name or Department is incorrect");
                                          return false;
                                        
                                     
                                      
                                           
                                      }

                              }
                              else 
                              {
                                   System.out.println("Login Not Successful");
                                 // JOptionPane.showMessageDialog(null,  "Entered Date or Name or Department is incorrect");
                                  return false;
                              }       
        }
            
        catch(Exception k)
       {
            k.printStackTrace();
        }
           return false; 
    }
    public boolean checkHOD(String eName, String eDOB)
    {   
        Scanner keyin =new Scanner(System.in);
        String tDOB,Dep;
        int ch1;
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            //conn.setAutoCommit(false);
            A://while(true)
            {   
                
                //System.out.print("Name : ");
                //Name=keyin.next();
                //String kp=keyin.next();
                //Name+=" "+kp;
                //System.out.println();
                String sql = "Select * FROM `HODS` WHERE `Name`='"+eName+"';";
                ResultSet rs = stmt.executeQuery(sql);  
                if(rs.absolute(1))
                {
                    
                    tDOB=rs.getString(2);
                    
                    B :   //while(true)
                    {
                        //System.out.print("DOB (YYYY-MM-DD) : ");
                        //eDOB=keyin.next();
                        //System.out.println();
                        if(tDOB.equals(eDOB))
                        {
                            System.out.println("Login Successful");
                            //System.out.println();
                            Dep=rs.getString(3);
                           // hodEntered h=new hodEntered();
                           // System.out.println("\t\tTime of Login : "+Time.Time());
                            //System.out.println();
                          //  h.hodOptions(Dep,eName);
                           // System.out.println("\t\tTime of Logout: "+Time.Time());
                            System.out.println();
                            return true;
                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Entered NAme or Date of birth is incorrect");return false;
                           // System.out.println();
                           /* C: while(true)
                            {
                                System.out.println("1.Try Again\n2.Back to Name");
                                ch1=keyin.nextInt();
                                System.out.println();
                                switch(ch1)
                                {
                                    case 1: break C;
                                    case 2: break B;
                                    default: System.out.println("ERROR");
                                }
                            } */   
                        }
                    }    

                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"Entered NAme or Date of birth is incorrect");return false;
                    //System.out.println();
                      /*      C: while(true)
                            {
                                System.out.println("1.Try Again\n2.Back to Main Menu ");
                                ch1=keyin.nextInt();
                                keyin.nextLine();
                                System.out.println();
                                switch(ch1)
                                {
                                    case 1: break C;
                                    case 2: return;
                                    default: System.out.println("ERROR");
                                }
                            }*/
                }
            }
            
            
            
            
        }
        catch(Exception k)
        {
              k.printStackTrace();
        }
        return false;
    }
    /*public boolean checkAdmin()
    {
        Scanner keyin= new Scanner (System.in);
        int ch1,ch2,SEM;
        String sql,USN,DOB,Class,DEP,Sub;
        try
        {
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            Q:while(true)
            {
                // System.out.println("Enter given Code");
            //eCode=keyin.nextInt();
           // sql ="Select * FROM `HODS` WHERE `Code`='""';";
         //   ResultSet rs = stmt.executeQuery(sql);  
                if(rs.absolute(1))
                {
                    
                     B:while(true)
                            {
                               System.out.println("1.Add Student \n2.Delete Student \n3.Add Faculty \n4.Delete Faculty \n5.Start Feedback \n6.Go Back");
                               ch2=keyin.nextInt();
                               System.out.println();
                               switch(ch2)
                               {
                                   case 1:
                                       //add student
                                       System.out.print("USN : ");
                                       USN=keyin.next();
                                        System.out.print("DOB (YYYY-MM-DD): ");
                                       DOB=keyin.next();
                                        System.out.print("Class: ");
                                       Class=keyin.next();
                                       System.out.print("SEM: ");
                                       SEM=keyin.nextInt();
                                       
                                        System.out.println();
                                       String sql1="INSERT INTO `Student Records`(`USN`, `DOB`, `Class`, `SEM`) VALUES ('"+USN+"','"+DOB+"','"+Class+"','"+SEM+"')";
                                     //rs=  stmt.executeQuery(sql1);  
                                       break;
                                   case 2:
                                       //delete student
                                        System.out.print("USN : ");
                                       USN=keyin.next();
                                       
                                       System.out.print(USN+" has been deleted");
                                       String sql3="DELETE FROM `Student Records` WHERE `USN`="+USN+";";
                                       stmt.executeUpdate(sql3);
                                        System.out.print(USN+" has been deleted");
                                       break ;
                                   case 3:
                                       //add Faculty
                                       System.out.print("Department : ");
                                       DEP=keyin.next();
                                       System.out.print("Name : ");
                                       USN=keyin.next();
                                        System.out.print("DOB (YYYY-MM-DD): ");
                                       DOB=keyin.next();
                                       System.out.print("Subject: ");
                                       Sub=keyin.next();
                                       System.out.print("SEM: ");
                                       SEM=keyin.nextInt();
                                       System.out.print("Class: ");
                                       Class=keyin.next();
                                       
                                        System.out.println();
                                       String sql2="INSERT INTO `"+DEP+"`(`Name`, `DOB`, `Class`, `Subject`, `SEM`) VALUES ('"+USN+"','"+DOB+"','"+Class+"','"+Sub+"','"+SEM+"')";
                                    //  rs= stmt.executeQuery(sql2);  
                                       break;
                                   case 4:
                                       //remove faculty
                                       System.out.print("Department : ");
                                       DEP=keyin.next();
                                       System.out.print("Name : ");
                                       USN=keyin.next();
                                       System.out.print("DOB (YYYY-MM-DD): ");
                                       DOB=keyin.next();
                                       
                                       String sql4="DELETE FROM `"+DEP+"` WHERE `Name`="+USN+" AND `DOB`='"+DOB+"';";
                                       stmt.executeUpdate(sql4);
                                        System.out.print(USN+" has been deleted");
                                       break ;
                                   case 5:
                                       //start feedback
                                       W: while(true)
                                      {
                                        System.out.println("Enter the Form Number (1,2,3)");
                                       formNumber=keyin.nextInt();
                                       if(formNumber>=1 && formNumber<=3 )
                                       {
                                           stmt.executeUpdate("UPDATE `HODS` SET `FormNumber`='"+formNumber+"' WHERE 1;");
                                           break W;
                                       }
                                       else 
                                       {
                                           System.out.println("Error in entry");
                                       }
                                      }
                                        break;     
                                       case 6:
                                       
                                       break Q;
                                       
                                   default:
                                       System.out.println("ERROR");
                                       System.out.println("Try again");
                               }
                            }
                }
                else 
                {
                    System.out.println("Code Error");
                     C: while(true)
                            {
                                System.out.println("1.Try Again\n2.Back to Main Menu ");
                                ch1=keyin.nextInt();
                                keyin.nextLine();
                                System.out.println();
                                switch(ch1)
                                {
                                    case 1: break C;
                                   // case 2: return;
                                    default: System.out.println("ERROR");
                                }
                            }
                    
                }
            }
            
        }
        catch(Exception k)
        {
            k.printStackTrace();
        }
        
  //  }
     
//}*/
}

