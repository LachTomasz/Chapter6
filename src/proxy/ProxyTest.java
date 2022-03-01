package proxy;

import java.lang.reflect.*;
import java.util.*;
/**
 * Ten program demonstruje użycie klas pośredniczących.
 * @author Tomek
 *
 */
public class ProxyTest {

    public static void main(String[] args) {

        var elements = new Object[1000];

        //Wstawianie do tablicy obiektów pośredniczących liczb całkowitych
        //z przedziału 1 - 1000.
        for (int i = 0; i < elements.length; i ++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[] {Comparable.class},
                    handler);
            elements[i] = proxy;
        }

        //Tworzenie losowej liczby całkowitej.
        Integer key = new Random().nextInt(elements.length) + 1;

        //Szukanie liczby.
        int result = Arrays.binarySearch(elements, key);

        //Drukowanie dopasowanej wartości, jeśłi zostanie znaleziona.
        if(result >= 0) System.out.println(elements[result]);
    }
}

/**
 * Objekt obsługujący wywołanie, który drukuje nazwę metody i parametry,
 * a następnie wywołuje oryginalną metodę.
 */
class TraceHandler implements InvocationHandler {

    private Object target;

    /**
     * Tworzy objekt TraceHandler.
     * @param target parametr niejawny wywołania metody.
     */
    public TraceHandler(Object target) {

        this.target = target;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {

        //Drukowanie argumentu niejawnego.
        System.out.print(target);

        //Drukowanie nazwy metody
        System.out.print(", " + m.getName() + "(");

        //Drukowanie argumentów jawnych.
        if(args !=  null) {
            for(int i = 0; i < args.length; i ++) {
                System.out.print(args[i]);
                if(i < args.length -1) System.out.print(", ");
            }
        }

        System.out.println(")");

        //rzeczywiste wywołanie metody
        return m.invoke(target, args);
    }
}