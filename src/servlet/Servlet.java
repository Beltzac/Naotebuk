package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import model.NivelAcesso;
import bean.LoginBean;

public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	protected void forward(HttpServletRequest request,
			HttpServletResponse response, String path) {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Forward para a pagina de erro
	protected void paginaErro(HttpServletRequest request,
			HttpServletResponse response, String mensagem, String stacktrace) {
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("stacktrace", stacktrace);
		request.setAttribute("voltar", "Controladora?action=emAberto");
		forward(request, response, "/erro.jsp");
	}

	// verifica se está logado
	protected Boolean filtroLogado(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");
		if (loginBean == null || !loginBean.isAutenticado()) {
			paginaErro(request, response,
					"Voc� precisa logar para realizar esta a��o", null);
			return false;
		}
		return true;
	}

	// verifica se é admin e está logado
	protected Boolean filtroAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");
		if (!filtroLogado(request, response)) {
			return false;
		}
		if (loginBean == null || loginBean.getUsuario() == null ) {
			paginaErro(request, response,
					"Sua conta n�o possui os privil�gios necessarios.", null);
			return false;
		}
		return true;
	}

}
