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
 * @time 2020��7��11�� ����12:11:31
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
        // �߼���
        /*
         * Step1. ���¼�ʱ��ť����ʼ�����趨ʱ���ʱ�� Step2. ��ʱ������������ʾ�� Step3. �������ȷ������ʱ5min��������ʱ��
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

        JButton Button3 = new JButton("�Զ���");
        Button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Ҫ���û����� �Զ����ʱ��
                inputTime();
            }

            private void inputTime() {
                JFrame frame = new JFrame();
                frame.setSize(350, 200);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JLabel label = new JLabel("�Զ���ʱ��");
                panel.add(label);
                JTextField textField = new JTextField(16);
                panel.add(textField);
                JButton button = new JButton("ȷ��");
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
