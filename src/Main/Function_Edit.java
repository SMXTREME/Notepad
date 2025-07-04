package Main;

public class Function_Edit {
    GUI gui;

    public Function_Edit(GUI gui) {
        this.gui = gui;
    }

    public void undoEdit() {
        gui.um.undo();
    }

    public void redoEdit() {
        gui.um.redo();
    }
}
