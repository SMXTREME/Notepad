package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GUI gui;

    public KeyHandler(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
            gui.file.saveAsFile();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
            gui.file.newFile();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_W) {
            gui.file.exitFile();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
            gui.file.openFile();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            gui.file.saveFile();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
            gui.edit.undoEdit();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
            gui.edit.redoEdit();
        } else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_N) {
            gui.format.wordWrapFormat();
        } else if ((e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ADD) || (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_EQUALS)) {
            int currentFontSize = gui.format.fontSize;
            int newFontSize = currentFontSize + 4;

            if (newFontSize <= 32) {
                gui.format.fontSizeFormat(newFontSize);
            }
        } else if ((e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MINUS) || (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SUBTRACT)) {
            int currentFontSize = gui.format.fontSize;
            int newFontSize = currentFontSize - 4;

            if (newFontSize >= 8) {
                gui.format.fontSizeFormat(newFontSize);
            }
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_T) {
            String currentTheme = gui.theme.currentTheme;
            switch (currentTheme) {
                case "Dark" -> {
                    gui.theme.changeTheme("Light");
                }
                case "Light" -> {
                    gui.theme.changeTheme("Dark");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
