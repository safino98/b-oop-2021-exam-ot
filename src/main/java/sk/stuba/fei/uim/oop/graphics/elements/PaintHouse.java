package sk.stuba.fei.uim.oop.graphics.elements;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class PaintHouse extends JPanel {
    private int posx;
    private int posy;
    private int width;
    private int height;
    private int rPosx;
    private int rPosy;
    private Color color;
    private Graphics graphics;

    public PaintHouse(Color color) {
        this.color = color;
    }

    public void paint(int x, int y){
        this.setOpaque(false);
        this.posx = x-(50/4);
        this.posy = y;
        this.width = 50/2;
        this.height = 50/2;
        this.rPosx = x;
        this.rPosy = y;
        paintComponent(graphics);

    }


    public void paintDone(){
        paintComponent(graphics);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(posx, posy, width, height);
        g.fillPolygon(new int[] {(rPosx-50/4), rPosx, (rPosx+50/4)}, new int[] {posy, (posy-50/2), posy},3);


    }
}
