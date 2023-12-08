
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number= ran.nextInt(999999);
    JButton add,back;
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfaadhar,tfdesignation,tfemail ;
    JDateChooser dcdob;
    JLabel lblempId;
    JComboBox cbeducation;
    AddEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("Serif",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("Serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("Serif",Font.PLAIN,20));
        add(labeldob);
        
        dcdob= new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("Serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("Serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone No.");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("Serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
       
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail .setFont(new Font("Serif",Font.PLAIN,20));
        add(labelemail );
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation .setFont(new Font("Serif",Font.PLAIN,20));
        add(labeleducation );
        
        String courses[]={"BBA","BCA","BTECH","BSC","BA","BCOM","MBA","MA","MCA","MSc","Phd","OTHER"};
        
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("Serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labelaadharno = new JLabel("Aadhar Number");
        labelaadharno.setBounds(400,350,150,30);
        labelaadharno.setFont(new Font("Serif",Font.PLAIN,20));
        add(labelaadharno);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel labelempId = new JLabel("Employee I'd");
        labelempId .setBounds(50,400,150,30);
        labelempId .setFont(new Font("Serif",Font.PLAIN,20));
        add(labelempId );
        
        lblempId = new JLabel(""+ number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("Serif",Font.PLAIN,20));
        add(lblempId);
        
        add= new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back= new JButton("Back To Home");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("local/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        
        
        
        setSize(900,700);
        setLocation(150,50);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
    
        if(ae.getSource()==add)
        {
            String name = tfname.getText();
            String fname= tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary= tfsalary.getText();
            String address = tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();
            
            
            try{
                conn Conn= new conn();
                String query="insert into employee values('"+name+"', '"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
                Conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new home();
            
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else
        {
            setVisible(true);
            new home();
        
        }
    }
    public static void main(String args[])
    {
        new AddEmployee();
    }
    
}
