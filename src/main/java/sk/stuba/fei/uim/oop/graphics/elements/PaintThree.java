package sk.stuba.fei.uim.oop.graphics.elements;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class PaintThree extends JPanel {
    private int posx;
    private int posy;
    private int width;
    private int height;
    private int rPosx;
    private int rPosy;
    private int rWidth;
    private int rHeight;
    private Color color;
    private Graphics graphics;

    public PaintThree(Color color) {
        this.color = color;
    }

    public void paint(int x, int y){
        this.setOpaque(false);
        this.posx = x-30;
        this.posy = y-30;
        this.width = 50;
        this.height = 33;
        this.rPosx = posx+(width/2)-(width/6);
        this.rPosy = posy+height-(height/30);
        this.rWidth = width/3;
        this.rHeight = height/2;
        paintComponent(graphics);

    }


    public void paintDone(){
        paintComponent(graphics);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillOval(posx, posy, width, height);
        g.fillRect(rPosx, rPosy, rWidth, rHeight);


    }
}
