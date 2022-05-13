/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author 38595
 */
public class GamePanel extends JPanel{
    //Screen settings
    final int originalTilesize=16; //16x16 tile
    final int scale = 3;
    
    final int tileSize = originalTilesize*scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;    // 768 pixels
    final int screenHeight = tileSize * maxScreenRow;   // 576 pixels
    
    Thread gameThread;
    
    public GamePanel() { 
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
                
    }
    
}
