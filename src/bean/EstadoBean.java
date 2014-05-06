package bean;

import java.io.Serializable;

public class EstadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;

	@Override
	public String toString() {
		return "EstadoBean [id=" + id + ", nome=" + nome + "]";
	}

	public EstadoBean() {
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
	
	

}
