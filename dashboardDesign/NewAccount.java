
package dashboardDesign;

import javax.swing.JFrame;

public class NewAccount extends JFrame 
{

    NewAccount()
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
       b3 = new JButton();
       b1.setBounds(372,315,210,35); // set location and size of Buttons.
       b2.setBounds(622,315,210,35);
       b3.setBounds(765,31,65,25);
       add(b1); // add Buttons to Frame.
       add(b2);
       add(b3);
       b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
                if(t1.getText().isEmpty() || p1.getText().isEmpty() || p2.getText().isEmpty()){
                    
                
                JOptionPane.showMessageDialog(null,"Please Fill up All field");
                }
               
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
       b3.setFocusable(true);
       b3.setContentAreaFilled(false);
       Image img = Toolkit.getDefaultToolkit().getImage("C:/Users/SOHARAB/Desktop/icon.png");
       Image newimg = img.getScaledInstance(65, 25,1);
       ImageIcon icon = new ImageIcon(newimg);
       b3.setIcon(icon);
       b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
              Librarian obj = new Librarian();
            }
        });
       
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
