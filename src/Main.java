import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        MyGUI myApp = new MyGUI();
        myApp.main(new String[]{"args"});

        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
   //             testApp test = new testApp();
            }
        });
    }
}
