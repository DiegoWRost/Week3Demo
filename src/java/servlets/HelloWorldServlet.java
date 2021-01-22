package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 806509
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        
        //Set attributes to be forwarded to the JSP and keep correct input if validation fails
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        
        // Validation of parameters (Always check for null first)
        if (firstname == null || firstname.equals("") | lastname == null || lastname.equals("")) {
            // Send back to form
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                .forward(request, response);
            return; // Stop execution so the code does keep going and forward again
        }
        
        // Use the dispatcher to forward the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);
    }
}
