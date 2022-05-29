/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author 38595
 */
public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        //PLACEHOLDER - Nullpoint!
        setup(0, "new/grass00", false);
        setup(1, "new/grass00", false);
        setup(2, "new/grass00", false);
        setup(3, "new/grass00", false);
        setup(4, "new/grass00", false);
        setup(5, "new/grass00", false);
        setup(6, "new/grass00", false);
        setup(7, "new/grass00", false);
        setup(8, "new/grass00", false);
        setup(9, "new/grass00", false);
        //PLACEHOLDER
        
        setup(10, "new/grass00", false);
        setup(11, "new/grass01", false);
        setup(12, "new/water00", false);
        setup(13, "new/water01", false);
        setup(14, "new/water02", false);
        setup(15, "new/water03", false);
        setup(16, "new/water04", false);
        setup(17, "new/water05", false);
        setup(18, "new/water06", false);
        setup(19, "new/water07", false);
        setup(20, "new/water08", false);
        setup(21, "new/water09", false);
        setup(22, "new/water10", false);
        setup(23, "new/water11", false);
        setup(24, "new/water12", false);
        setup(25, "new/water13", false);
        setup(26, "new/road00", false);
        setup(27, "new/road01", false);
        setup(28, "new/road02", false);
        setup(29, "new/road03", false);
        setup(30, "new/road04", false);
        setup(31, "new/road05", false);
        setup(32, "new/road06", false);
        setup(33, "new/road07", false);
        setup(34, "new/road08", false);
        setup(35, "new/road09", false);
        setup(36, "new/road10", false);
        setup(37, "new/road11", false);
        setup(38, "new/road12", false);
        setup(39, "new/earth", false);
        setup(40, "new/wall", false);
        setup(41, "new/tree", false);
        
        
        

    }

    public void setup(int index, String imagePath, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        try {
            InputStream is = getClass().getResourceAsStream("/maps/worldV2.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (IOException exe) {
            exe.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                    && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                    && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                    && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;

                worldRow++;

            }

        }
    }
}
