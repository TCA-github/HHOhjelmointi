package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Vene;


@WebServlet("/Servlet_LisaaMerkki")
public class Servlet_LisaaMerkki extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_LisaaMerkki() {
        super();
        System.out.println("Servlet_LisaaMerkki.Servlet_LisaaMerkki()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_LisaaMerkki.doGet()");
		String merkki = request.getParameter("merkki");
		Dao_Vene dao = new Dao_Vene();
		try {
			//kirjoitetaan ajaxille vastaus merkin lis‰‰misen onnistumisesta
			PrintWriter out = response.getWriter();
		    response.setContentType("text/html"); 	
		    if(dao.lisaaMerkki(merkki)){
		    	out.println(1);	
		    }else{
		    	out.println(0);	
		    }		    
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_LisaaMerkki.doPost()");
	}

}
