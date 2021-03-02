package dop;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            initCalc(Calc.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static  <T>void initCalc(Class<T> clazz) throws Exception{
        Method[] methods = clazz.getMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(Math.class)){
                Math math = method.getAnnotation(Math.class);
                Constructor<T> constructor = clazz.getConstructor();
                T element = constructor.newInstance();
                Object[] param = {
                        math.num1(),
                        math.num2()
                };
                method.invoke(element, param);
            }
        }
    }
}
