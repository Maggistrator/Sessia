package student;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author OldTeaOwl
 */
public class Abilities {

    static JFrame abilities = new JFrame();
    static JLabel smartness = new JLabel();
    static JLabel slyass = new JLabel();
    static JLabel luck = new JLabel();
    static JLabel background = new JLabel();

//    public static void main(String[] args) {
        public Abilities() {
        smartness.setIcon(new ImageIcon("D:/Coffe/Ботанство" + Navigation.smartness + ".png"));
        slyass.setIcon(new ImageIcon("D:/Coffe/Хитрожопость" + Navigation.slyass + ".png"));
        luck.setIcon(new ImageIcon("D:/Coffe/Удача" + Navigation.luck + ".png"));
        background.setIcon(new ImageIcon("D:/Coffe/Умения" + Navigation.points + ".png"));
        background.setBounds(0, 0, 300, 400);
        smartness.setBounds(0, 100, 300, 50);
        slyass.setBounds(0, 152, 300, 50);
        luck.setBounds(0, 204, 300, 50);
        addNewListener(smartness);
        addNewListener(slyass);
        addNewListener(luck);
        abilities.add(smartness);
        abilities.add(slyass);
        abilities.add(luck);
        abilities.add(background);
        abilities.setSize(300, 430);
        abilities.setLocationRelativeTo(null);
        abilities.setLayout(null);
        abilities.setVisible(true);
    }

    private static void addNewListener(JLabel target) {
        target.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if (Navigation.points > 0) {
                    if (target.equals(smartness)) {
                        Navigation.smartness++;
                        smartness.setIcon(new ImageIcon("D:/Coffe/Ботанство" + Navigation.smartness + ".png"));
                    }
                    if (target.equals(slyass)) {
                        Navigation.slyass++;
                        slyass.setIcon(new ImageIcon("D:/Coffe/Хитрожопость" + Navigation.slyass + ".png"));
                    }
                    if (target.equals(luck)) {
                        Navigation.luck++;
                        luck.setIcon(new ImageIcon("D:/Coffe/Удача" + Navigation.luck + ".png"));
                    }
                    Navigation.points--;
                    background.setIcon(new ImageIcon("D:/Coffe/Умения" + Navigation.points + ".png"));
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                target.setCursor(new Cursor(Cursor.HAND_CURSOR));
                target.setBorder(new LineBorder(Color.white));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                target.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                target.setBorder(null);
            }
        });
    }
}
