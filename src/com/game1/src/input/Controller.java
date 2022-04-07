package com.game1.src.input;

import objects.Enemy;

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    static LinkedList<Enemy> e = new LinkedList<Enemy>();

    Enemy tempEnemy;

    public Controller(){
        addEnemy(new Enemy(100,100));
        addEnemy(new Enemy(200,100));
        addEnemy(new Enemy(100,200));
        addEnemy(new Enemy(100,300));
    }

    public void draw(Graphics2D g2d){
        for (int i = 0; i < e.size(); i++){
            tempEnemy = e.get(i);
            tempEnemy.draw(g2d);
        }
    }

    public void update(){
        for (int i = 0; i < e.size(); i ++){
            tempEnemy = e.get(i);
            //burda düşmanların yok olmasını sağladık
//            if(tempEnemy.x<20){
//                removeEnemy(tempEnemy);
//            }
            tempEnemy.update();
        }
    }
    public static LinkedList<Enemy> getEnemyBounds(){
        return e;
    }

    public void addEnemy(Enemy enemy){
        e.add(enemy);
    }

    public void removeEnemy(Enemy enemy){
        e.remove(enemy);
    }

}
