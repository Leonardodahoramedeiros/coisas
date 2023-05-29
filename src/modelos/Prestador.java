package modelos;

public class Prestador {
	
	private int id;
	private String nome;
	private String matricula;
	private String telefone;
	
	
	
	public Prestador( String nome, String matricula, String telefone) {
		
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
	}
	
	public Prestador(int id, String nome, String matricula, String telefone) {
		
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void imprimi() {
		System.out.println(id + " " + nome + " " + matricula + " " + telefone);
	}
	


}
