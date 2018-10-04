package CategoryC.impl;

//сохранение и загрузка выполненных операций

public interface File {

    String load(String fileName);

    void save(String fileName, String lines, boolean append);
}
