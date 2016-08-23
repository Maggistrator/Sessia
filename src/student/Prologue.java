package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author OldTeaOwl
 */
public class Prologue {

    static AnimatedTextArea dialog = new AnimatedTextArea(60);
    static int step = 1;
    static JLabel art = new JLabel(new ImageIcon("D:/Coffe/Пролог.png"));
    static Thread music;
    static Timer time;
    static Timer animation;
    static Timer animation2;
    static MakeSound ms = new MakeSound();
    static int counter = 1;
    static boolean flag = true;
    static JFrame sciene = new JFrame();

    //public static void main(String[] args){
    public Prologue() {
        JLabel skip = new JLabel(new ImageIcon("D:/Coffe/Skip.png"));
        skip.setBounds(740, 0, 50, 40);
        dialog.setBounds(100, 530, 600, 40);
        art.setBounds(0, 0, 800, 600);
        dialog.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
        sciene.add(skip);
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
                if (Menu.isMusicActive) {
                    ms.playSound("D:/Coffe/Пролог.wav");
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
        skip.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if (Menu.isMusicActive) {
                    ms.interrupt();
                }
                sciene.setVisible(false);
                sciene.repaint();
                time.stop();
                new Navigation();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                skip.setBorder(new LineBorder(Color.lightGray));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                skip.setBorder(null);
            }
        });
        dialog.setWrapStyleWord(true);
        dialog.setLineWrap(true);
        time.start();
        music.start();
        dialog.setEditable(false);
        dialog.setVisible(false);
    }

    static void dialog(int step) {
        if (step == 1) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр1.png"));
            dialog.setVisible(true);
            dialog.setText("Было начало зимней сессии.");
            time.setDelay(8000);
        }

        if (step == 2) {
            dialog.setBounds(100, 500, 600, 70);
            dialog.setText("Препод как обычно нёс всякую хуиту. Он предпочитал называть это консультацией, но это всё равно не более чем хуита.");
            time.setDelay(5000);
            animation.start();
        }

        if (step == 3) {
            dialog.setBounds(100, 530, 600, 40);
            art.setIcon(new ImageIcon("D:/Coffe/Кадр1.png"));
            dialog.setText("Ничего не предвещало беды");
            animation.start();
        }
        if (step == 4) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр4.png"));
            dialog.setText("Она вошла в аудиторию ровно через 10 минут. Завуч.");
        }
        if (step == 5) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр5.png"));
            dialog.setBounds(100, 500, 600, 70);
            dialog.setText("Завуч: 'Хватит консультаций, бездельники! Мы с советом учителей решили...'");
        }
        if (step == 6) {
            dialog.setBounds(100, 530, 600, 40);
            art.setIcon(new ImageIcon("D:/Coffe/Кадр6.png"));
            dialog.setText("'Завуч: ...Начать экзамены прямо сейчас!'");
        }
        if (step == 7) {
            time.setDelay(7000);
            art.setIcon(new ImageIcon("D:/Coffe/Кадр7.png"));
            dialog.setText("'Завуч: ...Первый пошёл!'");
        }
        if (step == 8) {
            time.setDelay(2000);
            art.setIcon(new ImageIcon("D:/Coffe/Кадр8.png"));
            dialog.setText("Тян в очках: Учи, глупец! Я их задержу.");
        }
        if (step == 9) {
            dialog.setVisible(false);
            art.setIcon(new ImageIcon("D:/Coffe/Кадр9.png"));
        }
        if (step == 10) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр9_1.png"));
        }
        if (step == 11) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр9_2.png"));
            time.setDelay(1000);
        }
        if (step == 12) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр9_3.png"));
        }
        if (step == 14) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр9_4.png"));
            time.setDelay(6000);
        }
        if (step == 15) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр9_5.png"));
        }
        if (step == 16) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр10.png"));
        }
        if (step == 17) {
            art.setIcon(new ImageIcon("D:/Coffe/Кадр11.png"));
            time.setDelay(3000);
        }
        if (step == 18) {
            art.setIcon(new ImageIcon("D:/Coffe/Пролог_Конец.png"));
            dialog.setVisible(true);
            dialog.setBounds(200, 530, 400, 40);
            dialog.setText("Завуч: Следующий!");
        }
        if (step == 19) {
            dialog.setVisible(false);
            art.setIcon(new ImageIcon("D:/Coffe/Пролог_Конец_2.png"));
        }
        if (step == 20) {
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
