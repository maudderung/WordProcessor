package com.company;

import javax.swing.*;

public class Main extends JFrame {
    WordProcessor write = new WordProcessor();
    private JPanel mainPanel;
    private JButton a1ChoosePathButton;
    private JButton a2LoadAFileButton;
    private JButton a3SwitchLinesIndex1Button;
    private JButton a5SwitchWordsLine1Button;
    private JButton a6PrintWordsButton;
    private JButton a2WriteYourOwnButton;
    private JButton a7WriteAPremadeButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Main(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        a1ChoosePathButton.addActionListener(e -> {
            String path = textField1.getText();
            write.setPath(path);
        });
        a2LoadAFileButton.addActionListener(e ->
                write.readFile(write.getPath())
        );
        a3SwitchLinesIndex1Button.addActionListener(e -> {
            write.setWords();
            try {
            String input = textField2.getText();
            String[] numbers = input.split(" ");
            int firstLine = Integer.parseInt(numbers[0]);
            int secondLine = Integer.parseInt(numbers[1]);
                write.switchLine(firstLine, secondLine);
            } catch (ArrayIndexOutOfBoundsException arrayexception) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid index.");
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(mainPanel, "No words.");
            } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(mainPanel, "No indexes.");
        }
        });
        a6PrintWordsButton.addActionListener(e -> {
            write.readFile(write.getPath());
            write.setWords();
            String[][] words = write.getWords();
            textArea1.setText("");
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length; j++) {
                    textArea1.append(words[i][j] + " ");
                }
                textArea1.append("\n");
            }
        });
        a2WriteYourOwnButton.addActionListener(e -> {
            String input = textArea2.getText();
            write.writeText(input);
        });
        a5SwitchWordsLine1Button.addActionListener(e -> {
            write.setWords();
            try {
            String input = textField3.getText();
            String[] numbers = input.split(" ");
            int firstLine = Integer.parseInt(numbers[0]);
            int firstWord = Integer.parseInt(numbers[1]);
            int secondLine = Integer.parseInt(numbers[2]);
            int secondWord = Integer.parseInt(numbers[3]);
                write.switchWords(firstLine, firstWord, secondLine, secondWord);
            } catch (ArrayIndexOutOfBoundsException arrayexception) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid index.");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid number format.");
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(mainPanel, "No words.");
            }
        });
        a7WriteAPremadeButton.addActionListener(e -> write.writeSample());
    }

    public static void main(String[] args) {
        JFrame frame = new Main("Word Processor");
        frame.setVisible(true);
    }
}