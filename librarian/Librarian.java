
package librarian;
import dashboardDesign.*;

public class Librarian {
   
    public Librarian(){
        DashboardDesign dashObj=new DashboardDesign();
        dashObj.menu();
        dashObj.frameButton();
        dashObj.setVisible(true);
    }
    public static void main(String[] args) {
        Librarian obj = new Librarian();
    }  
}
