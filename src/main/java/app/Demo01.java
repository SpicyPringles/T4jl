package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;
 
// GUI

public class Demo01 {
// Registrar nuevo usuario usando valores fijos
	public static void main(String[] args) {
		// 1. obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// procesos
		
		Usuario u = new Usuario();
				u.setCod_usua(123);
				u.setNom_usua("Leinad");
				u.setApe_usua("Huapaya");
				u.setUsr_usua("lhuapaya");
				u.setCla_usua("1234");
				u.setFna_usua("1995/01/15");
				u.setIdtipo(1);
				u.setEst_usua(1);
		
		//Usuario u = new Usuario(321, "Maria", "Lopez", "mlopez", "maryl", "2005/05/14", 1, 1);		
		// insert.into tb_xxx values(?,?.......)
		// si el proceso es: reg/act/elim -> necesitan: transacciones
		
		em.getTransaction().begin();
		em.persist(u);
		// update
		em.merge(u);
		// delete
		em.remove(u);
		// select * from tb_xxx where id=?
		Usuario  x = em.find(Usuario.class, 1);
		em.getTransaction().commit();
		System.out.println("Registro OK");
		em.close();
		
		
	}
}
