package Main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName, fileAddress;

    public Function_File(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("Untitled");
        fileName = null;
        fileAddress = null;
    }

    public void openFile() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();

            gui.window.setTitle(fileName);

            System.out.println("File: " + fileAddress + fileName);

            try {
                BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

                gui.textArea.setText("");

                String line = null;

                while ((line = br.readLine()) != null) {
                    gui.textArea.append(line + "\n");
                }

                br.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveFile() {
        if (fileName == null) {
            saveAsFile();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                fw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveAsFile() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                fw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void exitFile() {
        System.exit(0);
    }
}
