package controller;

import br.edu.fateczl.adamczuk.pilhaint.Pilha;

public class NPRController {

	private Pilha stack = new Pilha();

	public void inserirValor(String entrada) {
		try {
			int entradaNumerica = Integer.parseInt(entrada);
			stack.push(entradaNumerica);
			System.out.println("\nValor empilhado: " + entradaNumerica);

		} catch (NumberFormatException e) {
			try {
				int resultado = npr(entrada);
				System.out.println("\nResultado: " + resultado);
			} catch (Exception e1) {
				System.err.println("\n" + e1.getMessage());
			}
		}

	}

	private int npr(String op) throws Exception {
		int resultado = 0;

		if (stack.size() >= 2) {
			int valorTopo;

			switch (op) {

			case "+":
				valorTopo = stack.pop();
				resultado = valorTopo + stack.pop();
				break;

			case "*":
				valorTopo = stack.pop();
				resultado = valorTopo * stack.pop();
				break;

			// para - e /, valorTopo = operador do lado direito
			// fazer um novo pop para pegar o lado esquerdo
			case "-":
				valorTopo = stack.pop();
				resultado = stack.pop() - valorTopo;
				break;

			case "/":
				valorTopo = stack.pop();
				if (valorTopo == 0) {
					throw new Exception("\nImpossivel dividir por 0");
				} else {
					resultado = stack.pop() / valorTopo;
				}
				break;
			default:
				throw new Exception("\nO valor inserido não é válido");
			}
		} else {
			if (!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))) {

				throw new Exception("\nO valor inserido não é válido");
			}

			throw new Exception("\nValores insuficientes na pilha");

		}

		stack.push(resultado);
		return resultado;
	}
}
