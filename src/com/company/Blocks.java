package com.company;

import java.awt.*;

public class Blocks {

    static int width = 20;

    int first_hegiht;
    int second_height;

    Rectangle first,second;
    Blocks(int height, int frame_maxwidth)
    {
        first_hegiht = 100 + (int) (Math.random () * (height-250));
        second_height = (height - first_hegiht) -150;

        first = new Rectangle (frame_maxwidth,height-first_hegiht,width,first_hegiht);
        second = new Rectangle (frame_maxwidth, 0,width,second_height);
    }

    public void move_blocks(double delta)
    {
        first.x = (int) (first.getX () - 2.5*delta);
        second.x = (int) ( second.getX () -2.5*delta);

    }

    public boolean check_if_intersects(Rectangle bird_rectangle)
    {
        if (bird_rectangle.intersects (first) || bird_rectangle.intersects (second)) {
            return true;
        } else {
            return  false;
        }

    }
}
