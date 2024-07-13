//import the needed libraries
import javax.imageio.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class MyFrame extends JFrame implements ActionListener{

    char[] letters = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
    ImagePanel bg = new ImagePanel(); //bg is an imagepanel used for display that can be updated by using the setimage method
    JPanel wordpanel = new JPanel(); //wordpanel is a jpanel that is used to display the word you have to guess 
    Word word = new Word();//this gets the word to guess from the word class
    char[] myword = word.chararray();//this calls the chararray method returning an array of the letters in the word
    JLabel[] mywordlabels = new JLabel[myword.length];//array containing the labels for each letter of the word to guess
    JButton[] letterButtons = new JButton[letters.length];
    int wingame = 0;
    int guesses = 0;
    
    //create a frame and modify it how you like

    MyFrame(){
        this.setTitle("Hangman Game");
        this.setSize(700, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.getContentPane().setBackground(Color.decode("#006D5B"));

    //modify the background image panel how you like 

        bg.setPreferredSize(new Dimension(650,580));
        bg.setLayout(new BorderLayout());
        bg.setImage("Gallow6.png");
        bg.setBackground(Color.darkGray);
        bg.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));

    //modify the word panel how you like

        wordpanel.setPreferredSize(new Dimension(650,75));
        wordpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        wordpanel.setBackground(Color.decode("#006D5B"));

    //this for-loop creates a new label for every character of the word to guess 

        for (int i = 0; i < myword.length; i++) {
            //create the jlabel
            JLabel newlabel = new JLabel();
            //modify the jlabel
            newlabel.setPreferredSize(new Dimension(50, 40));
            newlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            newlabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Color.black));
            newlabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            mywordlabels[i] = newlabel;//add the labels to an array
            wordpanel.add(newlabel);//add the labels to the panel
        }

        //display the background image and the panel that contains the word
        this.add(bg);
        this.add(wordpanel);

        //this for-loop creates a new button for each letter of the alphabet
        for (int i = 0; i < letters.length; i++) {
            //Create a new button
            JButton button = new JButton();

            //modify the button how you like
            button.setText(Character.toString(letters[i]));
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(45, 35));
            button.setBackground(Color.decode("#006D5B"));
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
            //add the actionlistener so we can detect each time we press the button
            button.addActionListener(this);
            //add the buttons to an array
            letterButtons[i]=button;
            //add it to our frame 
            this.add(button);
        }
        //always set the frame visible to true in the end 
        this.setVisible(true);
    }

    //this actionperformed method detects whenever a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //we create a sourcebutton which resembles the button we have pressed
        JButton sourceButton = (JButton) e.getSource();
        //character c is gets the letter of the pressed button
        char c = sourceButton.getText().charAt(0);
        //we disabled the button we pressed so we can limit it to juts one press
        sourceButton.setEnabled(false);
        
        //we declare the temp variable here so it resets every time we press a button
        int temp = 0;

        //this for loop detects whenever our pressed button matches any of the letters from the word
        for (int i = 0; i < myword.length; i++) {
            //if they match
            if(c==myword[i]){
                //we modify the button green to say that it was right
                sourceButton.setBackground(Color.green);
                //we display the letter in the word
                mywordlabels[i].setText(String.valueOf(c));
                //the temporary and wingame value goes up by one
                temp++;
                wingame++;
            }
        }
        //if the temporary value stayed zero that means the button pressed doesnt match any of the letters from the word
        if (temp==0) {
            //we make the button red to say that it was wrong
            sourceButton.setBackground(Color.red);
            //the guesses value goes up by one: this is basically a strike
            guesses++;
        }

        //if our wingame value matches the word length that means we have found all the letters of the word and the game should end
        if(wingame == myword.length){
            //this creates a new window with a yes or no option
            int result = JOptionPane.showConfirmDialog(null, "One More Game?", "You Win", JOptionPane.YES_NO_OPTION);
            //we detect which option was pressed and depending on that we can start a new game or close the program
            if(result==1 || result==-1){
                System.exit(0);
            } else {
                resetGame();
            }
        }

        //this updates the image for every strike we get
        switch(guesses){
            case 1:bg.setImage("Gallow5.png");
            break;
            case 2:bg.setImage("Gallow4.png");
            break;
            case 3:bg.setImage("Gallow3.png");
            break;
            case 4:bg.setImage("Gallow2.png");
            break;
            case 5:bg.setImage("Gallow1.png");
            break;
            //when we reach 6 strikes the game ends and we show the yes or no window shown as above
            case 6:bg.setImage("Gallow0.png");
            int result2 = JOptionPane.showConfirmDialog(null, "One More Game?", "You Lose", JOptionPane.YES_NO_OPTION);
            if(result2==1 || result2==-1){
                System.exit(0);
            } else {
                resetGame();
            }
        }
    }
    // Method to reset the game state
    public void resetGame() {
        //Resets all the values 
        word = new Word();
        myword = word.chararray();
        mywordlabels = new JLabel[myword.length];
        wingame = 0;
        guesses = 0;

        wordpanel.removeAll();
        //Resets to the original state
        for (int i = 0; i < myword.length; i++) {
            JLabel newlabel = new JLabel();
            newlabel.setPreferredSize(new Dimension(50, 40));
            newlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            newlabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Color.black));
            newlabel.setHorizontalAlignment(SwingConstants.CENTER);
            mywordlabels[i] = newlabel;
            wordpanel.add(newlabel);
        }
        wordpanel.revalidate();
        wordpanel.repaint();

        bg.setImage("Gallow6.png");

        for (int i = 0; i < letters.length; i++) {
            letterButtons[i].setEnabled(true);
            letterButtons[i].setBackground(null);
        }
    }
    //main method is needed to start the game
    public static void main(String[] args) {
        //Starts the game
        new MyFrame();
    }
    
}

//this imagepanel class makes updating the panels image possible

class ImagePanel extends JPanel {
    private BufferedImage image;

    public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            repaint(); // Repaint the panel to update the image
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Draw the image, scaled to fit the panel
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}