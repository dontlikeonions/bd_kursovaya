package servlets.select;

import dao.MainPageLeftTableDAO;
import dao.MainPageRightTableDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;


@WebServlet("/SelectGeneralView")
public class General extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<models.MainPageLeftTable> entriesLeft = MainPageLeftTableDAO.selectAll();
        request.setAttribute("entriesLeft", entriesLeft);

        ArrayList<models.MainPageRightTable> entriesRight = MainPageRightTableDAO.selectAll();
        request.setAttribute("entriesRight", entriesRight);

        try {
            getServletContext().getRequestDispatcher("/views/general.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
