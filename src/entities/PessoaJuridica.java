package entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer funcionarios;
	
	
	public PessoaJuridica() {
		
	}
	

	public PessoaJuridica(String nome, Double rendaAnual, Integer funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}
	

	public Integer getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}


	@Override
	public double imposto() {
		
		if(funcionarios>10) {
			return rendaAnual*0.14;
		}
		else {
			return rendaAnual*0.16;
		}
	}
	
}
