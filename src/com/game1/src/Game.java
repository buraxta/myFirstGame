package com.game1.src;

import com.game1.src.input.Controller;
import com.game1.src.input.KeyInput;
import objects.Enemy;
import objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {

    private String background = "/images/background.png";

    Timer gamelooptimer;
    Player p;
    Controller c;


    public Game(){
        setFocusable(true);
        gamelooptimer = new Timer(10, (ActionListener) this);
        gamelooptimer.start();
        p = new Player(100,100);
        c = new Controller();


        addKeyListener(new KeyInput(p)); //Bu satır olmazsa player sınıfında yazdığımız key olayları çalışmıyor.
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getBackgroundImage(),0,0,this);
        p.draw(g2d);
        c.draw(g2d);

    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        p.update();
        repaint();
        c.update();

    }

    public Image getBackgroundImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(background));
        return i.getImage();
    }
}
