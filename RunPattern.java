import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunPattern {

    public static void main(String[] args) {
        Pattern p = new Pattern();
        p.setSize(400,400);
        p.setTitle("PatternGame");
        p.setVisible(true);
        p.addWindowListener
                (new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {  System.exit(0); }
                });
    }
}
