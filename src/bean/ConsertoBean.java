package bean;

import java.io.Serializable;
import java.util.Date;

public class ConsertoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int estado_id;
	private int cliente_id;
	private String nome;
	private boolean tipo;
	private String modelo;
	private String fabricante;
	private String descricao;
	private String observacao;
	private double valor;
	private Date previsao;

	public Date getPrevisao() {	
			return previsao;	
	}
	
	public String getLevel(){
		
		Date dataAtual = new Date();  
		
		if(dataAtual.after(previsao)){
			return "danger";
		}
		
		if((previsao.getTime() - dataAtual.getTime()) < 172800000){
			return "warning";
		}
		
		return "active";
		
	}

	public void setPrevisao(java.util.Date previsao) {			
		this.previsao = previsao;			
	}
	
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

	public int getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(int estado_id) {
		this.estado_id = estado_id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ConsertoBean [id=" + id + ", estado_id=" + estado_id
				+ ", cliente_id=" + cliente_id + ", nome=" + nome + ", tipo="
				+ tipo + ", modelo=" + modelo + ", fabricante=" + fabricante
				+ ", descricao=" + descricao + ", observacao=" + observacao
				+ ", valor=" + valor + ", previsao=" + previsao + "]";
	}


	

}
