package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Asiakas;
import model.Tarjous;
import model.Vene;
import dao.Dao_Tarjous;
import dao.Dao_Vene;

@WebServlet("/Servlet_HaeTarjoukset")
public class Servlet_HaeTarjoukset extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public Servlet_HaeTarjoukset() {
       super();
       System.out.println("Servlet_HaeTarjoukset.Servlet_HaeTarjoukset()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeTarjoukset.doGet()");
		String veneStr = request.getParameter("Vene_id");		
		veneStr = veneStr.replace("tarjoa_", "");		
		int vene_id = Integer.parseInt(veneStr);
		Dao_Tarjous dao = new Dao_Tarjous();
		Dao_Vene daoVene = new Dao_Vene();
		try {
			Vene vene = daoVene.haeVene(vene_id);
			request.setAttribute("vene", vene);			
			ArrayList<Tarjous> tarjoukset = dao.haeTarjoukset(vene_id);
			ArrayList<Asiakas> asiakkaat = new ArrayList<Asiakas>();
			for(int i=0;i<tarjoukset.size();i++){ //etsitään tarjousten asiakkaat
				Asiakas asiakas = dao.etsiAsiakas(tarjoukset.get(i).getTarjous_id());
				asiakkaat.add(asiakas);
			}
			request.setAttribute("tarjoukset", tarjoukset);
			request.setAttribute("asiakkaat", asiakkaat);
			String jsp = "/venetarjoukset.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeTarjoukset.doPost()");
	}

}
