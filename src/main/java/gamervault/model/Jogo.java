package gamervault.model;

public class Jogo {

    private int id;
    private String nome;
    private String genero;
    private String plataforma;
    private int horasJogadas;

    public Jogo() {
    }

    public Jogo(String nome, String genero, String plataforma, int horasJogadas) {
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.horasJogadas = horasJogadas;
    }

    public Jogo(int id, String nome, String genero, String plataforma, int horasJogadas) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.horasJogadas = horasJogadas;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getHorasJogadas() {
        return horasJogadas;
    }

    public void setHorasJogadas(int horasJogadas) {
        this.horasJogadas = horasJogadas;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", horasJogadas=" + horasJogadas +
                '}';
    }
}