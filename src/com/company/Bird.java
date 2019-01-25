package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird implements  Runnable {
    private double x_cordinate;
    private double y_cordinate;

    Thread the_runner = new Thread (this);

    boolean gravity = true;

    @Override
    public void run() {
        this.going_upwards ();
    }

    class accerel
     { double acceleration;
       double velocity;
       //ctor
       public accerel()
         {
             acceleration = 0.15;
             velocity = 1.8;
         }

       public void change_velocity(double delta)
       {
           velocity+= acceleration*delta;
       }
     }



     accerel speed_control;
    private BufferedImage bird_image;

    //ctor for image
    public Bird() {
        x_cordinate = 100;
        y_cordinate = Flappyframe.height/2;

        speed_control = new accerel ();

        try {
            bird_image = ImageIO.read (new File ("resources/New Piskel.png"));
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        finally {
            System.out.println (
                    "width and height " + bird_image.getWidth () + "  " + bird_image.getHeight ()
            );
        }

    }

    //basic chagning position function

    public double getY_cordinate() {
        return y_cordinate;
    }

    public void setY_cordinate(double y_cordinate) {
        this.y_cordinate = y_cordinate;
    }

    public double getX_cordinate() {
        return x_cordinate;
    }

    public void setX_cordinate(int x_cordinate) {
        this.x_cordinate = x_cordinate;
    }

    public BufferedImage getBird_image() {
        return bird_image;
    }

    public void setBird_image(BufferedImage bird_image) {
        this.bird_image = bird_image;
    }


    public Rectangle get_Rectangle()
    {
        return new Rectangle ((int) this.x_cordinate, (int) this.y_cordinate, bird_image.getWidth ( ), bird_image.getHeight ( ));
    }

    public void position_actualization(double delta)
    {
       if(gravity == true)
       {
           this.speed_control.change_velocity (delta);

           this.y_cordinate += this.speed_control.velocity * delta;
       }

    }

    public void jump()
    {
        this.speed_control.velocity = 1.8;
        System.out.println ( "Shit happens" );
         if(gravity == true)
         {
             new Thread (this).start ();
         }
    }

    private void going_upwards()
    {
            gravity = false;
        System.out.println ( " The gravity is false" );
        System.out.println ( " The timein nanos:  " + System.nanoTime () );
        System.out.println ( " The y position:  " + this.y_cordinate );
            //the time part
            //measuring the time at the beggining
        /*
        * the jump time is 0.5 s
        * change in postion is 50
        * at that time the gravtiy and velocity downwards does  not work
        * raw change in y position
        * time is measured in nanoseconds
        * */
        //the coding part
        long start_time = System.nanoTime ();
        long last_time;
        long current_time = System.nanoTime ();
        while (System.nanoTime ( ) - start_time < 250_000_000) {

            last_time = current_time;
            try {
                Thread.sleep (1);
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
            current_time = System.nanoTime ();
            double delta = (double) 1/(current_time - last_time);
            System.out.println ( "The delta:  " + delta   );
            this.y_cordinate -= 0.8 ;
            //this may change
        }
        //setting gravity to true
        gravity = true;
    }
}
