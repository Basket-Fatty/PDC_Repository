package com.mycompany.pdcproject.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {

    static Player player = null;

    public MusicPlayer() throws FileNotFoundException, JavaLayerException {
//           File file = new File("music/123");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedInputStream stream = new BufferedInputStream(fis);
//		Player player = new Player(stream);
//		player.play(); 
    }

//    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
//
//    }

    public static void play() {
        new Thread(new Runnable() {
            public volatile boolean exit = false;

            @Override
            public void run() {
//                            while(!exit)
                {

                    try {
                        File file = new File("Music/123");
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream stream = new BufferedInputStream(fis);
                        player = new Player(stream);
                        player.play();
                    } catch (Exception e) {

                        // TODO: handle exception
                    }
                }
            }
        }).start();

    }

    public static void stopMusic() {
        player.close();
    }

}
