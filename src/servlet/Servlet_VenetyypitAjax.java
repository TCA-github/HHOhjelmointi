package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;


@WebServlet("/Servlet_VenetyypitAjax")
public class Servlet_VenetyypitAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet_VenetyypitAjax() {
        super();
       System.out.println("Servlet_VenetyypitAjax.Servlet_VenetyypitAjax()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VenetyypitAjax.doGet()");
		Dao dao = new Dao();
		try {
			String[] sarakkeet={"Tyyppi_id", "Tyyppi"};
			String strJSON = dao.haeTiedotJSON(sarakkeet,"VV_Tyypit","","",1);
			PrintWriter out = response.getWriter(  );
		    response.setContentType("text/html"); 
		    out.println(strJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VenetyypitAjax.doPost()");
	}

}
