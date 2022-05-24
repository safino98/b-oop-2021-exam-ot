package sk.stuba.fei.uim.oop.graphics.elements.buttons;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MainButton extends JButton {
    private boolean pressed;

    public MainButton(String name) {
        super(name);
        pressed = false;
    }
}
