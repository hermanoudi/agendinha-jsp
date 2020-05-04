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

import br.agenda.dao.ContatoDAO;
import br.agenda.model.dto.Contato;

public class PesquisarContatoAction extends HttpServlet {

	private static final long serialVersionUID = 3247826716106213413L;

	protected void doPost(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		
		String nome = rqt.getParameter("nome");
		
		ArrayList<Contato> list = new ArrayList<Contato>();
		
		try {
			list = (ArrayList<Contato>) ContatoDAO.getPesquisa(nome);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}
        rqt.setAttribute("list", list);
        
		RequestDispatcher view = rqt.getRequestDispatcher("/resultados.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
