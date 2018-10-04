package CategoryC.files;

import CategoryC.impl.File;
import CategoryC.impl.Read;


public class ReadInput implements Read {
    //читаем ввод пользователя и делаем загрузку или сохранение данных
    @Override
    public boolean read(String str, StringBuilder builder){
        File writer = new Writer();

        String[] lines = str.split(" ");//разделим строку на слова

        if (lines[0].equals("save")){//сохранение файла
            writer.save(lines[1], builder.toString(), false);
            System.out.println("Save success!");
            return true;
        }

        if (lines[0].equals("load")){//загрузка файла
            System.out.println(writer.load(lines[1]));
            return true;
        }

        if (lines[0].equals("help")){//экран помощи
            System.out.println("Here's what I can..");
            System.out.println("You may type expression like this: 9 + pow(3,2)*4-5/7\n" +
                    "Root: >>sqrt(4)\n" +
                    "Power: >>pow(4, 2), 4 - number, 2 - power\n" +
                    "Sinus: >>sin(0.5)\n" +
                    "Save: >>save fileName, \"fileName\" is name of your file\n" +
                    "Load: >>load fileName\n" +
                    "Exit: >>exit");
            return true;
        }

        if (lines[0].equalsIgnoreCase("harry") &&
                lines[1].equalsIgnoreCase("potter")){
            String userName = writer.load("userName");
            System.out.println("Yer a programmer, " + userName + "!");
            return true;
        }

        return false;
    }
}
