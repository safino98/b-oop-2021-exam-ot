package sk.stuba.fei.uim.oop.graphics.elements;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Setter
@Getter
public class PaintLine extends JPanel {
    private int posx;
    private int posy;
    private int posx2;
    private int posy2;
    private Color color;
    private Graphics graphics;


    public void paintLine(int x, int y){
        posx2=x;
        posy2=y;
        graphics.setColor(Color.BLACK);
        graphics.drawLine(posx,posy,x,y);
    }

    public void paintDone(){
        graphics.drawLine(posx,posy,posx2,posy2);
    }



}
