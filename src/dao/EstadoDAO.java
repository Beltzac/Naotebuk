package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;


import bean.EstadoBean;


public class EstadoDAO  {
	
	private Connection con;

	private PreparedStatement stmtCarregarTodos;

	
	public EstadoDAO() throws Exception {
		con = ConnectionFactory.getConnection();
	}
	
	public List<EstadoBean> carregarTodos() throws Exception {
		stmtCarregarTodos = con.prepareStatement("SELECT * FROM estado");
		ResultSet rs = stmtCarregarTodos.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		List<EstadoBean> l = bp.toBeanList(rs, EstadoBean.class);
		rs.close();
		return l;
	}
}
