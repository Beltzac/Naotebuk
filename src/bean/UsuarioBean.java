

package bean;

import java.io.Serializable;

import model.NivelAcesso;

public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String email;
	private String senha;
	private NivelAcesso nivel;
	
	public UsuarioBean() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "UsuarioBean [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + ", nivel=" + nivel + "]";
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	public NivelAcesso getNivel() {
		return nivel;
	}

	public void setNivel(NivelAcesso nivel) {
		this.nivel = nivel;
	}
	
	

}
