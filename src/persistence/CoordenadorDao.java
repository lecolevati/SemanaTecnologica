package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Coordenador;
import model.Curso;
import model.Usuario;

public class CoordenadorDao implements ICoordenadorDao {

	private Connection c;
	
	public CoordenadorDao() throws SQLException {
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public Coordenador consultaCoordenador(Usuario u) throws SQLException {
		Coordenador coord = new Coordenador();
		String sql = "select codigo, nome, curso from coordenador where usuario = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, u.getUsuario());
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			coord.setCodigo(rs.getInt("codigo"));
			coord.setNome(rs.getString("nome"));
			Curso cur = new Curso();
			cur.setCodigo(rs.getInt("curso"));
			coord.setCurso(cur);
		}
		rs.close();
		ps.close();
		return coord;
	}
	
}
