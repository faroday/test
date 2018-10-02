package CategoryC;

public class CountFactory {
    private Operation operation;

    public CountFactory(){
        operation = new Count();
    }

    //выполним все возможные операторы
    public String count(String str){
        str = operation.count(str, '*');
        str = operation.count(str, '/');
        str = operation.count(str, '+');
        str = operation.count(str, '-');
        return str;
    }
}
