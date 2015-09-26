package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Sala;

public interface ISalaDao {

	public List<Sala> listaSalas() throws SQLException;
	
}
