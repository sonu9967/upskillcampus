package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancel,submit;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("raleway",Font.BOLD,24));
        l1.setBounds(280,20,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("raleway",Font.BOLD,22));
        type.setBounds(100,70,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setBounds(100,120,150,20);
        r1.setFont(new Font("raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,120,150,20);
        r2.setFont(new Font("raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setBounds(100,170,200,20);
        r3.setFont(new Font("raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,170,250,20);
        r4.setFont(new Font("raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup groupaccount =new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number");
       card.setFont(new Font("raleway",Font.BOLD,22));
        card.setBounds(100,220,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("raleway",Font.BOLD,22));
        number.setBounds(330,220,300,30);
        add(number);
        
        JLabel carddetail=new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("raleway",Font.BOLD,12));
        carddetail.setBounds(100,250,300,20);
        add(carddetail);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("raleway",Font.BOLD,22));
        pin.setBounds(100,290,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("raleway",Font.BOLD,22));
        pnumber.setBounds(330,290,300,30);
        add(pnumber);
        
        JLabel pindetail=new JLabel("Your 4 Digit Pin Number");
        pindetail.setFont(new Font("raleway",Font.BOLD,12));
        pindetail.setBounds(100,320,300,20);
        add(pindetail);
        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("raleway",Font.BOLD,22));
        services.setBounds(100,370,400,30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("raleway",Font.BOLD,16));
        c1.setBounds(100,420,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("raleway",Font.BOLD,16));
        c2.setBounds(350,420,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("raleway",Font.BOLD,16));
        c3.setBounds(100,470,200,30);
        add(c3);
        
        c4=new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("raleway",Font.BOLD,16));
        c4.setBounds(350,470,200,30);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("raleway",Font.BOLD,16));
        c6.setBounds(350,520,200,30);
        add(c6);
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("raleway",Font.BOLD,12));
        c7.setBounds(100,570,600,30);
        add(c7);
        
        //butoon
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setBounds(280,620,100,30);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setBounds(440,620,100,30);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
         String accountType =null;
         if(r1.isSelected()){
         accountType="Saving Account";
         }else if(r2.isSelected()){
         accountType="Fixed Deposit Account";
         }else if(r3.isSelected()){
           accountType="Current Account";
         }else if(r4.isSelected()){
         accountType="Recourses Deposit Account";
    }
   Random random =new Random();
   String cardnumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
   
   String pinnumber =""+Math.abs((random.nextLong()%9000l)+1000L);
   
   String facility="";
   if(c1.isSelected()){
       facility = facility + " ATM Card";
   }else if(c2.isSelected()){
       facility=facility+" Internet Banking";
   }else if(c3.isSelected()){
       facility=facility+" Mobile Banking";
   }else if(c4.isSelected()){
       facility=facility+" EMAIL & SMS Alerts";
   }else if(c5.isSelected()){
       facility=facility+" Cheque Book";
   }else if(c6.isSelected()){
       facility=facility+" E-Statement";
   }
   
   try{
       if(accountType.equals("")){
           JOptionPane.showMessageDialog(null, "Account type is required");
       }else{
           Conn c= new Conn();
           String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
           String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
           c.s.executeUpdate(query1);
           c.s.executeUpdate(query2);
           //show msge to user for cardno and pin
           JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\nPin: "+pinnumber);
       }
   }catch(Exception e){
      System.out.println(e);
   }
  }else if(ae.getSource()==cancel){
      setVisible(false);
  }
  
   /* Random random =  Random()else if(ae.getSource()==cancel){
      Random random=new Random();
       long carnumber=c;
       setVisible(false);
   }*/
  } 
    public static void main(String args[]){
          new SignupThree("");
    }
}
