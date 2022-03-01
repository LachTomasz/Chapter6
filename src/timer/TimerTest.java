package timer;

/**
 * @author Tomek
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class TimerTest {

    public static void main(String[] args) {

        //TimePrinter listener = new TimePrinter();
        var listener = new TimePrinter();

        //utworzenie zegara wywołującego obiekt nasluchujacy
        //co sekunde
        //Timer timer = new Timer(1000, listener);
        var timer = new Timer(1000, listener);
        timer.start();

        //program ma dzialac, dopoki uzytkownik nie nacisnie przycisku OK
        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    public void actionPerformed(ActionEvent event){
        System.out.println("Kiedy usłyszysz dzwiek, bedzie godzina "
                + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}