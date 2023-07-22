package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);
        
        //back button
        back=new JButton("Back");
        back.setBounds(355,400,150,30);
        back.addActionListener(this);
        image.add(back);
        
        //balance display
        Conn c=new Conn();
        int balance=0;
           try{
              ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'"); 
              
              while(rs.next()){
               if(rs.getString("type").equals("Deposit") ){
                  balance +=Integer.parseInt(rs.getString("amount"));
               }else{
                  balance -=Integer.parseInt(rs.getString("amount"));
               
                }
              }
           }catch(Exception e){
               System.out.println(e);
           }
           
          JLabel text=new JLabel("Your Current Account Balance is the "+balance);
          text.setForeground(Color.white);
          text.setBounds(170,195,400,30);
          image.add(text);
              
        setSize(900,850);
        setLocation(220,0);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
    
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    
    }
}
