package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird  {
    private int x_cordinate;
    private double y_cordinate;



    private BufferedImage bird_image;

    //ctor for image
    public Bird() {
        x_cordinate = 100;
        y_cordinate = Flappyframe.height/2;

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

    public int getX_cordinate() {
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


    public void move_y_by_10() {
        this.y_cordinate-= 50;
    }
    public Rectangle get_Rectangle()
    {
        return new Rectangle (this.x_cordinate, (int) this.y_cordinate, bird_image.getWidth ( ), bird_image.getHeight ( ));
    }

}
