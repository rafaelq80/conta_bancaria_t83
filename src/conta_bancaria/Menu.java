package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	
	// Objeto para ler dados digitados pelo usuário
	private static final Scanner leia = new Scanner(System.in);
	
	// Objeto controlador de contas (responsável por cadastrar, listar, atualizar etc.)
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {

		int opcao;
		
		// Cria algumas contas de teste para o sistema não começar com a Collection vazia
		criarContasTeste();
		
		// Laço de repetição que mantém o menu rodando até a opção sair ser acionada
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
			System.out.println("            9 - Procurar pelo Titular da Conta       ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			// Tenta capturar a opção digitada
			// Caso o usuário digite algo inválido, mostra mensagem de erro
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e){
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				leia.nextLine();
			}

			// Se a opção for 0, o sistema será finalizado (System.exit(0))
			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			// Verifica qual opção do menu o usuário escolheu e executa a ação correspondente
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				
				cadastrarConta();
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				listarContas();
				
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				
				procurarContaPorNumero();
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
				atualizarConta();

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				deletarConta();
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				
				sacar();
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				depositar();
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				transferir();
				
				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "Procurar pelo Titular da Conta\n\n");

				listarPorTitular();
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	// Exibe informações sobre o projeto e a pessoa desenvolvedora
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}
	
	// Método responsável por aguardar o usuário pressionar a tecla Enter para continuar
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	// Método responsável por criar algumas contas de teste automaticamente ao iniciar o programa
	private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}
	
	// Método responsável por listar todas as contas
	private static void listarContas() {
		contaController.listarTodas();
	}
	
	// Método responsável por criar uma nova conta com os dados digitados pelo usuário
	private static void cadastrarConta() {
		
		System.out.print("Digite o número da Agência: ");
		int agencia = leia.nextInt();
		
		System.out.print("Digite o o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		
		System.out.print("Digite o Tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.print("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 ->{
			System.out.print("Digite o Limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			
			// Automatiza o numero da conta através do método gerarNumero()
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.print("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
		}
	}
	
	// Método responsável por procurar uma conta já cadastrada pelo número
	private static void procurarContaPorNumero() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		contaController.procurarPorNumero(numero);
	}
	
	// Método responsável por excluir uma conta existente pelo numero
	private static void deletarConta() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		// Busca a conta pelo número
		Conta conta = contaController.buscarNaCollection(numero);

		// Verifica se a conta existe
		if(conta != null) {
		
			// Confirmação da exclusão
			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();
			
			
			if(confirmacao.equalsIgnoreCase("S")) {
				contaController.deletar(numero);
			}else {
				System.out.println("\nOperação cancelada!");
			}
			
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}
	
	// Método responsável por atualizar os dados de uma conta existentepelo numero
	private static void atualizarConta() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		// Busca a conta pelo número
		Conta conta = contaController.buscarNaCollection(numero);
		
		// Se a conta existir
		if(conta != null) {
			
			// Obtém os dados atuais
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			// Atualiza agência (ou mantém valor atual se apertar Enter)
			System.out.printf("Agência atual: %d\nDigite o número da nova Agência (Pressione ENTER para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();

			/**
			 * Se o usuário não digitou nada (entrada vazia), mantém o valor atual de 'agencia'.
			 * Caso contrário, converte o valor digitado (String) para número inteiro e 
			 * atribui à variável 'agencia'.
			 * 
			 * Operador Ternário: condição ? ação caso seja verdadeira : ação caso seja falsa
			 * */
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
			
			// Atualiza o nome do titular (ou mantém valor atual se apertar Enter)
			System.out.printf("Titular atual: %s\nDigite o novo nome do Titular (Pressione ENTER para manter o valor atual): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
						
			// Atualiza saldo (ou mantém valor atual se apertar Enter)
			System.out.printf("Saldo atual: %.2f\nDigite o novo Saldo (Pressione ENTER para manter o valor atual): ", saldo);
			entrada = leia.nextLine();
			
			/**
			 * Se o usuário não digitou nada (entrada vazia), mantém o valor atual de 'agencia'.
			 * Caso contrário, converte o valor digitado (String) para número Real (float),
			 * substitui a , pelo . (método replace) e atribui à variável 'saldo'.
			 * */
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));
			
			// Se a conta for do tipo Conta Corrente
			switch(tipo) {
			case 1 ->{
				
				/**
				 * Como o objeto 'conta' é do tipo genérico Conta, precisamos convertê-la (casting) 
				 * para ContaCorrente.
				 * Isso é necessário porque apenas a classe ContaCorrente possui o atributo 'limite'.
				 * Após o casting, conseguimos acessar o método getLimite() para obter o limite da conta.
				 * */
				float limite = ((ContaCorrente) conta).getLimite();
				
				// Atualiza o limite da conta (ou mantém valor atual se apertar Enter)
				System.out.printf("Limite atual é: %.2f\nDigite o novo Limite (Pressione ENTER para manter o valor atual): ", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",", "."));
				
				/**
				 * Na atualização não utilizamos o método gerarNumero() no atributo 'numero'.
				 * Isso porque o número da conta já existe e identifica unicamente essa conta.
				 * 
				 * Se chamarmos 'gerarNumero()', um novo número seria criado e substituiria o antigo,
				 * o que impediria a atualização dos dados.
				 */
				contaController.atualizar(
				    new ContaCorrente(numero, agencia, tipo, titular, saldo, limite)
				);

			}
			// Se a conta for do tipo Conta Poupança
			case 2 -> {
				
				/**
				 * Como o objeto 'conta' é do tipo genérico Conta, precisamos convertê-la (casting) 
				 * para ContaPoupanca.
				 * Isso é necessário porque apenas a classe ContaPoupanca possui o atributo 'aniversario'.
				 * Após o casting, conseguimos acessar o método getAniversario() para obter o 
				 * dia do aniversário da conta.
				 * */
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				
				// Atualiza o dia do aniversário (ou mantém valor atual se apertar Enter)
				System.out.printf("Aniversário atual é: %d\nDigite o novo dia do Aniversário (Pressione ENTER para manter o valor atual): ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(
						new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario)
				);
			}
			// Se o tipo da conta for inválido
			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
			}
			
		}else {
			// Caso a conta não exista
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}
	
	private static void sacar() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor do saque: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.sacar(numero, valor);
		
	}
	
	private static void depositar() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor do depósito: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.depositar(numero, valor);
		
	}
	
	private static void transferir() {
		
		System.out.print("Digite o número da conta de origem: ");
		int numeroOrigem = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o número da conta de destino: ");
		int numeroDestino = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor da Transferência: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.transferir(numeroOrigem, numeroDestino, valor);
		
	}
	
	private static void listarPorTitular() {
		
		System.out.print("Digite o nome do titular da conta: ");
		String titular = leia.nextLine();
		
		contaController.listarPorTitular(titular);
		
	}
	
}