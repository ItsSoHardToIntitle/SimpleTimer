package com.zz.timer;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

/**
 * @author Zhang Zhen
 * @time 2020��7��11�� ����3:15:10
 */
public class Time3 implements Runnable {

    @Override
    public void run() {
        boolean flag = false;
        try {
            int setTime = GUI.setTime;
            TimeUnit.MINUTES.sleep(setTime);
            Timer.playVideo();
            int op = JOptionPane.showConfirmDialog(null, setTime + "min��ʱ�������Ƿ������ʱ?", "��ʾ",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                // ������ʱ5min��ʱ
                flag = true;
                while (flag) {
                    TimeUnit.MINUTES.sleep(5);
                    Timer.playVideo();
                    int op2 = JOptionPane.showConfirmDialog(null, "5min��ʱ�������Ƿ������ʱ?", "��ʾ",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if (op2 == JOptionPane.YES_OPTION) {
                        // ������ʱ5min��ʱ
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            } else {
            }
        } catch (InterruptedException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
    }

}
