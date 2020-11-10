/* *
 * Jason Jaroszewicz
 * CIS 117 Section 18
 * 13 June 2018
 * Chapter 17 Assignment
 * This program will use the Java Swing Library to create a GUI for an application
 * that kids can use for word-ordering practice. It will display a list of words with
 * two text boxes below the list. The user can type the two best fitting words in the text
 * boxes and the press a Done button. If the user clicks the clear button the words in the
 * text boxes should disappear.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.BorderFactory;

public class WordFun extends JFrame
{
    public static void main(String[] args)
    {
        new WordFun();
    }

    public WordFun()
    {
        this.setTitle("Word Order Game");
        this.setSize(470, 470);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wordFunContents();
        this.setVisible(true);
        this.setResizable(false);
    }

    public void wordFunContents()
    {
        // components
        JTextField textBoxFirst = new JTextField(20); // holds first word
        JLabel goesBefore = new JLabel("    goes before    ");
        JTextField textBoxSecond = new JTextField(20); // holds second word
        JButton clearButton = new JButton("Clear");
        JLabel message = new JLabel("");
        JLabel heading = new JLabel("Fun With Words");
        JLabel intro = new JLabel("Hey kids! Want to practice your typing and word ordering skills?");
        JLabel instructions = new JLabel("Pick two words from the following list, enter them in the boxes ");
        JLabel inst2 = new JLabel("in the correct dictionary order, and then press the Done key.");
        JButton doneButton = new JButton("Done");
        JLabel dog = new JLabel(" dog          ");
        JLabel eat = new JLabel(" eat ");
        JLabel snout = new JLabel(" snout ");
        JLabel lonely = new JLabel(" lonely ");
        JLabel zeal = new JLabel(" zeal ");
        JLabel bike = new JLabel(" bike ");
        JLabel tree = new JLabel(" tree         ");
        JLabel dogma = new JLabel(" dogma ");
        JLabel pig = new JLabel(" pig ");
        JLabel desk = new JLabel(" desk ");
        JLabel zoo = new JLabel(" zoo ");
        JLabel dirt = new JLabel(" dirt ");
        JLabel ball = new JLabel(" ball             ");
        JLabel troglodyte = new JLabel(" troglodyte ");
        JLabel man = new JLabel(" man ");
        JLabel treason = new JLabel(" treason ");
        JLabel my = new JLabel(" my ");
        JLabel smile = new JLabel(" smile ");
        JLabel cat = new JLabel(" cat             ");
        JLabel cowboy = new JLabel(" cowboy ");
        JLabel woman = new JLabel(" woman ");
        JLabel supercilious = new JLabel(" supercilious   ");
        JLabel doWord = new JLabel(" do ");
        JLabel mom = new JLabel(" mom ");
        JLabel cow = new JLabel(" cow             ");
        JLabel ice = new JLabel(" ice ");
        JLabel log = new JLabel(" log ");
        JLabel superWord = new JLabel(" super ");
        JLabel scant = new JLabel(" scant ");
        JLabel nose = new JLabel(" nose ");
        // alphabetized word list so index can be used to compare order
        String[] wordsArray = {"ball", "bike", "cat", "cow", "cowboy", "desk", "dirt", "do", "dog", "dogma", "eat",
                "ice", "log", "lonely", "man", "mom", "my", "nose", "pig", "scant", "smile", "snout",
                "super", "supercilious", "treason", "tree", "troglodyte", "woman", "zeal", "zoo"};
        // "fun with words" text details
        heading.setFont(heading.getFont().deriveFont(26f));
        heading.setPreferredSize(new Dimension(WIDTH, 4 * HEIGHT));

        // panels
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel p1 = new JPanel(new GridLayout(4,1)); // intro and instruct
        JPanel p2 = new JPanel(new GridLayout(6,5)); // words
        JPanel p3 = new JPanel(new GridLayout(1,1)); // text boxes
        JPanel p4 = new JPanel(); // buttons
        JPanel p5 = new JPanel(); // & message


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;

        // mainPanel //
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 5, 8, 5));
        add(mainPanel);
        // intro & instructions panel //
        p1.add(heading);
        p1.add(intro);
        p1.add(instructions);
        p1.add(inst2);
        // words list panel //
        // row 1
        p2.add(dog);
        p2.add(tree);
        p2.add(ball);
        p2.add(cat);
        p2.add(cow);
        // row 2
        p2.add(eat);
        p2.add(dogma);
        p2.add(troglodyte);
        p2.add(cowboy);
        p2.add(ice);
        // row 3
        p2.add(snout);
        p2.add(pig);
        p2.add(man);
        p2.add(woman);
        p2.add(log);
        // row 4
        p2.add(lonely);
        p2.add(desk);
        p2.add(treason);
        p2.add(supercilious);
        p2.add(superWord);
        // row 5
        p2.add(zeal);
        p2.add(zoo);
        p2.add(my);
        p2.add(doWord);
        p2.add(scant);
        // row 6
        p2.add(bike);
        p2.add(dirt);
        p2.add(smile);
        p2.add(mom);
        p2.add(nose);
        // text boxes panel //
        p3.add(textBoxFirst);
        p3.add(goesBefore);
        p3.add(textBoxSecond);
        // buttons panel //
        p4.add(doneButton, BorderLayout.CENTER);
        p4.add(clearButton, BorderLayout.CENTER);
        // message panel //
        p5.add(message);

        // add to main Panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(p1, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(p2, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(p3, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(p4, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        mainPanel.add(p5, constraints);

        // each button performs an action when clicked (actionPerformed)
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textBoxFirst.getText();
                textBoxSecond.getText();
                boolean sameWord = false;

                if ((textBoxFirst.getText().equals("")) || ((textBoxSecond.getText().equals(""))))
                {
                    message.setText("Enter words in both boxes. Then press done.");
                }
                else
                {
                    // if first entry is in list but second entry is not
                    if (Arrays.asList(wordsArray).contains(textBoxFirst.getText())
                            && !Arrays.asList(wordsArray).contains(textBoxSecond.getText()))
                    {
                        message.setText("Second entry not in word list - check spelling.");
                    }
                    // if second entry is in list but first entry is not
                    if (!Arrays.asList(wordsArray).contains(textBoxFirst.getText())
                            && Arrays.asList(wordsArray).contains(textBoxSecond.getText()))
                    {
                        message.setText("First entry not in word list - check spelling.");
                    }
                    // if neither entry is in list
                    if (!Arrays.asList(wordsArray).contains(textBoxFirst.getText())
                            && !Arrays.asList(wordsArray).contains(textBoxSecond.getText()))
                    {
                        message.setText("Neither entry is in the word list.");
                    }
                    // if both entries are in word list //
                    if (Arrays.asList(wordsArray).contains(textBoxFirst.getText())
                            && Arrays.asList(wordsArray).contains(textBoxSecond.getText()))
                    {
                        // if same word is entered in both text boxes
                        if (textBoxFirst.getText().equals(textBoxSecond.getText()))
                        {
                            message.setText("You entered the same words. Try again.");
                            sameWord = true;
                        }
                        if (sameWord == false)
                        {
                            // if words are in wrong order try again, else Well Done!
                            if ((Arrays.asList(wordsArray).indexOf(textBoxFirst.getText()))
                                    > (Arrays.asList(wordsArray).indexOf(textBoxSecond.getText())))
                            {
                                message.setText("Wrong. Try again.");
                            }
                            else
                            {
                                message.setText("Well done!");
                            }
                        }

                    }
                }
                // clear both text boxes
                textBoxFirst.setText("");
                textBoxSecond.setText("");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // clear text boxes when Clear is clicked
                textBoxFirst.setText("");
                textBoxSecond.setText("");
            }
        });

    }
}
