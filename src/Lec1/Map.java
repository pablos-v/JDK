package Lec1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    //region Fields
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private final int DOT_PADDING = 5;
    private char[][] field;
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    private int winLength;
    private int fieldSizeX;
    private int fieldSizeY;
    private int gameOver;
    private boolean isInitialized;
    private boolean isGameOver;
    private static final int DRAW = 0;
    private static final int WinHuman = 1;
    private static final int WinAI = 2;
    //endregion

    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        isInitialized = false;

    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, WinHuman)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, WinAI)) return;
    }

    void startNewGame(int mode, int fSizeX, int fSizeY, int wLen) {
        fieldSizeX = fSizeX;
        fieldSizeY = fSizeY;
        winLength = wLen;
        initMap(fieldSizeX, fieldSizeY);
        isInitialized = true;
        isGameOver = false;
        repaint();
    }

    private void initMap(int x, int y) {
        field = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private boolean checkWin(char c) {
        if (checkWinLines(c, fieldSizeX, fieldSizeY)) return true;
        if (checkWinLines(c, fieldSizeY, fieldSizeX)) return true;

        int flag_1 = 0, flag_2 = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            if (field[x][x] == c) flag_1++;
            if (field[x][fieldSizeX - 1 - x] == c) flag_2++;
        }
        return flag_1 == winLength || flag_2 == winLength;
    }

    private boolean checkWinLines(char c, int x, int y) {
        int flag = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (field[i][j] == c) flag++;
            }
            if (flag == winLength) return true;
            else flag = 0;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Oups!");
                }
            }
        }
        if (isGameOver) showMessageGameOver(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOver) {
            case DRAW -> g.drawString("DRAW!", 180, getHeight() / 2);
            case WinAI -> g.drawString("Comp wins!", 20, getHeight() / 2);
            case WinHuman -> g.drawString("You win!", 70, getHeight() / 2);
            default -> throw new RuntimeException("Wrong state: " + gameOver);
        }
    }


    private boolean checkEndGame(int dot, int gameOver) {
        if (checkWin((char) dot)) {
            this.gameOver = gameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOver = DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }
}
