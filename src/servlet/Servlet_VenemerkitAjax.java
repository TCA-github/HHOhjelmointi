package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;



@WebServlet("/Servlet_VenemerkitAjax")
public class Servlet_VenemerkitAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public Servlet_VenemerkitAjax() {
        super();
        System.out.println("Servlet_VenemerkitAjax.Servlet_VenemerkitAjax()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VenemerkitAjax.doGet()");
		Dao dao = new Dao();
		try {
			String[] sarakkeet={"VMerkki_id", "VMerkki"};
			String strJSON = dao.haeTiedotJSON(sarakkeet,"VV_Venemerkit","","",2);
			PrintWriter out = response.getWriter(  );
		    response.setContentType("text/html"); 
		    out.println(strJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VenemerkitAjax.doPost()");
	}
}
