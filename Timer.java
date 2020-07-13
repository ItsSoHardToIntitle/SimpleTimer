package com.zz.timer;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.UIManager;

/**
 * @author Zhang Zhen
 * @time 2020年7月11日 下午12:11:46
 */
public class Timer {
    public static void main(String[] args) {
        new GUI();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public static void playVideo() {
        @SuppressWarnings("unused")
        JApplet applate = new JApplet();
        URL urlAudio = null;
        String dir = System.getProperty("user.dir");
        File f = new File(dir + "//提示音.wav");
        try {
            urlAudio = f.toURL();
        } catch (MalformedURLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        AudioClip ac = Applet.newAudioClip(urlAudio);
        ac.play();
    }
}
