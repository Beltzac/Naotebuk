package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	

	public List<ConsertoBean> carregarEmAberto() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM conserto where estado_id = 1");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<ConsertoBean> l = bp.toBeanList(rs, ConsertoBean.class);
		rs.close();
		return l;
	}
	

	public List<ConsertoBean> carregarAtrasados() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM conserto WHERE previsao < current_date");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<ConsertoBean> l = bp.toBeanList(rs, ConsertoBean.class);
		rs.close();
		return l;
	}
	

	public List<ConsertoBean> carregarProntos() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM conserto where estado_id = 3");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<ConsertoBean> l = bp.toBeanList(rs, ConsertoBean.class);
		rs.close();
		return l;
	}
	
	public List<ConsertoBean> carregarPagos() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM conserto where estado_id = 4");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<ConsertoBean> l = bp.toBeanList(rs, ConsertoBean.class);
		rs.close();
		return l;
	}
	
	public List<ConsertoBean> carregarFinalizados() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM conserto where estado_id = 5");
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
	
	public List<ConsertoBean> pesquisaData (String data1, String data2) throws SQLException{
		String sql;
		String and;
		String end;

		sql = "SELECT * FROM conserto WHERE data_criacao BETWEEN '";
		and = "' AND '"; 
		end = "'";
		sql += data1 + and + data2 + end;
		
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
			SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
			Date date = from.parse(obj.getPrevisao());       
			String sqldate = to.format(date);
			stmtGravar = con.prepareStatement("INSERT INTO conserto (estado_id, cliente_id, nome, tipo, modelo, fabricante,descricao,observacao,valor, previsao,data_criacao) VALUES (?,?,?,?,?,?,?,?,?,?,CURRENT_DATE())",Statement.RETURN_GENERATED_KEYS);
			
			stmtGravar.setInt(1, obj.getEstado_id());
			stmtGravar.setInt(2, obj.getCliente_id());
			stmtGravar.setString(3, obj.getNome());
			stmtGravar.setBoolean(4, obj.isTipo());
			stmtGravar.setString(5, obj.getModelo());
			stmtGravar.setString(6, obj.getFabricante());			
			stmtGravar.setString(7, obj.getDescricao());			
			stmtGravar.setString(8, obj.getObservacao());			
			stmtGravar.setDouble(9, obj.getValor());
			stmtGravar.setString(10, sqldate);
			
			
			
			stmtGravar.executeUpdate();
			
			ResultSet rs = 	stmtGravar.getGeneratedKeys();
			if (rs.next()){
			    obj.setId(rs.getInt(1));
			}
			
			
		} else {
			System.out.println("Atualizando conserto: " + obj.toString());
			SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
			Date date = from.parse(obj.getPrevisao());       
			String sqldate = to.format(date);
			System.out.println("Atualizando produto: " + obj.toString());
			stmtAtualizar = con.prepareStatement("UPDATE conserto SET estado_id = ?, cliente_id= ?, nome= ?, tipo= ?, modelo= ?, fabricante= ?,descricao= ?,observacao= ?,valor = ?, previsao = ? WHERE id = ?");
			stmtAtualizar.setInt(1, obj.getEstado_id());
			stmtAtualizar.setInt(2, obj.getCliente_id());
			stmtAtualizar.setString(3, obj.getNome());
			stmtAtualizar.setBoolean(4, obj.isTipo());
			stmtAtualizar.setString(5, obj.getModelo());
			stmtAtualizar.setString(6, obj.getFabricante());			
			stmtAtualizar.setString(7, obj.getDescricao());			
			stmtAtualizar.setString(8, obj.getObservacao());			
			stmtAtualizar.setDouble(9, obj.getValor());
			stmtAtualizar.setString(10, sqldate);
			stmtAtualizar.setInt(11, obj.getId());
			
			
			stmtAtualizar.executeUpdate();					
			
		}

	}	
	
	public void pronto (int id) throws SQLException{
		stmtAtualizar = con.prepareStatement("UPDATE conserto SET estado_id = 3 WHERE id = ?");
		stmtAtualizar.setInt(1, id);
		stmtAtualizar.executeUpdate();
	}
	
	public void pago (int id) throws SQLException{
		stmtAtualizar = con.prepareStatement("UPDATE conserto SET estado_id = 4 WHERE id = ?");
		stmtAtualizar.setInt(1, id);
		stmtAtualizar.executeUpdate();
	}
	
	public void finalizar (int id) throws SQLException{
		stmtAtualizar = con.prepareStatement("UPDATE conserto SET estado_id = 5 WHERE id = ?");
		stmtAtualizar.setInt(1, id);
		stmtAtualizar.executeUpdate();
	}

	@Override
	public int deletar(int id) throws Exception {
		stmtDeletar = con.prepareStatement("DELETE FROM produto WHERE id = ?");
		stmtDeletar.setInt(1, id);
		return stmtDeletar.executeUpdate();
	}

}
