package modelos;

import bd.ServicosDAO;

public class Servicos {
    
    private int id;
    private String tipo;
    
    
    
    public Servicos(int id, String servico) {
        this.tipo = servico;
        this.id=id;
    }
    
    public Servicos(String tipo) {
        this.tipo = tipo;
    }
    
    // Getters e Setters
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
}
