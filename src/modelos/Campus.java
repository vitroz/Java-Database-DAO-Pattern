package modelos;


public class Campus {
    
    private int id;
    private String nome;
    
    public Campus(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Campus() {
       
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
    
    
    
}