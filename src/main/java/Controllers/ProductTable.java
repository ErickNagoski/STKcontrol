package Controllers;

public class ProductTable {
    private String codigo;
    private String descricao;
    private Double quantidade;
    private String endereco;
    private Double preco_venda;
    private Double ipi;
    private Double pre_custo;
    private String unidadeMedida;
    private String codigoFornecedor;
    private String fornecedor;
    private String movimento;

    public ProductTable(String codigo, String descricao, Double quantidade, String endereco, String unidadeMedida, String fornecedor, String movimento) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.endereco = endereco;
        this.unidadeMedida = unidadeMedida;
        this.fornecedor = fornecedor;
        this.movimento = movimento;
    }

    public ProductTable(String codigo, String descricao, Double quantidade, String endereco, Double preco_venda, Double ipi, Double pre_custo, String unidadeMedida, String codigoFornecedor, String fornecedor, String movimento) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.endereco = endereco;
        this.preco_venda = preco_venda;
        this.ipi = ipi;
        this.pre_custo = pre_custo;
        this.unidadeMedida = unidadeMedida;
        this.codigoFornecedor = codigoFornecedor;
        this.fornecedor = fornecedor;
        this.movimento = movimento;
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

    public Double getPreco_venda() {
        return preco_venda;
    }

    public Double getIpi() {
        return ipi;
    }

    public Double getPre_custo() {
        return pre_custo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public String getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getMovimento() {
        return movimento;
    }
}
