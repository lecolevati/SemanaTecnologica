package persistence;

import java.sql.SQLException;
import java.util.List;

import model.TipoPalestra;

public interface ITipoPalestraDao {

	public List<TipoPalestra> consultaTipos() throws SQLException;
	
}
