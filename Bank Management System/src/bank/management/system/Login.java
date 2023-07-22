
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
   JButton clear,login,signup;
   JTextField cardTextField ;
   JPasswordField pinTextField;
    Login(){  
    setTitle("AUTOMATED TELLER MACHINE");
    setLayout(null);
    //for image use the imageicon class aand classlaoder.getsystemresource is used to get sourse/image from system
//    //we cant keep pic direct on frame so we use Jlabel
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);//cant stored image into jlabel so convert into imageicon
    JLabel label=new JLabel(i3);//keep into jlabel
    label.setBounds(70,10,100,100);
    add(label);//label is obj
    
     JLabel text=new JLabel("Welcome To ATM");
     text.setFont(new Font("Osward",Font.BOLD,38));
     text.setBounds(200,40,400,40);
     add(text);
     
     JLabel cardno=new JLabel("Card No:");
     cardno.setFont(new Font("Raleway",Font.BOLD,28));
     cardno.setBounds(120,150,150,30);
     add(cardno);
     //for textfield
     cardTextField =new JTextField();
     cardTextField.setBounds(300,150,230,30);
     cardTextField.setFont(new Font("arial",Font.BOLD,14));
     add(cardTextField);
     
     JLabel pin=new JLabel("PIN:");
     pin.setFont(new Font("raleway",Font.BOLD,28));
     pin.setBounds(120,220,250,30);
     add(pin);
     
     pinTextField =new JPasswordField();
     pinTextField.setBounds(300,220,230,30);
     pinTextField.setFont(new Font("arial",Font.BOLD,14));
     add(pinTextField);
     
     //button of login
     login=new JButton("SIGN IN");
     login.setBackground(Color.black);
     login.setForeground(Color.white);
     login.setBounds(300,300,100,30);
     login.addActionListener(this);
     add(login);
     
     clear=new JButton("CLEAR");
     clear.setBackground(Color.black);
     clear.setForeground(Color.white);
     clear.setBounds(430,300,100,30);
     clear.addActionListener(this);
     add(clear);
     
     signup=new JButton("SIGN UP");
     signup.setBackground(Color.black);
     signup.setForeground(Color.white);
     signup.setBounds(300,350,230,30);
     signup.addActionListener(this);
     add(signup);
//background
    getContentPane().setBackground(Color.white);
    //for writing anything on frame we use jlabel
    setSize(800,480);
    setVisible(true);
    setLocation(330,180);
    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==clear){
        cardTextField.setText("");
        pinTextField.setText("");
    }else if(ae.getSource()==login){
        Conn conn=new Conn();
        String cardnumber=cardTextField.getText();
        String pinnumber=pinTextField.getText();
        String query = "select * from login where cardnumber='"+cardnumber+"' and pin ='"+pinnumber+"'";
    // for execute 
    try{
     ResultSet rs=conn.s.executeQuery(query);
     if(rs.next()){
      setVisible(false);//current frame off and 
      new Transactions(pinnumber).setVisible(true);//tansaction frame on
     }else{
     JOptionPane.showMessageDialog(null,"Incorrect card Number or Pin");
     }
    }catch(Exception e){
      System.out.println(e);
    }
    }else if(ae.getSource()==signup){
          setVisible(false);
          //obj for signup class
          new SignupOne().setVisible(true);
    }
    
    }
    public static void main(String args[]){
        new Login();
    }
}

