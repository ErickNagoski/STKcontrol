/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import com.example.stkcontrol.Application;

/**
 *
 * @author Vitória
 */
public class Produto  {
    public int produto_id;
    private  String codigo;
    private String descricao;
    private float preco_custo;
    private float preco_venda;
    private float ipi;
    private String codigo_fornecedor;
    private float estoque;
    private String endereco;

    private String unidade_media;

    public Produto(int produto_id, String codigo, String descricao, float preco_custo, float preco_venda, float ipi, String codigo_fornecedor, String unidade_media) {
        this.produto_id = produto_id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.ipi = ipi;
        this.codigo_fornecedor = codigo_fornecedor;
        this.unidade_media = unidade_media;
    }

    public Produto(int produto_id, String codigo, String descricao, float preco_custo, float preco_venda, float ipi, String codigo_fornecedor, float estoque, String endereco, String unidade_media) {
        this.produto_id = produto_id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.ipi = ipi;
        this.codigo_fornecedor = codigo_fornecedor;
        this.estoque = estoque;
        this.endereco = endereco;
        this.unidade_media = unidade_media;
    }

    public Produto(String codigo, String descricao, float preco_custo, float preco_venda, float ipi, String codigo_fornecedor, float estoque, String endereco, String unidade_media) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.ipi = ipi;
        this.codigo_fornecedor = codigo_fornecedor;
        this.estoque = estoque;
        this.endereco = endereco;
        this.unidade_media = unidade_media;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(float preco_custo) {
        this.preco_custo = preco_custo;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(String codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }

    public float getIpi() {
        return ipi;
    }

    public void setIpi(float ipi) {
        this.ipi = ipi;
    }

    public String getUnidade_media() {
        return unidade_media;
    }

    public void setUnidade_media(String unidade_media) {
        this.unidade_media = unidade_media;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
