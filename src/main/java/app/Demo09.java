package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;
 
// GUI

public class Demo09 {
// Listado de los usuarios según un criterio
	public static void main(String[] args) {
		// 1. obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
	
		//select * from tb_usuarios where campo condicion--> Lista
		String jpql = "select a from Usuario a where a.idtipo = :xtipo"; //IMPORTANTE
		int xtipo = 1;
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).setParameter("xtipo", xtipo).getResultList();
		
		
		//contenido del listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...:" + u.getCod_usua());
			System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
			//if (u.getIdtipo() == 1)
				//msg = "Administrativo";
			System.out.println("Tipo...:" + u.getIdtipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println("---------------------------------");
			
		}
		
		
		em.close();
		
		
	}
}
