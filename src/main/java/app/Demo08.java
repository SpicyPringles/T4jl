package app;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Usuario;
 
// GUI

public class Demo08 {
// Login objeto unico
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese Usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");
		// 1. obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
	
		//select * from tb_usuarios where usr_usua = ? and cla_usua = ? --> Lista
		String jpql = "select a from Usuario a where a.usr_usua = :xusr and a.cla_usua = :xcla"; //IMPORTANTE
		
		try {
			Usuario a = em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
			
			
			//contenido del listado
			
				System.out.println("Codigo...:" + a.getCod_usua());
				System.out.println("Nombre...:" + a.getNom_usua() + " " + a.getApe_usua());
				//if (u.getIdtipo() == 1)
					//msg = "Administrativo";
				System.out.println("Tipo...:" + a.getIdtipo() + "-" + a.getObjTipo().getDescripcion());
				System.out.println("---------------------------------");
				
				JOptionPane.showMessageDialog(null, "Bienvenido: " + a.getNom_usua());
				//abrir ventana
				FrmManteProd v = new FrmManteProd();
				v.setVisible(true);
				//dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Usuario o clave incorrecto");
		}
			
		
		
		
		em.close();
		
		
	}
}
