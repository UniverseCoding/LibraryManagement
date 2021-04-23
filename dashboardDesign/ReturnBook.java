package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import librarian.Librarian;

public class ReturnBook extends JFrame implements ItemListener{
    
    JLabel l,l1,l2,l3,l4,l5,studentIdMsg;
    JTextField t1,t3,bookName1,bookName2,bookName3,date1,date2,date3; 
    JButton submitButton,cancelButton,SearchButton;
    JCheckBox chBox1,chBox2,chBox3;
  
    
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
        Font textFont = new Font("Bold",2,20);
        l=new JLabel("Return Book");
        l1=new JLabel("Student id :");
        l2=new JLabel("ISBN  :");
        l3=new JLabel("Student Name :");
        l4=new JLabel("Book Name :");
        l5=new JLabel("Date of Issue :");
        studentIdMsg =new JLabel();
        studentIdMsg.setForeground(Color.RED);
        l.setFont(new Font("Bold", 1,25));
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        t1=new JTextField(30); 
        t3=new JTextField(10);
        t1.setFont(textFont);
        t3.setFont(textFont);
        bookName1=new JTextField(30);
        bookName2=new JTextField(30);
        bookName3=new JTextField(30);
        date1=new JTextField(30);
        date2=new JTextField(30);
        date3=new JTextField(30);
        submitButton=new JButton("Submit");
        cancelButton=new JButton("Cancel");
        SearchButton = new JButton("Search");
        //set jlabel location
        l.setBounds(580,30,260,35);
        l1.setBounds(415,85,170,30);
        l2.setBounds(415,120,170,200);
        l3.setBounds(415,95,170,130);
        l4.setBounds(415,150,170,260);
        l5.setBounds(415,180,170,320);
        studentIdMsg.setBounds(585,105,230,30);
        //set JTextfield location
        t1.setBounds(570, 85,230,30);
        t3.setBounds(570,145,230,30);
        bookName1.setBounds(570,265,180,30);
        bookName2.setBounds(790,265,180,30);
        bookName3.setBounds(1050,265,180,30);
        //Make the Text Fields not-Editable.
        t3.setEditable(false);
        bookName1.setEditable(false);
        bookName2.setEditable(false);
        bookName3.setEditable(false);
        date1.setEditable(false);
        date2.setEditable(false);
        date3.setEditable(false);
        date1.setBounds(570,325,180,30);
        date2.setBounds(790,325,180,30);
        date3.setBounds(1050,325,180,30);
        //set jButton location
        submitButton.setBounds(590, 400, 285, 30);
        cancelButton.setBounds(890,400, 285, 30);
        SearchButton.setBounds(806,84,80,30);
        submitButton.setFocusPainted(false);
        cancelButton.setFocusPainted(false);
        SearchButton.setFocusPainted(false);
        
    
    //JCheckBox for isbn.
        chBox1 =new JCheckBox();
        chBox2 =new JCheckBox();
        chBox3 =new JCheckBox();
        //set Bounds of CheckBox.
        chBox1.setBounds(570,205,130,30);
        chBox2.setBounds(790,205,130,30);
        chBox3.setBounds(1050,205,130,30);
        //Add Listener to ComboBox.
        chBox1.addItemListener(this);
        chBox2.addItemListener(this);
        chBox3.addItemListener(this);
        //Add to the Frame.
        add(chBox1);
        add(chBox2);
        add(chBox3);
        
        //Jlabel added
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(studentIdMsg);
        //JTextfield added
        add(t1);
        add(t3);
        add(bookName1);
        add(bookName2);
        add(bookName3);
        add(date1);
        add(date2);
        add(date3);
        
        add(submitButton);
        add(cancelButton);
        add(SearchButton);
        
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                if(bookName1.getText().equals("") && bookName2.getText().equals("") && bookName3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Select atleast one isbn.");
                }
                else
                {
                    PreparedStatement pst = null;
                    ResultSet rs =null;
                    try
                    {
                        Conn conn = new Conn();
                        String s = t1.getText();
                        String sql = "INSERT INTO `returnbook`(`studentId`, `StudentName`, `isbn`, `bookName`, `Date`, `returnDate`) VALUES (?,?,?,?,?,curdate())";
                        pst =conn.con.prepareStatement(sql);
                        if(chBox1.isSelected())
                        {
                            String isbn=chBox1.getText();
                            pst.setString(1,t1.getText());
                            pst.setString(2,t3.getText());
                            pst.setString(3,isbn);
                            pst.setString(4,bookName1.getText());
                            pst.setString(5,date1.getText());
                            pst.executeUpdate();
                            String sqlD = "DELETE FROM `issuebook` WHERE isbn='"+isbn+"'";
                            pst.executeUpdate(sqlD);
                            
                        }
                        if(chBox2.isSelected())
                        {
                           
                            String isbn=chBox2.getText();
                            pst.setString(1,t1.getText());
                            pst.setString(2,t3.getText());
                            pst.setString(3,isbn);
                            pst.setString(4,bookName2.getText());
                            pst.setString(5,date2.getText());
                            pst.executeUpdate();
                            String sqlD = "DELETE FROM `issuebook` WHERE isbn='"+isbn+"'";
                            pst.executeUpdate(sqlD);
                        }
                        if(chBox3.isSelected())
                        {
                           
                            String isbn=chBox3.getText();
                            pst.setString(1,t1.getText());
                            pst.setString(2,t3.getText());
                            pst.setString(3,isbn);
                            pst.setString(4,bookName3.getText());
                            pst.setString(5,date3.getText());
                            pst.executeUpdate();
                            String sqlD = "DELETE FROM `issuebook` WHERE isbn='"+isbn+"'";
                            pst.executeUpdate(sqlD);
                        }
                        
                        JOptionPane.showMessageDialog(null,"Book returned successfully");

                        reset();
                        freshIsbn();
                    }
                    catch(Exception aa) 
                    {
                        JOptionPane.showMessageDialog(null,aa);
                    }
                }
            }
        });
        
        SearchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<String> sId = new ArrayList<String>();
                String text = t1.getText();
                sId.add(text);
                freshIsbn();
                String regex = "^[a-zA-Z0-9]+$";
                Pattern pattern = Pattern.compile(regex);
                for (Object sID : sId)
                {
                    Matcher matcher = pattern.matcher((CharSequence) sID);
                    if(matcher.matches()==true)
                    {
                      PreparedStatement pst = null;
                      ResultSet rs =null;
                      try
                        {
                            Conn conn = new Conn();
                            String s = t1.getText();
                            String sql = "SELECT newstudent.StudentName,issuebook.isbn FROM newstudent JOIN issuebook ON newstudent.studentid=issuebook.studentid where issuebook.studentid='"+s+"'";
                            pst =conn.con.prepareStatement(sql);
                            rs = pst.executeQuery(sql);
                            while(rs.next())
                           {  
                               t3.setText(rs.getString("studentName"));
                               chBox1.setText(rs.getString("isbn"));
                               while(rs.next())
                               {
                                   chBox2.setText(rs.getString("isbn"));
                                   while(rs.next())
                                   {
                                       chBox3.setText(rs.getString("isbn"));
                                   }
                               }
                            }
                        }
                      catch(Exception aa) 
                      {
                          JOptionPane.showMessageDialog(null,aa);
                      }
                    }
                    else
                    {
                      JOptionPane.showMessageDialog(null,"Invalid");
                    }
                }
            }
        });
        
        cancelButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Librarian ob = new Librarian();
            setVisible(false);
        }
        });
    }
    //To free the CheckBoxes.
    public void freshIsbn()
    {
       chBox1.setText("");
       chBox2.setText("");
       chBox3.setText("");
    }
     public void reset()
    {
       t1.setText("");
       t3.setText("");
       bookName1.setText("");
       bookName2.setText("");
       bookName3.setText("");
       date1.setText("");
       date2.setText("");
       date3.setText("");
       chBox1.setSelected(false);
       chBox2.setSelected(false);
       chBox3.setSelected(false);
    }
    public void paint(Graphics g) {
        super.paint(g);     
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(400, 50, 840,495, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     }

  //Create ItemListener for checkBox work.
    public void itemStateChanged(ItemEvent ie) {
        if(chBox1.isSelected()){
           
             PreparedStatement pst = null;
             ResultSet rs =null;
                try{
                     if(chBox1.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"You Have no Isbn.");
                    }
                    else
                    {
                         Conn conn = new Conn();
                         String s = chBox1.getText();
                         String sql = "select *from issuebook where isbn='"+s+"'";
                         pst =conn.con.prepareStatement(sql);
                         rs = pst.executeQuery(sql);
                         while(rs.next())
                         {
                             bookName1.setText(rs.getString("bookName"));
                             date1.setText(rs.getString("date"));
                         }
                    }
                }
                catch(Exception aa)
                {
                    JOptionPane.showMessageDialog(null,aa);
                }
                
        }
        else
        {
            bookName1.setText("");
            date1.setText("");
        }
        if(chBox2.isSelected()){
            PreparedStatement pst = null;
            ResultSet rs =null;
            try
            {
                if(chBox2.getText().equals("") && chBox1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"You Have no Isbn.");
                     
                }
                else if(chBox2.getText().equals("") )
                {
                    JOptionPane.showMessageDialog(null,"You Have Only 1 Isbn.");
                }
                else
                {
                     Conn conn = new Conn();
                     String s = chBox2.getText();
                     String sql = "select *from issuebook where isbn='"+s+"'";
                     pst =conn.con.prepareStatement(sql);
                     rs = pst.executeQuery(sql);
                     while(rs.next()){
                         bookName2.setText(rs.getString("bookName"));
                         date2.setText(rs.getString("date"));
                    }
                }
            }
                 catch(Exception aa)
                {
                    JOptionPane.showMessageDialog(null,aa);
                }
        }
        else
        {
            bookName2.setText("");
            date2.setText("");
        }
        if(chBox3.isSelected()){
            PreparedStatement pst = null;
            ResultSet rs =null;
            try
            {
                if(chBox3.getText().equals("") && chBox2.getText().equals("") && chBox1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"You Have no Isbn.");
                    
                }
                else if(chBox3.getText().equals("") && chBox2.getText().equals("") )
                {
                    JOptionPane.showMessageDialog(null,"You Have Only 1 Isbn.");
                }
                else if(chBox3.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(null,"You Have Only 2 Isbn.");

                }
                else
                {
                    Conn conn = new Conn();
                    String s = chBox3.getText();
                    String sql = "select *from issuebook where isbn='"+s+"'";
                    pst =conn.con.prepareStatement(sql);
                    rs = pst.executeQuery(sql);
                    while(rs.next())
                    {
                        bookName3.setText(rs.getString("bookName"));
                        date3.setText(rs.getString("date"));
                    }
                }
            }
            catch(Exception aa)
           {
               JOptionPane.showMessageDialog(null,aa);
           }
        }
        else
        {
            bookName3.setText("");
            date3.setText("");
        }
    }
}
