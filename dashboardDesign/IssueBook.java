
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

public class IssueBook extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;

    IssueBook()
    {
        setTitle("Library Management System");
        setSize(1500,700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
 
    }
    public void gui()
    {
        //Code write here
    
   
        Font font = new Font("Soharab",Font.BOLD, 23);
        Font font2 = new Font("Soharab",Font.BOLD, 43);
        l6=new JLabel("Return Book");
        l1=new JLabel("Student Id: ");
        l2=new JLabel("Book Name:");
        l3=new JLabel("ISBN:");
        l4=new JLabel("Date:");
        l5=new JLabel("Return Date:");
       
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font2);
        
        
        t1=new JTextField(20); 
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        t5=new JTextField(20);
       
     
        
        
        b1=new JButton("Submit");
        b2=new JButton("Cancel");
        
        
        l1.setBounds(415,85,170,30);
        l2.setBounds(415,95,170,130);
        l3.setBounds(415,120,170,200);
        l4.setBounds(415,145,170,260);
        l5.setBounds(415,180,170,330);
        l6.setBounds(565,25,260,40);
        
        
        
       
        t1.setBounds(570,145,250,30);
        t2.setBounds(570,205,250,30);
        t3.setBounds(570,265,250,30);
        t4.setBounds(570,325,250,30);
        t5.setBounds(570,85,250,30);
        Font fnt = new Font("Soharab",Font.ROMAN_BASELINE,20);
        t1.setFont(fnt);
        t2.setFont(fnt);
        t3.setFont(fnt);
        t5.setFont(fnt);
        t4.setFont(fnt);
        
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t2.setHorizontalAlignment(JTextField.RIGHT);
        t3.setHorizontalAlignment(JTextField.RIGHT);
        t4.setHorizontalAlignment(JTextField.RIGHT);
        t5.setHorizontalAlignment(JTextField.RIGHT);
        
        
        b1.setBounds(570, 402, 90, 40);
        b2.setBounds(730, 402, 90, 40);
        b1.setFont(font);
        b2.setFont(font);
        
        add(l6);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(b1);
        add(b2);
    }
    
    @Override
     public void paint(Graphics g)
    {
        super.paint(g); 
        //1st Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(400, 50, 600, 66, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
        g1.drawRoundRect(400, 50, 600, 366, 50, 50);
        g1.drawRoundRect(400, 416, 600, 66, 50, 50);
        
    }
}


