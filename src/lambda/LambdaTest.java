package lambda;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * Program demonstrujący sposób użycia wyrażeń lambda.
 * @author Tomek
 *
 */
public class LambdaTest {

    public static void main(String[] args) {

        var planets = new String[] {"Merkury", "Wenus", "Ziemia", "Mars",
                "Jowisz", "Saturn", "Uran", "Neptun"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sortowanie alfabetyczne: ");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sortowanie według długości: ");
        //Poniżej wyrażenie lambda jako drugi parametr wywołania.
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000,
                //Poniżej wyrażenie lambda jako drugi parametr wywołania.
                event -> System.out.println("Jest godzina" + new Date()));

        timer.start();

        //Utrzymuje program w działaniu aż użytkownik kliknie OK.
        JOptionPane.showMessageDialog(null,  "Zamknąć program?");
        System.exit(0);
    }
}
