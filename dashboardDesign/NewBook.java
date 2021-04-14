package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import librarian.Librarian;

public class NewBook extends JFrame //implements ActionListener
{
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
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
        String category[]={"Select","Arts","Science","Biographies","Business","Comics","Computer & Tech",
                           "Cooking","Entertainment","Health & Fitness","Literature",
                           "Religion","Sports","Others"};
       
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
       // cb1.setSelectedItem(null);
        //cb1.addActionListener(this);
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
       
        l.setFont(new Font("Bold", 1,25));
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);
        l8.setFont(font);
       
       
        //cb1=new JComboBox(category); 
        //cb2=new JComboBox(year);
        t2=new JTextField(30);
        t3=new JTextField(20);
        t4=new JTextField(30);
        t5=new JTextField(20);
      
        t6=new JTextField(10);
        t7=new JTextField(20);
       
       
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
       
        cb1.setBounds(570, 85,250,30);
        t2.setBounds(570,145,250,30);
        t3.setBounds(570,205,250,30);
        t4.setBounds(570,265,250,30);
        t5.setBounds(570,325,250,30);
        cb2.setBounds(570,385,250,30);
        t6.setBounds(570,445,250,30);
        t7.setBounds(570,505,250,30);
       
        b1.setBounds(600, 580, 90, 35);
        b2.setBounds(700, 580, 90, 35);
       
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
   
       
        add(cb1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(cb2);
        add(t6);
        add(t7);
     
         
        add(b1);
        add(b2);
       
       // b1.addActionListener(this);
       // b2.addActionListener(this);
       // String category2=(String)cb2.getSelectedItem();
       // System.out.print(category2);
      b2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Librarian ob = new Librarian();
            setVisible(false);
        }
        });
      
      b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          String cetagory = cb1.getSelectedItem().toString();
          //String n= cb2.getSelectedItem().toString();
         int year_of_pub = Integer.parseInt(cb2.getSelectedItem().toString());
         // t5.setText("you have selected  "+ s + "" +num);
         // System.out.print(s+""+num);
           String bName=t2.getText();
           String isbn=t3.getText();
           String aName=t4.getText();
           String edition=t5.getText();
           int price=Integer.parseInt(t6.getText());
           String pName=t7.getText();
         
           if(isbn.isEmpty()){
              JOptionPane.showMessageDialog(null, "Please Fill up all field");
           }  
           else{
            data_base_update(cetagory,bName,isbn,aName,year_of_pub,price,pName,edition);
        } 
      }
    
    });
        
    } 
    
            private void data_base_update(String cetagory,String bName,String isbn,String aName,int year_of_pub,int price,String pName,String edition) {
                
                try{ 
                Conn con = new Conn();               
                String sql = "INSERT INTO newbook VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.c.prepareStatement(sql);
               
                
                st.setString(1,cetagory);
                st.setString(2,bName);
                st.setString(3,isbn);
                st.setString(4,aName);
                st.setInt(5,year_of_pub);
                st.setInt(6,price);
                st.setString(7,pName);             
                st.setString(8,edition);
                
                int rs = st.executeUpdate();
                st.close();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
		else
                    JOptionPane.showMessageDialog(null, "Error");
                
                 }catch(Exception ea){
                  System.out.println(ea);  
                                
            }
            }
    
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //1st Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(400, 50, 550, 650, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     
    }
}

