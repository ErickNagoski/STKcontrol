/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Vitória
 */
public class Venda {
    private int  id;
    private int cliente;
    private String nota_fiscal;
    private int valor;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNota_fiscal() {
        return nota_fiscal;
    }

    
    public void setNota_fiscal(String nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Venda(int id, int cliente, String nota_fiscal, int valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.nota_fiscal = nota_fiscal;
        this.valor = valor;
        this.data = data;
        
    }
    
    
    
}
