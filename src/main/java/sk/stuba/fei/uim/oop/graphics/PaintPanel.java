package sk.stuba.fei.uim.oop.graphics;

import sk.stuba.fei.uim.oop.graphics.elements.PaintHouse;
import sk.stuba.fei.uim.oop.graphics.elements.PaintLine;
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
private PaintLine line;
private ArrayList<PaintLine> lines;
private String relesedO;

    public PaintPanel(MainButton threeB, MainButton houseB, MainButton lineB) {
        this.threeB = threeB;
        this.houseB = houseB;
        this.lineB = lineB;
        addMouseListener(this);
        addMouseMotionListener(this);
        threes = new ArrayList<PaintThree>();
        houses = new ArrayList<PaintHouse>();
        lines = new ArrayList<PaintLine>();


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
            line = new PaintLine();
            for (int i = 0; i<threes.size(); i++) {
                if (threes.get(i).clicked(mouseEvent.getX(), mouseEvent.getY())) {
                    line.setGraphics(getGraphics());
                    line.setPosx(threes.get(i).getMainX());
                    line.setPosy(threes.get(i).getMainY());
                    relesedO = "Dom";
                }
            }
            for (int j = 0; j<houses.size(); j++) {
                if (houses.get(j).clicked(mouseEvent.getX(), mouseEvent.getY())) {
                    line.setGraphics(getGraphics());
                    line.setPosx(houses.get(j).getMainX());
                    line.setPosy(houses.get(j).getMainY());
                    relesedO="Strom";
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (threeB.isPressed()){
            threes.add(three);
            this.add(three);
            three = null;
            //repaint();

        }
        else if (houseB.isPressed()){
            houses.add(house);
            house = null;
            //repaint();
        }else if (lineB.isPressed()){
            String actual = "nic";
            for (int i = 0; i<threes.size(); i++) {
                if (threes.get(i).clicked(mouseEvent.getX(), mouseEvent.getY())) {
                    actual = "Strom";
                }
            }
            for (int j = 0; j<houses.size(); j++) {
                if (houses.get(j).clicked(mouseEvent.getX(), mouseEvent.getY())) {
                    actual = "Dom";
                }
            }
            if (relesedO.equals(actual)){
                lines.add(line);
            }

            line=null;
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
        if (lineB.isPressed()) {
            line.paintLine(mouseEvent.getX(), mouseEvent.getY());
            repaint();
            paintComp();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        /*int r,g,b;
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
        }*/


        paintComp();
    }



    private void paintComp(){
        //repaint();
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
        for (int k = 0; k<lines.size(); k++){
            if (lines.get(k)!=null){
                lines.get(k).paintDone();
            }
        }
    }

}
