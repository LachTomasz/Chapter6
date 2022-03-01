package staticInnerClass;

/**
 * Ten program demonstruje zastosowanie statycznych klas wewnętrznych.
 * @author Tomek
 *
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {

        var values = new double[20];
        for(int i = 0; i < values.length; i++)
            values[i] = 100 * Math.random();

        ArrayAlg.Pair p = ArrayAlg.minimax(values);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * Para liczb zmiennoprzecinkowych.
     */
    public static class Pair {
        private double first;
        private double second;

        /*
         * Tworzy parę dwóch liczb zmiennoprzecinkowych.
         * @param first pierwsza liczba
         * @param second druga liczba
         */
        public Pair (double first, double second) {
            this.first = first;
            this.second = second;
        }

        /**
         * Zwraca pierwszą liczbę pary.
         * @return pierwsza liczba
         */
        public double getFirst() {
            return first;
        }

        /**
         * @return druga liczbe
         */
        public double getSecond() {
            return second;
        }
    }

    /**Znajduje największa i najmniejsza wartość tablicy.
     * @param values tablica liczb zmiennoprzecinkowych.
     * @return para liczb, w której pierwsza liczba określa wartość najmniejsza,
     * a druga największą
     */

    public static Pair minimax(double[] values) {

        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for(double v : values) {
            if(min > v) min = v;
            if(max < v) max = v;
        }
        return new Pair(min,max);
    }
}