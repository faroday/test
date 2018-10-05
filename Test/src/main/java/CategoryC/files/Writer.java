package CategoryC.files;

import CategoryC.impl.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//работаем с файлами
public class Writer implements File {

    //загружаем из файла
    @Override
    public String load(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            int c;
            fileName = "";
            while((c=reader.read())!=-1){
                fileName += (char)c;
            }
            return fileName;
        } catch (IOException e) {
            return "Can't load file";
        }
    }

    //сохраняем в файл
    @Override
    public void save(String fileName, String lines, boolean append) {
        try {
            FileWriter file = new FileWriter(fileName, append);
            file.write(lines);
            file.flush();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
