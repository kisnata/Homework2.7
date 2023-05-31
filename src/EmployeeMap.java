import java.util.*;
public class EmployeeMap {
    private Map<String, Employee> staff = new HashMap<>();

        public void hireEmployee(Employee employee) {
        staff.put(employee.getFullName(), employee);
    }
    public void fireEmployee(String fullName) {
        if (staff.containsKey(fullName)) {
            staff.remove(fullName);
        } else {
            System.out.println("\n" + "Нет такого работника");
        }
    }

    public void fireEmployee(int id) {
        String fullName = "";
        for (var employee : staff.values()) {
            if (employee.getId() == id) {
                fullName = employee.getFullName();
            }
        }
        if (fullName.isEmpty()) {
            System.out.println("Нет сотрудника с данным id");
        } else {
            staff.remove(fullName);
        }
    }
    public void changeDepartment(String fullName, int newDepartmentNumber) {
        if (staff.containsKey(fullName)) {
            staff.get(fullName).setDepartment(newDepartmentNumber);
        } else {
            System.out.println("Нет такого работника");
        }
    }

    public void changeSalary(String fullName, double salary) {
        if (staff.containsKey(fullName)) {
            staff.get(fullName).setSalary(salary);
        } else {
            System.out.println("Нет такого работника");
        }
    }

    public void indexSalaries(int percent) {
        for (var e : staff.entrySet()) {
            double newSalary = e.getValue().getSalary();
            newSalary = newSalary + newSalary * percent / 100.0;
            e.getValue().setSalary(newSalary);
        }
    }

    public void showAllEmployees() {
        staff.forEach((k, v) -> System.out.println(v));
    }
    public void showFullNames() {
        for (var e : staff.values()) {
            System.out.println(e.getFullName());
        }
    }

    public void showEmployeesByDept() {
        var list = new ArrayList<>(staff.values());
        list.sort(Comparator.comparingInt(Employee::getDepartment));
        list.forEach(System.out::println);
    }

    public void showEmployeesOfDept(int deptNumber) {
        var list = staff.values();
        list.forEach(e -> {
            if (e.getDepartment() == deptNumber) {
                System.out.println(e);
            }
        });
    }

    public double calculateFullPayments() {
        double result = 0;
        for (var e : staff.values()) {
            result += e.getSalary();
        }
        return result;
    }

    public Employee getMinPaidEmployee() {
        var list = staff.values();
        return Collections.min(list, Comparator.comparingDouble(Employee::getSalary));
    }

    public Employee getMaxPaidEmployee() {
        var list = staff.values();
        return Collections.max(list, Comparator.comparingDouble(Employee::getSalary));
    }

    public double getAverageSalary() {
        return calculateFullPayments() / staff.size();
    }

    public Employee findMinPaidByDep(int deptNumber) {
        var list = new ArrayList<>(staff.values());
        list.removeIf(e -> e.getDepartment() != deptNumber);
        return Collections.min(list, Comparator.comparingDouble(Employee::getSalary));
    }

    public Employee findMaxPaidByDep(int deptNumber) {
        var list = new ArrayList<>(staff.values());
        list.removeIf(e -> e.getDepartment() != deptNumber);
        return Collections.max(list, Comparator.comparingDouble(Employee::getSalary));
    }

    public double findTotalSalaryByDep(int deptNumber) {
        double total = 0.0;
        for (var e : staff.values()) {
            if (e.getDepartment() == deptNumber) {
                total += e.getSalary();
            }
        }
        return total;
    }

    public double findAverageSalaryByDep(int deptNumber) {
        double total = 0.0;
        int count = 0;
        for (var e : staff.values()) {
            if (e.getDepartment() == deptNumber) {
                total += e.getSalary();
                count++;
            }
        }
        return total / count;
    }

    public void indexSalaryByDept(int deptNumber, int percent) {
        for (var e : staff.values()) {
            if (e.getDepartment() == deptNumber) {
                double salary = e.getSalary();
                salary += salary * percent / 100.0;
                e.setSalary(salary);
            }
        }
    }

    public void showEmployeesWithLowerSalary(double amount) {
        for (var e : staff.values()) {
            if (e.getSalary() < amount) {
                System.out.println("id: " + e.getId() + ", name: " + e.getFullName()
                        + ", salary: " + e.getSalary());
            }
        }
    }

    public void showEmployeesWithHigherSalary(double amount) {
        for (var e : staff.values()) {
            if (e.getSalary() >= amount) {
                System.out.println("id: " + e.getId() + ", name: " + e.getFullName()
                        + ", salary: " + e.getSalary());
            }
        }
    }

}
