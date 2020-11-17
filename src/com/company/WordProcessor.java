package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WordProcessor extends ReadingFile {
    String[][] words = null;

    public WordProcessor() {
        super();
        setWords();
    }

    public void setWords() {
        this.words = super.words;
    }

    public String[][] getWords() {
        return words;
    }

    public void switchLine(int firstLine, int secondLine) {
        String[][] words = getWords();
        ArrayList<String> temp = new ArrayList<>();
            Collections.addAll(temp, words[firstLine - 1]);
            words[firstLine - 1] = words[secondLine - 1];
            words[secondLine - 1] = temp.toArray(new String[0]);
        this.words = words;
        saveFile();
    }

    public void switchWords(int firstLine,int firstWord, int secondLine,int secondWord){
        String[][] words = getWords();
        String tempWord1,tempWord2;
        tempWord1=words[firstLine-1][firstWord-1];
        tempWord2=words[secondLine-1][secondWord-1];
        words[firstLine-1][firstWord-1]=tempWord2;
        words[secondLine-1][secondWord-1]=tempWord1;
        this.words=words;
        saveFile();
    }
    public void saveFile() {
        String path=getPath();
        try {
            File file = new File(path);
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter output = new BufferedWriter(filewriter);
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length; j++) {
                    output.write(words[i][j]+" ");
                }
                output.newLine();
            }
            output.close();
        } catch (IOException ioe) {
            System.out.println("Can't save file.");
        }
    }
}