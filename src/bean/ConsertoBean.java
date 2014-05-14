package bean;

import java.io.Serializable;

import model.Estado;
import model.TipoEquipamento;

public class ConsertoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Estado estado;
	private int cliente;
	private String nome;
	private TipoEquipamento tipo;
	private String modelo;
	private String fabricante;
	private String descricao;
	private String observacao;
	private double valor;

	public ConsertoBean() {
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public TipoEquipamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquipamento tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ConsertoBean [id=" + id + ", estado=" + estado + ", cliente="
				+ cliente + ", nome=" + nome + ", tipo=" + tipo + ", modelo="
				+ modelo + ", fabricante=" + fabricante + ", descricao="
				+ descricao + ", observacao=" + observacao + ", valor=" + valor
				+ "]";
	}	

}
