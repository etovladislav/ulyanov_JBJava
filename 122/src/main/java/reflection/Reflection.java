package reflection;


import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("Task10");
            Object newObject = aClass.newInstance();
            Method[] methods = aClass.getDeclaredMethods();
            System.out.println(methods[0]);
            methods[0].invoke(newObject, 10);
            methods[1].invoke(newObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
