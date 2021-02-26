import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyRecorder extends  JFrame{
    JPanel rootPanel = new JPanel();
    JButton recordButton = new JButton("Record"); //records movements
    JButton stopButton = new JButton("Stop"); //stops the recording
    JButton playButton = new JButton("Play"); //plays the recording

    MyRecorder()
    {
        setTitle("Recorder");
        setSize(250,75);

        rootPanel.add(recordButton);
        rootPanel.add(playButton);
        rootPanel.add(stopButton);
        this.getContentPane().add(rootPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);





        recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("record button clicked");
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("play button clicked");
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("stop button clicked");
            }
        });
    }

    public static void main(String args[])
    {
        MyRecorder myRecorder = new MyRecorder();


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnimationFrame animationFrame = new AnimationFrame();
                new AnimationFrame().setVisible(true);
                animationFrame.setLocationRelativeTo(null); // makes this spawn in the middle of the screen

            }
        });

    }


}
