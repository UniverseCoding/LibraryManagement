
package librarian;

public class Librarian {
   
    public Librarian(){
        Login login=new Login();
        login.gui();
        login.setVisible(true);
    }
    public static void main(String[] args) {
        Librarian obj = new Librarian();
    }  
}
