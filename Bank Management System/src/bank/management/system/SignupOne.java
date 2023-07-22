//imp questuion for interview 
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;//for calender

public class SignupOne extends JFrame implements ActionListener{
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JDateChooser datechooser;
    JRadioButton male ,female,other, married,unmarried;
    JButton next;
    long random;
    SignupOne(){
        setLayout(null);
        
        Random ran=new Random();//util package
        random=Math.abs(ran.nextLong()%9000L)+1000L;
        
        JLabel formno=new JLabel("APPLICATION FORM NO:"+random);
        formno.setFont(new Font("raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails=new JLabel("Page 1:Person Details");
        personDetails.setFont(new Font("raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        //textfield
        
        nameTextField =new JTextField();
        nameTextField.setFont(new Font("raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField =new JTextField();
        fnameTextField.setFont(new Font("raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        datechooser= new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        //to select only one option of gender set t
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField =new JTextField();
        emailTextField.setFont(new Font("raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
         
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);
        //to select only one option of gender set t
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField =new JTextField();
        addressTextField.setFont(new Font("raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField =new JTextField();
        cityTextField.setFont(new Font("raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField =new JTextField();
        stateTextField.setFont(new Font("raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField =new JTextField();
        pinTextField.setFont(new Font("raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        //button
        next= new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(620,635,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(850,725);
        setLocation(260,10);
        setVisible(true);
     
    }
    
    public void actionPerformed(ActionEvent ae){
          String formno=""+random;//if string add with long convert long into string
          String name = nameTextField.getText();//to get the value 
          String fname=fnameTextField.getText();
          String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
          String gender=null;
          if(male.isSelected()){
          gender="Male";
          }else if(female.isSelected()){
          gender="Female";
          }
          String email=emailTextField.getText();
          String marital=null;
          if(married.isSelected()){
            marital = "Married";
            
          }else if(unmarried.isSelected()){
            marital="Unmarried";
            
          }else if(other.isSelected()){
          marital="Other";
          }
         String address=addressTextField.getText();
         String city=cityTextField.getText();
         String state=stateTextField.getText();
         String pin=pinTextField.getText();
         
         try{
            if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is Required");
            }else{//step4
            Conn c=new Conn();
            String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
            //execute conn
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
            }
         }catch(Exception e)
         {
         System.out.println(e);
         }
    }
    public static void main(String args[]){
        new SignupOne();
    }
}
