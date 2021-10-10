package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venemalli;
import dao.Dao_Vene;

@WebServlet("/Servlet_LisaaMalli")
public class Servlet_LisaaMalli extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Servlet_LisaaMalli() {
        super();
        System.out.println("Servlet_LisaaMalli.Servlet_LisaaMalli()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_LisaaMalli.doGet()");		
		Venemalli veneMalli = new Venemalli();
		veneMalli.setMalli(request.getParameter("malli").trim());
		veneMalli.setMerkki_id(Integer.parseInt(request.getParameter("merkki_id")));
		veneMalli.setPituus(Double.parseDouble(request.getParameter("pituus")));
		veneMalli.setLeveys(Double.parseDouble(request.getParameter("leveys")));
		veneMalli.setPaino(Integer.parseInt(request.getParameter("paino")));
		veneMalli.setTyyppi_id(Integer.parseInt(request.getParameter("tyyppi_id")));
		Dao_Vene dao = new Dao_Vene();
		try {
			//kirjoitetaan ajaxille vastaus mallin lis‰‰misen onnistumisesta
			PrintWriter out = response.getWriter();
		    response.setContentType("text/html"); 	
		    if(dao.lisaaMalli(veneMalli)){
		    	out.println(1);	
		    }else{
		    	out.println(0);	
		    }			
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_LisaaMalli.doPost()");
	}

}
