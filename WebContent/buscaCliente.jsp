<div class="row">		
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td>
							<form action="busca.jsp" method="get">
								<label>Palavra-chave</label>
								<div class="form-group">
									<input type="text" class="form-control"
											name="chave" value="" id="">
								</div>
								<button type="submit" value="" class="btn btn-primary">
									Pesquisar
								</button>
							</form>
							</td>
						</tr>
					</tbody>
				</table>	

				<hr>
			</div>
<div class="row">
				<%
					if(request.getParameter("chave")!=null && !request.getParameter("chave").equals("")){
						out.print("<table class='table'>"
		     				+"<thead>"
		     					+"<tr>"
		     						+"<th width='250px'>Cliente</th>"
		     						+"<th>CPF</th>"
		     						+"<th>E-mail</th>"
		     						+"<th>Link</th>"
		     					+"</tr>"
		     				+"</thead>");
						out.print("</table>");
					}
				%>
			</div>