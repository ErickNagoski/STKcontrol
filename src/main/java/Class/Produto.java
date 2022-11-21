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
    private float codigo_fornecedor;
    private float estoque;

    public Produto(int produto_id, String codigo, String descricao, float preco_custo, float preco_venda, float ipi, float codigo_fornecedor, float estoque) {
        this.produto_id = produto_id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.ipi = ipi;
        this.codigo_fornecedor = codigo_fornecedor;
        this.estoque = estoque;
        
        
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
    
    public String setCodigo(String codigo) {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescriçao(String descriçao) {
        this.descricao = descriçao;
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

    public float getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(float codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }
    
    
}
