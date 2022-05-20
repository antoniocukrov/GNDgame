/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

/**
 *
 * @author 38595
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    public int hasKey=0;
    int spriteSwitch=0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=32;
        solidArea.height=32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up0 = ImageIO.read(getClass().getResourceAsStream("/player/mage_up_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_up_2.png"));
            down0 = ImageIO.read(getClass().getResourceAsStream("/player/mage_down_0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_down_2.png"));
            left0 = ImageIO.read(getClass().getResourceAsStream("/player/mage_left_0.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_left_2.png"));
            right0 = ImageIO.read(getClass().getResourceAsStream("/player/mage_right_0.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_right_2.png"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressed == true) {
                direction = "right";

            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // CHECK OBJ COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;

            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4){
                    spriteNum = 1;
                }
                spriteCounter = 0;
                    System.out.println(spriteNum);
            }
        }
        }
        
    public void pickUpObject(int i) {
        
        if(i !=999){
            String objectName = gp.obj[i].name;
            
            switch(objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    break;
                case "Door":
                    gp.playSE(3);
                    if(hasKey>0) {
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    System.out.println("Key: " + hasKey);
                    break;
                case "Boots":
                    gp.playSE(2);
                    speed+=2;
                    gp.obj[i]= null;
                    break;
            }
        }
        
    }
    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x,y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1 || spriteNum == 3){
                    image = up0;
                }
                if (spriteNum == 2) {
                    image = up1;
                }
                if (spriteNum == 4) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1 || spriteNum == 3){
                    image = down0;
                }
                if (spriteNum == 2) {
                    image = down1;
                }
                if (spriteNum == 4) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1 || spriteNum == 3){
                    image = left0;
                }
                if (spriteNum == 2) {
                    image = left1;
                }
                if (spriteNum == 4) {
                    image = left2;
                }
                break;
            case "right":
                 if (spriteNum == 1 || spriteNum == 3){
                    image = right0;
                }
                if (spriteNum == 2) {
                    image = right1;
                }
                if (spriteNum == 4) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
