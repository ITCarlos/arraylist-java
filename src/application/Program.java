package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		System.out.print("How many employees?: ");
		int n = input.nextInt();

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + " :");
			System.out.print("Id: ");
			int id = input.nextInt();
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Salary: $");
			double salary = input.nextDouble();

			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}

		System.out.println();
		for (Employee x : list) {
			System.out.println(x);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = input.nextInt();
		Integer pos = position(list, id);
		if (pos == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = input.nextDouble();
			list.get(pos).increaseSalary(percent);

		}

		System.out.println();
		System.out.println("List of employees updated!: ");
		for (Employee x : list) {
			System.out.println(x);
		}

		input.close();

	}

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
