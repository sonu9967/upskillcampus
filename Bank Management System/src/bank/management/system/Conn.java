package bank.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
   public Conn(){
   try{
   //register the driver class by Class.forName(dtatabasename);
   //Class.forName(com.mysql.cj.jdbc.Driver);
   //create connection
   c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","SONUMONU");
   //create statement --->3rs step
   s=c.createStatement();
   
   
   }catch(Exception e){
     System.out.println(e);
   }
   } 
    
}
