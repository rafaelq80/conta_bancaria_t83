package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
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
