package student;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.Timer;
 
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JTextArea;
 
@SuppressWarnings("serial")
public class AnimatedTextArea extends JTextArea implements ActionListener {
    public static final int DEFAULT_TYPE_PAUSE = 200;
    
    private Queue<Character> queue;
    private Timer timer;
    private int pause;
    
    public AnimatedTextArea(int pause) {
        this.pause = pause;
    }
    
    public AnimatedTextArea() {
        this(DEFAULT_TYPE_PAUSE);
    }
    
    @Override
    public void setText(String text) {
        queue = new LinkedList<Character>();
        for ( char c : text.toCharArray() )
            queue.add(c);
        super.setText("");
        timer = new Timer(pause, this);
        timer.start();
    }
 
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if ( queue.isEmpty() )
            timer.stop();
        else {
            String tmp = super.getText();
            if ( tmp == null )
                tmp = "";
            tmp += queue.remove();
            super.setText(tmp);
        }
    }
}