/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;
/**
 *
 * @author rudolf
 */
public class Time {

    /**
     *
     */
    public static String Time()
    {
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        //Get and display SQL TIME
      java.sql.Time sqlTime = new java.sql.Time(javaTime);
      String s =sqlTime.toString();
      s = s.substring(0, Math.min(s.length(), 5));
     // System.out.println(s);
      return (s);
    }
    
}
