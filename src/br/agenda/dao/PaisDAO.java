package br.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.agenda.model.dto.Pais;
import br.agenda.dao.ConnectionFactory;

public class PaisDAO {
	// a conexão com o banco de dados
	private static Connection connection;

	// construtor que recebe a conexão
	public PaisDAO() throws SQLException {
		connection = ConnectionFactory.getConnection();
	}

	public static void adiciona(Pais o) throws SQLException {
		
		// prepared statement para incluir
		String SQL = "insert into pais (pai_nome) values (?)";

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		try {
			// seta os valores
			psm.setString(1, o.getNome());

			// executa
			psm.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados: " + e.getMessage());
		}

		psm.close();
	}
	public List<Pais> getLista() throws SQLException {

		String SQL = "select * from pais";
		PreparedStatement psm = connection.prepareStatement(SQL);
		ResultSet rs = psm.executeQuery();

		List<Pais> lista = new ArrayList<Pais>();

		while (rs.next()) {
			// criando o objeto
			Pais obj = new Pais();
			obj.setId(rs.getLong("pai_id"));
			obj.setNome(rs.getString("pai_nome"));
			
			// adicionando o objeto à lista
			lista.add(obj);
		}

		rs.close();
		psm.close();

		return lista;
	}
}
