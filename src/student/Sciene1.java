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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author OldTeaOwl
 */
public class Sciene1 {

    transient static JTextArea log = new JTextArea();
    transient static JLabel qestion = new JLabel();
    transient static JLabel smart = new JLabel();
    transient static JLabel slyass = new JLabel();
    transient static JLabel lucky = new JLabel();
    transient static JScrollPane scrollPane = new JScrollPane(log);
    transient static JPanel pane = new JPanel();
    transient static int step;
    transient static int anstep;
    transient static JLabel art = new JLabel();
    transient static JLabel uchilka = new JLabel(new ImageIcon("C:/Coffe/MC Uchilka.png"));
    transient static Thread music;
    transient static Timer time;
    transient static MakeSound ms = new MakeSound();
    transient static JFrame sciene = new JFrame();
    transient static int points;

    //public static void main(String[] args) {
    public Sciene1() {
        step = 1;
        points = 0;
        anstep = 1;
        art.setIcon(new ImageIcon("C:/Coffe/Русский1.png"));
        smart.setText("Хм, Украiньску мову?");
        slyass.setText("Пфф! Вы смеётесь? Да этож все знают!(нет))");
        lucky.setText("<Халява приди!!!>");
        log.setFont(new Font("Arial", Font.PLAIN, 12));
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        log.setEnabled(false);
        log.setDisabledTextColor(Color.black);
        slyass.setForeground(Color.blue);
        lucky.setForeground(Color.GREEN);
        qestion.setBounds(0, 375, 500, 50);
        smart.setSize((int) ((int) slyass.getText().length() * smart.getFont().getSize2D()), 20);
        slyass.setSize((int) ((int) slyass.getText().length() * smart.getFont().getSize2D()), 20);
        lucky.setSize((int) ((int) slyass.getText().length() * smart.getFont().getSize2D()), 20);
        smart.setLocation((500 - smart.getWidth()) / 2, 450);
        slyass.setLocation((500 - slyass.getWidth()) / 2, 475);
        lucky.setLocation((500 - lucky.getWidth()) / 2, 500);
        pane.setBounds(270, 10, 500, 550);
        scrollPane.setBounds(10, 10, 250, 550);
        scrollPane.setVisible(false);
        pane.setVisible(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        art.setBounds(0, 0, 800, 600);
        uchilka.setBounds(155, 10, 220, 360);
        uchilka.setBorder(new LineBorder(Color.DARK_GRAY));
        pane.setBorder(new LineBorder(Color.DARK_GRAY));
        qestion.setBorder(new LineBorder(Color.DARK_GRAY));
        qestion.setHorizontalAlignment(JLabel.CENTER);
        qestion.setVerticalAlignment(JLabel.CENTER);
        labelset(smart);
        labelset(slyass);
        labelset(lucky);
        qestion.setText("О'кей, что ты сейчас сдаёшь?");
        pane.setLayout(null);
        pane.add(uchilka);
        pane.add(qestion);
        sciene.add(scrollPane);
        sciene.add(pane);
        sciene.add(art);
        sciene.setLayout(null);
        sciene.setSize(800, 600);
        sciene.setResizable(false);
        sciene.setLocationRelativeTo(null);
        sciene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sciene.setVisible(true);
        smart.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                int buffer = 4 + Navigation.smartness;
                points += buffer;
                log.append("\nИспользуя свои офигительные знания, ты получаешь " + buffer + " баллов из 10");
                step++;
                next();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                smart.setBorder(new LineBorder(Color.lightGray));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                smart.setBorder(new LineBorder(Color.darkGray));
            }
        });
        slyass.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                int buffer = new Random().nextInt(5) + 1 + Navigation.slyass;
                points += buffer;
                if (buffer >= 4) {
                    log.append("\nХех, хитрая задница! \nНа этот раз тебе перепало " + buffer + " баллов из 10!");
                }
                if (buffer < 4) {
                    log.append("\nПровалилась она, твоя хитрожопость!\n " + buffer + " баллов из 10!");
                }
                step++;
                next();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                slyass.setBorder(new LineBorder(Color.lightGray));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                slyass.setBorder(new LineBorder(Color.darkGray));
            }
        });
        lucky.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                int buffer = new Random().nextInt(10);
                if (buffer > 2 && buffer < 10 - Navigation.luck) {
                    buffer += Navigation.luck;
                }
                points += buffer;
                if (buffer == 0) {
                    log.append("\nХалява отвернулась от тебя, лалка! Ты не получаешь ничего=3");
                }
                if (buffer <= 4) {
                    log.append("\nНиоч. " + buffer + "/10");
                }
                if (buffer > 4 && buffer < 10) {
                    log.append("\n(Тебе ниспослано " + buffer + " баллов из 10)");
                }
                if (buffer == 10) {
                    log.append("\nАааааа!!! Ты.Получашь.Грёбаные.10 баллов из 10!!!");
                }
                step++;
                next();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lucky.setBorder(new LineBorder(Color.lightGray));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lucky.setBorder(new LineBorder(Color.darkGray));
            }
        });
        music = new Thread(new Runnable() {
            @Override
            public void run() {
                if (Menu.isMusicActive) {
                    ms.playSound("C:/Coffe/Акт1.wav");
                }
            }
        });
        time = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog(anstep);
                anstep++;
            }
        });
        time.start();
        music.start();
    }

    static void dialog(int step) {
        if (anstep == 1) {
            art.setIcon(new ImageIcon("C:/Coffe/Русский2.png"));
        }

        if (anstep == 2) {
            art.setIcon(new ImageIcon("C:/Coffe/Русский3.png"));
        }

        if (anstep == 3) {
            art.setVisible(false);
            scrollPane.setVisible(true);
            pane.setVisible(true);
            log.setText("----------Вопрос 1/10----------");
            time.stop();
        }
    }

    private static void labelset(final JLabel target) {
        target.setBorder(new LineBorder(Color.DARK_GRAY));
        target.setHorizontalAlignment(JLabel.CENTER);
        target.setVerticalAlignment(JLabel.CENTER);
        pane.add(target);
    }

    private static void next() {
        if (step == 2) {
            log.append("\n----------Вопрос 2/10----------");
            qestion.setText("Жы-шы пишы с буквой - ...");
            smart.setText("ЫЫЫЫЫ!!!");
            slyass.setText("Как сказал известный лингвист ХЗ-ков... (демагогия)");
        }
        if (step == 3) {
            log.append("\n----------Вопрос 3/10----------");
            qestion.setText("Кто такой Пушкин?");
            smart.setText("Знаю, знаю! Эт у которого 'вы любите розы а я на них срал'");
            slyass.setText("<Извлечь из труханов шпаргалку>");
        }
        if (step == 4) {
            log.append("\n----------Вопрос 4/10----------");
            qestion.setText("Кто написал Войну и мир?");
            smart.setText("Лермонтов, мамой клянусь!");
            slyass.setText("О, кстати о войне, вы смотрели 'Битву экстрасенсов'?(увод)");
        }
        if (step == 5) {
            log.append("\n----------Вопрос 5/10----------");
            qestion.setText("Назови виды причастий!");
            smart.setText("Я только один знаю - Действительно Страдающее");
            slyass.setText("Слава Святому Путису!");
        }
        if (step == 6) {
            log.append("\n----------Вопрос 6/10----------");
            qestion.setText("Что изучает фонетика?");
            smart.setText("Это когда Вы фоните - а рядом чуваки со счётчиками бегают");
            slyass.setText("Можно я на доске изображу?(нарисовать елдак)");
        }
        if (step == 7) {
            log.append("\n----------Вопрос 7/10----------");
            qestion.setText("Назови приставку в слове 'приставка'?");
            smart.setText("XBox360");
            slyass.setText("А Вам самим слабо штоле?))0))(взять на 'слабо')");
        }
        if (step == 8) {
            log.append("\n----------Вопрос 8/10----------");
            qestion.setText("Что такое синтаксис?");
            smart.setText("Это когда всё норм, и всё равно CompilationError");
            slyass.setText("<О'кей гугл!>");
        }
        if (step == 9) {
            log.append("\n----------Вопрос 9/10----------");
            qestion.setText("Что изучает пунктуация?");
            smart.setText("В душе не ебу");
            slyass.setText("Вашу пунктуальность. Вы опоздали на пару. Сказать начальству?");
        }
        if (step == 10) {
            log.append("\n----------Вопрос 10/10----------");
            qestion.setText("Ты идиот?");
            smart.setText("Кто? Я?");
            slyass.setText("Если я скажу 'да', мне поставят 3?");
        }
        if (step == 11) {
            if (Menu.isMusicActive) {
                ms.interrupt();
            }
            scrollPane.setVisible(false);
            pane.setVisible(false);
            art.setVisible(true);
            if (points < 50) {
                art.setIcon(new ImageIcon("C:/Coffe/Кадр10.png"));
                JOptionPane.showMessageDialog(null, "Кхм.. Парень? Ты провалился.  \n(Лог:У тебя " + points + " баллов из 100,"
                        + "\n а на 3 надо минимум 50. Мне жаль.)");
                Navigation.points--;
            }
            if (points >= 50 && points < 70) {
                art.setIcon(new ImageIcon("C:/Coffe/Сдал.png"));
                JOptionPane.showMessageDialog(null, "СДАААААААААЛ!");
                //арт про СДААААЛ!
            }
            if (points >= 70 && points < 90) {
                JOptionPane.showMessageDialog(null, "Да у тебя 4, парень!!! Это надо отметить! =)");
            }
            if (points >= 90 && points < 100) {
                JOptionPane.showMessageDialog(null, "Чиииитер!!! У. Тебя. Грёбаная. 5-ка!!!");
            }

            if (Navigation.step == 1) {
                Navigation.points++;
                Navigation.step++;
                Markbook.passRussian();
            }
            Sciene1.step = 1;
            Sciene1.anstep = 1;
            Navigation.show();
            Navigation.playMusic();
            sciene.setVisible(false);
            sciene.repaint();
            Navigation.runnable.interrupt();
        }
    }
}
