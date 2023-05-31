import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeMap staff = new EmployeeMap();
        staff.hireEmployee(new Employee("Иван", "Сидоров", 3, 9.0));
        staff.hireEmployee(new Employee("Алексей", "Кузнецов", 5, 12.0));
        staff.hireEmployee(new Employee("Ольга", "Малинина", 1, 25.0));
        staff.hireEmployee(new Employee("Мария", "Попова", 2, 50.0));
        staff.hireEmployee(new Employee("Павел", "Соколов", 4, 32.0));
        staff.hireEmployee(new Employee("Николай", "Васильев", 1, 42.0));
        staff.hireEmployee(new Employee("Дарья", "Михайлова", 5, 100.0));
        staff.hireEmployee(new Employee("Роман", "Цветков", 4, 15.0));
        staff.hireEmployee(new Employee("Андрей", "Жуков", 3, 55.5));
        staff.hireEmployee(new Employee("Макар", "Зайцев", 2, 200.0));

        staff.showAllEmployees();

        System.out.println("Введите данные для добавления нового сотрудника:");
        Scanner in = new Scanner(System.in);
        System.out.print("Имя: ");
        String firstName = in.nextLine();
        System.out.print("Фамилия: ");
        String lastName = in.nextLine();

        System.out.print("Введите номер отдела (от 1 до 5): ");
        int deptNo = Integer.parseInt(in.nextLine());
        while (deptNo < 1 || deptNo > 5) {
            System.out.print("Вы ввели неправильный номер отдела. Попробуйте еще раз (от 1 до 5): ");
            deptNo = in.nextInt();
        }
        System.out.print("Введите зарплату: ");
        double salary = Double.parseDouble(in.nextLine());

        staff.hireEmployee(new Employee(firstName, lastName, deptNo, salary));
        staff.showAllEmployees();
        System.out.println("============================================");

        System.out.print("Какого сотрудника вы хотите уволить? Введите полное имя: ");
        String nameToWork = in.nextLine();
        staff.fireEmployee(nameToWork);
        staff.showAllEmployees();
        System.out.println("============================================");

        System.out.print("Какому сотруднику вы хотите изменить зарплату? Введите полное имя: ");
        nameToWork = in.nextLine();
        System.out.print("\n" + "Введите новую зарплату: ");
        salary = Double.parseDouble(in.nextLine());
        staff.changeSalary(nameToWork, salary);
        staff.showAllEmployees();
        System.out.println("============================================");

        System.out.print("Какого сотрудника вы хотите перевести в другой отдел? Введите полное имя: ");
        nameToWork = in.nextLine();
        System.out.print("\n" + "Введите новый отдел (от 1 до 5): ");
        deptNo = Integer.parseInt(in.nextLine());
        staff.changeSalary(nameToWork, deptNo);
        staff.showAllEmployees();
        System.out.println("============================================");

        in.close();

        System.out.println("Сотрудники по отделам");
        staff.showEmployeesByDept();
    }
}