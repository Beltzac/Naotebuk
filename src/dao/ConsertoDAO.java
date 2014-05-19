package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

import bean.ConsertoBean;

import com.mysql.jdbc.Statement;

public class ConsertoDAO implements IDAO<ConsertoBean> {

	private Connection con;

	private PreparedStatement stmtCarregar;
	private PreparedStatement stmtCarregarTodos;
	private PreparedStatement stmtPesquisar;	
	private PreparedStatement stmtGravar;
	private PreparedStatement stmtAtualizar;
	private PreparedStatement stmtDeletar;

	public ConsertoDAO() throws Exception {
		con = ConnectionFactory.getConnection();	
	}

	@Override
	public ConsertoBean carregar(int id) throws Exception {
		stmtCarregar = con.prepareStatement("SELECT * FROM conserto WHERE id = ?");
		stmtCarregar.setInt(1, id);
		ResultSet rs = stmtCarregar.executeQuery();
		ConsertoBean o = null;

		if (rs.next()) {
			BeanProcessor bp = new BeanProcessor();
			o = bp.toBean(rs, ConsertoBean.class);
		}

		rs.close();
		return o;
	}
	

	@Override
	public List<ConsertoBean> carregarTodos() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM conserto");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<ConsertoBean> l = bp.toBeanList(rs, ConsertoBean.class);
		rs.close();
		return l;
	}

	@Override
	public List<ConsertoBean> pesquisar(String texto,  List<String> campos)
			throws Exception {

		String sql;

		sql = "SELECT * FROM conserto WHERE ";

		for (String campo : campos) {
			sql += campo + " LIKE '%" + texto + "%'" + " OR ";
		}

		// Remove último AND
		sql = sql.substring(0, sql.length() - 4);

		stmtPesquisar = con.prepareStatement(sql);
		ResultSet rs = stmtPesquisar.executeQuery();

		BeanProcessor bp = new BeanProcessor();
		List<ConsertoBean> l = bp.toBeanList(rs, ConsertoBean.class);
		rs.close();
		return l;
	}

	@Override
	public void gravar(ConsertoBean obj, boolean update) throws Exception {
	
		
		
		if (!update){
			System.out.println("Criando produto: " + obj.toString());
			
			stmtGravar = con.prepareStatement("INSERT INTO conserto (estado, cliente, nome, tipo, modelo, fabricante,descricao,observacao,valor,data_criacao) VALUES (?,?,?,?,?,CURRENT_DATE())",Statement.RETURN_GENERATED_KEYS);
			
			stmtGravar.setString(1, obj.getEstado());
			stmtGravar.setInt(2, obj.getCliente());
			stmtGravar.setString(3, obj.getNome());
			stmtGravar.setString(4, obj.getTipo());
			stmtGravar.setString(5, obj.getModelo());
			stmtGravar.setString(6, obj.getFabricante());			
			stmtGravar.setString(7, obj.getDescricao());			
			stmtGravar.setString(8, obj.getObservacao());			
			stmtGravar.setDouble(9, obj.getValor());
			
			
			
			stmtGravar.executeUpdate();
			
			ResultSet rs = 	stmtGravar.getGeneratedKeys();
			if (rs.next()){
			    obj.setId(rs.getInt(1));
			}
			
			
		} else {
			System.out.println("Atualizando produto: " + obj.toString());
			stmtAtualizar = con.prepareStatement("UPDATE conserto SET estado = ?, cliente= ?, nome= ?, tipo= ?, modelo= ?, fabricante= ?,descricao= ?,observacao= ?,valor = ? WHERE id = ?");
			stmtGravar.setString(1, obj.getEstado());
			stmtGravar.setInt(2, obj.getCliente());
			stmtGravar.setString(3, obj.getNome());
			stmtGravar.setString(4, obj.getTipo());
			stmtGravar.setString(5, obj.getModelo());
			stmtGravar.setString(6, obj.getFabricante());			
			stmtGravar.setString(7, obj.getDescricao());			
			stmtGravar.setString(8, obj.getObservacao());			
			stmtGravar.setDouble(9, obj.getValor());
			stmtGravar.setInt(10, obj.getId());
			
			
			stmtAtualizar.executeUpdate();					
			
		}

	}	



	@Override
	public int deletar(int id) throws Exception {
		stmtDeletar = con.prepareStatement("DELETE FROM produto WHERE id = ?");
		stmtDeletar.setInt(1, id);
		return stmtDeletar.executeUpdate();
	}

}
