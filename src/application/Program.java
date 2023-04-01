package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		List<Pessoa> list= new ArrayList<>();
		
		System.out.print("Qual será o número de pagamento de imposto? ");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.printf("Imposto #%d: %n", i);
			System.out.println("individual ou companhia(i/c)? ");
			char tipo=sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome=sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual=sc.nextDouble();
			
			if(tipo=='i') {
				System.out.print("Gastos com saúde: ");
				double gastosSaude=sc.nextDouble();
				Pessoa individual= new PessoaFisica(nome,rendaAnual,gastosSaude);
				list.add(individual);
			}
			else if(tipo=='c') {
				System.out.print("Número de funcionários: ");
				int funcionarios=sc.nextInt();
				Pessoa juridica= new PessoaJuridica(nome,rendaAnual,funcionarios);
				list.add(juridica);
			}
		}
		System.out.println();
		System.out.println("IMPOSTOS: ");
		for(Pessoa x: list) {
			System.out.printf("%s : $ %.2f%n", x.getNome(),x.imposto());
		}
		System.out.println();
		System.out.printf("IMPOSTO TOTAL: $ %.2f%n", impostoTotal(list));
		
		
		
		
		sc.close();

	}
	public static double impostoTotal(List<Pessoa> list) {
		double total=0;
		
		for(int i=0;i<list.size();i++) {
			total+=list.get(i).imposto();
		}
		return total;
	}

}
