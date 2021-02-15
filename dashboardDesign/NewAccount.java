
package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class NewAccount extends JFrame 
{
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField p1,p2;
    JButton b1,b2,b3;
    
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
       t1 = new JTextField();  // create  objects for text field and password field.
       p1 = new JPasswordField(); 
       p2 = new JPasswordField();
       t1.setFont(new Font("Soharab", Font.BOLD, 24)); // set Font and font Size.
       p1.setFont(new Font("Soharab", Font.ROMAN_BASELINE, 24));
       p2.setFont(new Font("Soharab", Font.ROMAN_BASELINE, 24));
       t1.setBounds(372, 75, 460, 25); // set Location and Size.
       p1.setBounds(372, 145, 460, 25);
       p2.setBounds(372, 215, 460, 25);
       Color color1 = new Color(12,177,80);//Create a color for Background.
       t1.setBackground(color1);
       p1.setBackground(color1);
       p2.setBackground(color1);
       Color color2 = new Color(57,55,197);//Create a color for Forground.
       t1.setForeground(color2);
       p1.setForeground(color2);
       p2.setForeground(color2);
       add(t1); // add to JFrame.
       add(p1);
       add(p2);
       
       //Buttons Section.
       b1 =new JButton("Submit"); // create buttons object and gave a name.
       b2 = new JButton("Clear All");
       b3 = new JButton("Back");
       b1.setBounds(630,315,95,35); // set location and size of Buttons.
       b2.setBounds(750,315,95,35);
       b3.setBounds(1056,11,95,35);
       add(b1); // add Buttons to Frame.
       add(b2);
       add(b3);
       b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
            }
        });
       b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
                t1.setText("");
                p1.setText("");
                p2.setText("");
                
            }
        });
       b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
                dispose();
               DashboardDesign dbd = new DashboardDesign();
               dbd.setVisible(true);
            }
        });
       
    }
     public void paint(Graphics g){
        super.paint(g);
        

        //1st Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(170, 77, 710, 250, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
     }
}
