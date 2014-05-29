package servlet;

import java.io.IOException;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.FormUtil;
import bean.ClienteBean;
import bean.ConsertoBean;
import bean.EstadoBean;
import bean.LoginBean;
import bean.UsuarioBean;
import dao.ClienteDAO;
import dao.ConsertoDAO;
import dao.EstadoDAO;
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
		ConsertoDAO consertoDAO = null;
		ClienteDAO clienteDAO = null;

		String path = getServletContext().getRealPath("/");

		// carrega 
		carregarObjetosComuns(request, response);

		if (action == null) {
			response.sendRedirect("Controladora?action=listaPedidos");
		} else
			switch (action) {
			case "login":
				loginBean = FormUtil.populate(LoginBean.class, request);

				if (loginBean.autenticar()) {
					System.out.println("Usuario logando:"
							+ loginBean.getEmail());
					
					session.setAttribute("loginBean", loginBean);
					System.out.println(((LoginBean)session.getAttribute("loginBean")).toString());
					 //response.sendRedirect(request.getHeader("Referer"));
					if(loginBean.isGerente()){
						response.sendRedirect("Controladora?action=cadastroUsuario");
					}else{
						response.sendRedirect("Controladora?action=listaPedidos");
					}
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
				response.sendRedirect("Controladora?action=listaPedidos");

				break;
				
			case "listaPedidos":
				
				forward(request, response, "/listaPedidos.jsp");
				
				break;
		
			case "loginPage":
				
				forward(request, response, "/login.jsp");
				
				break;
			
			case "pesquisaUsuario":
				
				usuarioDAO = null;
				try {
					usuarioDAO = new UsuarioDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Usu·rio)", e1.getMessage());
					return;
				}

				List<UsuarioBean> listaUsuarios = null;
				List<String> campos = new ArrayList<>();
				campos.add("nome");
				campos.add("email");
				campos.add("matricula");

				try {

					String pesquisa2 = request.getParameter("pesquisa");
					

					if (pesquisa2 != null && pesquisa2.length() > 0)
						listaUsuarios = usuarioDAO.pesquisar(pesquisa2, campos);
					else
						listaUsuarios = usuarioDAO.carregarTodos();
					
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao pesquisar usu·rios",
							e.getMessage());
					return;
				}
				request.setAttribute("listaUsuarios", listaUsuarios);
				System.out.print(listaUsuarios);
				//forward(request, response, "/listaUsers.jsp");
				
				forward(request, response, "/pesquisa.jsp");
				
				break;
			
			case "cadastroUsuario":
				
				forward(request, response, "/formUsuario.jsp");
				
				break;
				
			case "cadastroCliente":
	
				forward(request, response, "/formCliente.jsp");
				
				break;
			
			case "cadastroPedido":
				
				forward(request, response, "/formPedido.jsp");
				
				break;
			
			case "pesquisaPedido":
				
				forward(request, response, "/busca.jsp");
				
				break;

			case "pagamento":
				
				forward(request, response, "/pagamentoConserto.jsp");
				
				break;

			case "emAberto":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaEmAberto = null;
				try {
					listaEmAberto = consertoDAO.carregarEmAberto();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao listar consertos",
							e.getMessage());
					return;
				}

				request.setAttribute("listaEmAberto", listaEmAberto);
				
				forward(request, response, "/listaEmAberto.jsp");
				
				break;

			case "atrasados":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaAtrasados = null;
				try {
					listaAtrasados = consertoDAO.carregarAtrasados();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao listar consertos",
							e.getMessage());
					return;
				}

				request.setAttribute("listaAtrasados", listaAtrasados);
	
				forward(request, response, "/listaAtrasados.jsp");
	
				break;

			case "prontos":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaProntos = null;
				try {
					listaProntos = consertoDAO.carregarProntos();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao listar consertos",
							e.getMessage());
					return;
				}

				request.setAttribute("listaProntos", listaProntos);
	
	
				forward(request, response, "/listaProntos.jsp");
	
				break;

			case "listarTodos":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaTodos = null;
				try {
					listaTodos = consertoDAO.carregarTodos();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao listar consertos",
							e.getMessage());
					return;
				}

				request.setAttribute("listaTodos", listaTodos);
	
				forward(request, response, "/listaPedidos.jsp");
	
				break;
				
			case "novoUsuario":
				
				usuarioDAO = null;
				try {
					usuarioDAO = new UsuarioDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Usu√°rio)", e.getMessage());
					return;
				}

				UsuarioBean usuario = FormUtil.populate(UsuarioBean.class,
						request);

				try {
					usuarioDAO.gravar(usuario, false);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao cadastrar sua conta", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=cadastroUsuario");
	
				break;
				
			case "novoCliente":
				
				clienteDAO = null;
				try {
					clienteDAO = new ClienteDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Cliente)", e.getMessage());
					return;
				}
				ClienteBean cliente = FormUtil.populate(ClienteBean.class,
						request);

				try {
					clienteDAO.gravar(cliente, false);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao cadastrar um novo cliente", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=cadastroCliente");
	
				break;
				
			case "novoPedido":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e.getMessage());
					return;
				}
				ConsertoBean conserto = FormUtil.populate(ConsertoBean.class,
						request);

				try {
					consertoDAO.gravar(conserto, false);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao cadastrar um novo conserto", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=cadastroPedido");
	
				break;
			
			case "editarUsuario":
				
				try {
					usuarioDAO = new UsuarioDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Usu·rio)", e.getMessage());
					return;
				}

				int id = Integer.valueOf(request.getParameter("id"));

				UsuarioBean u = null;
				try {
					u = usuarioDAO.carregar(id);
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao carregar dados do usu·rio", e.getMessage());
					return;
				}

				request.setAttribute("usuario", u);

				forward(request, response, "/formUsuario2.jsp");
				
				break;

			default:
				paginaErro(request, response, "AÁ„o Inexistente", null);
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
	
	private void carregarObjetosComuns(HttpServletRequest request,
			HttpServletResponse response) {

		ClienteDAO clienteDAO = null;
		try {
			clienteDAO = new ClienteDAO();
		} catch (Exception e1) {
			e1.printStackTrace();
			paginaErro(request, response, "Erro ao processar (Cliente)",
					e1.getMessage());
			return;
		}
		List<ClienteBean> listaClientes = null;
		try {
			listaClientes = clienteDAO.carregarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			paginaErro(request, response,
					"Erro ao carregar lista de clientes", e.getMessage());
			return;
		}

		request.setAttribute("listaClientes", listaClientes);
		
		EstadoDAO estadoDAO = null;
		try {
			estadoDAO = new EstadoDAO();
		} catch (Exception e1) {
			e1.printStackTrace();
			paginaErro(request, response, "Erro ao processar (Estados)",
					e1.getMessage());
			return;
		}
		List<EstadoBean> listaEstados = null;
		try {
			listaEstados = estadoDAO.carregarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			paginaErro(request, response,
					"Erro ao carregar lista de estados", e.getMessage());
			return;
		}

		request.setAttribute("listaEstados", listaEstados);

	}
}
