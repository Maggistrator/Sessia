package student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author OldTeaOwl
 */
public class Sciene2 {

    static int step = 1;
    static JLabel art = new JLabel(new ImageIcon("D:/Coffe/Акт2.png"));
    static Thread music;
    static Timer time;
    static Timer animation;
    static Timer animation2;
    static MakeSound ms = new MakeSound();
    static int counter = 1;
    static boolean flag = true;
    static JFrame sciene = new JFrame();

    public static void main(String[] args){
    //public Sciene2() {
    art.setBounds(0, 0, 800, 600);
        sciene.add(art);
        sciene.setLayout(null);
        sciene.setSize(800, 600);
        sciene.setResizable(false);
        sciene.setLocationRelativeTo(null);
        sciene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sciene.setVisible(true);
        music = new Thread(new Runnable() {
            @Override
            public void run() {
                if (Menu.isMusicActive) {
                    ms.playSound("D:/Coffe/Акт2.wav");
                }
            }
        });
        time = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog(step);
                step++;
            }
        });
        animation = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (flag) {
                    art.setIcon(new ImageIcon("D:/Coffe/Кадр2.png"));
                    art.setIcon(new ImageIcon("D:/Coffe/Кадр3.png"));
                    flag = false;
                } else {
                    art.setIcon(new ImageIcon("D:/Coffe/Кадр1.png"));
                    counter++;
                    flag = true;
                }
                if (counter > 2) {
                    counter = 1;
                    animation2.start();
                    animation.stop();
                }
            }
        });
        animation2 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (flag) {
                    art.setIcon(new ImageIcon("D:/Coffe/Кадр3_1.png"));
                    flag = false;
                } else {
                    art.setIcon(new ImageIcon("D:/Coffe/Кадр1.png"));
                    counter++;
                    flag = true;
                }
                if (counter > 2) {
                    counter = 1;
                    animation2.stop();
                }
            }
        });
    time.start();
        music.start();
    }

    static void dialog(int step) {
        if (step == 1) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1.png"));
            time.setDelay(1000);
        }

        if (step == 2) {
   art.setIcon(new ImageIcon("D:/Coffe/Химия1_2.png"));
   time.setDelay(4000);
        }

        if (step == 3) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_3.png"));
            time.setDelay(400);
        }
        if (step == 4) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_4.png"));
            time.setDelay(1000);
        }
        if (step == 5) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_5.png"));
        }
        if (step == 6) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_6.png"));
            time.setDelay(3000);
        }
        if (step == 7) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_7.png"));
        }
        if (step == 8) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_8.png"));
        }
        if (step == 9) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия1_9.png"));
        }
        if (step == 10) {
            art.setIcon(new ImageIcon("D:/Coffe/Химия2.png"));
        }
        
        if (step == 11) {
            if (Menu.isMusicActive) {
                ms.interrupt();
            }
            sciene.setVisible(false);
            sciene.repaint();
            time.stop();
            new Navigation();
        }
    }
}
