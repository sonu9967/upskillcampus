package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*; 
public class MiniStatement extends JFrame implements ActionListener {
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,200);
        add(balance);
        
        //data fetching from system
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * fro  login where pin ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        //bank query
        try{
            Conn c=new Conn();
            int bal = 0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
           
                // for balance finding
              if(rs.getString("type").equals("Deposit") ){
                  bal +=Integer.parseInt(rs.getString("amount"));
               }else{
                  bal -=Integer.parseInt(rs.getString("amount"));
               
                }
            }
            balance.setText("Your Current Balance is Rs "+bal);
        }catch(Exception e){
            System.out.println(e);
            
        }
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e){
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
