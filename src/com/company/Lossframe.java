package com.company;

import javax.swing.*;
import java.awt.*;

public class Lossframe extends JFrame {

    JLabel jLabeltext, jLabelscore;
    public Lossframe(int score)
    {
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
        setLocationByPlatform (false);
        setLocation (500, 500-150);
        setSize (300, 300);
        setLayout (new GridLayout (2, 1, 30, 0));
        String text = "You have lost!";
        jLabeltext = new JLabel (text, JLabel.CENTER);
        jLabelscore = new JLabel ("Your score:  " + Integer.toString (score), JLabel.CENTER);

        add (jLabeltext,JLabel.CENTER_ALIGNMENT);
        add (jLabelscore,JLabel.CENTER_ALIGNMENT);
    }
}
