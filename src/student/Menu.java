package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

/**
 * @author OldTeaOwl
 */
public class Menu {

    static Timer time;
    static int next;
    static MakeSound ms = new MakeSound();
    public static boolean isMusicActive = true;

    public static void main(String[] args) {
        JFrame entry = new JFrame("Сессия: Месть Завуча");
        try {
            javax.swing.LookAndFeel alloyLnF = new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
            UIManager.setLookAndFeel(alloyLnF);
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "Error in a LaF of executable file");
        }

        JLabel art = new JLabel(new ImageIcon("D:/Coffe/student.png"));
        AnimatedLabel text = new AnimatedLabel(60);
        JButton start = new JButton("Начать");
        JButton about = new JButton("О разработчике");
        JButton Settings = new JButton("Настройки");
        JButton Exit = new JButton("Выход");
        start.setBounds(10, 10, 150, 40);
        about.setBounds(25, 52, 120, 30);
        Settings.setBounds(25, 84, 120, 30);
        Exit.setBounds(10, 266, 150, 40);
        art.setBounds(170, 10, 300, 250);
        text.setBounds(170, 260, 300, 50);
        start.setBackground(Color.green);
        start.setFont(new Font("Arial", Font.PLAIN, 16));
        about.setFont(new Font("Arial", Font.ITALIC, 10));
        Settings.setFont(new Font("Arial", Font.ITALIC, 10));
        Exit.setFont(new Font("Arial", Font.PLAIN, 16));
        text.setFont(new Font("Arial", Font.ITALIC, 16));
        time = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int a = new Random().nextInt(5);
                if (next == a) {
                    a++;
                }
                if (a == 1) {
                    text.setText("Где кофе?");
                }
                if (a == 2) {
                    text.setText("Мужайтесь - сессия близко...");
                }
                if (a == 3) {
                    text.setText("Сиськи! Больше сисек!!!");
                }
                if (a == 4) {
                    text.setText("Кто сожрал мой доширак?");
                }
                if (a == 5) {
                    text.setText("Должен. Учить. Грёбаные. Диффуры.");
                }
                time.setDelay(5000);
                next = a;
            }
        });
        time.start();
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, ""
                        + "Доброго времени суток. Я - Денди.\n"
                        + "Я студент, вероятно как и Вы. \n"
                        + "Возможно, Вы знаете меня как "
                        + "OldTeaOwl или Свирл Бородатый, "
                        + "а может не знаете.\n"
                        + "Если вы разработчик, "
                        + "и пришли выразить недовольство мерзкой"
                        + " графикой и унылым \n"
                        + "геймплеем - идите нахуй. А если же вы просто "
                        + "заглянули погонять очередную\n"
                        + "визуальную новеллу - приглашаю "
                        + "окунуться в самое пекло - в сессию.\n"
                        + "Вам предстоит пройти несколько уровней "
                        + "дабы сдать, и выйти из этого ада победителем.\n"
                        + "Преподы могущественны, но с нами "
                        + "Халява, вперёд, студент, за раздолбайство и пофигизм!\n\n"
                        + "P.S. Удачи.");
            }
        });
        Settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //JOptionPane.showMessageDialog(null, "Какие настройки?О_о?");
                int answer = JOptionPane.showConfirmDialog(null, "Включить беззвучный режим?");
                if (answer == JOptionPane.YES_OPTION) {
                    ms.interrupt();
                    isMusicActive = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Если что, я хз как его опять включить");
                }
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                entry.setVisible(false);
                entry.repaint();
                if (isMusicActive) {
                    ms.interrupt();
                }
                new Prologue();
            }
        });
        art.setBorder(new LineBorder(Color.black));
        text.setBorder(new LineBorder(Color.black));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        entry.add(art);
        entry.add(text);
        entry.add(about);
        entry.add(start);
        entry.add(Settings);
        entry.add(Exit);
        entry.setLayout(null);
        entry.setSize(500, 360);
        entry.setResizable(false);
        entry.setLocationRelativeTo(null);
        entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        entry.setVisible(true);
        ms.playSound("D:/Coffe/MainMenuTheam.wav");
    }

}
