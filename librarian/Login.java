package librarian;

import dashboardDesign.Conn;
import dashboardDesign.DashboardDesign;
import java. awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame{
    JLabel l,l1,l2;
    JTextField tf1,tf2;
    JButton b1,b2;
    Login()
    {
        setTitle("Library Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
    }
    void gui()
    {
        l=new JLabel("Login");
        l.setFont(new Font("Bold", 1,25));
        l.setBounds(610,25,250,30);
        
        l1=new JLabel("Username:");
        l2=new JLabel("Password:");
        l1.setBounds(485,85,170,30);
        l2.setBounds(485,145,170,30);
        
        tf1=new JTextField(10);
        tf2=new JTextField(15);
        tf1.setBounds(570, 85,250,30);
        tf2.setBounds(570,145,250,30);
        
        b1 = new JButton("Login");
        b2 = new JButton("Cancel");
        b1.setBounds(590, 200, 90, 35);
        b2.setBounds(690, 200, 90, 35);
        
        add(l);
        add(l1);
        add(l2);
        add(tf1);
        add(tf2);
        add(b1);
        add(b2);
        
        
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    Conn con = new Conn();           
                    String sql1 = "select * from newAccount where uid = ?";
                    String sql2 = "select * from newAccount where Password = ?";
                    PreparedStatement st1 = con.c.prepareStatement(sql1);      
                    PreparedStatement st2 = con.c.prepareStatement(sql2); 
                    st1.setString(1, tf1.getText());
                    st2.setString(1, tf2.getText());
                    ResultSet rs1 = st1.executeQuery(); 
                    ResultSet rs2 = st2.executeQuery(); 
                    
                    if(rs1.next()==true && rs2.next()==true) 
                    {  
                        DashboardDesign dashObj=new DashboardDesign();
                        dashObj.menu();
                        dashObj.frameButton();
                        dashObj.setVisible(true);
                        setVisible(false);
                    }
                    else{
                        if(rs1.next()==false)
                        {
                            JOptionPane.showMessageDialog(null,"Worng Username!");
                        }
                        else if(rs2.next()==false)
                        {        
                            JOptionPane.showMessageDialog(null,"Worng Password!");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No Record Found, please contact adminitrator!");
                        }
                    }
                }
                catch(Exception exc)
                {
                    System.err.println(exc);
                }
                
            }
        });
        
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        }); 
        
    
    }
}
