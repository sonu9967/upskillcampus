//imp questuion for interview 
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;
import com.toedter.calendar.JDateChooser;//for calender

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JDateChooser datechooser;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    long random;
    String formno;
    JComboBox religion,income,occupation,education,category;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
         
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[]={"General","OBC","SC/ST","Other"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","<Upto 10,00,000"};
        income=new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel gender=new JLabel("Educational:");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationvalues[]={"Non-Graduate","Post-Graduate","Docatrate"};
        education=new JComboBox(educationvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
        
        
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
         String occupationvalues[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
         occupation=new JComboBox(occupationvalues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
  
        JLabel address=new JLabel("Pan No:");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan =new JTextField();
        pan.setFont(new Font("raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar =new JTextField();
        aadhar.setFont(new Font("raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
       
        //to select only one option of gender set t
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
       
        //to select only one option of gender set t
        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
       
        
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
          //String formno=""+random;//if string add with long convert long into string
          String sreligion = (String)religion.getSelectedItem();//to get the value 
          String scategory=(String)category.getSelectedItem();
          String sincome=(String) income.getSelectedItem();
          String soccupation=(String) occupation.getSelectedItem();
          String seducation=(String) education.getSelectedItem();
          String seniorcitizen=null;
          if(syes.isSelected()){
          seniorcitizen="Yes";
          }else if(sno.isSelected()){
            seniorcitizen="No";
          }
         // String email=emailTextField.getText();
          String existingaccount=null;
          if(eyes.isSelected()){
            existingaccount = "Yes";
            
          }else if(eno.isSelected()){
            existingaccount="No";
            
          }
          
         String span=pan.getText();
         String saadhar=aadhar.getText();
        
         
         try{
            //step4
            Conn c=new Conn();
            String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            //execute conn
            c.s.executeUpdate(query);
            //signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            }
         catch(Exception e)
         {
         System.out.println(e);
         }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}
