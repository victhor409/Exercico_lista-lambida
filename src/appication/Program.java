package appication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;



public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("How many employees will be register?");
		int n=sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Employee #"+(i+1)+":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.print("Salary: ");
			double salary=sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.println("Enter the employee id that will have salary increase:  ");
		int idSalary = sc.nextInt();
		
		
		/*expressao lambda onde transforma a lista em um Stream( tipo especial do java que aceita funcoes de alta ordem 
		 * chamara a funcao filter  ( filtra apenas os precados que forem colocados dentro da funcao)
		 * Predicado(elementos x ->(tal que ) x.get(id) seja igual a idSlary)
		 * pegar o primeiro (findFirst) se o primeiro nao existir volta null
		*/
		Employee emp = list.stream().filter(x -> x.getId()==idSalary).findFirst().orElse(null);
		
		
		//Integer pos = position(list,idSalary);
		
		
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percent: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		//estrutura for ech sem variavel i, para imprimir uma lista
		for(Employee e:list) {
			System.out.println(e);
		}
		
		
		sc.close();
		
	}
	//funcao recebe o staic pois esta dentro da main que também é static 
	public static Integer position(List<Employee> list ,int id) {
		for(int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
