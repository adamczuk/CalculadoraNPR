package view;

import java.util.Scanner;

import controller.NPRController;

public class Main {

	public static void main(String[] args) {
		NPRController nprController = new NPRController();

		Scanner sc = new Scanner(System.in);
		String entrada;
		do {
			System.out.println("\nInserir um numero ou operação. Digite x para sair\n");
			entrada = sc.nextLine();
			if (entrada.equals("x")) {
				break;
			} else {
				nprController.inserirValor(entrada);
			}

		} while (!entrada.equals("x"));

		sc.close();
	}

}
