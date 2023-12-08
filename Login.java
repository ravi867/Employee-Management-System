package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
public class Login extends JFrame implements ActionListener{
    JTextField tfusername, tfpassword;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername =new JLabel("USERNAME");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        tfusername=new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        JLabel lblpassword =new JLabel("PASSWORD");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        tfpassword=new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        JButton login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(BLACK);
        login.setForeground(WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("local/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String username =tfusername.getText();
            String password = tfpassword.getText();
            conn c = new conn();
            String query ="select * from login where username= '"+username+"' and password ='"+password+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new home();
            }else 
            {
                JOptionPane.showMessageDialog(null,"Invalid useername or password");
                setVisible(false);
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    

public static void main(String args[])
{
    new Login();
}
}