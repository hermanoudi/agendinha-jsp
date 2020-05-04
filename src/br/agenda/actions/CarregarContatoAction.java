package br.agenda.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.agenda.dao.ContatoDAO;
import br.agenda.model.dto.Bairro;
import br.agenda.model.dto.Cidade;
import br.agenda.model.dto.Contato;
import br.agenda.model.dto.Pais;

public class CarregarContatoAction extends HttpServlet {

	private static final long serialVersionUID = 3247826716106213413L;

	protected void doPost(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		
		Long id = Long.parseLong(rqt.getParameter("selected_contato"));
		Contato contato = new Contato();
		try {
			contato = ContatoDAO.carrega(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}
        rqt.setAttribute("contato", contato);
        
		RequestDispatcher view = rqt.getRequestDispatcher("/alteracontato.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
