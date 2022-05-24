package sk.stuba.fei.uim.oop.graphics;

import sk.stuba.fei.uim.oop.graphics.elements.buttons.MainButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private MainButton strom, dom, cesta;
    private JLabel text;
    private PaintPanel panel;
    private int i;

    public MainFrame() {
        super("Peciatkaren");
        int i = 0;
        generateFrame();
        this.repaint();
        this.setVisible(true);
        strom.setPressed(true);
        panel.setColor(Color.green);

    }
    private void generateFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,4));
        menu.setBackground(new Color(200,200,200));

        strom = new MainButton("Strom");
        strom.addActionListener(this);
        dom = new MainButton("Dom");
        dom.addActionListener(this);
        cesta = new MainButton("Cesta");
        cesta.addActionListener(this);
        text = new JLabel("Aktualne zvolene");

        panel = new PaintPanel(strom, dom, cesta);

        menu.add(strom);
        menu.add(dom);
        menu.add(cesta);
        menu.add(text);
        this.add(menu, BorderLayout.PAGE_START);
        this.add(panel);

    }

    public Color moveColor(){
        Color color = Color.RED;
        if (i==1){color=Color.BLUE;}
        else if (i==2){color=Color.GREEN;}
        else if (i==3){
            color=Color.RED;
            i=0;
        }
        i++;
        return color;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        panel.setColor(moveColor());
        if (actionEvent.getActionCommand().equals("Strom")){
            strom.setPressed(true);
            cesta.setPressed(false);
            dom.setPressed(false);
        }else if (actionEvent.getActionCommand().equals("Dom")){
            dom.setPressed(true);
            strom.setPressed(false);
            cesta.setPressed(false);
        }else if (actionEvent.getActionCommand().equals("Cesta")){
            cesta.setPressed(true);
            dom.setPressed(false);
            strom.setPressed(false);
        }
    }
}
