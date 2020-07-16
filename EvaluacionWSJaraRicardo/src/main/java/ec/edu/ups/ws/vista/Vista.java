/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ws.vista;

//import ec.edu.ups.practica.business.ServicesON;
import ec.edu.ups.ws.business.ServicesON;
import ec.edu.ups.ws.emtitis.Amortizacion;
import ec.edu.ups.ws.emtitis.PetisionSRV;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicio
 */
@WebServlet(name = "Vista", urlPatterns = {"/Vista"})
public class Vista extends HttpServlet {

    @Inject
    ServicesON servicesON;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.getWriter().println("Hola ");
            //response.getWriter().println(servicesON.solicitudCredito(new PetisionSRV("12345", 120, 12)).getDescripcion());
            List<Amortizacion> lista = servicesON.listaAmortizacio("8SRV123455");
            response.getWriter().println(lista.get(2).getId());

        } catch (Exception ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().println("Codigo Incorrecto");
        }

    }

}
