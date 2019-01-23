package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EventQueue.invokeLater (new Runnable ( ) {
            @Override
            public void run() {
                Flappyframe flappyframe = new Flappyframe ( );

                Thread thread = new Thread (new Runnable ( ) {
                    @Override
                    public void run() {
                        flappyframe.setGame_running ();
                    }
                });

                thread.start ();

            }
        });
    }
}
