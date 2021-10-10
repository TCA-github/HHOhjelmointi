package servlet;

import helper.Helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarjous;
import model.Vene;
import dao.Dao_Tarjous;
import dao.Dao_Vene;


@WebServlet("/Servlet_TarjousVene")
public class Servlet_TarjousVene extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Servlet_TarjousVene() {
        super();
        System.out.println("Servlet_TarjousVene.Servlet_TarjousVene()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_TarjousVene.doGet()");
		String id = request.getParameter("Vene_id");
		id=id.replace("tarjoa_", "");
		Dao_Vene dao = new Dao_Vene();
		try {
			Vene vene = dao.haeVene(Integer.parseInt(id));			
			request.setAttribute("vene", vene);	
			ArrayList<String> kuvat = dao.haeKuvat(Integer.parseInt(id));				
			request.setAttribute("kuvat", kuvat);
			String jsp = "/tarjoavene.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_TarjousVene.doPost()");
		Helper helper = new Helper();
		String tiedot = helper.naytaMuuttujaArvoparit(request, response);
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html"); 		
	    out.println(tiedot);	
	    Tarjous tarjous = new Tarjous();
	    int vene_id = Integer.parseInt(request.getParameter("vene_id"));
	    tarjous.setVene_id(vene_id);
	    tarjous.setAsiakas_id(Integer.parseInt(request.getParameter("omistaja")));
	    Date vPaiva=null;
	    SimpleDateFormat fdate=new SimpleDateFormat("dd.MM.yyyy");	    	
    	try {
			vPaiva = fdate.parse(request.getParameter("voimassapaiva"));
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		tarjous.setVoimassapaiva(vPaiva);
		tarjous.setTarjous(Integer.parseInt(request.getParameter("maara")));
	    Dao_Tarjous dao = new Dao_Tarjous();
	    if(dao.lisaaTarjous(tarjous)){//Tehd‰‰n uusi tarjous	    							
	    	response.sendRedirect("Servlet_HaeTarjoukset?Vene_id=" + vene_id);
		}else{
			response.sendRedirect("Servlet_TarjousVene?Vene_id=tarjoa_" + vene_id);
		}   
	    
	}

}
