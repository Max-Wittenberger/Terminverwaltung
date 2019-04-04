
package dhbwka.wwi.vertsys.javaee.jtodo.common.web;

import com.sun.org.apache.xpath.internal.operations.Equals;
import dhbwka.wwi.vertsys.javaee.jtodo.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.jtodo.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.jtodo.common.jpa.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/app/settings/"})
public class SettingsServlet extends HttpServlet {
    
    @EJB
    ValidationBean validationBean;
            
    @EJB
    UserBean userBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        //Formular mit Userdaten füllen
        HttpSession session = request.getSession();
        User user = userBean.getCurrentUser();
        session.setAttribute("signup_form", user );
        // Anfrage an dazugerhörige JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/settings.jsp").forward(request, response);
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // Formulareingaben auslesen        
        String username = request.getParameter("signup_username");
        String vorname = request.getParameter("signup_vorname");
        String nachname = request.getParameter("signup_nachname");
        String oldPassword = request.getParameter("old_password");
        String password1 = request.getParameter("signup_password1");
        String password2 = request.getParameter("signup_password2");
        
       
        // Eingaben prüfen
        User user = new User(username, oldPassword, vorname , nachname);
        List<String> errors = this.validationBean.validate(user);
        this.validationBean.validate(user.getPassword(), errors);
        
         User currentUser = this.userBean.getCurrentUser();
        
        if (password1 != null && password2 != null && !password1.equals(password2)) {
            errors.add("Die beiden Passwörter stimmen nicht überein.");
        }
        
        if(vorname != null && !"".equals(vorname)){
            currentUser.setVorname(vorname);
        }
        if(nachname != null && !"".equals(nachname)){
            currentUser.setNachname(nachname);
        }
        if(password1 != null && !"".equals(password1)){
            currentUser.setPassword(password1);
        }
        
        
        if (errors.isEmpty()) {
            // Keine Fehler: Startseite aufrufen
            //request.login(username, password1);
            this.userBean.update(currentUser);
            response.sendRedirect(WebUtils.appUrl(request, "/app/dashboard/"));
        } else {
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);
            
            HttpSession session = request.getSession();
            session.setAttribute("signup_form", formValues);
            
            response.sendRedirect(request.getRequestURI());
        }
    }
}
       
    

