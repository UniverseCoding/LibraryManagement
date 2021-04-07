
package dashboardDesign;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import librarian.Librarian;

public class IssueBook extends JFrame{
    JLabel labelStudentId,labelBookName,labelIsbn,labelHeading;
    JTextField textFieldStudentId,textFieldBookName,textFieldIsbn;
    JButton submitButton,cancelButton;
    

    //create a object of the class PraperStatement and initialize to null.
    Connection con = null;
    PreparedStatement pst =null;
    //Creating the Constractor.
    IssueBook()
    {
        setTitle("Library Management System");
        setSize(1500,700);
        getContentPane().setBackground(new Color(204, 255, 190));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
 
    }
    //create a method to maintain all the components.
    public void gui()
    {
        Font font = new Font("Soharab",Font.BOLD, 23);//Create a new font.
        Font fonbookName = new Font("Soharab",Font.BOLD, 43);//Create another new font.
    //JLabels.
        //give name to the labels.
        labelHeading=new JLabel("Issue Book");
        labelStudentId=new JLabel("Student Id: ");
        labelBookName=new JLabel("Book Name:");
        labelIsbn=new JLabel("ISBN:");
        //set the new create fonts to the labels.
        labelStudentId.setFont(font);
        labelBookName.setFont(font);
        labelIsbn.setFont(font);
        labelHeading.setFont(fonbookName);
        //set Bounds of the labels.
        labelStudentId.setBounds(415,120,170,30);
        labelBookName.setBounds(415,150,170,130);
        labelIsbn.setBounds(415,190,170,200);
        labelHeading.setBounds(565,25,260,40);
        //Add labels into the JFrame.
        add(labelHeading);
        add(labelStudentId);
        add(labelBookName);
        add(labelIsbn);
        
    //TextFields.
        //create text Fields and their size.
        textFieldStudentId=new JTextField(20); 
        textFieldBookName=new JTextField(20);
        textFieldIsbn=new JTextField(20);
       
        //Add TextFields into the Frame.
        add(textFieldStudentId);
        add(textFieldBookName);
        add(textFieldIsbn);
      
        //set Bounds of the Text Fields.  
        textFieldStudentId.setBounds(570,120,250,30);
        textFieldBookName.setBounds(570,200,250,30);
        textFieldIsbn.setBounds(570,280,250,30);

        //create a new font for text fields.
        Font fnt = new Font("Soharab",Font.ROMAN_BASELINE,22);
        //set font to Text Fields.
        textFieldStudentId.setFont(fnt);
        textFieldBookName.setFont(fnt);
        textFieldIsbn.setFont(fnt);
       
        //Buttons.
        //create Buttons and set their Name.
        submitButton=new JButton("Submit");
        cancelButton=new JButton("Cancel");
        //set Bounds for Buttons.
        submitButton.setBounds(570, 402, 115, 40);
        cancelButton.setBounds(710, 402, 115, 40);
        //set font to the buttons.
        submitButton.setFont(font);
        cancelButton.setFont(font);
        //Action Listener for Submit Button.
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
                if(textFieldStudentId.getText().isEmpty()||textFieldBookName.getText().isEmpty()||textFieldIsbn.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Fill up All field");
                }
                else{
                    try{
                        //create the object of Connection class
                        Conn conn = new Conn();                       
                        String sql = "INSERT INTO issueBook(`studentId`, `bookName`, `isbn`, `date`, `returnDate`) VALUES (?,?,?,curdate(),DATE_ADD(curdate(), INTERVAL 3 month))";
                       //sql queries statement for insert data into database
                        pst =conn.con.prepareStatement(sql);
                        pst.setString(1,textFieldStudentId.getText());
                        pst.setString(2,textFieldBookName.getText());
                        pst.setString(3,textFieldIsbn.getText());
                        
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Issue Book Successfully");
                    }
                    catch(Exception ae){
                     JOptionPane.showMessageDialog(null,ae);
                    }
                }
                reset();
                
            }
        });
        //Action Listener for cancel button.
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
              Librarian obj = new Librarian();
              setVisible(false);
            }
        });
        //AddButtonsinto the Frame.
        add(submitButton);
        add(cancelButton);
    }
    //create a reset method to clear all fields of JTextField.
    public void reset()
    {
        textFieldStudentId.setText("");
        textFieldBookName.setText("");
        textFieldIsbn.setText("");
       
    }
    
    @Override
    //Create a method to Design the interface.
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
