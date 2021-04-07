
package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import librarian.Librarian;


public class NewAccount extends JFrame 
{
    JLabel label1,label2,label3;
    JTextField textField1;
    JPasswordField passwordField1,passwordField2;
    JButton submitButton,ClearButton,backButton;
    JCheckBox  JCheckBox1,JCheckBox2;
    
    Connection con =null;
    PreparedStatement pst =null;
    
    public NewAccount()
    {
        setTitle("Library Management System");
        setSize(1500,700);
        getContentPane().setBackground(new Color(190, 245, 104));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        
    }
    public void gui ()
    {
       //Label Section.
       label1 = new JLabel("Name: "); // create objects for Labels and given Names.
       label2 = new JLabel("Password: ");
       label3 = new JLabel("Re-Password: ");
       label1.setBounds(572, 175, 120, 25); // set locations and size of labels.
       label2.setBounds(572, 245, 180, 25);
       label3.setBounds(572, 315, 230, 25);
       label1.setForeground(Color.BLUE); //set  label's Text Color.
       label2.setForeground(Color.BLUE);
       label3.setForeground(Color.BLUE);
       label1.setFont(new Font("Soharab", Font.PLAIN, 34)); //create new Font for Label.
       label2.setFont(new Font("Soharab", Font.PLAIN, 34));
       label3.setFont(new Font("Soharab", Font.PLAIN, 30));
       add(label1); // add to JFrame.
       add(label2);
       add(label3);
       
       //TextField and PasswordField Section.
        // create  objects for text field and password field.
       passwordField1 = new JPasswordField(); 
       textField1 = new JTextField(); 
       passwordField2 = new JPasswordField();
       // set Font and font Size.
       textField1.setFont(new Font("Soharab", Font.BOLD, 24)); 
       passwordField1.setFont(new Font("Soharab", Font.ROMAN_BASELINE, 24));
       passwordField1.setEchoChar('*');
       passwordField2.setEchoChar('*');
       passwordField2.setFont(new Font("Soharab", Font.ROMAN_BASELINE, 24));
        // set Location and Size.
       textField1.setBounds(772, 175, 460, 25);
       passwordField1.setBounds(772, 245, 460, 25);
       passwordField2.setBounds(772, 315, 460, 25);
       //Create a color for Forground.
       Color color2 = new Color(57,55,197);
       textField1.setForeground(color2);
       passwordField1.setForeground(color2);
       passwordField2.setForeground(color2);
       // add to JFrame.
       add(textField1);
       add(passwordField1);
       add(passwordField2);
       
    //Buttons Section.
        // create buttons object and gave a name.
       submitButton =new JButton("Submit");
       ClearButton = new JButton("Clear All");
       backButton = new JButton();
       // set location and size of Buttons.
       submitButton.setBounds(772,415,210,35); 
       ClearButton.setBounds(1022,415,210,35);
       backButton.setBounds(1165,131,65,25);
        // add Buttons to Frame.
       add(submitButton);
       add(ClearButton);
       add(backButton);
       submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
                if(textField1.getText().isEmpty() || passwordField1.getText().isEmpty() || passwordField2.getText().isEmpty()){
                     JOptionPane.showMessageDialog(null,"Please Fill up All field");
                }
                else
                    try{
                        if(passwordField1.getText().equals(passwordField2.getText())){
                        String submit = "INSERT INTO `newaccount`(`Name`, `Password`, `RePassword`) VALUES (?,?,?)";
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/librarian","root","");
                        pst = con.prepareStatement(submit);
                        pst.setString(1,textField1.getText());
                        pst.setString(2,passwordField1.getText());
                        pst.setString(3,passwordField2.getText());
                        pst.executeUpdate();      
                        JOptionPane.showMessageDialog(null,"New Account Created successfully");
                        reset();
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Password and re-password is not Matched");
                    }
                    catch(Exception ae){
                        JOptionPane.showMessageDialog(null, e);
                    }
               
            }
        });
       ClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
               reset();
            }
        });
       backButton.setFocusable(true);
       backButton.setContentAreaFilled(false);
       Image img = Toolkit.getDefaultToolkit().getImage("C:/Users/SOHARAB/Desktop/icon.png");
       Image newimg = img.getScaledInstance(65, 25,1);
       ImageIcon icon = new ImageIcon(newimg);
       backButton.setIcon(icon);
       backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
              Librarian obj = new Librarian();
            }
        });
       //JCheckBox Section to visible Password.
       JCheckBox1 = new JCheckBox("Show");
       JCheckBox1.setBounds(1158, 275, 73, 25);
       add(JCheckBox1);
       JCheckBox1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(JCheckBox1.isSelected()){
                   passwordField1.setEchoChar((char)0);
               }
               else
                   passwordField1.setEchoChar('*');
           }
       }
       );
       
       JCheckBox2 = new JCheckBox("Show");
       JCheckBox2.setBounds(1158, 345, 73, 25);
       add(JCheckBox2);
       JCheckBox2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(JCheckBox2.isSelected()){
                   passwordField2.setEchoChar((char)0);
               }
               else
                   passwordField2.setEchoChar('*');
           }
       }
       );
    }
    
   
    //Create Reset method for clear all fields.
    public void reset()
    {
        textField1.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }
     public void paint(Graphics g){
        super.paint(g);
        

        //1st Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(570, 163, 710, 360, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     }
}

