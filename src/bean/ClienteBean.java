package bean;

import java.io.Serializable;

public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cpf;
	private String dataNasc;
	private boolean sexo;
	private String rua;
	private int num;
	private String cep;
	private String cidade;
	private String estado;
	private String email;

	public ClienteBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClienteBean [id=" + id + ", cpf=" + cpf + ", dataNasc="
				+ dataNasc + ", sexo=" + sexo + ", rua=" + rua + ", num=" + num
				+ ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado
				+ ", email=" + email + "]";
	}
	
	

}
