package modelos;

import bd.ClienteDAO;

public class Cliente {
	private int id;
    private String nome;
    private int cpf;
    private String telefone;
    
    public Cliente(String nome, int cpf, String telefone) {
        this.id = -1;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public Cliente(int id, String nome, int cpf, String telefone) {
        this.id = id;
    	this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
        
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getCpf() {
        return cpf;
    }
    
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void save() {
    	ClienteDAO.saveCliente(this);
    }
    
    public void imprime() {
    	System.out.println(nome + " "+ cpf + " " + telefone);
    }

}


