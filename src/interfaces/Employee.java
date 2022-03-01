package interfaces;

/**
 * @author Tomek
 *
 */
public class Employee implements Comparable<Employee>{
    //
    private String name;
    private double salary;

    public Employee(String name, double salary) {

        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void reiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * Porównuje pracowników według wysokości pensji.
     * @param other inny objekt klasy Employee
     * @return wartość ujemna, jesli pracownik ma niższą pensję niż inny (other) pracownik,
     * 0, jeśli pensje są równe, w przeciwnym razie liczba dodatnia
     */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}