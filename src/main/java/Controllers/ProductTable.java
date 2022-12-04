package Controllers;

public class ProductTable {
    private String codigo;
    private String descricao;
    private Double quantidade;
    private String endereco;

    public ProductTable(String codigo, String descricao, Double quantidade, String endereco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.endereco = endereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
