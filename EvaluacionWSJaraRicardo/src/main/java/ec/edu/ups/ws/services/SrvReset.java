/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ws.services;

import ec.edu.ups.ws.business.ServicesON;
import ec.edu.ups.ws.emtitis.Amortizacion;
import ec.edu.ups.ws.emtitis.Mensajes;
import ec.edu.ups.ws.emtitis.PetisionSRV;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Vinicio
 */
@Path("/prueba")
public class SrvReset {
    
    @Inject
    ServicesON servicesON;
    
    @Path("/solicitud")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensajes solicitudCredito(PetisionSRV petisionSRV){
        return servicesON.solicitudCredito(petisionSRV);
    }
    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Amortizacion> listaAmotizacion(@QueryParam("codigo") String codigo){
        try {
            return servicesON.listaAmortizacio(codigo);
        } catch (Exception ex) {
            Logger.getLogger(SrvSoap.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
