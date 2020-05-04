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

public class ApagarContatoAction extends HttpServlet {

	private static final long serialVersionUID = 3247826716106213413L;

	protected void doGet(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		
		System.out.println(rqt.getParameter("codigo"));
		Long id = Long.parseLong(rqt.getParameter("codigo"));
		Contato contato = new Contato();
		contato.setId(id);
		try {
			ContatoDAO.exclui(contato);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}
        rqt.setAttribute("contato", contato);
        
		RequestDispatcher view = rqt.getRequestDispatcher("/index.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
