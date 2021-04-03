
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
    JLabel l1,l2,l3;
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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        
    }
    public void gui ()
    {
       //Label Section.
       l1 = new JLabel("Name: "); // create objects for Labels and given Names.
       l2 = new JLabel("Password: ");
       l3 = new JLabel("Re-Password: ");
       l1.setBounds(172, 75, 120, 25); // set locations and size of labels.
       l2.setBounds(172, 145, 180, 25);
       l3.setBounds(172, 215, 230, 25);
       l1.setForeground(Color.RED); //set  label's Text Color.
       l2.setForeground(Color.GREEN);
       l3.setForeground(Color.BLUE);
       l1.setFont(new Font("Soharab", Font.PLAIN, 34)); //create new Font for Label.
       l2.setFont(new Font("Soharab", Font.PLAIN, 34));
       l3.setFont(new Font("Soharab", Font.PLAIN, 30));
       add(l1); // add to JFrame.
       add(l2);
       add(l3);
       
       //TextField and PasswordField Section.
       textField1 = new JTextField();  // create  objects for text field and password field.
       passwordField1 = new JPasswordField(); 
       passwordField2 = new JPasswordField();
       textField1.setFont(new Font("Soharab", Font.BOLD, 24)); // set Font and font Size.
       passwordField1.setFont(new Font("Soharab", Font.ROMAN_BASELINE, 24));
       passwordField1.setEchoChar('*');
       passwordField2.setEchoChar('*');
       passwordField2.setFont(new Font("Soharab", Font.ROMAN_BASELINE, 24));
       textField1.setBounds(372, 75, 460, 25); // set Location and Size.
       passwordField1.setBounds(372, 145, 460, 25);
       passwordField2.setBounds(372, 215, 460, 25);
       Color color1 = new Color(12,177,80);//Create a color for Background.
       textField1.setBackground(color1);
       passwordField1.setBackground(color1);
       passwordField2.setBackground(color1);
       Color color2 = new Color(57,55,197);//Create a color for Forground.
       textField1.setForeground(color2);
       passwordField1.setForeground(color2);
       passwordField2.setForeground(color2);
       add(textField1); // add to JFrame.
       add(passwordField1);
       add(passwordField2);
       
       //Buttons Section.
       submitButton =new JButton("Submit"); // create buttons object and gave a name.
       ClearButton = new JButton("Clear All");
       backButton = new JButton();
       submitButton.setBounds(372,315,210,35); // set location and size of Buttons.
       ClearButton.setBounds(622,315,210,35);
       backButton.setBounds(765,31,65,25);
       add(submitButton); // add Buttons to Frame.
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
       JCheckBox1.setBounds(850, 145, 73, 25);
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
       JCheckBox2.setBounds(850, 215, 73, 25);
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
        g1.drawRoundRect(170, 63, 710, 360, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     }
}

