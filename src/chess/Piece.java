package chess;

import java.awt.Color;
import java.awt.Point;

abstract class Piece {

    static final int PIECE_SIZE = 6;

    abstract Color[][] getImage();

    abstract boolean isWhite();

    abstract boolean isActionLegal(Point start, Point end);

    void move(Point start, Point end, Piece[][] board, Piece me) {
        board[(int) start.getY()][(int) start.getX()] = null;
        board[(int) end.getY()][(int) end.getX()] = me;
    }

    int delta(double start, double end) {
        return Math.abs((int) end - (int) start);
    }

    void getColor(Color[][] image, int[][] pixels, boolean isWhite) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels.length; j++) {
                final int pixel = pixels[i][j];
                if (pixel == 0) {
                    image[i][j] = null;
                } else if (pixel == 1 && isWhite) {
                    image[i][j] = Color.WHITE;
                } else if (pixel == 1) {
                    image[i][j] = Color.BLACK;
                } else {
                    throw new IllegalStateException("Set up pixel board wrong!");
                }
            }
        }
    }
}