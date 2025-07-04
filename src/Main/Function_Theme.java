package Main;

import java.awt.*;
import java.util.Objects;

public class Function_Theme {
    GUI gui;

    public Function_Theme(GUI gui) {
        this.gui = gui;
    }

    public void changeTheme(String theme) {
        switch (theme) {
            case "Light" -> {
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                gui.textArea.setCaretColor(Color.black);
            }
            case "Dark" -> {
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                gui.textArea.setCaretColor(Color.white);
            }
        }
    }
}
