package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\n🎉 Conta Cadastrada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.printf("\nA Conta número: %d foi atualizada com sucesso!%n", conta.getNumero());
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada!%n", conta.getNumero());
		}
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada!%n", numero);
		}
		
	}

	@Override
	public void deletar(int numero) {
		
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.printf("\nA conta número %d foi deletada com sucesso!%n", numero);
			}
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada!%n", numero);
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.printf("\nO saque no valor de %.2f, na conta número: %d foi efetuado com sucesso!%n", valor, numero);
			}
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada!%n", numero);
		}
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.printf("\nO depósito no valor de %.2f, na conta número: %d foi efetuado com sucesso!%n", valor, numero);
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada!%n", numero);
		}
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.printf("\n"
						+ "A Transferência no valor de %.2f, da conta número: %d para a conta número: %d, foi efetuada com sucesso!%n", 
						valor, numeroOrigem, numeroDestino);
			}
		}else {
			System.out.println("\nA Conta de Origem e/ou Conta de Destino não foram encontradas!%n");
		}
		
	}

	@Override
	public void listarPorTitular(String titular) {
		
		List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		
		if(listaTitulares.isEmpty()) {
			System.out.printf("\nNenhuma conta foi encontrada para titulares que possuam o nome: %s", titular);
		}
		
		for(var conta : listaTitulares) {
			conta.visualizar();
		}
		
	}
	
	// Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}

	
}
