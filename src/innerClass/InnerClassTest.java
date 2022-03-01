package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;
//import javax.swing.Timer;


/**
 * Ten program demonstruje sposób użycia klas wewnętrznych.
 * @author Tomek
 *
 */
public class InnerClassTest {

    public static void main(String[] args) {

        var clock = new TalkingClock(1000, true);
        clock.start();

        //Niech program działa, dopóki użytkownik nie wciśnie przycisku OK.
        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}

/**
 * Zegar drukujący informacje o czasie w równych odstępach czasu.
 */
class TalkingClock{
    private int interval;
    private boolean beep;

    /**
     * Tworzy obiekt TalkingClock.
     * @param interval odstęp czasu pomiędzy kolejnymi komunikatami (w milisekundach)
     * @param beep wartość true oznacza, że dzwięk ma być odtwarzany
     */
    public TalkingClock(int interval, boolean beep) {

        this.interval = interval;
        this.beep = beep;

    }

    /**
     * włączenie zegara
     */

    public void start() {

        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener{

        public void actionPerformed(ActionEvent event) {

            System.out.println("Kiedy usłyszysz dzwięk, będzie godzina "
                    + Instant.ofEpochMilli(event.getWhen()));
            if(beep) Toolkit.getDefaultToolkit().beep();//w if - TalkingClock.this.beep
        }
    }
}
