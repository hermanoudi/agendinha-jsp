package br.agenda.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.agenda.dao.ContatoDAO;
import br.agenda.model.dto.Contato;

public class ContatoAction extends HttpServlet {

	private static final long serialVersionUID = 3247826716106213413L;

	protected void doPost(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		HttpSession session = rqt.getSession();
		
		String nome     	= rqt.getParameter("nome");
		Contato o = new Contato();
		o.setNome(nome);
		
		ArrayList<Contato> lista = new ArrayList<Contato>();
		
		try {
			ContatoDAO dao = new ContatoDAO();
			//lista = (ArrayList<Contato>)dao.getLista(nome);
			session.setAttribute("lista", lista);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}

		RequestDispatcher view = rqt.getRequestDispatcher("/index.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
