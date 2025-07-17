package target2024.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@ToString
@Getter
class Employee {
    String name;
    Integer salary;
}

public class TopNEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Charlie", 6000),
                new Employee("David", 7000),
                new Employee("Eve", 5000),
                new Employee("Frank", 8000)
        );

        List<Employee> topEmployees = getTopEmployeesBasedOnSalary(employees, 2); // 2nd highest salary
//        topEmployees.forEach(System.out::println);
        
        topEmployees.forEach(employee -> {
        	System.out.println(employee);
        });
    }

    private static List<Employee> getTopEmployeesBasedOnSalary(List<Employee> employees, int rank) {
        // Step 1: Get unique salaries in descending order
        List<Integer> sortedUniqueSalaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Step 2: Check if rank is valid
        if (rank <= 0 || rank > sortedUniqueSalaries.size()) {
            return Collections.emptyList();
        }

        // Step 3: Get the salary at the given rank
        Integer targetSalary = sortedUniqueSalaries.get(rank - 1);

        // Step 4: Filter employees with the target salary
        return employees.stream()
                .filter(e -> e.getSalary().equals(targetSalary))
                .collect(Collectors.toList());
    }
}
