package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author OldTeaOwl
 */
public class Sciene3 {

    static int step = 1;
    static JLabel art = new JLabel(new ImageIcon("C:/Coffe/Акт3.png"));
    static Thread music;
    static Timer time;
    static Timer delay;
    static Timer VirtualIntellect;
    static Timer shield;
    static Timer powertimer;
    static Timer animation;
    static Timer animation2;
    static MakeSound ms = new MakeSound();
    static JFrame sciene = new JFrame();
    static JLabel protagonist = new JLabel(new ImageIcon("C:/Coffe/Protagonist.png"));
    static JLabel teacher = new JLabel(new ImageIcon("C:/Coffe/Teacher.png"));
    static JProgressBar progress = new JProgressBar(0, 200);
    static JProgressBar power = new JProgressBar(0, 100);
    static JLabel title = new JLabel("Level Progress");
    static JTextArea log = new JTextArea();
    static JScrollPane scroll = new JScrollPane(log);
    static JLabel smart = new JLabel("Ботаник");
    static JLabel slyass = new JLabel("Хитрожопость");
    static JLabel luck = new JLabel("Удача");

    //public static void main(String[] args) {
    public Sciene3() {
        try {
            UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "Error in a LaF of executable file");
        }
        smart.setHorizontalAlignment(JLabel.CENTER);
        slyass.setHorizontalAlignment(JLabel.CENTER);
        luck.setHorizontalAlignment(JLabel.CENTER);
        smart.setBounds(275, 430, 250, 20);
        slyass.setBounds(275, 455, 250, 20);
        luck.setBounds(275, 480, 250, 20);
        scroll.setBounds(275, 100, 250, 320);
        title.setBounds(320, 5, 250, 30);
        title.setFont(new Font("MV Boli", Font.PLAIN, 24));
        power.setBounds(10, 530, 250, 25);
        progress.setBounds(40, 40, 700, 40);
        power.setValue(100);
        progress.setValue(100);
        progress.setStringPainted(true);
        power.setStringPainted(true);
        protagonist.setBounds(10, 100, 250, 400);
        teacher.setBounds(535, 100, 250, 400);
        smart.setBorder(new LineBorder(Color.darkGray));
        slyass.setBorder(new LineBorder(Color.darkGray));
        luck.setBorder(new LineBorder(Color.darkGray));
        log.setDisabledTextColor(Color.black);
        log.setEnabled(false);
        log.setWrapStyleWord(true);
        log.setLineWrap(true);
        log.setOpaque(false);
        scroll.setOpaque(false);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        art.setBounds(0, 0, 800, 600);
        progress.setVisible(false);
        title.setVisible(false);
        protagonist.setVisible(false);
        teacher.setVisible(false);
        power.setVisible(false);
        scroll.setVisible(false);
        smart.setVisible(false);
        slyass.setVisible(false);
        luck.setVisible(false);
        sciene.add(smart);
        sciene.add(slyass);
        sciene.add(luck);
        sciene.add(scroll);
        sciene.add(power);
        sciene.add(title);
        sciene.add(progress);
        sciene.add(protagonist);
        sciene.add(teacher);
        sciene.add(art);
        sciene.setLayout(null);
        sciene.setSize(800, 600);
        sciene.setResizable(false);
        sciene.setLocationRelativeTo(null);
        sciene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sciene.setVisible(true);
        powertimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                power.setString("BrainPower: " + (int) (power.getPercentComplete() * 100) + "/" + power.getMaximum());
                progress.setString((int) (progress.getPercentComplete() * 200) + "/" + progress.getMaximum());
                if (power.getValue() < power.getMaximum()) {
                    power.setValue(power.getValue() + 1);
                }
            }
        });
        powertimer.start();
        progress.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (progress.getValue() == progress.getMinimum()) {
                    VirtualIntellect.stop();
                    JOptionPane.showMessageDialog(null, "Поражение!");
                    if (Menu.isMusicActive) {
                        ms.interrupt();
                    }
                    sciene.setVisible(false);
                    sciene.repaint();
                    time.stop();
                    new Navigation();
                } else if (progress.getValue() == progress.getMaximum()) {
                    VirtualIntellect.stop();
                    JOptionPane.showMessageDialog(null, "Великая победа!!!Сдааааал!!!");
                    if (Menu.isMusicActive) {
                        ms.interrupt();
                    }
                    sciene.setVisible(false);
                    sciene.repaint();
                    time.stop();
                    if (Navigation.step == 3) {
                        Navigation.points++;
                        Navigation.step++;
                        Markbook.passMath();
                    }
                    Navigation.runnable.interrupt();
                    
                                Navigation.runnable = new Thread(new Runnable() {
                    public void run() {
                        new Viktory();
                    }
                });
                Navigation.runnable.run();
                }
            }
        });
        delay = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smart.setEnabled(true);
                slyass.setEnabled(true);
                luck.setEnabled(true);
                log.append("---------------------Зачёт начался!!!------------------");
                VirtualIntellect.start();
                delay.stop();
            }
        });
        shield = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VirtualIntellect.start();
                shield.stop();
            }
        });
        VirtualIntellect = new Timer(1200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rand = new Random().nextInt(4) + 1;
                int data = 0;
                if (rand == 1) {
                    data = 15 - Navigation.luck;
                    progress.setValue(progress.getValue() - data);
                    log.append("\n Препод придирается к твоему ответу на " + data + " баллов!");
                } else if (rand == 2) {
                    data = 15 - Navigation.smartness;
                    progress.setValue(progress.getValue() - data);
                    log.append("\n Препод начинает дико втирать тебе какую-то аццкую теорему, и требует, "
                            + "чтобы ты повторил. Это, мать твою, невозможно, и у тебя отбирают " + data + " баллов!");
                } else if (rand == 3) {
                    data = 15 - Navigation.slyass;
                    progress.setValue(progress.getValue() - data);
                    log.append("\n Препод спалила твою шпору! У тебя отбирают " + data + " баллов!");
                } else if (rand == 4) {
                    VirtualIntellect.setDelay(new Random().nextInt(2000) + 500);
                    log.append("\n Зрачки препода безумно вращаются из стороны в сторону! "
                            + "По их скорости, твой опытный глаз вычислил, что теперь реакция препода "
                            + "где-то " + (double) (VirtualIntellect.getDelay() / new Double(1000)) + " секунд!");
                }
            }
        });

        smart.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (power.getValue() >= 20) {
                    int data = 5 + Navigation.smartness;
                    power.setValue(power.getValue() - 20);
                    progress.setValue(progress.getValue() + data);
                    log.append("\n Ты атакуешь препода потоком формул на " + data + " баллов!");
                } else {
                    log.append("\n Твоей силы мозга недостаточно!");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                smart.setBorder(new LineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                smart.setBorder(new LineBorder(Color.darkGray));
            }
        });
        slyass.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (power.getValue() >= 50) {
                    int data = 5 + Navigation.slyass * 2;
                    power.setValue(power.getValue() - 50);
                    progress.setValue(progress.getValue() + data);
                    log.append("\n Твоя изощрённая хитрожопость без труда обводит противника вокруг пальца! "
                            + "Ты получил" + data + " баллов!");
                } else {
                    log.append("\n Твоей силы мозга недостаточно!");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                slyass.setBorder(new LineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                slyass.setBorder(new LineBorder(Color.darkGray));
            }
        });
        luck.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int rand = new Random().nextInt(5) + 1;
                int data = 0;
                if (rand == 1) {
                    if (power.getValue() >= 20) {
                        data = 5 + Navigation.smartness;
                        power.setValue(power.getValue() - 20);
                        progress.setValue(progress.getValue() + data);
                        log.append("\n Ты атакуешь препода потоком формул на " + data + " баллов!");
                    } else {
                        log.append("\n Твоей силы мозга недостаточно!");
                    }
                } else if (rand == 2) {
                    if (power.getValue() >= 50) {
                        data = 5 + Navigation.slyass * 2;
                        power.setValue(power.getValue() - 50);
                        progress.setValue(progress.getValue() + data);
                        log.append("\n Твоя изощрённая хитрожопость без труда обводит противника вокруг пальца! "
                                + "Ты получил" + data + " баллов!");
                    } else {
                        log.append("\n Твоей силы мозга недостаточно!");
                    }
                } else if (rand == 3) {
                    log.append("\n Тебе удалось невероятно сконцентрироваться! Энергия восстановлена!");
                    power.setValue(power.getMaximum());
                } else if (rand == 4) {
                    log.append("\n Чёрт, башка - как после недельного запоя без закуски! Энергия упала!");
                    power.setValue(power.getMinimum());
                } else if (rand == 5) {
                    log.append("\n Ты выдал какую-то особо заковыристую хрень, и препод впал в когнитивный диссонанс! Быстро пользуйся!");
                    VirtualIntellect.stop();
                    shield.start();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                luck.setBorder(new LineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                luck.setBorder(new LineBorder(Color.darkGray));
            }
        });

        music = new Thread(new Runnable() {
            @Override
            public void run() {
                if (Menu.isMusicActive) {
                    ms.playSound("C:/Coffe/Акт3.wav");
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
        music.start();
        time.start();
    }

    static void dialog(int step) {
        if (step == 1) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан1.png"));
        }
        if (step == 2) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан2.png"));
        }
        if (step == 3) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан3.png"));
        }
        if (step == 4) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан4.png"));
        }
        if (step == 5) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан5.png"));
        }
        if (step == 6) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан6.png"));
        }
        if (step == 7) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан7.png"));
        }
        if (step == 8) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан8.png"));
        }
        if (step == 9) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан9.png"));
        }
        if (step == 10) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан10.png"));
        }
        if (step == 11) {
            art.setIcon(new ImageIcon("C:/Coffe/Матан11.png"));
        }

        if (step == 12) {
            art.setVisible(false);
            progress.setVisible(true);
            protagonist.setVisible(true);
            teacher.setVisible(true);
            title.setVisible(true);
            power.setVisible(true);
            scroll.setVisible(true);
            smart.setVisible(true);
            slyass.setVisible(true);
            luck.setVisible(true);
            smart.setEnabled(false);
            slyass.setEnabled(false);
            luck.setEnabled(false);
            delay.start();
            time.stop();
        }
    }
}
