package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import librarian.Librarian;

public class NewStudent extends JFrame 
{
    private final Container c;
    private Font f, font;
    private JButton b1, b2;
    NewStudent()
    {
        setTitle("Library Management System");
        setBounds(500,220,350,400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        c = this.getContentPane();
        c.setBackground(Color.getHSBColor(142,82,82));
     
        
    }
    public void gui()
    {
        
        //creat JTextField
        JTextField j1 = new JTextField();
        JTextField j2 = new JTextField();
        JTextField j3 = new JTextField();
        JTextField j4 = new JTextField();
        JTextField j5= new  JTextField();
        JTextField j6= new  JTextField();
        JTextField j7 = new JTextField();
        
        // set JTextField location
        j1.setBounds(600,100,240,30);
        j2.setBounds(600,160,240,30);
        j3.setBounds(600,220,240,30);
        j4.setBounds(600,280,240,30);
        j5.setBounds(600,340,240,30);
        j6.setBounds(600,400,240,30);
        j7.setBounds(600,520,240,50);
        
        // Added JTextField
        add(j1);
        add(j2);
        add(j3);
        add(j4);
        add(j5);
        add(j6);
        add(j7);
        
        //Create button1 
        b1=new JButton("Submit");
        b1.setBounds(605,605,90,35);
        b1.setFont(font);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.CYAN);
        add(b1);
        
         //Create button2
        b2=new JButton("Cancel");
        b2.setBounds(740,605,90,35);
        b2.setFont(font);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.CYAN);
        add(b2);
        //create JLabel  
        JLabel l=new JLabel("Student Register");
        l.setFont(new Font("Bold", 1,25));
        l.setBounds(610,30,250,30);
        add(l);
        
        //Create jComboBox
        String year[] = {"1st year","2nd year", "3rd year", "4th year"};
        JComboBox cb = new JComboBox(year);
        cb.setBounds(600,460,240,30);
        add(cb);
        //Action Listener for cancel button.
         b2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Librarian ob = new Librarian();
            setVisible(false);
        }
        });
      //Action Listener for submit button.
      b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
         
         
           String year = cb.getSelectedItem().toString();
           String student_name=j1.getText();
           String student_id=j2.getText();
           String email_id=j3.getText();
           String mobile_no=(j4.getText());     
           String course_name=j5.getText();
           String branch=j6.getText();     
           String address=j7.getText();
           if(student_id.isEmpty()|| student_name.isEmpty()){
              JOptionPane.showMessageDialog(null, "Please Fill up all field");
           }  
           else{
            data_base_update(student_name,student_id,email_id,mobile_no,course_name,branch,year,address);
        } 
      }
    
    });
    }
        
          public void data_base_update(String student_name,String student_id,String email_id,String mobile_no,String course_name, String branch, String year, String address){
          
          try{ 
                Conn con = new Conn();               
                String sql = "INSERT INTO NewStudent VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.c.prepareStatement(sql);
               
                
                st.setString(1,student_name);
                st.setString(2,student_id);
                st.setString(3,email_id);
                st.setString(4,mobile_no);
                st.setString(5,course_name);
                st.setString(6,branch);
                st.setString(7,year);             
                st.setString(8,address);
                
                st.executeUpdate();
                st.close();
                
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                
                 }catch(Exception ea){
                  JOptionPane.showMessageDialog(null,ea); 
                                
                }
            }
         
    
    
     @Override
    public void paint(Graphics g) {
        super.paint(g); 
        

        //creat Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 153, 51));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(400, 50, 600, 668, 50, 50);
        
        g.setFont(g.getFont().deriveFont(18f));
        g.drawString("Student name :", 430, 150);
        g.drawString("Student id :", 430, 210);
        g.drawString("Email id :", 430, 270);
        g.drawString("Mobile No :", 430, 330);
        g.drawString("Course name :", 430,390);
        g.drawString("Branch :", 430, 450);
        g.drawString("Year :", 430,510);
        g.drawString("Address :", 430,570);
        
        
    }
}
