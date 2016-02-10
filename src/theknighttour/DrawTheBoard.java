/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theknighttour;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *The program provides an algorithm that gives sequences of moves of the knight such that the knight
 *visits each square only once. I Used JApplet and JFrame to give a visual view of the knight traveling. 
 *
 * @author Algharabeh
 */
public class DrawTheBoard extends JPanel {

    private final ArrayList<int[]> board = new ArrayList<>();
    private final ArrayList<Point> Point = new ArrayList<>();
    private final Timer timer;
    private int count = 0;
    private int width;
    private int height;
    private final Image TheKnight = (new ImageIcon("src/theknighttour/Knight.png")).getImage();
    
     public void SetTheBoard(int row, int column) { // Method that sets the board
        board.add(new int[]{row, column});
    }

    public DrawTheBoard() { // Constructer 
        timer = new Timer(800, new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics lily) {
        super.paintComponent(lily);
        height = getHeight() / 8;
        width = getWidth() / 8;

        for (int k=1;k<8;k++) {
            lily.drawLine(width*k,0,width*k,getHeight());
            lily.drawLine(0,height*k,getWidth(),height*k);
        }
        
        for (int i = 0; i < board.size(); i++) {
            Point.add(new Point(width*(board.get(i)[1] + 1) - (width/2),height*(board.get(i)[0]+1) - (height/2)));
        }
       
        if (Point.size()>0&&count!=board.size()) {
            lily.drawImage(TheKnight, (int) Point.get(count-1).getX() - (width / 12),
                    (int) Point.get(count-1).getY()-(height/8), height, width, this);
        } 
        else if (Point.size()>0) {
            timer.stop();
            lily.drawImage(TheKnight, (int) Point.get(Point.size()-1).getX() - (height/2),
                    (int) Point.get(Point.size()-1).getY() - (width/2), height, width, this);
        }
        
         for (int i = 0; i + 1<Point.size()&& i + 1 < count; i++) {
            if (i == 0) {
                lily.setColor(Color.BLUE);
            } else if (i + 1 == 63) {
                lily.setColor(Color.RED);
            } else {
                lily.setColor(Color.ORANGE);
            }
            lily.drawLine((int) Point.get(i).getX(), (int) Point.get(i).getY(),
                    (int) Point.get(i+1).getX(), (int) Point.get(i+1).getY());
        }
    }

    public void TourStart() { // Method that starts the timer 
        timer.start();

    }

}
