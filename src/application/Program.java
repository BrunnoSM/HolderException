package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account acc = new Account();

		System.out.println("Informe os dados da conta: ");
		System.out.print("Número: ");
		int accountNumber = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();

		acc = new Account(accountNumber, holder, balance, withdrawLimit);

		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double withdraw = sc.nextDouble();

		try {
			acc.withdraw(withdraw);
			System.out.printf("Novo saldo: %.2f", acc.getBalance());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
