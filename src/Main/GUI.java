package Main;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;

    // Text Area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    // Top Menu Bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuTheme;

    //File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //Edit Menu
    JMenuItem iUndo, iRedo;

    //Format Menu
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTMR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28, iFontSize32;
    JMenu menuFont, menuFontSize;

    //Colour Menu
    JMenuItem iThemeLight, iThemeDark;

    Function_File file = new Function_File(this);
    Function_Edit edit = new Function_Edit(this);
    Function_Format format = new Function_Format(this);
    Function_Theme theme = new Function_Theme(this);
    KeyHandler keyH = new KeyHandler(this);

    UndoManager um = new UndoManager();


    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createThemeMenu();

        format.selectedFont = "Arial";
        format.fontSizeFormat(20);
        format.wordWrapFormat();

        theme.changeTheme("Dark");

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Untitled");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.addKeyListener(keyH);

        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();

        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuTheme = new JMenu("Theme");
        menuBar.add(menuTheme);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: On");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTMR = new JMenuItem("Times New Roman");
        iFontTMR.addActionListener(this);
        iFontTMR.setActionCommand("Times New Roman");
        menuFont.add(iFontTMR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);

        iFontSize32 = new JMenuItem("32");
        iFontSize32.addActionListener(this);
        iFontSize32.setActionCommand("size32");
        menuFontSize.add(iFontSize32);
    }

    public void createThemeMenu() {
        iThemeLight = new JMenuItem("Light");
        iThemeLight.addActionListener(this);
        iThemeLight.setActionCommand("Light");
        menuTheme.add(iThemeLight);

        iThemeDark = new JMenuItem("Dark");
        iThemeDark.addActionListener(this);
        iThemeDark.setActionCommand("Dark");
        menuTheme.add(iThemeDark);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New": file.newFile(); break;
            case "Open": file.openFile(); break;
            case "Save": file.saveFile(); break;
            case "SaveAs": file.saveAsFile(); break;
            case "Exit": file.exitFile(); break;
            case "Word Wrap": format.wordWrapFormat(); break;
            case "Arial", "Comic Sans MS", "Times New Roman": format.setFontFormat(command); break;
            case "size8": format.fontSizeFormat(8); break;
            case "size12": format.fontSizeFormat(12); break;
            case "size16": format.fontSizeFormat(16); break;
            case "size20": format.fontSizeFormat(20); break;
            case "size24": format.fontSizeFormat(24); break;
            case "size28": format.fontSizeFormat(28); break;
            case "size32": format.fontSizeFormat(32); break;
            case "Light", "Dark": theme.changeTheme(command); break;
            case "Undo": edit.undoEdit(); break;
            case "Redo": edit.redoEdit(); break;
        }
    }
}
