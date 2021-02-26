package edu.psu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class testApp {
    //GUI components
    private JPanel panelMain;
    private JButton openFileButton;
    private JButton startTestingButton;
    private JLabel promptLabelBottom;
    private JLabel promptLabelTop;

    //Logic fields
    private File inputFile;
    private ArrayList<JComponent> components;
    private int failed = 0, passed = 0;

    public testApp(){
        JFrame frame = new JFrame("GUI Testing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panelMain);
        frame.pack();
        frame.setVisible(true);

        //TODO capture JTextBoxes from the myGUI application
        Toolkit tk = Toolkit.getDefaultToolkit();
        components = new ArrayList<>();
        AWTEventListener customListener = new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if(components.size()<4){
                    //Collect events
                    if(event.getID() == MouseEvent.MOUSE_PRESSED) {
                        components.add((JComponent) event.getSource());
                        promptLabelBottom.setText(components.size() + "/4");
                    }
                    //When all components are pressed
                    if(components.size() == 4){
                        promptLabelTop.setText("Select the file containing test cases");
                        promptLabelBottom.setText("Your selection: ...");
                        openFileButton.setEnabled(true);
                    }
                }
            }
        };
        tk.addAWTEventListener(customListener, AWTEvent.MOUSE_EVENT_MASK);

        //Button listener
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add file chooser
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(panelMain);

                if(returnValue == JFileChooser.APPROVE_OPTION){
                    //update the prompt
                    inputFile = fileChooser.getSelectedFile();
                    promptLabelBottom.setText("You've selected: "+ inputFile.getName());

                    //enable test button
                    startTestingButton.setEnabled(true);
                }else{
                    //DO NOTHING
                }
            }
        });
        startTestingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptLabelTop.setText("Testing in progress...");
                promptLabelBottom.setVisible(false);
                //TODO implement testing algorithm
                try(Scanner in = new Scanner(inputFile)){
                    while(in.hasNext()){
                        String testCase = in.nextLine();
                        String[] tokens = testCase.split(" ");

                        //TODO implement algorithm that populates fields of the myGUI
                        //fill in the inputs
                        ((JTextField) components.get(0)).setText(tokens[0]);
                        ((JTextField) components.get(1)).setText(tokens[1]);
                        //run the code
                        ((JButton) components.get(3)).doClick();
                        //verify results
                        String result = ((JTextField) components.get(2)).getText();
                        boolean status = result.compareTo(tokens[2]) == 0;
                        System.out.print("Testing > " + tokens[0] + " + " + tokens[1] + " | Actual = " + result + " Expected = " + tokens[2] + " Status: ");
                        if(status){
                            System.out.println("PASS");
                            passed++;
                        }else{
                            System.out.println("FAIL");
                            failed++;
                        }
                    }
                }catch (IOException exc){
                    System.err.println("Couldn't read the input file!");
                }

                //TODO after the testing is finished
                promptLabelBottom.setVisible(true);
                promptLabelTop.setText("Testing is complete.");
                promptLabelBottom.setText("Total: " + (failed+passed) + " Passed: " + passed + " Failed: " + failed);
            }
        });
    }
}
