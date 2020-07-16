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
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vinicio
 */
@WebService(serviceName = "SrvSoap")
public class SrvSoap {
    @Inject
    ServicesON servicesON;
    
    @WebMethod
    public Mensajes solicitudCredito(PetisionSRV petisionSRV){
        return servicesON.solicitudCredito(petisionSRV);
    }
    
    @WebMethod
    public List<Amortizacion> listaAmotizacion(String codigo){
        try {
            return servicesON.listaAmortizacio(codigo);
        } catch (Exception ex) {
            Logger.getLogger(SrvSoap.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
