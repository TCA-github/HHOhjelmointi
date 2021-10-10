package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vene;
import dao.Dao_Vene;


@WebServlet("/Servlet_MuokkaaVene")
public class Servlet_MuokkaaVene extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_MuokkaaVene() {
        super();
        System.out.println("Servlet_MuokkaaVene.Servlet_MuokkaaVene()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaVene.doGet()");
		String id = request.getParameter("Vene_id");
		id=id.replace("muokkaa_", "");
		Dao_Vene dao = new Dao_Vene();
		try {
			Vene vene = dao.haeVene(Integer.parseInt(id));			
			request.setAttribute("vene", vene);	
			request.setAttribute("kuva", dao.haePaaKuva(Integer.parseInt(id)));
			String jsp = "/muokkaavene.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaVene.doPost()");
		Vene vene = new Vene();
	    vene.setVene_id(Integer.parseInt(request.getParameter("vene_id")));
		vene.setMalli_id(Integer.parseInt(request.getParameter("malli")));
	    vene.setVuosimalli(Integer.parseInt(request.getParameter("vuosimalli")));
	    vene.setOstohinta(Integer.parseInt(request.getParameter("ostohinta")));
	    vene.setHintapyynto(Integer.parseInt(request.getParameter("hintapyynto")));
	    vene.setTiukkahinta(Integer.parseInt(request.getParameter("tiukkahinta")));
	    String tulopaiva = request.getParameter("tulopaiva");
	    System.out.println("Tulop‰iv‰ "  + tulopaiva);
	    Date tPaiva=null;
	    if(tulopaiva.length()>0){//Jos tulop‰iv‰ on tiedossa, k‰‰nnet‰‰n String->Date
	    	SimpleDateFormat fdate=new SimpleDateFormat("dd.MM.yyyy");	    	
	    	try {
				tPaiva = fdate.parse(tulopaiva);
			} catch (ParseException e) {				
				e.printStackTrace();
			}	    	
	    }else{
	    	vene.setTulopaiva(null);
	    }
	    vene.setTulopaiva(tPaiva);//Pit‰‰ v‰litt‰‰ Date
	    vene.setOmistaja(Integer.parseInt(request.getParameter("omistaja")));
	    String valitysvene = request.getParameter("valitysvene");
	    if(valitysvene==null){
	    	vene.setValitysvene(0);
	    }else{
	    	vene.setValitysvene(1);
	    }
	    vene.setKuvaus(request.getParameter("kuvaus"));
	    vene.setLisatietoja(request.getParameter("lisatietoja"));
	    Dao_Vene dao = new Dao_Vene();
	    if(dao.muutaVene(vene)){
			try {
				response.sendRedirect("Servlet_HaeVeneet?hakusana=" + dao.haeArvo("Malli", "VV_Mallit", "Malli_id", vene.getMalli_id()));
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}else{
			response.sendRedirect("muokkaavene.jsp?ok=0");
		}    
	}
}
