package Lec1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    public static final int WINDOW_HEIGHT = 200;
    public static final int WINDOW_WIDTH = 300;
    JButton btnStart = new JButton("Start New Game");

    SettingsWindow(GameWindow gamewindow) {
        setLocationRelativeTo(gamewindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamewindow.startNewGame(0, 3, 3, 3); // TODO интерактивно запрашивать
                setVisible(false);
            }
        });

        add(btnStart);
    }

}
