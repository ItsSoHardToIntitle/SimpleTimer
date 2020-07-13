package com.zz.timer;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

/**
 * @author Zhang Zhen
 * @time 2020年7月11日 下午3:14:52
 */
public class Time implements Runnable {

    @Override
    public void run() {
        boolean flag = false;
        try {
            TimeUnit.MINUTES.sleep(20);
            Timer.playVideo();
            int op = JOptionPane.showConfirmDialog(null, "20min计时结束，是否继续加时?", "提示",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                // 继续加时5min计时
                flag = true;
                while (flag) {
                    TimeUnit.MINUTES.sleep(5);
                    Timer.playVideo();
                    int op2 = JOptionPane.showConfirmDialog(null, "5min加时结束，是否继续加时?", "提示",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if (op2 == JOptionPane.YES_OPTION) {
                        // 继续加时5min计时
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            } else {
            }
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

}
