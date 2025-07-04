package Main;

import java.awt.*;

public class Function_Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    int fontSize;

    public Function_Format(GUI gui) {
        this.gui = gui;
    }

    public void wordWrapFormat() {
        if (!gui.wordWrapOn) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        } else {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: off");
        }
    }

    public void fontSizeFormat(int fontSize) {
        this.fontSize = fontSize;

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFontFormat(selectedFont);
    }

    public void setFontFormat(String font) {
        selectedFont = font;

        switch (selectedFont) {
            case "Arial": gui.textArea.setFont(arial); break;
            case "Comic Sans MS": gui.textArea.setFont(comicSansMS); break;
            case "Times New Roman": gui.textArea.setFont(timesNewRoman); break;
        }
    }
}
