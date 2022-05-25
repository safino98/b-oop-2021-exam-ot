package sk.stuba.fei.uim.oop.graphics.elements;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@Setter
public class PaintThree extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private int rPosx;
    private int rPosy;
    private int rWidth;
    private int rHeight;
    private int mainX;
    private int mainY;
    private Color color;
    private Graphics graphics;

    public PaintThree(Color color) {
        this.color = color;
    }

    public void paint(int x, int y){
        this.setOpaque(false);
        this.mainX=x;
        this.mainY=y;
        this.x = x-30;
        this.y = y-30;
        this.width = 50;
        this.height = 33;
        this.rPosx = this.x+(width/2)-(width/6);
        this.rPosy = this.y+height-(height/30);
        this.rWidth = width/3;
        this.rHeight = height/2;
        paintComponent(graphics);

    }

    public boolean clicked(int clickX, int clickY) {
        Rectangle rect = new Rectangle(x + (int) (width * (1.0/3.0)), y + (int) (height * 0.5), (int) (width * (1.0/3.0)), (int) (height * 0.5));
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, (int) (height * (2.0/3.0)));
        return rect.contains(clickX, clickY) || ellipse.contains(clickX, clickY);
    }

    public void paintDone(){
        paintComponent(graphics);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillOval(x, y, width, height);
        g.fillRect(rPosx, rPosy, rWidth, rHeight);


    }
}
