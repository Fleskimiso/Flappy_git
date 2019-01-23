package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;

public class Flappyframe extends JFrame implements KeyListener {

    //variables
    extendedpanel application_panel;
    static int width = 800;
    static int height = 500;

    final int TARGETED_FPS = 60;
    long OPTIMAL_TIME;
    private boolean game_running;
    private int score=0;
    //ctor

    //overloaded ctor
    public Flappyframe() {
        this (width, height);
    }

    //ctor
    public Flappyframe(int x_size, int y_size) {
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setSize (x_size, y_size);
        setVisible (true);
        setLayout (new GridLayout (1, 1));

        application_panel = new extendedpanel ( );
        Container container = getContentPane ( );
        container.add (application_panel);

        this.addKeyListener (this);
        //now thigns with game loops

        OPTIMAL_TIME = (long) ( 1000000000/ TARGETED_FPS);
        game_running = true;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //  System.out.println (e.getKeyChar () + " was pressed" );
        if (e.getKeyChar ( ) == ' ') {
            System.out.println (this.application_panel.flappy_bird.getX_cordinate ( ));
            System.out.println ("Y cordiante  " + this.application_panel.flappy_bird.getY_cordinate () );
            this.application_panel.flappy_bird.move_y_by_10 ();

        }
    }


        public void setGame_running()
        {

            long lastLoopTime = System.nanoTime ();
            long lastFpsTime = 0;
            int fps = 0;
            while (game_running == true) {
                // work out how long its been since the last update, this
                // will be used to calculate how far the entities should
                // move this loop
                long now = System.nanoTime ( );
                long updateLength = now - lastLoopTime;
                lastLoopTime = now;
                double delta = updateLength / ((double) OPTIMAL_TIME);

                // update the frame counter
                lastFpsTime += updateLength;
                fps++;

                // update our FPS counter if a second has passed since
                // we last recorded
                if (lastFpsTime >= 1000000000) {
                    System.out.println ("(FPS: " + fps + ")");
                    lastFpsTime = 0;
                    fps = 0;
                }

                // update the game logic
                this.application_panel.update_game_logic (delta, this.getHeight (),this);

                // draw everyting
                this.application_panel.repaint ();

                // we want each frame to take 10 milliseconds, to do this
                // we've recorded when we started the frame. We add 10 milliseconds
                // to this and then factor in the current time to give
                // us our final value to wait for
                // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
                try {
                    //Thread.sleep((lastLoopTime - System.nanoTime ( ) + OPTIMAL_TIME) / 1000000);
                    Thread.sleep (10);
                } catch (InterruptedException e) {
                    e.printStackTrace ( );
                }
            }


        }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setGame_running_value(boolean vaule) {
        game_running = vaule;
    }

    public void setScore(int value) {
        this.score = value;
    }
    public  int getScore()
    {
        return this.score;
    }

}
