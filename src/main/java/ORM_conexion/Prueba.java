package ORM_conexion;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Funciones f = new Funciones();
		Transaction t  = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			//f.crearEmpleado("Marcos", "12345678A");
			//f.crearEmpleado("Juan", "49324771Y");
			//f.crearEmpleado("Victor", "48712362H");
			
			ORM.Empleado emp = s.get(ORM.Empleado.class, "12345678A");
			ORM.Empleado emp2 = s.get(ORM.Empleado.class, "49324771Y");
			ORM.Empleado emp3 = s.get(ORM.Empleado.class, "48712362H");
			
			f.crearEmpPlantilla(1, emp);
			f.crearEmpPlantilla(2, emp2);
			f.crearEmpPlantilla(3, emp3);
			
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
		}
	}

}
