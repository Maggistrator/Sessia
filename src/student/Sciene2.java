package student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author OldTeaOwl
 */
public class Sciene2 {

    static int count = -1;
    static int step = 1;
    static JLabel art = new JLabel(new ImageIcon("D:/Coffe/Акт2.png"));
    static Thread music;
    static Timer time;
    static MakeSound ms = new MakeSound();
    static int counter = 1;
    static boolean flag = true;
    static JFrame sciene = new JFrame();
    static JLabel workbook = new JLabel(new ImageIcon("D:/Coffe/Лаба.png"));
    static JPanel pane = new JPanel();
    static JScrollPane scrollPane = new JScrollPane(pane);
    static JPanel actionPanel = new JPanel();
    static JScrollPane borderpane = new JScrollPane(actionPanel);
    static JLabel smart = new JLabel();
    static JLabel slyass = new JLabel();
    static JLabel luck = new JLabel();
    static String text;
    static JLabel current;
    static int rezult = 0;

    //public static void main(String[] args) {
        public Sciene2() {
        disable();
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        pane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        smart.setHorizontalAlignment(JLabel.CENTER);
        slyass.setHorizontalAlignment(JLabel.CENTER);
        luck.setHorizontalAlignment(JLabel.CENTER);
        slyass.setForeground(Color.blue);
        luck.setForeground(Color.green);
        actionPanel.setLayout(null);
        smart.setBounds(5, 3, 237, 20);
        slyass.setBounds(5, 25, 237, 20);
        luck.setBounds(5, 47, 237, 20);
        workbook.setBounds(0, 0, 800, 600);
        art.setBounds(0, 0, 800, 600);
        scrollPane.setBounds(0, 0, 250, 500);
        borderpane.setBounds(0, 500, 250, 100);
        actionPanel.add(smart);
        actionPanel.add(slyass);
        actionPanel.add(luck);
        borderpane.setVisible(false);
        scrollPane.setVisible(false);
        scrollPane.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        workbook.setVisible(false);
        sciene.add(borderpane);
        sciene.add(scrollPane);
        sciene.add(workbook);
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
                text = smart.getText();
                time.start();
                disable();
                current = smart;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                smart.setBorder(new LineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (smart.isEnabled()) {
                    smart.setBorder(new LineBorder(Color.darkGray));
                } else {
                    smart.setBorder(new LineBorder(Color.lightGray));
                }
            }
        });
        slyass.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                text = slyass.getText();
                time.start();
                disable();
                current = slyass;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                slyass.setBorder(new LineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (slyass.isEnabled()) {
                    slyass.setBorder(new LineBorder(Color.darkGray));
                } else {
                    slyass.setBorder(new LineBorder(Color.lightGray));
                }
            }
        });
        luck.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                text = luck.getText();
                time.start();
                disable();
                current = luck;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                luck.setBorder(new LineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (luck.isEnabled()) {
                    luck.setBorder(new LineBorder(Color.darkGray));
                } else {
                    luck.setBorder(new LineBorder(Color.lightGray));
                }
            }
        });
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
        time.start();
        music.start();
    }

    private static void dialog(int step) {
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
            art.setVisible(false);
            workbook.setVisible(true);
            scrollPane.setVisible(true);
            borderpane.setVisible(true);
            time.setDelay(5000);
        }
        if (step == 12) {
            GenerateLabel("<html>Заходи, заходи, студент,"
                    + "<br>не заперто, хе-хе!</html>");
        }
        if (step == 13) {
            GenerateLabel("Итак, ты хочешь сдать химию?");
        }
        if (step == 14) {
            GenerateLabel("<html>Хорошо, тогда сейчас мы будем варить<br> метамфетамин!<html>");
        }
        if (step == 15) {
            GenerateLabel("<html>Ха, шутка!"
                    + "<br>Но кое-что мы варить всё-таки будем..."
                    + "<br>Да начнётся лаба! Хо-хо-хо!</html>");
        }
        if (step == 16) {
            GenerateLabel("<html>Итак, добавь гидросульфит натрия в эту "
                    + "<br>пробирку но будь осторожен, студент - <br>"
                    + "можно остаться без всех десяти "
                    + "<br>комплюктероуправлялок!Хе-хе-хе!</html>");
            smart.setText("<Взять гидросульфит натрия>");
            slyass.setText("<Взять пробирку с водой>");
            luck.setText("<Взять што-то нарандом>");
            time.stop();
            enable();
        }
        if (step == 17) {
            GenerateLabel(2, text);
        }
        if (step == 18) {
            GenerateLabel(3, "<html>Ты берёшь пробирку,"
                    + "<br>и херачишь в тёмную вязкую"
                    + "<br>жижу с резким запахом</html>");
        }

        if (step == 19) {
            GenerateLabel("Неплохо, поджигай спиртовку!");
        }
        if (step == 20) {
            if (current.equals(smart)) {
                rezult++;
            }
            if (current.equals(slyass)) {
                rezult--;
            }
            if (current.equals(luck)) {
                rezult += new Random().nextInt(2) - 1;
            }
            switch (rezult) {
                case 1:
                    GenerateLabel(3, "<html>Ты поджёг спиртовку. <br>Жижа нагревается и бурлит<html>");
                    break;
                case -1:
                    GenerateLabel(3, "<html>Ты поджёг спиртовку. <br>Водичка кипит<html>");
                    break;
                default:
                    GenerateLabel(3, "<html>Ты поджёг спиртовку. <br>Что-то происходит, но ты - гуманитарий<html>");
                    break;
            }
        }
        if (step == 21) {
            GenerateLabel("Теперь, лей известковое молоко!");
            smart.setText("Взять жидкость, похожую на малафью");
            slyass.setText("Добавить угарный газ, ибо так угарней");
            time.stop();
            enable();
        }
        if (step == 22) {
            GenerateLabel(3, text);
        }
        if (step == 22) {
            if (current.equals(smart)) {
                rezult++;
            }
            if (current.equals(slyass)) {
                rezult--;
            }
            if (current.equals(luck)) {
                rezult += new Random().nextInt(2) - 1;
            }
            switch (rezult) {
                case 2:
                    GenerateLabel(3, "<html>Жижа парит. <br>Аромат кажется тебе знакомым.<html>");
                    break;
                case -2:
                    GenerateLabel(3, "<html>От запаха этой херни<br>у тебя режет в глазах<html>");
                    break;
                default:
                    GenerateLabel(3, "Олололо!");
                    break;
            }
        }
        if (step == 23) {
            GenerateLabel("Скажи мне когда будешь готов");
            smart.setText("<Готов>");
            slyass.setText("<Готов>");
            luck.setText("<Олололо>");
            time.stop();
            enable();
        }
                if (step == 24) {
            GenerateLabel(3, text);
        }
        if (step == 25) {
            if (current.equals(smart)) {
                rezult++;
            }
            if (current.equals(slyass)) {
                rezult--;
            }
            if (current.equals(luck)) {
                rezult += new Random().nextInt(2) - 1;
            }
            switch (rezult) {
                case 3:
                    GenerateLabel(3, "<html>Ты снимаешь пробирку с пламени"
                            + "<br>Хм, пахнет неплохо<html>");
                    break;
                case -3:
                    GenerateLabel(3, "<html>Чувак, ты сварил целую пробирку<br>наредкость отвратительного состава<html>");
                    break;
                default:
                    GenerateLabel(3, "Сложно сказать, что это");
                    break;
            }
        }
        if (step == 26) {
            GenerateLabel("<html>Теперь, выпей это!<br>Хо-хо-хо!<br>Тяжёл он, путь к зачёту, да?<html>");
        }
        if (step == 27) {

            switch (rezult) {
                case 3:
                    Navigation.luck += 2;
                    Navigation.smartness -= 2;
                    GenerateLabel(3, "<html>Поздравляю! Ты сварил типичный самогон! "
                            + "<br>Тебя быстро разносит, и в голове помутняется..."
                            + "<br>Но, Халява любит рисковых)"
                            + "<br>Интеллект -2, Удача +2<html>");
                    break;
                case -3:
                    Navigation.slyass -= 2;
                    Navigation.smartness += 2;
                    GenerateLabel(3, "<html>Твою мать!<br>Один глоток этого пойла научил тебя"
                            + "<br>большему, чем 9 лет школы"
                            + "<br>не пей метиловый спирт"
                            + "<br>Хитрожопость -2, Интеллект +2<html>");
                    break;
                default:
                    Navigation.luck -= 2;
                    Navigation.slyass += 2;
                    GenerateLabel(3, "<html>На этом экзамене тебе не свезло,"
                            + "<br>но ты всё неплохо выкрутился - "
                            + "<br>старый хрыч явно хотел тебя травануть"
                            + "<br>Удача -2, Хитрожопость +2</html>");
                    break;
            }
        }
        if (step == 28) {
            switch (rezult) {
                case 3:
                    art.setIcon(new ImageIcon("D:/Coffe/Сдал.png"));
                    GenerateLabel("Зачёт!");
                    JOptionPane.showMessageDialog(null, "Зачёт!");
                    break;
                case -3:
                    GenerateLabel("Тышто, совсем тупой штоле?");
                    JOptionPane.showMessageDialog(null, "Тышто, совсем тупой штоле?(с)Химик");
                    break;
                default:
                    GenerateLabel("<html>Чёт ты не химик<br>Шёл бы ты отсюда, петушок</html>");
                    JOptionPane.showMessageDialog(null, "Забей, главное, что зачёт!)");
                    break;
            }
        }
        if (step == 29) {
            if (Menu.isMusicActive) {
                ms.interrupt();
            }
            sciene.setVisible(false);
            sciene.repaint();
            time.stop();
            Sciene2.step = 1;
            count = -1;
            counter = 1;
            rezult = 0;
            if(Navigation.step==2){
                    Navigation.points++;
            Navigation.step++;
            Markbook.passChemistry();
            }
           Navigation.show();
            Navigation.playMusic();
            Navigation.runnable.interrupt();
        }
    }

    private static void GenerateLabel(String text) {
        count++;
        ImageIcon ico = new ImageIcon("D:/Coffe/Химик.png");
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

    private static void GenerateLabel(int type, String text) {
        count++;
        ImageIcon ico = null;
        if (type == 1) {
            ico = new ImageIcon("D:/Coffe/Химик.png");
        } else if (type == 2) {
            ico = new ImageIcon("D:/Coffe/Студент.png");
        } else if (type == 3) {
            ico = new ImageIcon("D:/Coffe/ЗнакЛабы.png");
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

    private static void enable() {
        smart.setEnabled(true);
        slyass.setEnabled(true);
        luck.setEnabled(true);
        smart.setBorder(new LineBorder(Color.darkGray));
        slyass.setBorder(new LineBorder(Color.darkGray));
        luck.setBorder(new LineBorder(Color.darkGray));
    }

    private static void disable() {
        smart.setEnabled(false);
        slyass.setEnabled(false);
        luck.setEnabled(false);
        smart.setBorder(new LineBorder(Color.lightGray));
        slyass.setBorder(new LineBorder(Color.lightGray));
        luck.setBorder(new LineBorder(Color.lightGray));
    }
}
