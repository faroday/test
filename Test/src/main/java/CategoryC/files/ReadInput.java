package CategoryC.files;

import CategoryC.CountFactory;
import CategoryC.impl.File;
import CategoryC.impl.Read;


public class ReadInput implements Read {
    //читаем ввод пользователя и делаем загрузку или сохранение данных, а так же и другие команды
    @Override
    public boolean read(String str, StringBuilder builder, CountFactory factory){
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
            System.out.println("By default: basic mode\n" +
                    "Switch to boolean mode: >>bool\n" +
                    "Switch to basic mode: >>basic\n" +
                    "Save: >>save fileName, \"fileName\" is name of your file\n" +
                    "Load: >>load fileName\n" +
                    "Exit: >>exit\n\n" +
                    "In basic mode:\n" +
                    "You may type expression like this: 9 + pow(3,2)*4-5/7\n" +
                    "Root: >>sqrt(4)\n" +
                    "Power: >>pow(4, 2), 4 - number, 2 - power\n" +
                    "Sinus: >>sin(0.5)\n\n" +
                    "In boolean mode:\n" +
                    "You may type expression like this: !1 & ( 0 | 1 )\n" +
                    "true: >>1\n" +
                    "false: >>0\n" +
                    "AND: >>&\n" +
                    "OR: >>|\n" +
                    "NOT: >>!");
            return true;
        }

        if (lines[0].equalsIgnoreCase("harry") &&
                lines[1].equalsIgnoreCase("potter")){
            String userName = writer.load("userName");
            System.out.println("Yer a programmer, " + userName + "!");
            return true;
        }

        if (lines[0].equalsIgnoreCase("bool")){
            factory.booleanMode();
            return true;
        }

        if (lines[0].equalsIgnoreCase("basic")){
            factory.basicMode();
            return true;
        }

        return false;
    }
}
