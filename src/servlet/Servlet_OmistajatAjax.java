package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet("/Servlet_OmistajatAjax")
public class Servlet_OmistajatAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Servlet_OmistajatAjax() {
        super();
        System.out.println("Servlet_OmistajatAjax.Servlet_OmistajatAjax()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_OmistajatAjax.doGet()");
		Dao dao = new Dao();
		try {
			String[] sarakkeet={"Asiakas_id", "Etunimi", "Sukunimi"};
			String strJSON = dao.haeTiedotJSON(sarakkeet,"VV_Asiakkaat","Poistettu","0",3);
			PrintWriter out = response.getWriter(  );
		    response.setContentType("text/html"); 
		    out.println(strJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_OmistajatAjax.doPost()");
	}

}
