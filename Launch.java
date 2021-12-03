package Main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Launch {

    private File file;

    public void start(){

        String filePath = "src/Main/Launch.java";
        file = new File(filePath);

        try {
            String write = privateToPrivate(readFile(file));
            writeFile(write,file);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private String privateToPrivate(String str) {
        return str.replaceAll("private","public");
    }

    /**
     * Считывает текст из файле и возвращает строку с текстом
     * @param file - файл, в котором будем считывать текст
     * @return - текст из файла
     */
    private String readFile(File file) {
        String textFile = "";
        try {
            FileReader reader = new FileReader(file);
            textFile = "";
            int c;
            while ((c = reader.read()) != -1) {
                textFile += (char) c;
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return textFile;
    }

    /**
     * Записывает текст в файл
     * @param writeText - текст, который нужно записать в файл
     * @param file      - файл, в который будет записан текст
     */
    private void writeFile(String writeText, File file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(writeText);
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
