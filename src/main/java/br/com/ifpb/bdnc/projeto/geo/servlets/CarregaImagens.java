package br.com.ifpb.bdnc.projeto.geo.servlets;

import br.com.ifpb.bdnc.projeto.geo.entities.Image;
import br.com.ifpb.bdnc.projeto.geo.persistence.Persister;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DouglasGabriel
 */
public class CarregaImagens extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Image> images = (List<Image>)Persister.getAll();
        request.setAttribute("images", images);
        request.getServletContext().getRequestDispatcher("/mapas.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
