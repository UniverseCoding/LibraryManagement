package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import librarian.Librarian;

public class ReturnBook extends JFrame{
    
    JLabel l,l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5; 
    JButton b1,b2,b3;
    
    ReturnBook()
    {
        setTitle("Library Management System");
        setSize(1500,700);
        getContentPane().setBackground(new Color(204, 255, 204));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
 
    }
    public void gui()
    {
        
        Font font=new Font("Bold", 1, 17);      
                
        l=new JLabel("Return Book");
        l1=new JLabel("Student id :");
        l2=new JLabel("ISBN  :");
        l3=new JLabel("Student Name :");
        l4=new JLabel("Book Name :");
        l5=new JLabel("Date of Issue :");
        
        l.setFont(new Font("Bold", 1,25));
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
       
        t1=new JTextField(30);  
        t2=new JTextField(30);
        t3=new JTextField(10);
        t4=new JTextField(30);
        t5=new JTextField(30);
        
        
        b1=new JButton("Submit");
        b2=new JButton("Cancel");
        b3 = new JButton("Search");
        //set jlabel location
        l.setBounds(580,30,260,35);
        l1.setBounds(415,85,170,30);
        l2.setBounds(415,95,170,130);
        l3.setBounds(415,120,170,200);
        l4.setBounds(415,150,170,260);
        l5.setBounds(415,180,170,320);
        //set JTextfield location
        t1.setBounds(570, 85,230,30);
        t2.setBounds(570,145,230,30);
        t3.setBounds(570,205,230,30);
        t4.setBounds(570,265,230,30);
        t5.setBounds(570,325,230,30);
        //set jButton location
        b1.setBounds(590, 400, 85, 30);
        b2.setBounds(690,400, 85, 30);
        b3.setBounds(806,84,80,30);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                
                   
                PreparedStatement pst = null;
                ResultSet rs =null;
                
                try{
                     Conn conn = new Conn();
                     String s = t1.getText();
                     String nm = "Salamaddin sk";
                     String sql = "select *from issueBook where studentId='"+s+"'";
                     String sql2 = "select *from newaccount where Name='"+nm+"'";
                     pst =conn.con.prepareStatement(sql);
                     rs = pst.executeQuery(sql);
                     
                     if(rs.next()){
                         t2.setText(rs.getString("isbn"));
                         /*t3.setText(rs.getString("studentName"));
                         t4.setText(rs.getString("book Name"));*/
                     }
                     rs = pst.executeQuery(sql2);
                     if(rs.next()){
                         t3.setText(rs.getString("Name"));
                         /*t3.setText(rs.getString("studentName"));
                         t4.setText(rs.getString("book Name"));*/
                     }
                    }
                 catch(Exception aa)
                {
                    JOptionPane.showMessageDialog(null,aa);
                }
            
                   
            }
        });
        
        
        //Jlabel added
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        
        //JTextfield added
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        
        add(b1);
        add(b2);
        add(b3);
        
  
        
        b2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Librarian ob = new Librarian();
            setVisible(false);
        }
        });
           
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);     
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(400, 50, 500,495, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     
    }
}
