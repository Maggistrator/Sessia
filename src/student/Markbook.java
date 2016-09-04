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
public class Markbook {

    static JFrame markbook = new JFrame();
    static JLabel russian = new JLabel(new ImageIcon("D:/Coffe/Русский(не сдал).png"));
    static JLabel chemistry = new JLabel(new ImageIcon("D:/Coffe/Химия(не сдал).png"));
    static JLabel math = new JLabel(new ImageIcon("D:/Coffe/Матан(не сдал).png"));
    static JLabel background = new JLabel(new ImageIcon("D:/Coffe/Зачётка.png"));

    //public static void main(String[] args) {
    public Markbook() {
        final JLabel skip = new JLabel(new ImageIcon("D:/Coffe/Skip.png"));
        skip.setBounds(230, 364, 50, 27);
        skip.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                markbook.setVisible(false);
                markbook.repaint();
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
        background.setBounds(0, 0, 300, 400);
        russian.setBounds(0, 100, 300, 50);
        chemistry.setBounds(0, 152, 300, 50);
        math.setBounds(0, 204, 300, 50);
        markbook.add(skip);
        markbook.add(russian);
        markbook.add(chemistry);
        markbook.add(math);
        markbook.add(background);
        markbook.setSize(300, 430);
        markbook.setLocationRelativeTo(null);
        markbook.setLayout(null);
        markbook.setVisible(true);
        markbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void passRussian() {
        russian.setIcon(new ImageIcon("D:/Coffe/Русский(сдал).png"));
    }

    public static void passChemistry() {
        chemistry.setIcon(new ImageIcon("D:/Coffe/Химия(сдал).png"));
    }

    public static void passMath() {
        math.setIcon(new ImageIcon("D:/Coffe/Матан(сдал).png"));
    }
}
