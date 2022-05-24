package sk.stuba.fei.uim.oop.graphics;

import sk.stuba.fei.uim.oop.graphics.elements.PaintHouse;
import sk.stuba.fei.uim.oop.graphics.elements.PaintThree;
import sk.stuba.fei.uim.oop.graphics.elements.buttons.MainButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintPanel extends JPanel implements MouseMotionListener, MouseListener {
private int x,y;
private PaintThree three;
private ArrayList<PaintThree> threes;
private PaintHouse house;
private ArrayList<PaintHouse> houses;
private Color color;
private MainButton threeB, houseB, lineB;

    public PaintPanel(MainButton threeB, MainButton houseB, MainButton lineB) {
        this.threeB = threeB;
        this.houseB = houseB;
        this.lineB = lineB;
        addMouseListener(this);
        addMouseMotionListener(this);
        threes = new ArrayList<PaintThree>();
        houses = new ArrayList<PaintHouse>();


    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (threeB.isPressed()){
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
            three = new PaintThree(color);
            three.setGraphics(getGraphics());
            three.paint(x, y);
        }
        else if (houseB.isPressed()){
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
            house = new PaintHouse(color);
            house.setGraphics(getGraphics());
            house.paint(x, y);
        }else if (lineB.isPressed()){
            System.out.println("stlacena je cesta");
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (threeB.isPressed()){
            threes.add(three);
            this.add(three);
            three = null;
            repaint();
        }
        else if (houseB.isPressed()){
            houses.add(house);
            house = null;
            repaint();
        }else if (lineB.isPressed()){
            System.out.println("stlacena je cesta");
        }
        paintComp();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        int r,g,b;
        r=color.getRed();
        g=color.getGreen();
        b=color.getBlue();
        Color transparent = new Color(r,g,b,127);

        if (threeB.isPressed()){
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
            three = new PaintThree(transparent);
            three.setGraphics(getGraphics());
            three.paint(x, y);
            paintComp();

        }
        else if (houseB.isPressed()){
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
            house = new PaintHouse(transparent);
            house.setGraphics(getGraphics());
            house.paint(x, y);
            paintComp();


        }else if (lineB.isPressed()){
            System.out.println("stlacena je cesta");
            paintComp();
        }

        repaint();
    }

    private void paintComp(){
        for (int i = 0; i<threes.size(); i++){
            if (threes.get(i)!=null){
                threes.get(i).paintDone();
            }
        }
        for (int j = 0; j<houses.size(); j++){
            if (houses.get(j)!=null){
                houses.get(j).paintDone();
            }
        }
    }

}
