package objects;

import com.game1.src.GlobalPosition;
import com.game1.src.MainClass;

import javax.swing.*;
import java.awt.*;

public class Enemy extends GlobalPosition {
    private String image = "/images/enemy.png";

    int speed = 4;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void update(){
        x += speed;
        if (x > 575){
            speed  = -4;
        }
        if (x < 0){
            speed  = 4;
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,40); // düşman
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(getEnemyImage(),x,y,null);
    }

    public Image getEnemyImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(image));
        return i.getImage();
    }
}
