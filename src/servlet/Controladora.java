package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

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

		HttpSession session = request.getSession();

		LoginBean loginBean;

		UsuarioDAO usuarioDAO = null;
		ConsertoDAO consertoDAO = null;
		ClienteDAO clienteDAO = null;

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
							"Erro ao processar (Usu�rio)", e1.getMessage());
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
					paginaErro(request, response, "Erro ao pesquisar usu�rios",
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
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaConsertos = null;
				List<String> camposConserto = new ArrayList<>();
				camposConserto.add("nome");
				camposConserto.add("modelo");
				camposConserto.add("fabricante");
				camposConserto.add("descricao");

				try {

					String pesquisa2 = request.getParameter("pesquisa");
					String idTeste = request.getParameter("id");
					String data1 = request.getParameter("data1");
					String data2 = request.getParameter("data2");
					System.out.println(data1);					

					if (pesquisa2 != null && pesquisa2.length() > 0){
						listaConsertos = consertoDAO.pesquisar(pesquisa2, camposConserto);
					}else if(idTeste != null){
						List<ConsertoBean> lista = new ArrayList<>();
						lista.add(consertoDAO.carregar(Integer.valueOf(idTeste)));		
						listaConsertos = lista;
					}else if(data1 !=null && data2 != null){
						SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
						Date date1 = from.parse(data1);
						Date date2 = from.parse(data2);
						String d1 = to.format(date1);
						String d2 = to.format(date2);
						listaConsertos =consertoDAO.pesquisaData(d1, d2);
					}else{
						listaConsertos = consertoDAO.carregarTodos();
					}
						
					
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao pesquisar conserto",
							e.getMessage());
					return;
				}
				request.setAttribute("listaConsertos", listaConsertos);

				forward(request, response, "/busca.jsp");
				
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
							"Erro ao processar (Usuário)", e.getMessage());
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
							"Erro ao processar (Usu�rio)", e.getMessage());
					return;
				}

				int id = Integer.valueOf(request.getParameter("id"));

				UsuarioBean u = null;
				try {
					u = usuarioDAO.carregar(id);
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao carregar dados do usu�rio", e.getMessage());
					return;
				}

				request.setAttribute("usuario", u);

				forward(request, response, "/formUsuario2.jsp");
				
				break;
				
			case "relatorio":
				
				forward(request, response, "/relatorio.jsp");
				
				break;
				
			case "pesquisaCliente":
				
				clienteDAO = null;
				try {
					clienteDAO = new ClienteDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Cliente)", e1.getMessage());
					return;
				}

				List<ClienteBean> listaClientes = null;
				List<String> camposCliente = new ArrayList<>();
				camposCliente.add("nome");
				camposCliente.add("email");
				camposCliente.add("cpf");

				try {

					String pesquisa2 = request.getParameter("pesquisa");
					

					if (pesquisa2 != null && pesquisa2.length() > 0)
						listaClientes = clienteDAO.pesquisar(pesquisa2, camposCliente);
					else
						listaClientes = clienteDAO.carregarTodos();
					
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao pesquisar cliente",
							e.getMessage());
					return;
				}
				request.setAttribute("listaClientes", listaClientes);
				//System.out.print(listaUsuarios);
				//forward(request, response, "/listaUsers.jsp");
				
				forward(request, response, "/pesquisaCliente.jsp");
				
				break;
				
			case "editarCliente":
				
				try {
					clienteDAO = new ClienteDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Cliente)", e.getMessage());
					return;
				}

				int idC = Integer.valueOf(request.getParameter("id"));

				ClienteBean c = null;
				try {
					c = clienteDAO.carregar(idC);
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao carregar dados do cliente", e.getMessage());
					return;
				}

				request.setAttribute("cliente", c);

				forward(request, response, "/formCliente2.jsp");
				
				break;
				
			case "editCliente":
				
				clienteDAO = null;
				try {
					clienteDAO = new ClienteDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Cliente)", e.getMessage());
					return;
				}
				ClienteBean cliente2 = FormUtil.populate(ClienteBean.class,
						request);

				try {
					clienteDAO.gravar(cliente2, true);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar um cliente", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=pesquisaCliente");
				
				break;
				
			case "editUsuario":
				
				usuarioDAO = null;
				try {
					usuarioDAO = new UsuarioDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Usuário)", e.getMessage());
					return;
				}

				UsuarioBean usuario2 = FormUtil.populate(UsuarioBean.class,
						request);

				try {
					usuarioDAO.gravar(usuario2, true);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar sua conta", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=pesquisaUsuario");
				
				break;
				
			case "pagos":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaPagos = null;
				try {
					listaPagos = consertoDAO.carregarPagos();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao listar consertos",
							e.getMessage());
					return;
				}

				request.setAttribute("listaPagos", listaPagos);
	
	
				forward(request, response, "/listaPagos.jsp");
	
				break;
				
			case "finalizados":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e1.getMessage());
					return;
				}

				List<ConsertoBean> listaFinalizados = null;
				try {
					listaFinalizados= consertoDAO.carregarFinalizados();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response, "Erro ao listar consertos",
							e.getMessage());
					return;
				}

				request.setAttribute("listaFinalizados", listaFinalizados);
	
	
				forward(request, response, "/listaFinalizados.jsp");
	
				break;
				
			case "editarConserto":
				
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e.getMessage());
					return;
				}

				int idCon = Integer.valueOf(request.getParameter("id"));

				ConsertoBean con = null;
				try {
					con = consertoDAO.carregar(idCon);
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao carregar dados do conserto", e.getMessage());
					return;
				}

				request.setAttribute("conserto", con);

				forward(request, response, "/formPedido2.jsp");
				
				break;
				
			case "editPedido":
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e.getMessage());
					return;
				}

				ConsertoBean conserto2 = FormUtil.populate(ConsertoBean.class,
						request);

				try {
					consertoDAO.gravar(conserto2, true);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar o conserto", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=listarTodos");
				
				break;
				

			case "done":
				
				int idDone = Integer.valueOf(request.getParameter("id"));
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e.getMessage());
					return;
				}
				
				try {
					consertoDAO.pronto(idDone);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar o conserto", e1.getMessage());
					return;
				}
				
				int cli = Integer.valueOf(request.getParameter("cli"));
				try{
					clienteDAO = null;
					clienteDAO = new ClienteDAO();
					consertoDAO = null;
					consertoDAO = new ConsertoDAO();
					ClienteBean c3 = clienteDAO.email(cli);
					ConsertoBean c4 = consertoDAO.carregar(idDone);
					String mail = c3.getEmail();
					Email email = new SimpleEmail();
					email.setHostName("smtp.googlemail.com");
					email.setSmtpPort(465);
					email.setAuthenticator(new DefaultAuthenticator("cenibrac.dim2012", "pistache00"));
					email.setSSLOnConnect(true);
					email.setFrom("cenibrac.dim2012@gmail.com");
					email.setSubject("Pedido n� " + c4.getId() + " est� pronto");
					email.setMsg("Estamos aguardando o pagamento do seu pedido \nModelo: " + c4.getModelo() +"\nFabricante: " + c4.getFabricante() + "\nObrigado pela Prefer�ncia!\nAtt Naotebuk");
					email.addTo(mail);
					email.send();
				}catch(Exception e1){
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar o conserto", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=prontos");
				
				break;
				
			case "pago":
				
				int idPago = Integer.valueOf(request.getParameter("id"));
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e.getMessage());
					return;
				}
				
				try {
					consertoDAO.pago(idPago);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar o conserto", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=pagos");
				
				break;
				
			case "finalizar":
				
				int idFinal = Integer.valueOf(request.getParameter("id"));
				
				consertoDAO = null;
				try {
					consertoDAO = new ConsertoDAO();
				} catch (Exception e) {
					e.printStackTrace();
					paginaErro(request, response,
							"Erro ao processar (Conserto)", e.getMessage());
					return;
				}
				
				try {
					consertoDAO.finalizar(idFinal);
				} catch (Exception e1) {
					e1.printStackTrace();
					paginaErro(request, response,
							"Erro ao editar o conserto", e1.getMessage());
					return;
				}

				response.sendRedirect("Controladora?action=finalizados");
				
				break;

			default:
				paginaErro(request, response, "A��o Inexistente", null);
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
