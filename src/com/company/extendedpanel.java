package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class extendedpanel extends JPanel {
//this will be panel where everything will be located

    Bird flappy_bird;

    ArrayList<Blocks> blocksArrayList;
    public extendedpanel()  {

        flappy_bird = new Bird ();
        blocksArrayList =  new ArrayList<>();
        blocksArrayList.add (new Blocks (Flappyframe.height,Flappyframe.width));
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect (0,0,2000,2000);
        g2.drawImage (flappy_bird.getBird_image (),flappy_bird.getX_cordinate (), (int) flappy_bird.getY_cordinate (),this);

        g2.setColor (Color.green);
        for (int i = 0; i < blocksArrayList.size ( ); i++) {

            g2.setColor (Color.green);
            g2.draw (blocksArrayList.get (i).first);
            g2.fill (blocksArrayList.get (i).first);
            g2.setColor (Color.blue);
            g2.draw (blocksArrayList.get (i).second);
            g2.fill (blocksArrayList.get (i).second);

        }

    }

    public void update_game_logic(double delta, int height,Flappyframe game_instance)
    {
        double bird_change_in_Y = 3;
        if(flappy_bird.getY_cordinate () > height)
        {

        }
        else
        {
            flappy_bird.setY_cordinate (   flappy_bird.getY_cordinate ()   +  (bird_change_in_Y*delta) );
        }
        for (int i = 0; i < blocksArrayList.size ( ); i++) {
            blocksArrayList.get (i).move_blocks (delta);

        }

        if(blocksArrayList.get (blocksArrayList.size ()-1).first.getX ()< Flappyframe.width -200)
        {
            blocksArrayList.add (new Blocks (Flappyframe.height,Flappyframe.width));
        }
        if (blocksArrayList.get (0).check_if_intersects (flappy_bird.get_Rectangle ( )) == true) {
            System.out.println ("You have lost" );
            game_instance.setGame_running_value (false);
            new Lossframe (game_instance.getScore ());
        }

        if(blocksArrayList.get(0).first.getX () < 0)
        {
            blocksArrayList.remove (0);
            game_instance.setScore (game_instance.getScore ( ) + 1);
        }

    }
    }
