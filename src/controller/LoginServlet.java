package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.ILoginDao;
import persistence.LoginDao;
import model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String erro = "";
		String mensagem = "";
		String url = "";
		Usuario u = new Usuario();
		u.setUsuario(request.getParameter("login"));
		u.setSenha(request.getParameter("senha"));
		try {
			ILoginDao lDao = new LoginDao();
			u = lDao.validaUsuario(u);
			if (!u.getNome().equals("") || u.getNome() != null) {
				session.setAttribute("login", u);
				url = "index.jsp"; 
			} else {
				session.invalidate();
				mensagem = "Login e/ou Senha Inválidos";
				url = "login.jsp";
			}
		} catch (SQLException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("erro", erro);
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher view = request.getRequestDispatcher(url);
			view.forward(request, response);
		}
	}
}
