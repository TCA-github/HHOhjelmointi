package servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Asiakas;
import model.Asiakas;

@WebServlet("/Servlet_UusiAsiakas")
public class Servlet_UusiAsiakas extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Servlet_UusiAsiakas() {
        super();
        System.out.println("Servlet_UusiAsiakas.Servlet_UusiAsiakas()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiAsiakas.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiAsiakas.doPost()");
		/*
		Helper helper = new Helper();
		String tiedot = helper.naytaMuuttujaArvoparit(request, response);
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html"); 		
	    out.println(tiedot);	
	    */
		
		Asiakas asiakas = new Asiakas();
		asiakas.setEtunimi(request.getParameter("etunimi"));
		asiakas.setSukunimi(request.getParameter("sukunimi"));
		asiakas.setKatuosoite(request.getParameter("katuosoite"));
		asiakas.setPostinumero(request.getParameter("postinumero"));
		asiakas.setSahkoposti(request.getParameter("sahkoposti"));
		asiakas.setSalasana(request.getParameter("salasana"));
		asiakas.setPuhelin(request.getParameter("puhelin"));
		asiakas.setLisatietoja(request.getParameter("lisatietoja"));
		
		Dao_Asiakas dao = new Dao_Asiakas();
		if(dao.lisaaAsiakas(asiakas)){
			response.sendRedirect("uusiasiakas.jsp?ok=1");
		}else{
			response.sendRedirect("uusiasiakas.jsp?ok=0");
		}
		
		
		
	}
}













