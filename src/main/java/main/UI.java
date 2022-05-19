/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author 38595
 */
public class UI {
    GamePanel gp;
    
    public UI(GamePanel gp) {
        this.gp=gp;
    }
    
public void draw(Graphics2D g2){
    g2.setFont(new Font("Arial",Font.PLAIN,40));
    }
}

