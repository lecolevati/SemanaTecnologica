package persistence;

import java.sql.SQLException;

import model.Coordenador;
import model.Usuario;

public interface ICoordenadorDao {

	public Coordenador consultaCoordenador(Usuario u) throws SQLException;
	
}
