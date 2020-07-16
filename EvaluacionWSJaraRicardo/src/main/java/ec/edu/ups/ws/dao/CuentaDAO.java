
package ec.edu.ups.ws.dao;

import ec.edu.ups.ws.emtitis.Cuenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class CuentaDAO {

    @PersistenceContext
    private EntityManager em;

    public CuentaDAO() {
    }

    public boolean insert(Cuenta cuenta) throws Exception {
        boolean bandera = true;
    	try {
            em.persist(cuenta);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Cuenta" + e.getMessage());
            
        }
        
        return bandera;
    }

    public void delete(Cuenta cuenta) throws Exception {
        try {
            em.remove(read(cuenta.getId()));
        } catch (Exception e) {
            throw new Exception("Error Eliminar Cuenta " +e.getMessage());
        }
    }


    public void deleteId(int id) throws Exception {
        try {
            em.remove(read(id));
        } catch (Exception e) {
            throw new Exception("Erro Eliminar por id: Cuenta " +e.getMessage());
        }
    }

    public void update(Cuenta cuenta) throws Exception {
        try {
            em.merge(cuenta);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Cuenta " +e.getMessage());
        }
    }


    public Cuenta read(int id) throws Exception {
        try {
            return em.find(Cuenta.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer por id: Cuenta " +e.getMessage());
        }
    }

    public List<Cuenta> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Cuenta.findAll");
            List<Cuenta> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Cuenta " +e.getMessage());
        }

    }


    public Cuenta findByID(String id) throws Exception {
        try {
            Query q = em.createNamedQuery("Cuenta.findById");
            q.setParameter("id", Integer.parseInt(id));
            return (Cuenta) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  ID " +e.getMessage());
        }

    }

    public Cuenta findByNumero(String numero) throws Exception {
        try {
            Query q = em.createNamedQuery("Cuenta.findByNumero");
            q.setParameter("numero", numero);
            return (Cuenta) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  nombre: ");
        }

    }
    
}
