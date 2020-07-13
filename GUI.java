package com.zz.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Zhang Zhen
 * @time 2020年7月11日 下午12:11:31
 */
public class GUI {
    public static int setTime = 0;

    public GUI() {
        JFrame frame = new JFrame("Timer");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // 逻辑：
        /*
         * Step1. 按下计时按钮，开始按照设定时间计时； Step2. 计时结束，弹窗提示； Step3. 点击弹窗确定，加时5min，继续计时；
         */
        JButton Button = new JButton("20min");
        Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Time()).start();
            }
        });
        panel.add(Button);

        JButton Button2 = new JButton("25min");
        Button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Time2()).start();
            }
        });
        panel.add(Button2);

        JButton Button3 = new JButton("自定义");
        Button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 要求用户输入 自定义的时间
                inputTime();
            }

            private void inputTime() {
                JFrame frame = new JFrame();
                frame.setSize(350, 200);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JLabel label = new JLabel("自定义时间");
                panel.add(label);
                JTextField textField = new JTextField(16);
                panel.add(textField);
                JButton button = new JButton("确定");
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setTime = Integer.valueOf(textField.getText());
                        new Thread(new Time3()).start();
                        frame.dispose();
                    }
                });
                panel.add(button);
                frame.setVisible(true);
            }
        });
        panel.add(Button3);
    }
}
