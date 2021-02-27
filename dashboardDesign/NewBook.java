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
        String category[]={"Arts","Science","Biographies","Business","Comics","Computer & Tech",
                           "Cooking","Entertainment","Health & Fitness","History","Literature","Medical",
                           "Religion","Romance","Self-Help","Sports","Travel","Others"};
        
        String year[]={"1950",  "1951",  "1952",  "1953",  "1954",  "1955",  "1956",
                       "1957","1958","1959","1960","1961","1962","1963","1964","1965",
                        "1966","1967","1968","1969","1970","1971","1972","1973","1974",
                        "1975","1976","1977","1978","1979","1980","1981","1982","1983",
                        "1984","1985","1986","1987","1988","1989","1990","1991","1992",
                        "1993","1994","1995","1996","1997","1998","1999","2000","2001",
                        "2002","2003","2004","2005","2006","2007","2008","2009","2010",
                        "2011","2012","2013","2014","2015","2016","2017","2018","2019",
                        "2020","2021"};

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
