import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

 class Game2 extends JFrame {
    private JButton jbt = new JButton("Run");
    private JButton jbt1 = new JButton("up");
    private JButton jbt2 = new JButton("down");
    private JButton jbt3 = new JButton("left");
    private JButton jbt4 = new JButton("right");
    private JButton jbt5 = new JButton("exit");
    private JLabel jlb = new JLabel();
    private Container cp;
    private ImageIcon icon = new ImageIcon("0.jpg");
    private JPanel jpn1 = new JPanel(new GridLayout());
    private JPanel jpn2 = new JPanel(new GridLayout(1,6,3,3));
    private Timer t1,t2;
    private int dirFlag = 1;
    private int x=0,y=0,higx = 50,higy = 50;
    private float m = 0.0f;
    private boolean flag = false;
    public Game2(){
        init();
    }

    private void init(){
        this.setBounds(100,100,600,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();

        t1 = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag){
                    case 1:
                        if (y-4 > -330){
                            y-=10;
                        }else {
                            dirFlag = 2;
                        }
                        break;
                    case 2:
                        if (y+4< 380-higy){
                            y+=10;
                        }else {
                            dirFlag = 1;
                        }
                        break;
                    case 3:
                        if (x-4 > 0){
                            x-=10;
                        }else {
                            dirFlag = 4;
                        }
                        break;
                    case 4:
                        if (x + 4< 560-higx){
                            x+=10;
                        }else {
                            dirFlag = 3;
                        }
                        break;
                }
                jlb.setLocation(x,y);
            }
        });



        t2 = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (x - higx == 0 && y - higy==0){
                    t2.stop();
                }else {
                    int newx,newy;
                    if (higx<x){
                        newx = higx + 1;
                    }else {
                        newx = higx - 1;
                    }
                    newy = Math.round(m*(float)(newx-x)+y);
                    higx = newx;
                    higy = newy;
                    jlb.setLocation(newx,newy);
                    System.out.println(newx +","+ newy);
                }
            }
        });


        cp.add(jpn1,BorderLayout.CENTER);
        cp.add(jpn2,BorderLayout.SOUTH);
        jpn1.setLayout(null);
        Image img = icon.getImage();
        Image im = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        icon.setImage(im);

        jlb.setBounds(100,100,100,100);
        jlb.setIcon(icon);
        jpn1.add(jlb);
        jpn2.add(jbt);
        jpn2.add(jbt1);
        jpn2.add(jbt2);
        jpn2.add(jbt3);
        jpn2.add(jbt4);
        jpn2.add(jbt5);



        jlb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                flag = true;
            }
        });
        jpn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (flag){
                    x = e.getX() - 25;
                    y = e.getY() - 25;
                    m = (float)(y-higy) /(float)(x-higx);
                    t2.start();
                    flag = false;
                }
            }
        });
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });

        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 1;
            }
        });

        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 2;
            }
        });

        jbt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 3;
            }
        });

        jbt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 4;
            }
        });

        jbt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
