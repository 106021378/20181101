import javax.swing.*;
import java.awt.*;

public class DigitalTimer extends JFrame {
    Container cp;
    private MainFrame mfrm;
    private JLabel jlb[] = new JLabel[8];
    private JPanel jpnc = new JPanel(new GridLayout(1,8,2,2));
    private String jlbImageName[] = {"0.jpg"};
    private ImageIcon icon[] = new ImageIcon[10];
    private JPanel jpnb = new JPanel(new GridLayout(1,3,3,3));
    private JButton jbtnstart = new JButton("Start");
    private JButton jbtnreset = new JButton("Reset");
    private JButton jbtnClose = new JButton("Close");
    int h,m,s;
    public DigitalTimer(MainFrame frm){
        mfrm = frm;
        init();
    }
    void init(){
        setBounds(100,100,300,150);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));

        for (int i=0;i<10;i++){

        }


    }
}
