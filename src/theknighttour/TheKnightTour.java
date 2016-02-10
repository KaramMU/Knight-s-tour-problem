/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theknighttour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * The program provides an algorithm that gives sequences of moves of the knight such that the knight visits 
 * each square only once. I Used JApplet and JFrame to give a visual view of the knight traveling.

 *
 * @author Algharabeh
 */
public class TheKnightTour extends JApplet {
    private JButton Way = new JButton("Start The Tour");
    private DrawTheBoard drawBoard = new DrawTheBoard();
    private Board board = new Board(drawBoard);
    private JLabel Row = new JLabel("Position Range: 1-8            Row: ");
    private JLabel Column = new JLabel("Column: ");
    private JTextField Row2 = new JTextField(2);
    private JTextField Column2 = new JTextField(2);
    private JPanel Framework = new JPanel();
    

    public TheKnightTour() {  // Constructer  
        Framework.add(Row);
        Framework.add(Column);
        Framework.add(Row2); 
        Framework.add(Column2);
        Framework.add(Way);
        
        Framework.setBackground(Color.orange);
        add(Framework );
        drawBoard.setBackground(Color.white);
        add(drawBoard);
        
        add(Framework, BorderLayout.NORTH);
        add(drawBoard, BorderLayout.CENTER);
        
        drawBoard.setBorder(new LineBorder(Color.BLACK));
        Way.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Integer.parseInt(Row2.getText())-1;
                int column = Integer.parseInt(Column2.getText())-1;
                
                board.PossibleMovesCount(row,column);
                board.TheStartTime();
                board.fixIntialLocation(row,column);
                board.FindTheWay(row,column);
                drawBoard.SetTheBoard(row,column);
                drawBoard.TourStart();
            }
        });
    }

    @Override
    public void init(){
        setSize(1000, 1000);
    }

    @Override
    public void start(){

    }

    @Override
    public void stop(){

    }

    public static void main(String[] args) {     
        TheKnightTour applet = new TheKnightTour();
        JFrame karam = new JFrame();
        karam.add(applet);
        karam.setSize(600, 600);
        karam.setTitle("The Knight Tour");
        karam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        karam.setVisible(true);   
        
    }
}
