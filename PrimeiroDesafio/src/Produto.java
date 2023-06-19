public class Produto {

    private static int count = 1;
    private int id;
    private String nome;
    private Double preco;
    private int quantidade;

    public Produto(String nome, Double preco, int quantidade) {
        this.id = count;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, Double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\n" + "\n" + "Produto: " +
                "\n ID = " + id +
                "\n Nome = " + nome  +
                "\n Preço = " + preco +
                "\n Quantidade = " + quantidade;
    }
}
