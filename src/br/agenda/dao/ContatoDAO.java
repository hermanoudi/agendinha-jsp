package br.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.agenda.model.dto.Cidade;
import br.agenda.model.dto.Bairro;
import br.agenda.model.dto.Pais;
import br.agenda.model.dto.Contato;

import br.agenda.dao.ConnectionFactory;

;



public class ContatoDAO {
	// a conexão com o banco de dados
	private static Connection connection;

	// construtor que recebe a conexão
	public ContatoDAO() throws SQLException {
		connection = ConnectionFactory.getConnection();
	}

	public static void adiciona(Contato o) throws SQLException {
		
		// prepared statement para incluir
		String SQL = "insert into contato (con_nome, con_endereco, bai_id, cid_id, con_residencial, con_comercial, con_celular, con_email, con_msn, pai_id) values (?,?,?,?,?,?,?,?,?,?)";

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		try {
			// seta os valores
			psm.setString(1, o.getNome());
			psm.setString(2, o.getEndereco());
			psm.setLong(3, o.getIdBairro().getId());
			psm.setLong(4, o.getIdCidade().getId());
			psm.setString(5, o.getResidencial());
			psm.setString(6, o.getComercial());
			psm.setString(7, o.getCelular());
			psm.setString(8, o.getEmail());
			psm.setString(9, o.getMsn());
			psm.setLong(10, o.getIdPais().getId());
			
			// executa
			psm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir dados");
		}

		psm.close();
	}
	
	public static void exclui(Contato obj) throws SQLException {

		// prepared statement para excluir
		String SQL = "delete from contato where con_id=?";
		PreparedStatement psm = connection.prepareStatement(SQL);
		try {
			// seta os valores
			psm.setLong(1, obj.getId());

			// executa
			psm.execute();
		} catch (SQLException e) {
			System.out.println("Erro no SQL: " + SQL + " - Erro: " + e.getMessage());
		}
		
		psm.close();
	}
	
	
	
	public static void altera(Contato o) throws SQLException {

		// prepared statement para alterar
		String SQL = "update contato set con_nome=?, con_endereco=?, bai_id=?, cid_id=?, con_residencial=?, con_comercial=?, con_celular=?, con_email=?, con_msn=?, pai_id=?  where con_id=?";

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		try {
			// seta os valores
			psm.setString(1, o.getNome());
			psm.setString(2, o.getEndereco());
			psm.setLong(3, o.getIdBairro().getId());
			psm.setLong(4, o.getIdCidade().getId());
			psm.setString(5, o.getResidencial());
			psm.setString(6, o.getComercial());
			psm.setString(7, o.getCelular());
			psm.setString(8, o.getEmail());
			psm.setString(9, o.getMsn());
			psm.setLong(10, o.getIdPais().getId());
			psm.setLong(11, o.getId());

			// executa
			psm.executeUpdate();
		} catch (SQLException e) {
	             System.out.println("Erro no SQL");
		}
		//fechar comando
		psm.close();
	}
	
	
   public static Contato carrega(Long id) throws SQLException {
		
		String SQL = "SELECT c.con_id, c.con_nome, c.con_endereco, " +
				             "c.bai_id, b.bai_nome, c.cid_id, cid.cid_nome, " +
				             "c.con_residencial, c.con_comercial, c.con_celular, c.con_email, " +
				             "c.con_msn, c.pai_id, p.pai_nome " +
				       "FROM contato c, cidade cid, bairro b, pais p " +
				      "WHERE cid.cid_id = c.cid_id " +
				        "AND b.bai_id   = c.bai_id " +
				        "AND p.pai_id   = c.pai_id " +
				        "AND c.con_id=?";
		Contato c = new Contato();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		psm.setLong(1,id);
		ResultSet rs = psm.executeQuery();

		if (!rs.next())
			return null;

		Pais nac = new Pais();
		nac.setId(rs.getLong("pai_id"));
		nac.setNome(rs.getString("pai_nome"));
		
		Cidade cid = new Cidade();
		cid.setId(rs.getLong("cid_id"));
		cid.setNome(rs.getString("cid_nome"));
		
		Bairro bai = new Bairro();
		bai.setId(rs.getLong("bai_id"));
		bai.setNome(rs.getString("bai_nome"));
		
		c.setId(rs.getLong("con_id"));
		c.setNome(rs.getString("con_nome"));
		c.setEndereco(rs.getString("con_endereco"));
		c.setIdBairro(bai);
		c.setIdCidade(cid);
		c.setResidencial(rs.getString("con_residencial"));
		c.setComercial(rs.getString("con_comercial"));
		c.setCelular(rs.getString("con_celular"));
		c.setEmail(rs.getString("con_email"));
		c.setMsn(rs.getString("con_msn"));
		c.setIdPais(nac);
		
		rs.close();
		psm.close();
		return c;
	}

	

   
   
   
   
   
   
	public List<Contato> getLista() throws SQLException {

		String SQL = "SELECT  c.con_id, c.con_nome, c.con_endereco, " +
				             "c.bai_id, b.bai_nome, c.cid_id, cid.cid_nome, c.con_residencial, " +
				             "c.con_comercial, c.con_celular, c.con_email, c.con_msn, " +
				             "c.pai_id, p.pai_nome " +
				       "FROM contato c, bairro b, cidade cid, pais p " +
				      "WHERE b.bai_id = c.bai_id " +
				        "AND cid.cid_id = c.cid_id " +
				        "AND p.pai_id = c.pai_id " +
				   "ORDER BY c.con_nome";
		
		PreparedStatement psm = connection.prepareStatement(SQL);
		ResultSet rs = psm.executeQuery();

		List<Contato> lista = new ArrayList<Contato>();
			
		while (rs.next()) {
			// criando o objeto
			Contato o = new Contato();
			o.setId(rs.getLong("con_id"));
			o.setNome(rs.getString("con_nome"));
			o.setEndereco(rs.getString("con_endereco"));
			
			Bairro bai = new Bairro();
			bai.setId(rs.getLong("bai_id"));
			bai.setNome(rs.getString("bai_nome"));
			o.setIdBairro(bai);
			
			
			Cidade cid = new Cidade();
			cid.setId(rs.getLong("cid_id"));
			cid.setNome(rs.getString("cid_nome"));
			o.setIdCidade(cid);
			
			o.setResidencial(rs.getString("con_residencial"));
			o.setComercial(rs.getString("con_comercial"));
			o.setCelular(rs.getString("con_celular"));
			o.setEmail(rs.getString("con_email"));
			o.setMsn(rs.getString("con_msn"));
			Pais pai = new Pais();
			pai.setId(rs.getLong("pai_id"));
			o.setIdPais(pai);
			
			
			// adicionando o objeto à lista
			lista.add(o);
		}

		rs.close();
		psm.close();

		return lista;
	}


 public static List<Contato> getPesquisa(String nome) throws SQLException {

	    String SQL = "SELECT c.con_id, c.con_nome, c.con_endereco, " +
					 		 "c.bai_id, b.bai_nome, c.cid_id, cid.cid_nome, c.con_residencial, c.con_comercial, " +
					 		 "c.con_celular, c.con_email, c.con_msn, p.pai_id " +
					   "FROM contato c, bairro b, cidade cid, pais p " +
					  "WHERE cid.cid_id = c.cid_id " +
					    "AND b.bai_id   = c.bai_id " +
					    "AND p.pai_id   = c.pai_id " +
					    "AND c.con_nome like upper(?)";
		
		Contato c = new Contato();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		//aqui
		psm.setString(1,"%"+nome+"%");
		ResultSet rs = psm.executeQuery();

		List<Contato> list = new ArrayList<Contato>();
		
		while (rs.next()) {
			// criando o objeto
			Contato o = new Contato();
			o.setId(rs.getLong("con_id"));
			o.setNome(rs.getString("con_nome"));
			o.setEndereco(rs.getString("con_endereco"));
			
			Bairro bai = new Bairro();
			bai.setId(rs.getLong("bai_id"));
			bai.setNome(rs.getString("bai_nome"));
			o.setIdBairro(bai);
			
			
			Cidade cid = new Cidade();
			cid.setId(rs.getLong("cid_id"));
			cid.setNome(rs.getString("cid_nome"));
			o.setIdCidade(cid);
			
			o.setResidencial(rs.getString("con_residencial"));
			o.setComercial(rs.getString("con_comercial"));
			o.setCelular(rs.getString("con_celular"));
			o.setEmail(rs.getString("con_email"));
			o.setMsn(rs.getString("con_msn"));
			Pais pai = new Pais();
			pai.setId(rs.getLong("pai_id"));
			o.setIdPais(pai);
			
			
			// adicionando o objeto à lista
			list.add(o);
		}

		rs.close();
		psm.close();

		return list;
	}

	
	
	
	
	
}

