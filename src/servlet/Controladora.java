package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.FormUtil;
import bean.LoginBean;
import dao.ConsertoDAO;
import dao.UsuarioDAO;

/**
 * Servlet implementation class Controladora
 */
@WebServlet("/Controladora")
@MultipartConfig
public class Controladora extends Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controladora() {
		super();
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String sub = request.getParameter("sub");

		HttpSession session = request.getSession();

		LoginBean loginBean;

		UsuarioDAO usuarioDAO = null;
		ConsertoDAO produtoDAO = null;

		String path = getServletContext().getRealPath("/");

		// carrega categorias, etc
		

		if (action == null) {
			response.sendRedirect("Controladora?action=index");
		} else
			switch (action) {
			case "login":

				loginBean = FormUtil.populate(LoginBean.class, request);

				if (loginBean.autenticar()) {
					System.out.println("Usuario logando:"
							+ loginBean.getEmail());
					session.setAttribute("loginBean", loginBean);
					response.sendRedirect(request.getHeader("Referer"));
				} else {
					paginaErro(request, response,
							"Login e/ou senha incorretos", null);
					return;
				}

				break;
			case "logout":

				loginBean = (LoginBean) session.getAttribute("loginBean");
				if (session != null) {
					if (loginBean != null) {
						System.out.println("Usuario deslogado:"
								+ loginBean.getEmail());
					}
					session.invalidate();
				}
				response.sendRedirect("Controladora?action=index");

				break;
		

			default:
				paginaErro(request, response, "Ação Inexistente", null);
				break;
			}

	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
