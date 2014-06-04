package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import dao.ConnectionFactory;


@WebServlet("/Relatorio")
public class Relatorio extends Servlet {
	private static final long serialVersionUID = 1L;       

    public Relatorio() {
        super();
    }

    @SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	if (!filtroAdmin(request, response)) {
			return;
		}
    	
    	String jasp;
    	
    	switch (request.getParameter("option")) {
    	
		case "atrasado":
			jasp = "/report/atrasado-naotebuk.jasper";
			break;
			
		case "retirar":
			jasp = "/report/retirar-naotebuk.jasper";
			break;
			
		case "datas":
			jasp = "/report/datas-naotebuk.jasper";
			break;
		
		default:
			paginaErro(request, response, "Erro ao criar relatório (Parâmetro não existente)", null);
			return;			
		}
    	
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String jasper = request.getContextPath() + jasp;
			String host = "http://" + request.getServerName() + ":" + request.getServerPort();
			URL jasperURL = new URL(host + jasper);
			HashMap params = new HashMap();
			if(jasp == "/report/datas-naotebuk.jasper"){
				String data1 = request.getParameter("data1");
				String data2 = request.getParameter("data2");
				
				if (data1 == null || data2 == null || data1.isEmpty() || data2.isEmpty()){
					paginaErro(request, response, "Selecione as datas, inicial e final.", null);
					return;
				}
				
				SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = from.parse(data1);
				Date date2 = from.parse(data2); 
				String da1 = to.format(date1);
				String d1 = "'" + da1 + "'";
				String da2 = to.format(date2);
				String d2 = "'" + da2 + "'";
				params.put("data1", da1);
				params.put("data2", da2);
				System.out.println(params.get("data1"));
				System.out.println(params.get("data2"));
				System.out.println(jasp);
 			}
			byte[] bytes = null;
			bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, con);
			//JasperPrint  jasperPrint = JasperFillManager.fillReport(jasp, params, new JREmptyDataSource()); 
			//JasperExportManager.exportReportToPdfFile(jasperPrint, "test.pdf");  
			if (bytes != null) {
				response.setContentType("application/pdf");
				OutputStream ops = null;
				ops = response.getOutputStream();
				ops.write(bytes);
			}
		}catch (JRException e) {
			e.printStackTrace();
			paginaErro(request, response, "Erro ao criar relatório", e.getMessage());
			return;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
