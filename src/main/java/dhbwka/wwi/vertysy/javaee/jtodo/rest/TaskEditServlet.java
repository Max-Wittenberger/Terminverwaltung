
package dhbwka.wwi.vertysy.javaee.jtodo.rest;

import dhbwka.wwi.vertsys.javaee.jtodo.common.web.WebUtils;
import dhbwka.wwi.vertsys.javaee.jtodo.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.ejb.CategoryBean;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.jtodo.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.jtodo.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa.Termin;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa.TaskStatus;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Seite zum Anlegen oder Bearbeiten einer Aufgabe.
 */
@WebServlet(urlPatterns = "/app/rest/")
public class TaskEditServlet extends HttpServlet {

    @EJB
    TaskBean taskBean;

    @EJB
    CategoryBean categoryBean;

    @EJB
    UserBean userBean;

    @EJB
    ValidationBean validationBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");

        // Zu bearbeitende Aufgabe einlesen
        HttpSession session = request.getSession();

                                
        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/rest.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // Angeforderte Aktion ausführen
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

     
    }


}
