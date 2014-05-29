package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

import bean.UsuarioBean;

public class UsuarioDAO implements IDAO<UsuarioBean> {

	private Connection con;

	private PreparedStatement stmtCarregar;
	private PreparedStatement stmtCarregarTodos;
	private PreparedStatement stmtPesquisar;
	private PreparedStatement stmtLogin;
	private PreparedStatement stmtGravar;
	private PreparedStatement stmtAtualizar;
	private PreparedStatement stmtDeletar;

	public UsuarioDAO() throws Exception {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public UsuarioBean carregar(int id) throws Exception {
		stmtCarregar = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");
		stmtCarregar.setInt(1, id);
		ResultSet rs = stmtCarregar.executeQuery();
		UsuarioBean o = null;

		if (rs.next()) {
			BeanProcessor bp = new BeanProcessor();
			o = bp.toBean(rs, UsuarioBean.class);
		}

		rs.close();
		return o;
	}
	
	public UsuarioBean carregar(String email, String senha) throws Exception{		
		stmtLogin = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = MD5(?)");
		stmtLogin.setString(1, email);
		stmtLogin.setString(2, senha);
		ResultSet rs = stmtLogin.executeQuery();
		UsuarioBean o = null;

		if (rs.next()) {
			BeanProcessor bp = new BeanProcessor();
			o = bp.toBean(rs, UsuarioBean.class);
		}

		rs.close();
		return o;
		
	}

	@Override
	public List<UsuarioBean> carregarTodos() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM usuario");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<UsuarioBean> l = bp.toBeanList(rs, UsuarioBean.class);
		rs.close();
		return l;
	}

	@Override
	public List<UsuarioBean> pesquisar(String texto, List<String> campos)
			throws Exception {

		String sql;

		sql = "SELECT * FROM usuario WHERE ";

		for (String campo : campos) {
			sql += campo + " LIKE '%" + texto + "%'" + " OR ";
		}

		// Remove último AND
		sql = sql.substring(0, sql.length() - 4);		
		stmtPesquisar = con.prepareStatement(sql);
		ResultSet rs = stmtPesquisar.executeQuery();

		BeanProcessor bp = new BeanProcessor();
		List<UsuarioBean> l = bp.toBeanList(rs, UsuarioBean.class);
		rs.close();
		return l;
	}

	@Override
	public void gravar(UsuarioBean obj, boolean update) throws Exception {
		
		if (!update){
			System.out.println("Criando conta: " + obj.getEmail());
			stmtGravar = con.prepareStatement("INSERT INTO usuario (nome, email, senha, gerente, matricula, data_criacao) VALUES (?,?,MD5(?),?,?,CURRENT_DATE())");
			stmtGravar.setString(1, obj.getNome());
			stmtGravar.setString(2, obj.getEmail());
			stmtGravar.setString(3, obj.getSenha());
			stmtGravar.setBoolean(4, obj.isGerente());
			stmtGravar.setString(5, obj.getMatricula());
			
			stmtGravar.executeUpdate();
			
		} else {
			System.out.println("Atualizando conta: " + obj.getEmail());
			stmtAtualizar = con.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, gerente = ?, matricula = ? WHERE id = ?");
			stmtGravar.setString(1, obj.getNome());
			stmtGravar.setString(2, obj.getEmail());
			stmtGravar.setString(3, obj.getSenha());
			stmtGravar.setBoolean(4, obj.isGerente());
			stmtGravar.setString(5, obj.getMatricula());
			
			stmtAtualizar.executeUpdate();					
			
		}

	}

	@Override
	public int deletar(int id) throws Exception {
		stmtDeletar = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
		stmtDeletar.setInt(1, id);
		return stmtDeletar.executeUpdate();
	}

}
