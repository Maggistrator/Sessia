package student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author OldTeaOwl
 */
public class Viktory {

    static int step = 1;
    static JLabel art = new JLabel(new ImageIcon("C:/Coffe/Победа2.png"));
    static Thread music;
    static Timer time;
    static MakeSound ms = new MakeSound();
    static int counter = 1;
    static boolean flag = true;
    static JFrame sciene = new JFrame();
    static JPanel pane = new JPanel();
    static JScrollPane scrollPane = new JScrollPane(pane);
    static int count = -1;

    //public static void main(String[] args) {
    public Viktory() {
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        pane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        scrollPane.setBounds(550, 0, 250, 500);
        scrollPane.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sciene.add(scrollPane);
        scrollPane.setOpaque(true);
        pane.setOpaque(false);
        final JLabel skip = new JLabel(new ImageIcon("C:/Coffe/Skip.png"));
        skip.setBounds(740, 530, 50, 40);
        art.setBounds(0, 0, 800, 600);
        sciene.add(skip);
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
                    ms.playSound("C:/Coffe/Пролог.wav");
                }
            }
        });
        time = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog(step);
                step++;
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
                Navigation.show();
                Navigation.playMusic();
                Navigation.runnable.interrupt();
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
        time.start();
        music.start();
    }

    static void dialog(int step) {
        if (step == 1) {
            art.setIcon(new ImageIcon("C:/Coffe/Победа3.png"));
        }

        if (step == 2) {
            art.setIcon(new ImageIcon("C:/Coffe/Победа4.png"));
        }

        if (step == 3) {
            art.setIcon(new ImageIcon("C:/Coffe/Победа5.png"));
        }
        if (step == 4) {
            art.setIcon(new ImageIcon("C:/Coffe/Победа6.png"));
            time.setDelay(4000);
        }

        if (step == 5) {
            GenerateLabel(3, "<html>Хэй, студент!"
                    + "<br>Сдал? Ты - молодчина!"
                    + "<br>Надеюсь, тебе понравилось)");
        }

        if (step == 6) {
            GenerateLabel(3, "<html>Игруха создана за 4 недели"
                    + "<br>в рамках обучения другана"
                    + "<br>программированию на Java</html>");
        }

        if (step == 7) {
            GenerateLabel(3, "<html>Любые совпадения с реальными"
                    + "<br>лицами случайны."
                    + "<br>P.S.Тут угадывается гуманоид?"
                    + "<br>Поздравьте меня! </html>");
        }
        if (step == 8) {
            GenerateLabel(3, "<html>Интересный факт#1:"
                    + "<br>Во втором акте есть 3 ветви."
                    + "<br>Чтобы получить каждую из них,"
                    + "<br>нужно использовать ответы одного типа</html>");
        }
        if (step == 9) {
            GenerateLabel(3, "<html>Интересный факт#2:"
                    + "<br>Первый акт можно пройти используя"
                    + "<br>тлько ботанство</html>");
        }
        if (step == 10) {
            GenerateLabel(3, "<html>Интересный факт#3:"
                    + "<br>Друг свою игру так и не написал."
                    + "<br>Вот обезьяна</html>");
        }
        if (step == 11) {
            GenerateLabel(3, "<html>Интересный факт#4:"
                    + "<br>Я не ношу очки");
        }
        if (step == 12) {
            GenerateLabel(3, "<html>P.S. Напишите на стене этого"
                    + "<br>чувака https://vk.com/svatosh"
                    + "<br>'Свят, учи программирование!'"
                    + "<br>P.P.S. Шутка)</html>");
        }

        if (step == 13) {
            GenerateLabel(2, "OldTeaOwl, 2016г");
            time.setDelay(8000);
        }

        if (step == 14) {
            if (Menu.isMusicActive) {
                ms.interrupt();
            }
            sciene.setVisible(false);
            sciene.repaint();
            time.stop();
            Navigation.show();
            Navigation.playMusic();
            Navigation.runnable.interrupt();
        }
    }

    private static void GenerateLabel(int type, String text) {
        count++;
        ImageIcon ico = null;
        if (type == 1) {
            ico = new ImageIcon("C:/Coffe/Химик.png");
        } else if (type == 2) {
            ico = new ImageIcon("C:/Coffe/Студент.png");
        } else if (type == 3) {
            ico = new ImageIcon("C:/Coffe/ЗнакЛабы.png");
        }
        JLabel label = new JLabel();
        label.setFont(new Font("Comic Sans", Font.PLAIN, 9));
        label.setText(text);
        label.setIcon(ico);
        label.setBounds(5, count * 55, 200, 50);
        pane.add(label);
        scrollPane.setViewportView(pane);
        pane.setPreferredSize(new Dimension(250, count * 55));
        pane.repaint();
    }

}
