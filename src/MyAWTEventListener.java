
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
This is Dr. Wang's code, but modified to fit our project better
 */

/**
 *
 * @author wxw18
 */
public class MyAWTEventListener implements AWTEventListener {
    ArrayList<AWTEvent> eventList;
    boolean recording = false;

    MyAWTEventListener(ArrayList<AWTEvent> eventList) {
        this.eventList = eventList;
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        if(event.getID() == MouseEvent.MOUSE_CLICKED){
            Object o = event.getSource();
            if(o instanceof JButton){
                JButton button = (JButton)o;
                if(button.getText().equals("Recording")){
                    recording = true;
                }
                else if(button.getText().equals("Stop")){
                    recording = false;
                }
            }
        }
        if(recording){
            eventList.add(event);
        }
    }

}
