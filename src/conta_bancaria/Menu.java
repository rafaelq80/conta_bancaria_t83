package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
		// Instanciar Objetos da Classe Conta
		
		/*System.out.println("\n\nInstanciar Objeto da Classe Conta");
		
		Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 500000.00f);
		
		Conta c2 = new Conta(2, 123, 2, "Priscila Lins", 500000.00f);
		
		
		System.out.println("O Saldo da conta é: " + c1.getSaldo());
		
		c1.setSaldo(600000.00f);
		
		System.out.println("O Saldo da conta é: " + c1.getSaldo());
		
		c1.visualizar();
		
		c2.visualizar();
		
		System.out.println(c1.sacar(1000));
		System.out.println("O Saldo da conta é: " + c1.getSaldo());
		
		System.out.println(c2.sacar(1000000));
		System.out.println("O Saldo da conta é: " + c2.getSaldo());
		
		c1.depositar(5000);
		System.out.println("O Saldo da conta é: " + c1.getSaldo());*/
		
		// Instanciar Objetos da Classe ContaCorrente
		
		System.out.println("\n\nInstanciar Objeto da Classe ContaCorrente");
		
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Thuany Silva", 1000000.00f, 100000.00f);
		
		cc1.visualizar();
		
		// Sacar ContaCorrente
		System.out.println("Sacar R$ 2.000.000.00f: " + cc1.sacar(2000000.00f));
		System.out.println("O Saldo da conta é: R$ " + cc1.getSaldo());
		
		System.out.println("Sacar R$ 2.000.00f: " + cc1.sacar(2000.00f));
		System.out.println("O Saldo da conta é: R$ " + cc1.getSaldo());
		
		// Depositar ContaCorrente
		System.out.println("Depositar R$ 5.000.00");
		cc1.depositar(5000.00f);
		System.out.println("O Saldo da conta é: R$ " + cc1.getSaldo());
		
		// Instanciar Objeto da Classe ContaPopupanca
		
		System.out.println("\n\nInstanciar Objeto da Classe ContaPoupnca");
		
		ContaPoupanca cp1 = new ContaPoupanca(4, 456, 2, "Maria da Silva", 100000.00f, 15);
				
		cp1.visualizar();
				
		// Sacar ContaPoupanca
		System.out.println("Sacar R$ 200.000.00: " + cp1.sacar(200000.00f));
		System.out.println("O Saldo da conta é: R$ " + cp1.getSaldo());
				
		System.out.println("Sacar R$ 2.000.00: " + cp1.sacar(2000.00f));
		System.out.println("O Saldo da conta é: R$ " + cp1.getSaldo());
				
		// Depositar ContaPopupanca
		System.out.println("Depositar R$ 5.000.00");
		cp1.depositar(5000.00f);
		System.out.println("O Saldo da conta é: R$ " + cp1.getSaldo());
		
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

}