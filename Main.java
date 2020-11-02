import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JPanel topPanel;
  JPanel buttonPanel;

  JButton[] numberButtons;
  JButton clearButton;
  JButton enterButton;

  JTextField display;

  //password Variable
  String password = "1234";
  
  String input = "";


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //intialize the main panel with a border layout
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    //initialize the button panel with a grid layout
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4,4));

    //initialize the top panel with the default layout (flow)
    topPanel = new JPanel();

    //create the display
    display = new JTextField("CLOSE");
    //set a preferred size so flow layout knows it should be bigger
    display.setPreferredSize(new Dimension(800, 100));
    //add it to the top
    topPanel.add(display);

    // sets the size of array
    numberButtons = new JButton[10];

    //creating the number buttons
    for(int i = 0; i < numberButtons.length;i++){
      numberButtons[i] = new JButton("" + i);
      
      //set the action command 
      numberButtons[i].setActionCommand("" + i);

      //add ActionListener
      numberButtons[i].addActionListener(this);
    }

    //create the clear button, add action listener and command
    clearButton = new JButton("CLEAR");
    clearButton.addActionListener(this);
    clearButton.setActionCommand("clear");

    //create the enter button, add action listener and command
    enterButton = new JButton("ENTER");
    enterButton.addActionListener(this);
    enterButton.setActionCommand("enter");

    //add the buttons to the grid
    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);

    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);

    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);

    buttonPanel.add(clearButton);
    buttonPanel.add(numberButtons[0]);
    buttonPanel.add(enterButton);

    //assemble the panels
    mainPanel.add(topPanel, BorderLayout.PAGE_START);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);

    //add the main panel to the frame 
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();


    //create a for loop to run every time a button is clicked
    for(int i = 0; i < numberButtons.length; i++){

      //get text from the display textfield
      String starDisplay = display.getText();
    
      //create variable star to represent one star
      String star = "*";

      //write an if statement to run every time a number button is clicked
      if(command.equals("" + i)){

        //add the button clicked to the input variable defined in class variables
        input = input + i;

        //display the star on the screen
        display.setText(starDisplay + star);

        //if display is showing close, the nested if statement should clear the screen, display a star and run the usual if statement
        if(starDisplay.equals("CLOSE")){
          display.setText("*");
       }
      
       //write an else if statement to clear the display screen when the clear button is clicked
      }else if(command.equals("clear")){
        display.setText("");

       //write an else if statement to run when the enter button is clicked
      }else if(command.equals("enter")){

        //compares the password typed in to the password variable defined above
        if(input.equals(password)){
          display.setText("OPEN");
        }else{
          display.setText("WRONG PIN");
        }
      }
    
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
} 
