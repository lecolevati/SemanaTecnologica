package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Curso;

public class CursoDao implements ICursoDao {

	private Connection c;
	
	public CursoDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public Curso consultaCurso(Curso cur) throws SQLException {
		String sql = "Select codigo, nome from cursos where codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cur.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			cur.setNome(rs.getString("nome"));
		}
		rs.close();
		ps.close();
		return cur;
	}
	
}
