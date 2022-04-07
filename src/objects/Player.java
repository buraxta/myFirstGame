package objects;

import com.game1.src.GlobalPosition;
import com.game1.src.input.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Player extends GlobalPosition {

    private String playerimage = "/images/player.png";

    private LinkedList<Enemy> e = Controller.getEnemyBounds();

    int velX = 0;
    int velY = 0;

    public Player(int x, int y) {
        super(x, y);
    }

    public void update(){
        x += velX;
        y += velY;

        //Burayı ekrandan taşmaması için yazdık
        if (x < 0){
            x = 0;
        }
        if (y < 0){
            y = 0;
        }
        //
        if (x>550){
            x=550;
        }
        if (y > 340){
            y = 340;
        }
        collision();
    }

    public void collision(){
        for (int i = 0; i<e.size();i++){
            if (getBounds().intersects(e.get(i).getBounds())){
                System.out.println("Game Over!");
            }
        }
    }
    /* klavye işlemleri için
        1) önce burayı yaptık
        2) sonra KeyInput sınıfına da aynı metodları yazdık ve oraya burayı tanıttık
        3) sonra  Game sınıfının constructur'una işlem yaptık*/
    /*Matığı:
      klavye tetiklendiğinde;
      1) önce constructor nesne oluşturdu,
      2= ordan keyInput'taki komutlar çalıştırıldı
      3) ordaki metodlar da en son burayı tetikledi*/

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key==KeyEvent.VK_RIGHT){
            velX = 5;
        } else if(key==KeyEvent.VK_LEFT){
            velX = -5;
        }else if (key==KeyEvent.VK_DOWN){
            velY = 5;
        }else if (key == KeyEvent.VK_UP){
            velY = -5;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key==KeyEvent.VK_RIGHT){
            velX = 0;
        } else if(key==KeyEvent.VK_LEFT){
            velX = 0;
        }else if (key==KeyEvent.VK_DOWN){
            velY = 0;
        }else if (key == KeyEvent.VK_UP){
            velY = 0;
        }
    }


    public Rectangle getBounds(){
        return new Rectangle(x,y,60,70); // hero
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImage(),x,y,null);
    }

    public Image getPlayerImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
        return i.getImage();
    }
}
