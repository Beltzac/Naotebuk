package bean;


public class LoginBean {
	private String email;
	private String senha;
	private boolean gerente;
	private boolean autenticado;

	public boolean autenticar() {
		System.out.println("Email: " + email + " Senha: " + senha);
		if (email != null && senha != null)
			if (email.equals("lol@gmail.com") && senha.equals("123")){
				autenticado = true;
				return true;		
			}
		return false;
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

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
}