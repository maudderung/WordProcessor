package com.company;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFile{
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void writeSample() {
        Main GUI = new Main(" ");
        String path=getPath();
        String word = "word";
        try {
            File file = new File(path);
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter output = new BufferedWriter(filewriter);
            for (int i = 0; i < 50; i++) {
                output.write(word + (i + 1) + " ");
                if (i == 17)
                    output.newLine();
                if (i == 33)
                    output.newLine();
                if (i == 47)
                    output.newLine();
            }
            output.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(GUI.getMainPanel(), "Invalid file");
            System.out.println("Invalid file.");
        }catch(NullPointerException npe){
        JOptionPane.showMessageDialog(GUI.getMainPanel(),"No specified path");
    }
    }

    public void writeText(String text) {
        Main GUI = new Main(" ");
        String path=getPath();
        try {
            File file = new File(path);
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter output = new BufferedWriter(filewriter);
                output.write(text);
            output.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(GUI.getMainPanel(), "Invalid file.");
            System.out.println("Invalid file.");
        }catch(NullPointerException npe){
            JOptionPane.showMessageDialog(GUI.getMainPanel(),"No specified path");
        }
    }
}