//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class MyGUI extends JFrame {
    private JTextField input1;
    private JTextField input2;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField output;

    public MyGUI() {
        this.initComponents();
    }

    private void initComponents() {
        this.input1 = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.input2 = new JTextField();
        this.jLabel3 = new JLabel();
        this.output = new JTextField();
        this.jButton1 = new JButton();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.input1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("Input1: ");
        this.jLabel2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel2.setText("Input2: ");
        this.input2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel3.setFont(new Font("Tahoma", 0, 18));
        this.jLabel3.setText("Output: ");
        this.output.setFont(new Font("Tahoma", 0, 18));
        this.output.setEnabled(false);
        this.jButton1.setFont(new Font("Tahoma", 0, 18));
        this.jButton1.setText("OK");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MyGUI.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel4.setFont(new Font("Tahoma", 0, 18));
        this.jLabel4.setText("+");
        this.jLabel5.setFont(new Font("Tahoma", 0, 18));
        this.jLabel5.setText("=");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(65, 65, 65).addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.input2, -2, 197, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.input1, -2, 197, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.output, -2, 197, -2).addComponent(this.jButton1, -2, 87, -2)))).addContainerGap(53, 32767)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel4).addGap(143, 143, 143)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel5).addGap(144, 144, 144)))));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.input1, -2, 34, -2).addComponent(this.jLabel1)).addGap(9, 9, 9).addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.input2, -2, 34, -2).addComponent(this.jLabel2)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.output, -2, 34, -2).addComponent(this.jLabel3)).addGap(26, 26, 26).addComponent(this.jButton1).addGap(40, 40, 40)));
        this.pack();
    }

    public void jButton1ActionPerformed(ActionEvent evt) {
        int i1 = Integer.parseInt(this.input1.getText());
        int i2 = Integer.parseInt(this.input2.getText());
        int sum = i1 + i2;
        if (sum % 53 == 0) {
            --sum;
        }

        if (sum % 37 == 0) {
            ++sum;
        }

        if (sum % 91 == 0) {
            sum += 2;
        }

        this.output.setText(sum + "");
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new MyGUI()).setVisible(true);
            }
        });
    }
}
