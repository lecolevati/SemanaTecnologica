package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Perfil;
import model.Usuario;

public class LoginDao implements ILoginDao {

	private Connection c;
	
	public LoginDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public Usuario validaUsuario(Usuario user) throws SQLException {
		Usuario u = new Usuario();
		String sql = "select * from fn_user(?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, user.getSenha());
		ps.setString(2, user.getUsuario());
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			u.setNome(rs.getString("nome"));
			u.setUsuario(rs.getString("usuario"));
			u.setSenha(rs.getString("senha"));
			Perfil p = new Perfil();
			p.setCodigo(rs.getInt("codigo_perfil"));
			u.setPerfil(p);
		}
		rs.close();
		ps.close();
		return u;
	}
	
}
