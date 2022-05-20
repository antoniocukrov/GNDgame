/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author 38595
 */
public class UI {
    GamePanel gp;
    Font arial_40;
    
    public UI(GamePanel gp) {
        this.gp=gp;
        
        arial_40=new Font("Arial",Font.PLAIN,40);
    }
    
public void draw(Graphics2D g2){
    g2.setFont(arial_40);
    g2.setColor(Color.white);
    g2.drawString("Has key : " + gp.player.hasKey, 50, 50);
    
    }
}

