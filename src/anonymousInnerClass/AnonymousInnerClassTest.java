package anonymousInnerClass;

import java.awt.*;
import java.time.*;
import javax.swing.*;

/**
 * Ten program demonstruje zastosowanie anonimowych klas wewnętrznych.
 * @author Tomek
 *
 */
public class AnonymousInnerClassTest {

    public static void main(String[] args) {

        var clock = new TalkingClock();
        clock.start(1000, true);
        //Niech program działa, dopóki użytkownik nie wciśnie przycisku OK.
        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);

    }

}

/**
 * Zegar drukujący informacje o czasie w równych odstępach czasu.
 */
class TalkingClock{

    /**
     * Uruchamia zegar.
     * @param interval odstęp czasu pomiędzy kolejnymi komunikatami (w milisekundach)
     * @param beep wartość true oznacza, że dzwięk ma być odtwarzany
     */

    //Wariant z listing 6.8 str 323

//	public void start (int interval, boolean beep) {
//
//		var listener = new ActionListener() {
//
//			public void actionPerformed(ActionEvent event) {
//
//				System.out.println("Kiedy usłyszysz dzwięk, będzie godzina: "
//						+ Instant.ofEpochMilli(event.getWhen()));
//				if(beep) Toolkit.getDefaultToolkit().beep();
//			}
//		};
//
//		var timer = new Timer(interval, listener);
//		timer.start();
//
//	}

    //Wariant z zastosowaniem wyrażenia lambda

    public void start(int interval, boolean beep) {

        var timer = new Timer(interval, event ->
        {
            System.out.println("Kiedy usłyszysz dzwięk, będzie godzina: "
                    + Instant.ofEpochMilli(event.getWhen()));
            if(beep) Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
    }
}
