package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

import bean.ClienteBean;

public class ClienteDAO implements IDAO<ClienteBean> {

	private Connection con;

	private PreparedStatement stmtCarregar;
	private PreparedStatement stmtCarregarTodos;
	private PreparedStatement stmtPesquisar;
	private PreparedStatement stmtGravar;
	private PreparedStatement stmtAtualizar;
	private PreparedStatement stmtDeletar;

	public ClienteDAO() throws Exception {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public ClienteBean carregar(int id) throws Exception {
		stmtCarregar = con.prepareStatement("SELECT * FROM cliente WHERE id = ?");
		stmtCarregar.setInt(1, id);
		ResultSet rs = stmtCarregar.executeQuery();
		ClienteBean o = null;

		if (rs.next()) {
			BeanProcessor bp = new BeanProcessor();
			o = bp.toBean(rs, ClienteBean.class);
		}

		rs.close();
		return o;
	}	


	@Override
	public List<ClienteBean> carregarTodos() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM cliente");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<ClienteBean> l = bp.toBeanList(rs, ClienteBean.class);
		rs.close();
		return l;
	}

	@Override
	public List<ClienteBean> pesquisar(String texto, List<String> campos)
			throws Exception {

		String sql;

		sql = "SELECT * FROM cliente WHERE ";

		for (String campo : campos) {
			sql += campo + " LIKE '%" + texto + "%'" + " OR ";
		}

		// Remove último AND
		sql = sql.substring(0, sql.length() - 4);		
		stmtPesquisar = con.prepareStatement(sql);
		ResultSet rs = stmtPesquisar.executeQuery();

		BeanProcessor bp = new BeanProcessor();
		List<ClienteBean> l = bp.toBeanList(rs, ClienteBean.class);
		rs.close();
		return l;
	}

	@Override
	public void gravar(ClienteBean obj, boolean update) throws Exception {
		
		if (!update){
			SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
			Date date = from.parse(obj.getDataNasc());       
			String sqldate = to.format(date);     
			System.out.println("Criando conta: " + obj.getEmail());
			stmtGravar = con.prepareStatement("INSERT INTO cliente (nome, email, cpf, cep, rua, cidade, estado, num, sexo, dataNasc, data_criacao) VALUES (?,?,?,?,?,?,?,?,?,?,CURRENT_DATE())");
			stmtGravar.setString(1, obj.getNome());
			stmtGravar.setString(2, obj.getEmail());			
			stmtGravar.setString(3, obj.getCpf());
			stmtGravar.setString(4, obj.getCep());
			stmtGravar.setString(5, obj.getRua());
			stmtGravar.setString(6, obj.getCidade());
			stmtGravar.setString(7, obj.getEstado());
			stmtGravar.setString(8, obj.getNumero());
			stmtGravar.setBoolean(9, obj.isSexo());
			stmtGravar.setString(10, sqldate);
	
		
			
			stmtGravar.executeUpdate();
			
		} else {
			System.out.println("Atualizando conta: " + obj.getEmail());
			stmtAtualizar = con.prepareStatement("UPDATE cliente SET nome = ?, email = ?, cpf = ?,  cep = ?, rua = ?,cidade = ?,estado = ?, num = ?, sexo = ? WHERE id = ?");
			stmtAtualizar.setString(1, obj.getNome());
			stmtAtualizar.setString(2, obj.getEmail());			
			stmtAtualizar.setString(3, obj.getCpf());
			stmtAtualizar.setString(4, obj.getCep());
			stmtAtualizar.setString(5, obj.getRua());
			stmtAtualizar.setString(6, obj.getCidade());
			stmtAtualizar.setString(7, obj.getEstado());
			stmtAtualizar.setString(8, obj.getNumero());
			stmtAtualizar.setBoolean(9, obj.isSexo());
			stmtAtualizar.setInt(10, obj.getId());
			
			stmtAtualizar.executeUpdate();					
			
		}

	}

	@Override
	public int deletar(int id) throws Exception {
		stmtDeletar = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
		stmtDeletar.setInt(1, id);
		return stmtDeletar.executeUpdate();
	}

}
