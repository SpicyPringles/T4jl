package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Producto;
 
// GUI

public class Demo07 {
// Listado de todos los productos, mostrando nombre del proveedor y nombre de categoria
	public static void main(String[] args) {
		// 1. obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
	
		//select * from tb_productos--> Lista
		String jpql = "select p from Producto p"; //IMPORTANTE
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		
		
		//contenido del listado
		for (Producto p : lstProductos) {
			System.out.println("Codigo...:" + p.getId_prod());
			System.out.println("Nombre...:" + p.getDes_prod());
			//if (u.getIdtipo() == 1)
				//msg = "Administrativo";
			System.out.println("Categoria...:" + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor...:" + p.getObjProveedor().getNombre_rs());
			System.out.println("---------------------------------");
			
		}
		
		
		em.close();
		
		
	}
}
