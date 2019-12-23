package webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class login extends HttpServlet {

    public void showLoginForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br>Please enter username and password");
        out.println("<form method=post>");
        out.println("<br>Username: <input type=text name=username>");
        out.println("<br>Password: <input type=text name=password>");
        out.println("<br><input type=submit>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.isEmpty() || password.isEmpty()) {
            showLoginForm(request, response);
        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("welcome");
//            request.setAttribute("username", username);
//            rd.forward(request, response);
            response.sendRedirect("welcome?username=" + username);
        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showLoginForm(request, response);

    }
}
