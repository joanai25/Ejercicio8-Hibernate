package ORM_conexion;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ORM.Proyecto;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Funciones f = new Funciones();
		Transaction t = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			//Crear empleado en plantilla
			ORM.Empleado emp = f.crearEmpleado("Elena", "1");
			ORM.EmpPlantilla empPlan = f.crearEmpPlantilla(1, emp);
			//ORM.Empleado emp = s.get(ORM.Empleado.class, "48751235I");
			//ORM.EmpPlantilla empPlan = s.get(ORM.EmpPlantilla.class, 1);
			
			//Crear empleado fuera de plantilla
			
			//ORM.Empleado emp2 = s.get(ORM.Empleado.class, "74816474T");
			
			//Crear proyecto nuevo y asignarle jefe de proyecto en plantilla creado en el programa
			Date fecha = new Date(120, 5,12);
			ORM.Proyecto pr = f.crearProyectoPlan(empPlan, "Proyecto22", fecha);
			
			
			
			//Crear proyecto nuevo y asignarle jefe que  esta en plantilla existente en la BD
			Date fecha_fin = new Date(120, 9,15);
			ORM.Empleado emp2 = f.crearEmpleado("Paco", "3");
			
			//Asignar empleado existente que esta en plantilla 
			ORM.AsigProyectoId apID = f.idAsigProyecto(emp2.getDni(), pr.getIdProy(), fecha_fin);
			ORM.AsigProyecto ap = f.AsignarProyecto(apID, emp2, pr);
			
			//Asignar empleado creado en el programa que no esta en plantilla
			
			
			
			
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
