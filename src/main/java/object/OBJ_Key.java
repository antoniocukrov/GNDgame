/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author 38595
 */
public class OBJ_Key extends SuperObject{
    GamePanel gp;
    public OBJ_Key(GamePanel gp) {
        this.gp=gp;
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
            uTool.scaleImage(image, gp.tileSize,gp.tileSize);
        }catch(IOException e){
           e.printStackTrace();
        }
             
    }
}
