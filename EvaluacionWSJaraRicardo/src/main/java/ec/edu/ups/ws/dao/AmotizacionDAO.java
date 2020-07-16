
package ec.edu.ups.ws.dao;

import ec.edu.ups.ws.emtitis.Amortizacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class AmotizacionDAO {

    @PersistenceContext
    private EntityManager em;

    public AmotizacionDAO() {
    }

    public boolean insert(Amortizacion amortizacion) throws Exception {
        boolean bandera = true;
    	try {
            em.persist(amortizacion);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Amortizacion" + e.getMessage());
            
        }
        
        return bandera;
    }

    public void delete(Amortizacion amortizacion) throws Exception {
        try {
            em.remove(read(amortizacion.getId()));
        } catch (Exception e) {
            throw new Exception("Error Eliminar Amortizacion " +e.getMessage());
        }
    }


    public void deleteId(int id) throws Exception {
        try {
            em.remove(read(id));
        } catch (Exception e) {
            throw new Exception("Erro Eliminar por id: Amortizacion " +e.getMessage());
        }
    }

    public void update(Amortizacion amortizacion) throws Exception {
        try {
            em.merge(amortizacion);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Amortizacion " +e.getMessage());
        }
    }


    public Amortizacion read(int id) throws Exception {
        try {
            return em.find(Amortizacion.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer por id: Amortizacion " +e.getMessage());
        }
    }

    public List<Amortizacion> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Amortizacion.findAll");
            List<Amortizacion> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Amortizacion " +e.getMessage());
        }

    }


    public Amortizacion findByID(String id) throws Exception {
        try {
            Query q = em.createNamedQuery("Amortizacion.findById");
            q.setParameter("id", Integer.parseInt(id));
            return (Amortizacion) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  ID " +e.getMessage());
        }

    }

    public List<Amortizacion> findByCodigo(String codigo) throws Exception {
        try {
            Query q = em.createNamedQuery("Amortizacion.findByCodigo");
            q.setParameter("codigo",  codigo);
            List<Amortizacion> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro buscar por  nombre: ");
        }

    }
    
}
