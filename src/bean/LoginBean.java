package bean;

import dao.UsuarioDAO;


public class LoginBean {
	private String email;
	private String senha;
	private UsuarioBean usuario;
	private boolean autenticado;
	private boolean gerente;

	public boolean isGerente() {
		return gerente;
	}


	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}


	public boolean autenticar() {
		
		if (email != null && senha != null){
			
			try {
				UsuarioDAO dao = new UsuarioDAO();
				UsuarioBean alvo = dao.carregar(email,senha);
				
				
				if (alvo != null){
					usuario = alvo;
					autenticado = true;
					gerente = alvo.isGerente();
					return true;		
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return false;
	}

	
	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", senha=" + senha + ", usuario="
				+ usuario + ", autenticado=" + autenticado + ", gerente="
				+ gerente + "]";
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

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
}