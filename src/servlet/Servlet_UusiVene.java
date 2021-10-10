package servlet;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Vene;
import model.Vene;

@WebServlet("/Servlet_UusiVene")
public class Servlet_UusiVene extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet_UusiVene() {
    	super();
    	System.out.println("Servlet_UusiVene.Servlet_UusiVene()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiVene.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiVene.doPost()");
		/*
		Helper helper = new Helper();
		String tiedot = helper.naytaMuuttujaArvoparit(request, response);
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html"); 		
	    out.println(tiedot);	
	    */
	    Vene vene = new Vene();
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
	    if(dao.lisaaVene(vene)){
			try {
				response.sendRedirect("Servlet_HaeVeneet?hakusana=" + dao.haeArvo("Malli", "VV_Mallit", "Malli_id", vene.getMalli_id()));
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}else{
			response.sendRedirect("uusivene.jsp?ok=0");
		}    
	}
}










