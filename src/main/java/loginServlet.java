import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        HttpSession session = request.getSession();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");


        if(servletContext.getAttribute("brugerMap") == null){

            Map<String,String> brugerMap = new HashMap<>();

            brugerMap.put("test","test");
            brugerMap.put("admin","admin");

            servletContext.setAttribute("brugerMap", brugerMap);

        }



            if (!((Map<String,String>) servletContext.getAttribute("brugerMap")).containsKey(navn)){



            request.setAttribute("besked", "Du findes ikke som bruger, her kan du oprette en bruger");
            request.getRequestDispatcher("WEB-INF/opretBruger.jsp").forward(request,response);

        }
        if (((Map<String,String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)){

            if (navn.equalsIgnoreCase("admin")){

                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);

            }

            session.setAttribute("besked","du er logget ind med navnet " + navn);
            request.getRequestDispatcher("WEB-INF/huskelisten.jsp").forward(request,response);

        }

        request.setAttribute("besked", "Kodeord er forkert");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        //todo gå til index siden
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
