
package dashboardDesign;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentInformation extends JFrame{
   
    private JTextField jtext;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] columns = {"Student Id","Student Name","email Id","Mobile No",
                    "Course Name","Branch","Year","Address"};
    private String[] rows = new String[8];
    int rowcount,rowcount2;
    StudentInformation()
    {
        setSize(1500,700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
 
    }
   public void gui()
    {
         Font font=new Font("Bold", 1, 22);//Create a new font.       
        JLabel jlabel_search=new JLabel("Student Information");//create a jlabel
        jlabel_search.setBounds(390,20,250,100); //set jlabel location
        jlabel_search.setFont(font); //set Jlabel font size
        add(jlabel_search);// added label
            
        //create jtextfield 
        jtext = new JTextField();
        jtext.setBounds(610,57,170,30);
        add(jtext);
        
        //create jBotton
         JButton jbutton_search=new JButton("Search");
         jbutton_search.setBounds(805,57,78,30);
         add(jbutton_search);
         // create table
         table = new JTable();
         model = new DefaultTableModel();
         model.setColumnIdentifiers(columns);
         table.setModel(model);
        // table.setFont(font);
         table.setRowHeight(30);
         
         
         scroll =new JScrollPane(table);
         scroll.setBounds(200,200,940,285);
         add(scroll);
         
         //add actionlistener
         jbutton_search.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
           try{
               Conn con = new Conn();
                String sql = "select * from newstudent where student_name=? || student_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, jtext.getText());
                st.setString(2, jtext.getText());
                ResultSet rs = st.executeQuery();             
                if(rs.next())
                {
                    
                   // rs.beforeFirst();
                
                      rows[0] = rs.getString("student_id");
                      rows[1] = rs.getString("student_name");
                      rows[2] = rs.getString("email_id");
                      rows[3] = rs.getString("mobile_no");
                      rows[4] = rs.getString("course_name");
                      rows[5] = rs.getString("branch");
                      rows[6] = rs.getString("year");
                      rows[7] = rs.getString("address");
                      rowcount = table.getRowCount();
                                            
                      if(rowcount>0)
                      model.removeRow(0); //delete zeros no row
                      
                      reset();//reset method call for reset jtextfield
                      model.addRow(rows); 
                                                                                                         
		}
                    else
                    {                     
                        rowcount2 = table.getRowCount();
                        
                        if(rowcount2>0)  
                            model.removeRow(0); //delete zeros no row
                        
                        reset();                      
                        JOptionPane.showMessageDialog(null,"No Record Found!");                 
                        
                    }
                
                    st.close();
                    rs.close();		              
               
            }catch(Exception ea){
                   System.out.println(ea);              
            }
          
        }
        });
                              
    }
    
     public void reset()
    {
        jtext.setText("");    
            
    }
}
