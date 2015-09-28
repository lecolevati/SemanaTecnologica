package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Curso;
import model.Palestra;

public interface IPalestrasDao {

	public void iuPalestras(Palestra palestra) throws SQLException;
	public void deletePalestras(Palestra palestra) throws SQLException;
	public List<Palestra> consultaReduzidaPalestras(Curso curso) throws SQLException;
	
}
