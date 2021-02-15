package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewBook extends JFrame 
{
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9; 
    JComboBox cb1,cb2;
    JButton b1,b2;
    
    NewBook()
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
        String category[]={"India","Aus","U.S.A","England","Newzealand"}; 
        String year[]={"India","Aus","U.S.A","England","Newzealand"};
        
        Font font=new Font("Bold", 1, 17);      
        JComboBox cb1=new JComboBox(category);   
        JComboBox cb2=new JComboBox(year); 
                
        l=new JLabel("New Book Register");
        l1=new JLabel("Category:");
        l2=new JLabel("Book Name:");
        l3=new JLabel("ISBN:");
        l4=new JLabel("Auther Name:");
        l5=new JLabel("Edition:");
        l6=new JLabel("Year of publication:");
        l7=new JLabel("Price:");
        l8=new JLabel("Publisher Name:");
        l9=new JLabel("Publisher Id:");
        
        l.setFont(new Font("Bold", 1,25));
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);
        l8.setFont(font);
        l9.setFont(font);
        
        
        cb1=new JComboBox(category);   
        t2=new JTextField(30);
        t3=new JTextField(10);
        t4=new JTextField(30);
        t5=new JTextField(3);
        cb2=new JComboBox(year);
        t6=new JTextField(5);
        t7=new JTextField(20);
        t8=new JTextField(5);
        
        
        b1=new JButton("Submit");
        b2=new JButton("Cancel");
        
        l.setBounds(590,25,250,30);
        l1.setBounds(415,85,170,30);
        l2.setBounds(415,95,170,130);
        l3.setBounds(415,120,170,200);
        l4.setBounds(415,145,170,260);
        l5.setBounds(415,170,170,330);
        l6.setBounds(415,195,170,400);
        l7.setBounds(415,220,170,470);
        l8.setBounds(415,245,170,540);
        l9.setBounds(415,270,170,610);
        
        cb1.setBounds(570, 85,250,30);
        t2.setBounds(570,145,250,30);
        t3.setBounds(570,205,250,30);
        t4.setBounds(570,265,250,30);
        t5.setBounds(570,325,250,30);
        cb2.setBounds(570,385,250,30);
        t6.setBounds(570,445,250,30);
        t7.setBounds(570,505,250,30);
        t8.setBounds(570,565,250,30);
        
        b1.setBounds(600, 632, 90, 40);
        b2.setBounds(700, 632, 90, 40);
        
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        
        add(cb1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(cb2);
        add(t6);
        add(t7);
        add(t8);
        
        
        add(b1);
        add(b2);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        //1st Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(400, 50, 600, 668, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     
    }
    
//    public static void main(String args[])
//    {
//        NewBook n=new NewBook(); 
//        n.gui();
//        n.setVisible(true);
//    }
}
