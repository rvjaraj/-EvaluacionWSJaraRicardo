/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ws.business;

import ec.edu.ups.ws.dao.AmotizacionDAO;
import ec.edu.ups.ws.dao.CuentaDAO;
import ec.edu.ups.ws.emtitis.Amortizacion;
import ec.edu.ups.ws.emtitis.Cuenta;
import ec.edu.ups.ws.emtitis.Mensajes;
import ec.edu.ups.ws.emtitis.PetisionSRV;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Vinicio
 */
@Stateless
public class ServicesON {

    @Inject
    CuentaDAO cuentaDAO;

    @Inject
    AmotizacionDAO amotizacionDAO;

    public Mensajes solicitudCredito(PetisionSRV petisionSRV) {
        try {
            Cuenta c = cuentaDAO.findByNumero(petisionSRV.getNuemroCuenta());
            if (petisionSRV.getCantidad() > 0) {
                if (petisionSRV.getNumeromeses() > 1) {
                    Amortizacion a = null;
                    double cantiad = petisionSRV.getCantidad();
                    cantiad = cantiad / petisionSRV.getNumeromeses();
                    String codigo = new Date().getMinutes() + "SRV" + petisionSRV.getNuemroCuenta();
                    for (int i = 0; i < petisionSRV.getNumeromeses(); i++) {
                        a = new Amortizacion((i + 1) + "", codigo, new Date(new Date().getYear(), new Date().getMonth() + i, new Date().getDay()), cantiad, c);
                        amotizacionDAO.insert(a);
                    }
                    return new Mensajes(3, "MSG3", "Se numero de credito es: " + a.getCodigo());
                } else {
                    return new Mensajes(2, "MSG3", "El numero de cuota debe ser mayor a 1" + c.getNumero());
                }
            } else {
                return new Mensajes(1, "MSG1", "La Cantidad debe ser mayor a 0" + c.getNumero());
            }

        } catch (Exception ex) {
            Logger.getLogger(ServicesON.class.getName()).log(Level.SEVERE, null, ex);
            return new Mensajes(0, "Error ", ex.getMessage());
        }
    }
    
    public List<Amortizacion> listaAmortizacio(String codigo) throws Exception{
        try {
            return amotizacionDAO.findByCodigo(codigo);
        } catch (Exception ex) {
            throw new Exception("Lista Basia");
        }
    }
}
