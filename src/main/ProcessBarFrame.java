package main;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ProcessBarFrame extends JFrame {
    private JProgressBar barProcess;

    ProcessBarFrame() throws HeadlessException {
        super();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.exit(0);
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        createProcessBar();
        panel.add(barProcess);

        setContentPane(panel);
        setBackground(new Color(0, 0, 0, 0));
        setSize(300, 70);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setAlwaysOnTop(true);
    }

    private void createProcessBar() {
        barProcess = new JProgressBar();
        barProcess.setIndeterminate(true);
        barProcess.setFont(new Font("Tahoma", Font.PLAIN, 11));
        barProcess.setString("подождите...");
        barProcess.setStringPainted(true);
    }

    void changeColor(Color colorB, Color colorF, Color colorBText, Color colorFText){
        barProcess.setBackground(colorB);
        barProcess.setForeground(colorF);
        barProcess.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() { return colorBText; }
            protected Color getSelectionForeground() { return colorFText; }
        });
    }

    JProgressBar getBarProcess() {
        return barProcess;
    }
}
