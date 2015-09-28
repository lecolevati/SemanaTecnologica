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
import persistence.IPalestrasDao;
import persistence.ISalaDao;
import persistence.ITipoPalestraDao;
import persistence.PalestrasDao;
import persistence.SalaDao;
import persistence.TipoPalestraDao;
import model.Coordenador;
import model.Curso;
import model.DataEvento;
import model.Evento;
import model.Palestra;
import model.Sala;
import model.TipoPalestra;
import model.Usuario;

@WebServlet("/cadastropalestra")
public class CadastroPalestraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroPalestraServlet() {
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
		Palestra p = new Palestra();
		p.setCodigo(request.getParameter("codigo"));
		p.setTitulo(request.getParameter("titulo"));
		p.setTitulacao(request.getParameter("titulacao"));
		p.setPalestrante(request.getParameter("nome"));
		p.setEmpresa(request.getParameter("empresa"));
		p.setDuracao(Integer.parseInt(request.getParameter("duracao")));
		p.setDt(request.getParameter("dia"));
		p.setHr(request.getParameter("hora"));
		TipoPalestra tp = new TipoPalestra();
		Curso cur = new Curso();
		Evento ev = new Evento();
		Sala sl = new Sala();
		tp.setCodigo(Integer.parseInt(request.getParameter("tipo")));
		cur.setCodigo(Integer.parseInt(request.getParameter("codigocurso")));
		ev.setCodigo(Integer.parseInt(request.getParameter("codigoevento")));
		sl.setNumero(Integer.parseInt(request.getParameter("sala")));
		p.setTipo(tp);
		p.setCurso(cur);
		p.setEvento(ev);
		p.setSala(sl);
		Usuario u = new Usuario();
		u.setUsuario(request.getParameter("usuario"));
		Coordenador coord = new Coordenador();
		List<DataEvento> listaDatas = new ArrayList<DataEvento>();
		List<TipoPalestra> listaTipo = new ArrayList<TipoPalestra>();
		List<Sala> listaSala = new ArrayList<Sala>();
		List<Palestra> listaPalestra = new ArrayList<Palestra>();
		try {
			IPalestrasDao pDao = new PalestrasDao();
			pDao.iuPalestras(p);
			ICoordenadorDao coordDao = new CoordenadorDao();
			coord = coordDao.consultaCoordenador(u);
			ICursoDao curDao = new CursoDao();
			cur = curDao.consultaCurso(cur);
			IEventoDao evDao = new EventoDao();
			ev = evDao.consultaEvento();
			listaDatas = evDao.consultaDatasEvento(ev);
			ITipoPalestraDao tpDao = new TipoPalestraDao();
			listaTipo = tpDao.consultaTipos();
			ISalaDao sDao = new SalaDao();
			listaSala = sDao.listaSalas();
			listaPalestra = pDao.consultaReduzidaPalestras(cur);
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
			request.setAttribute("listapalestra", listaPalestra);

			RequestDispatcher view = request.getRequestDispatcher("cadastroPalestras.jsp");
			view.forward(request, response);
		}
	}
}
