//You have two classes: Employee (name: String, salary: Long)
// and Department (name: String, code: String, employees: List<Employee>).
// Both classes have getters for all fields with the corresponding names
// (getName(), getSalary(), getEmployees() and so on).
//
//        Write a method using Stream API that calculates
//        the general number of employees
//        with salary >= threshold for all departments whose code
//        starts with string "111-" (without "").
//        mapResult.entrySet().forEach(m -> {
//            System.out.println("code: " + m.getKey());
//            m.getValue().stream()
//                    .map(e -> "name: " + e.getName() + "salary: " + e.getSalary())
//                    .forEach(System.out::println);
//        });

public class CalcNumberOfEmployees {
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.getCode().matches("111-\\d+"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(e -> e.getSalary() >= threshold)
                .count();
    }
}



