package Lec1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public static final int WINDOW_HEIGHT = 555;
    public static final int WINDOW_WIDTH = 507;
    public static final int WINDOW_POSX = 800;
    public static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map;

    SettingsWindow settings;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("My Game!");
        setResizable(false);

        settings = new SettingsWindow(this);

        //region Buttons
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        //endregion

        //region Map and Panel
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH);

        map = new Map();
        add(map);
        //endregion

        setVisible(true);
    }

    public void startNewGame(int mode, int fSizeX, int fSizeY, int winLen) {
        map.startNewGame(mode, fSizeX, fSizeY, winLen);
    }
}
