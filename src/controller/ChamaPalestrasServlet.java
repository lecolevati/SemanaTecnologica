package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.CoordenadorDao;
import persistence.CursoDao;
import persistence.EventoDao;
import persistence.ICoordenadorDao;
import persistence.ICursoDao;
import persistence.IEventoDao;
import persistence.ISalaDao;
import persistence.ITipoPalestraDao;
import persistence.SalaDao;
import persistence.TipoPalestraDao;
import model.Coordenador;
import model.Curso;
import model.DataEvento;
import model.Evento;
import model.Sala;
import model.TipoPalestra;
import model.Usuario;

@WebServlet("/chamapalestras")
public class ChamaPalestrasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChamaPalestrasServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		Usuario u = new Usuario();
		u.setUsuario(request.getParameter("usuario"));
		Coordenador coord = new Coordenador();
		Curso cur = new Curso();
		List<DataEvento> listaDatas = new ArrayList<DataEvento>();
		Evento ev = new Evento();
		List<TipoPalestra> listaTipo = new ArrayList<TipoPalestra>();
		List<Sala> listaSala = new ArrayList<Sala>();
		try {
			ICoordenadorDao coordDao = new CoordenadorDao();
			coord = coordDao.consultaCoordenador(u);
			ICursoDao curDao = new CursoDao();
			cur = curDao.consultaCurso(coord.getCurso());
			IEventoDao evDao = new EventoDao();
			ev = evDao.consultaEvento();
			listaDatas = evDao.consultaDatasEvento(ev);
			ITipoPalestraDao tpDao = new TipoPalestraDao();
			listaTipo = tpDao.consultaTipos();
			ISalaDao sDao = new SalaDao();
			listaSala = sDao.listaSalas();
		} catch (SQLException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("erro", erro);
			request.setAttribute("usuario", u);
			request.setAttribute("coordenador", coord);
			request.setAttribute("curso", cur);
			request.setAttribute("evento", ev);
			request.setAttribute("listadatas", listaDatas);
			request.setAttribute("listatipo", listaTipo);
			request.setAttribute("listasala", listaSala);
			RequestDispatcher view = request.getRequestDispatcher("cadastroPalestras.jsp");
			view.forward(request, response);
		}
		
	}

}
