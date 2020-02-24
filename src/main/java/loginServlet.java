import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        HttpSession session = request.getSession();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");


        if (servletContext.getAttribute("brugerMap") == null) {

            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");
            brugerMap.put("admin", "admin");

            servletContext.setAttribute("brugerMap", brugerMap);

        }

        if (servletContext.getAttribute("aktiveBrugere") == null) {
            Set<String> aktiveBrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktiveBrugere);
        }

        if (!(session.getAttribute("besked") == null   )){

            request.getRequestDispatcher("WEB-INF/huskelisten.jsp").forward(request,response);
        }


        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {


            request.setAttribute("besked", "Du findes ikke som bruger, her kan du oprette en bruger");
            request.getRequestDispatcher("WEB-INF/opretBruger.jsp").forward(request, response);

        }
        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            if (navn.equalsIgnoreCase("admin")) {

                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

            }
            if (!((Set<String>) servletContext.getAttribute("aktiveBrugere")).contains(navn)) {
                ((Set<String>) servletContext.getAttribute("aktiveBrugere")).add(navn);
                session.setAttribute("besked", "du er logget ind med navnet " + navn);
                session.setAttribute("navn", navn);
                request.getRequestDispatcher("WEB-INF/huskelisten.jsp").forward(request, response);

            }

        }
        request.setAttribute("besked", "Der gik noget noget galt - prøv igen");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        //todo gå til index siden


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    }


