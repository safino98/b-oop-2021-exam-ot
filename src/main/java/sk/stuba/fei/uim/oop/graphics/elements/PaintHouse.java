package sk.stuba.fei.uim.oop.graphics.elements;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

@Setter
@Getter
public class PaintHouse extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private int rPosx;
    private int rPosy;
    private Color color;
    private Graphics graphics;
    private int mainX;
    private int mainY;

    public PaintHouse(Color color) {
        this.color = color;
    }

    public void paint(int x, int y){
        this.setOpaque(false);
        this.x = x-(50/4);
        this.y = y;
        this.width = 50/2;
        this.height = 50/2;
        this.rPosx = x;
        this.rPosy = y;
        this.mainX=x;
        this.mainY=y;
        paintComponent(graphics);

    }

    public boolean clicked(int clickX, int clickY) {
        Rectangle rect = new Rectangle(x, y, width, height);
        //Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, (int) (height * (2.0/3.0)));
        Polygon pol = new Polygon(new int[] {(rPosx-50/4), rPosx, (rPosx+50/4)}, new int[] {y, (y-50/2), y},3);
        return rect.contains(clickX, clickY) || pol.contains(clickX, clickY);
    }

    public void paintDone(){
        paintComponent(graphics);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(x, y, width, height);
        g.fillPolygon(new int[] {(rPosx-50/4), rPosx, (rPosx+50/4)}, new int[] {y, (y-50/2), y},3);


    }
}
