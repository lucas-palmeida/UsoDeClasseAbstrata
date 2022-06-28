package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthSpending = sc.nextDouble();
				list.add(new PessoaFisica(name, annualIncome, healthSpending));
			}
			else {
				System.out.print("Number of employees: ");
				int noEmployees = sc.nextInt();
				list.add(new PessoaJuridica(name, annualIncome, noEmployees));
			}	
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double totalTaxes = 0.0;
		for(Contribuinte c : list) {
			System.out.println(c.getName() + ": $ " + String.format("%.2f", c.taxPaid()));
			totalTaxes += c.taxPaid();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f%n", totalTaxes);
		sc.close();
	}

}
