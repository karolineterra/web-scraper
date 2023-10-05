package com.scraping;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteFile {
    private String content;

    public WriteFile(String content) {
        this.content = content;
    }

    protected void startWriting() {
        String fileName = "resultados.txt";
        String contentText = this.content;

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(contentText);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo.");
        }

    }
}
