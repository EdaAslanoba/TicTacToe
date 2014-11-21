package com.mycompany.app;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JApplet; //to create GUI
import javax.swing.JFrame;


public class TicTacToe extends JApplet {

    //create as enum so that we know to draw an X if player is X and so on. predefined constants
    private enum CellSelection { N, X, O }; //null, X and O
    //private CellSelection[,] grid = new CellSelection[3,3]; how to do this in Java?

    final private float lineLength = 360;
    final private float block = lineLength / 3;
    final private float offset = 20;
    final private float delta = 5;

    public void init() {
        setBackground(Color.white);
        setForeground(Color.white);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.gray);

        //-------Draw 3 x 3 game grid----------//

        //draw board
        g2.draw(new Line2D.Double ( offset + block, offset , offset + block, offset + lineLength));
        g2.draw(new Line2D.Double ( offset + (2 * block), offset , offset + (2 * block), offset + lineLength));
        g2.draw(new Line2D.Double ( offset, offset + block, offset + lineLength, offset + block));
        g2.draw(new Line2D.Double ( offset, offset + ( 2 * block ), offset + lineLength, offset + (2 * block)));

        /*
        //draw players
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (grid[i, j] == CellSelection.O) DrawO(i, j, g);
        else if (grid[i, j] == CellSelection.X) DrawX(i, j, g);
        */

    }

    //draw X
    public void DrawX(int i, int j, Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Line2D.Double(i * block + delta, j * block + delta,
                (i * block) + block - delta, (j * block) + block - delta));
        g2.draw(new Line2D.Double((i * block) + block - delta,
                j * block + delta, (i * block) + delta, (j * block) + block - delta));

    }

    //draw an O
    public void DrawO(int i, int j, Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Ellipse2D.Double(i * block + delta, j * block + delta,
            block - 2 * delta, block - 2 * delta));
    }

    public static void main(String s[]) {

        JFrame f = new JFrame("Tic Tac Toe");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet applet = new TicTacToe();

        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(440, 440));
        f.setResizable(true); //disable dragging the window from the corner
        f.setVisible(true);

    }

}


//old methods - improved now


        /*
        //vertical lines
        int x1Vertical = 150;
        int x2Vertical = 250;
        int y1Vertical = 50;
        int y2Vertical = 350;
        g2.draw(new Line2D.Double(x1Vertical, y1Vertical, x1Vertical, y2Vertical));
        g2.draw(new Line2D.Double(x2Vertical, y1Vertical, x2Vertical, y2Vertical));

        //horizontal lines
        int x1Horizontal = 50;
        int x2Horizontal = 350;
        int y1Horizontal = 150;
        int y2Horizontal = 250;
        g2.draw(new Line2D.Double(x1Horizontal, y1Horizontal, x2Horizontal, y1Horizontal));
        g2.draw(new Line2D.Double(x1Horizontal, y2Horizontal, x2Horizontal, y2Horizontal));
        */