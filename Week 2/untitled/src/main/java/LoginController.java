import model.User;
import model.UserObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ceva", name = "ceva")
public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("!!!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello Im a servlet<h1>");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " " + password);
        RequestDispatcher rd = null;
        User user = UserObject.getInstance().authenticate(username, password);
        if (user != null) {
            System.out.println(user.getName());
            Cookie userType = new Cookie("userType", user.getType());
            userType.setMaxAge(3600);
            response.addCookie(userType);
            rd = getServletContext().getRequestDispatcher("/admin.jsp");
        } else {
            System.out.println("not user");
            rd = getServletContext().getRequestDispatcher("/user.jsp");
        }
        rd.forward(request, response);
    }
}
