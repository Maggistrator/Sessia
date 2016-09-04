package student;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author OldTeaOwl
 */
public class Navigation {

    public static int smartness = 1;
    public static int slyass = 1;
    public static int luck = 1;
    public static int points = 1;
    private static final JLabel art = new JLabel(new ImageIcon("C:/Coffe/Меню Миссий.png"));
    static private Thread music;
    static Thread runnable;
    private static final MakeSound ms = new MakeSound();
    private static boolean flag = true;
    private static boolean stop = true;
    static int step = 1;
    static Timer time;
    static boolean done = false;
    private static final JFrame sciene = new JFrame();
    private static final JLabel russian = new JLabel(new ImageIcon("C:/Coffe/Русский.png"));
    private static final JLabel math = new JLabel(new ImageIcon("C:/Coffe/Матан.png"));
    private static final JLabel chemistry = new JLabel(new ImageIcon("C:/Coffe/Химия.png"));
    private static final JLabel pointframe = new JLabel(new ImageIcon("C:/Coffe/ИконкаУмения.png"));
    private static final JLabel markbook = new JLabel(new ImageIcon("C:/Coffe/ИконкаЗачётки.png"));
    private static final JLabel help = new JLabel(new ImageIcon("C:/Coffe/ИконкаПомощи.png"));
    private static final JLabel blank = new JLabel();

    //public static void main(String[] args) {
    public Navigation() {

        JPanel tools = new JPanel();
        tools.setBorder(new LineBorder(Color.black));
        tools.setBounds(320, 520, 200, 50);
        pointframe.setBounds(0, 0, 50, 50);
        markbook.setBounds(50, 0, 50, 50);
        blank.setBounds(100, 0, 50, 50);
        help.setBounds(150, 0, 50, 50);
        pointframe.setBorder(new LineBorder(Color.black));
        markbook.setBorder(new LineBorder(Color.black));
        blank.setBorder(new LineBorder(Color.black));
        help.setBorder(new LineBorder(Color.black));
        russian.setBounds(0, 300, 300, 300);
        art.setBounds(0, 0, 800, 600);
        russian.setBounds(5, 50, 170, 180);
        chemistry.setBounds(250, 110, 210, 240);
        math.setBounds(565, 50, 200, 180);
        music = new Thread(new Runnable() {
            @Override
            public void run() {
                if (Menu.isMusicActive) {
                    ms.playSound("C:/Coffe/Navigation.wav");
                }
            }
        });

        time = new Timer(700, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (flag) {
                    pointframe.setIcon(new ImageIcon("C:/Coffe/АктивнаяИконкаУмения.png"));
                } else {
                    pointframe.setIcon(new ImageIcon("C:/Coffe/ИконкаУмения.png"));
                }
                flag = !flag;
            }
        });
        time.start();
        pointframe.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                runnable = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new Abilities();
                    }
                });
                runnable.run();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                pointframe.setCursor(new Cursor(Cursor.HAND_CURSOR));
                pointframe.setIcon(new ImageIcon("C:/Coffe/АктивнаяИконкаУмения.png"));
                time.stop();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                pointframe.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                pointframe.setIcon(new ImageIcon("C:/Coffe/ИконкаУмения.png"));
            }
        });
        russian.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if(step>1){JOptionPane.showMessageDialog(null, "Экзамен по русскому уже прошёл!");}
                else{
                sciene.setVisible(false);
                sciene.repaint();
                runnable = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new Sciene1();
                    }
                });
                runnable.run();
                if (Menu.isMusicActive) {
                    ms.interrupt();
                }}
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                russian.setCursor(new Cursor(Cursor.HAND_CURSOR));
                russian.setBorder(new LineBorder(Color.white));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                russian.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                russian.setBorder(null);
            }
        });
        math.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if (step < 3){JOptionPane.showMessageDialog(null, "Сначала сдай химию и русский!");}
                else if (step >3){JOptionPane.showMessageDialog(null, "Ура!!! Всё, сессия сдана, го пинать хуи!!!");}
                else {
                    sciene.setVisible(false);
                    sciene.repaint();
                    if (Menu.isMusicActive) {
                        ms.interrupt();
                    }
                    runnable = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Sciene3();
                        }
                    });
                    runnable.run();

                } 
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                math.setCursor(new Cursor(Cursor.HAND_CURSOR));
                math.setBorder(new LineBorder(Color.white));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                math.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                math.setBorder(null);
            }
        });
        chemistry.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if (step < 2) {JOptionPane.showMessageDialog(null, "Сначала сдай русский!");}
                else if(step>2){JOptionPane.showMessageDialog(null, "Экзамен по химии уже прошёл!");}
                else{
                    sciene.setVisible(false);
                    sciene.repaint();
                    if (Menu.isMusicActive) {
                        ms.interrupt();
                    }
                    runnable = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Sciene2();
                        }
                    });
                    runnable.run();
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                chemistry.setCursor(new Cursor(Cursor.HAND_CURSOR));
                chemistry.setBorder(new LineBorder(Color.white));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                chemistry.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                chemistry.setBorder(null);
            }
        });
        markbook.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                Runnable runnable = new Runnable() {
                    public void run() {
                        new Markbook();
                    }
                };
                runnable.run();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                markbook.setCursor(new Cursor(Cursor.HAND_CURSOR));
                markbook.setIcon(new ImageIcon("C:/Coffe/АктивнаяИконкаЗачётки.png"));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                markbook.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                markbook.setIcon(new ImageIcon("C:/Coffe/ИконкаЗачётки.png"));
            }
        });
        help.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                JOptionPane.showMessageDialog(null, "Смотри сюда, студент:\n"
                        + "Твоя задача - сдать сессию - экзамен за экзаменом.\n"
                        + "Преподы будут задавать вопросы, а ты на них должен ответить\n"
                        + "и чем выше балл - тем лучше. Баллы выдаются за ответы.\n"
                        + "Есть 3 варианта ответа - заученный, хитрожопый, и наугад.\n"
                        + "Заученный - гарант стабильности. Он всегда даст тебе балл\n"
                        + "и зависит от показателя Ботанства. Чем выше Ботанство - \n"
                        + "тем выше гарантированный балл, но заметно ниже максимально\n"
                        + "возможного. Хитрожопый ответ с некоторой вероятностью может дать\n"
                        + "балл как выше так и ниже заученного, но больше минимума, и меньше\n"
                        + "максимума. Наудачу - это прямая мольба к богине всея студенчества\n"
                        + "- Халяве, и с некоторой вероятностью может дать как максимальный\n "
                        + "балл, так и ничего.\n"
                        + "Самый надёжный способ сдать - ботанить, но кто не рискует - тот\n"
                        + "не пьёт шампанского!)\n\n"
                        + "Удачи, студент!");
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                help.setCursor(new Cursor(Cursor.HAND_CURSOR));
                help.setIcon(new ImageIcon("C:/Coffe/АктивнаяИконкаПомощи.png"));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                help.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                help.setIcon(new ImageIcon("C:/Coffe/ИконкаПомощи.png"));
            }
        });
        tools.setLayout(null);
        music.start();
        tools.add(pointframe);
        tools.add(markbook);
        tools.add(blank);
        tools.add(help);
        sciene.add(russian);
        sciene.add(math);
        sciene.add(chemistry);
        sciene.add(tools);
        sciene.add(art);
        sciene.setLayout(null);
        sciene.setSize(800, 600);
        sciene.setResizable(false);
        sciene.setLocationRelativeTo(null);
        sciene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sciene.setVisible(true);
    }

    public static void playMusic() {
        music = new Thread(new Runnable() {
            @Override
            public void run() {
                if (Menu.isMusicActive) {
                    ms.playSound("C:/Coffe/Navigation.wav");
                }
            }
        });
        music.start();
    }

    public static void show() {
        sciene.setVisible(true);
        sciene.repaint();
    }
}
