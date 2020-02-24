import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "koebServlet", urlPatterns = "/koebServlet")
public class koebServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vareNavn = request.getParameter("vareNavn");

        HttpSession session = request.getSession();


        if(session.getAttribute("liste")== null){

            Set<String> liste = new HashSet<>();

            session.setAttribute("liste",liste);
        }
        ((Set<String>) session.getAttribute("liste")).add(vareNavn);
        request.setAttribute("besked", "Du har tilføjet " + vareNavn);
        request.getRequestDispatcher("WEB-INF/huskelisten.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
