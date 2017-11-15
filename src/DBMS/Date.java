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
public class Date {
    public static String Date()
    {
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(javaTime);
        System.out.println(" DATE : " +sqlDate.toString());
        return sqlDate.toString();
    }
    
}
