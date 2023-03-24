package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
			
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// usando uma lista génerica no qual eu especifico cada tipo de objeto 
		// da minha lista, que no caso vai ser o employee
		List<Employee> list = new ArrayList();
		
		
		
		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			
			System.out.println();
			System.out.printf("Employee #%d: %n", i+1);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			// enquanto o id que eu digitei existe na lista
			while(hasId(list, id)) {
				System.out.println("Id already taken! Try again");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary:");
			Double salary = sc.nextDouble();
			
			// instanciando dentro da memória um novo objeto Employee com estes dados 
			// que digitei
			Employee emp = new Employee(id, name, salary);
			
			// adicionando na lista o meu objeto
			list.add(emp);
			
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
		
		// Integer pos = position(list, idsalary);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		for (Employee e : list) {
			System.out.println(e);
		}
		
		sc.close();
	}
	
	// função auxiliar
	public static Integer position(List<Employee> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}