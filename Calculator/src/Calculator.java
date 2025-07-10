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

    JFrame frame =  new JFrame("Calculator"); //the window itself (JFrame) with calculator as the name
    JLabel displayLabel = new JLabel(); //label for the text
    JPanel displayPanel = new JPanel(); //panel for the label

    Calculator() { //constructor class for window properties
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
        frame.add(displayPanel); //putting the panel in our window
    }
}
