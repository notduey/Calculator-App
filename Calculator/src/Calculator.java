import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int windowWidth = 360; //width of window
    int windowHeight = 540; //height of window

    Color customLightGray = new Color(212, 212, 210); //custom gray color
    Color customDarkGray = new Color(80, 80, 80); //custom dark gray
    Color customBlack = new Color(28, 28, 28); //custom black
    Color customPurple = new Color(143, 78, 255); //custom purple

    String[] buttonValues = { //button values
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="}; //symbols on right
    String[] topSymbols = {"AC", "+/-", "%"}; //symbols on top

    JFrame frame =  new JFrame("Calculator"); //the window itself (JFrame) with calculator as the name
    JLabel displayLabel = new JLabel(); //label for the text
    JPanel displayPanel = new JPanel(); //panel for the label
    JPanel buttonsPanel = new JPanel(); //buttons panel

    Calculator() { //constructor class for window properties
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //forces java to use its own neutral theme the user's operating system’s buttons, but this statement was added, the buttons were all white and the custom colors didn't apply
        } 
        catch (Exception e) { //catches the error and instead of crashing, the program runs the catch statement
            e.printStackTrace(); //gives name of the error (like ClassNotFoundException) and stack trace showing where the error happened in the code.
        }

        frame.setVisible(true); //true so the window is visible
        frame.setSize(windowWidth, windowHeight); //frame size is same as window width and height
        frame.setLocationRelativeTo(null); //setting location to null centers the window when the user opens the application
        frame.setResizable(false); //false makes it so the user cannot resize the window in any way
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it so when the user clicks on the x button the program will be terminated (closed)
        frame.setLayout(new BorderLayout()); //BorderLayout makes it so you can place stuff within the window

        displayLabel.setBackground(customBlack); //label background color
        displayLabel.setForeground(Color.white); //text (foreground) color
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80)); //font for the label; font, formatting, size
        displayLabel.setHorizontalAlignment(JLabel.RIGHT); //offsets text to the right
        displayLabel.setText("0"); //sets default text
        displayLabel.setOpaque(true); //true makes label opaque

        displayPanel.setLayout(new BorderLayout()); //setting the layout
        displayPanel.add(displayLabel); //putting the text label inside the panel
        frame.add(displayPanel, BorderLayout.NORTH); //putting the panel in our window, display panel offset to top of window

        buttonsPanel.setLayout(new GridLayout(5, 4)); //grid panel; 5 rows, 4 columns
        buttonsPanel.setBackground(customBlack); //button background
        frame.add(buttonsPanel, BorderLayout.CENTER); //adds button panel to window and centers it

        for (int i = 0; i < buttonValues.length; i++) { //for loop that correlates to the buttonValues array and makes new button
            JButton button = new JButton(); //creates new Jbutton instance
            String buttonValue = buttonValues[i]; //gets the button's label from the array
            button.setFont(new Font("Arial", Font.PLAIN, 30)); //font, formatting, size
            button.setText(buttonValue); //sets the button display text
            button.setFocusable(false); //makes the retangular border around the button characters invisible
            button.setOpaque(true); //makes the button opaque
            if (Arrays.asList(topSymbols).contains(buttonValue)) { //if statement; if the symbol in the for loop is a part of the topSymbols array, run code inside
                button.setBackground(customLightGray); //button color
                button.setForeground(customBlack); //font (foreground) color
            }
            else if (Arrays.asList(rightSymbols).contains(buttonValue)) { //else if statement; same as the if statement but for rightSymbol arrays instead
                button.setBackground(customPurple); //button color
                button.setForeground(Color.white); //font (foreground) color
            }
            else { //if it's none of the above, run code below
                button.setBackground(customDarkGray); //button color
                button.setForeground(Color.white); //font (foreground) color
            }
            
            buttonsPanel.add(button); //adds the button to the panel
        }
    }
}