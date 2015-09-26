package persistence;

import java.sql.SQLException;

import model.Curso;

public interface ICursoDao {

	public Curso consultaCurso(Curso cur) throws SQLException;
	
}
