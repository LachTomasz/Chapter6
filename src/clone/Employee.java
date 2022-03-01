package clone;


import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Tomek
 *
 */
public class Employee implements Cloneable{

    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {

        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{

        //Wywołanie metody Object.clone().
        Employee cloned = (Employee) super.clone();
        //var cloned = (Employee) super.clone();

        //Kopiowanie pól zmienialnych.
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Ustawia datę zatrudnienia na podany dzień.
     * @param year rok zatrudnienia
     * @param month miesiąc zatrudnienia
     * @param day dzień zatrudnienia
     */
    public void setHireDay(int year, int month, int day) {

        Date newHireDay = new GregorianCalendar(year, month-1, day).getTime();
        //var newHireDay = new GregorianCalendar(year, month-1, day).getTime();

        //Przykład zmiany pola obiektowego.
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {

        double raise = salary * byPercent;
        salary += raise;
    }

    public String toString() {
        return "Employee[name: " + name + ", salary: " + salary
                + ", hireDay: " + hireDay + "]";
    }
}
