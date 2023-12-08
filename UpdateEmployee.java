
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;



public class UpdateEmployee extends JFrame implements ActionListener {
   
    JButton add,back;
    JTextField tfeducation,tffname,tfsalary,tfaddress,tfphone,tfdesignation,tfemail ;
    String empId;
    
    UpdateEmployee(String empId)
    {
        this.empId= empId;
                    getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("Serif",Font.PLAIN,20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
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
        
        JLabel lbldob= new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
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
        
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
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
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee I'd");
        labelempId .setBounds(50,400,150,30);
        labelempId .setFont(new Font("Serif",Font.PLAIN,20));
        add(labelempId );
        
        JLabel lblempId = new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("Serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
            conn c = new conn();
            String query=  "select * from employee where empId= '"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfaddress.setText(rs.getString("address"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                
            }
        
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        add= new JButton("Update Details");
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
        
        
        setSize(800,600);
        setLocation(300,50);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
    
        if(ae.getSource()==add)
        {
            
            String fname= tffname.getText();
         
            String salary= tfsalary.getText();
            String address = tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            
            
            try{
                conn Conn= new conn();
                String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"'where empId='"+empId+"'";
                Conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Update Successfully");
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
        new UpdateEmployee("");
    }
    
}
