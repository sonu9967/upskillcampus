package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
    JTextField pin,repin;
    String pinnumber;
    JButton change,back;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setBounds(250,195,500,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        //new pin create
        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.white);
        pintext.setBounds(165,260,180,25);
        pintext.setFont(new Font("System",Font.BOLD,17));
        image.add(pintext);
        //for type the new pin --> JTextField
        pin =new JTextField();
        pin.setFont(new Font("raleway",Font.BOLD,17));
        pin.setBounds(330,260,180,25);
        image.add(pin);
        
        //reenter pin
        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.white);
        repintext.setBounds(165,300,220,25);
        repintext.setFont(new Font("System",Font.BOLD,17));
        image.add(repintext);
        
        repin =new JTextField();
        repin.setFont(new Font("raleway",Font.BOLD,17));
        repin.setBounds(330,300,180,25);
        image.add(repin);
        //button change
        change=new JButton("CHANGE");
        change.setBounds(355,370,150,30);
        change.addActionListener(this);
        image.add(change);
        //back button
        back=new JButton("BACK");
        back.setBounds(355,410,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,850);
        setLocation(220,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin =pin .getText();
            String rpin =repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered Pin Doesn't Match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                return;
            }if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Re-New Pin");
                return;
            }
            Conn c=new Conn();//making the connection 
            String query1="update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query2="update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query3="update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
        //execute the query
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"Pin Change Successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        
        }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }
    
    public static void main(String args[]){
    
    new PinChange("").setVisible(true);
    }
    
}
