package student;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author OldTeaOwl
 */
public class Sciene1 {

    static AnimatedLabel dialog = new AnimatedLabel(60);
    static int step = 1;
    static JLabel art = new JLabel(new ImageIcon("D:/Coffe/Акт1/Акт1.png"));
    static Thread music;
    static Timer time;
    static Timer animation;
    static MakeSound ms = new MakeSound();
    static boolean flag = true;
    static boolean stop = true;

    public static void main(String[] args) {
        //public Sciene1() {
        JFrame sciene = new JFrame();
        JLabel books = new JLabel();
        books.setBounds(0, 300, 300, 300);
        books.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                books.setEnabled(false);
                animation.stop();
                art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр3.png"));
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                books.setCursor(new Cursor(Cursor.HAND_CURSOR));
                animation.stop();
                art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр3.png"));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                books.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр3_1.png"));
                animation.start();
            }
        });
        dialog.setBounds(100, 530, 600, 40);
        art.setBounds(0, 0, 800, 600);
        dialog.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
        sciene.add(dialog);
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
                ms.playSound("D:/Coffe/Акт1.wav");
            }
        });
        time = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog(step);
                step++;
            }
        });
        animation = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (flag) {
                    art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр3_1.png"));
                    flag = false;
                } else {
                    art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр3.png"));
                    flag = true;
                }
            }
        });

        dialog.setHorizontalAlignment(JLabel.CENTER);
        dialog.setVerticalAlignment(JLabel.CENTER);
        time.start();
        music.start();
        sciene.add(books);
        dialog.setVisible(false);
    }

    static void dialog(int step) {
        if (step == 1) {
            art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр1.png"));
        }

        if (step == 2) {
            art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр2.png"));
        }

        if (step == 3) {
            art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр3_1.png"));
            animation.start();
            time.stop();
        }

        if (step == 4) {
            animation.stop();
            art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр4.png"));
        }

        if (step == 5) {
            ms.interrupt();
            //тут к сцене 2
        }
    }
}
//art.setIcon(new ImageIcon("D:/Coffe/Акт1/Кадр1.png"));
