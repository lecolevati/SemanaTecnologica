package persistence;

import java.sql.SQLException;

import model.Usuario;

public interface ILoginDao {

	public Usuario validaUsuario(Usuario user) throws SQLException;
	
}
