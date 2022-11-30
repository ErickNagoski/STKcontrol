package Class;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableEstoque {

    private final StringProperty codigo;
    private final StringProperty descricao;
    private final StringProperty quantidade;
    private final StringProperty endereco;

    public TableEstoque(String codigo, String descricao, String quantidade, String endereco) {
        this.codigo = new SimpleStringProperty(codigo);
        this.descricao = new SimpleStringProperty(descricao);
        this.quantidade = new SimpleStringProperty(quantidade);
        this.endereco = new SimpleStringProperty(endereco);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public StringProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public String getQuantidade() {
        return quantidade.get();
    }

    public StringProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.set(quantidade);
    }

    public String getEndereco() {
        return endereco.get();
    }

    public StringProperty enderecoProperty() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    @Override
    public String toString() {
        return "tableEstoque{" +
                "codigo=" + codigo +
                ", descricao=" + descricao +
                ", quantidade=" + quantidade +
                ", endereco=" + endereco +
                '}';
    }
}
