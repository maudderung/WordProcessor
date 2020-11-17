package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadingFile extends WritingFile{
    String[][] words;

    public void readFile(String path) {
        Main GUI = new Main(" ");
        List<String> content = new ArrayList<>();
        String line;
        int lines=0;
        try{
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                content.add(line);
                lines++;
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(GUI.getMainPanel(), "Invalid file path.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(GUI.getMainPanel(), "I/O error.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(GUI.getMainPanel(), "No specified path.");
        }
        String[][] words = new String[lines][];
        for(int i=0;i<lines;i++){
            words[i]=(content.get(i)).split("\\t|\\s");
        }
        this.words=words;
    }

}

