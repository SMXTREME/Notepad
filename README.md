# SimpleNotepad

SimpleNotepad is a lightweight text editor application built with Java. It provides basic notepad functionalities such as creating, editing, saving, and formatting text files. The project is structured for easy understanding and modification, making it suitable for learning Java GUI development.

## Features

-   Create, open, save, and edit text files
-   Basic text editing operations (cut, copy, paste, undo, redo)
-   Text formatting options (font, size, style)
-   Theme support (light/dark modes)
-   Keyboard shortcuts for common actions

## Project Structure

```
SimpleNotepad/
├── src/
│   └── Main/
│       ├── Function_Edit.java      # Handles edit operations (cut, copy, paste, etc.)
│       ├── Function_File.java      # Handles file operations (open, save, new, etc.)
│       ├── Function_Format.java    # Handles text formatting (font, size, etc.)
│       ├── Function_Theme.java     # Handles theme switching
│       ├── GUI.java                # Main GUI window and component setup
│       ├── KeyHandler.java         # Keyboard shortcut handling
│   └── META-INF/
│       └── MANIFEST.MF             # Manifest file for Java application
├── SimpleNotepad.iml               # IntelliJ IDEA project file
├── SimpleNotepad.jar               # Pre-built executable JAR file
```

## Getting Started

1. **Clone the repository** or download the source code.
2. **Run the application:**
    - **Using the JAR file:**
        - Make sure you have Java installed (JDK 8 or higher).
        - Open a terminal or command prompt in the project directory.
        - Run: `java -jar SimpleNotepad.jar`
    - **Or build from source:**
        - Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
        - Build and run the `GUI.java` file to launch the application.

## Requirements

-   Java Development Kit (JDK) 8 or higher
-   A Java IDE (optional, but recommended)

## Usage

-   Use the menu options or keyboard shortcuts to perform file and edit operations.
-   Change the theme or text formatting from the menu bar.

## License

This project is for educational purposes. You may modify and use it as needed.
