package student;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class exp {

    public static void main(String[] args) throws BadLocationException {
        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        textPane.insertComponent(new JLabel(new ImageIcon("D:/Coffe/Пролог.png")));
        Style style = textPane.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style, Color.red);
        
        
        try {
            doc.insertString(doc.getLength(), "BLAH ", style);
        } catch (BadLocationException e) {
        }

        StyleConstants.setForeground(style, Color.blue);

        try {
            doc.insertString(doc.getLength(), "BLEH", style);
        } catch (BadLocationException e) {
        }

        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(textPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
