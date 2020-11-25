package ORM_conexion;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ORM.AsigProyecto;
import ORM.AsigProyectoId;
import ORM.Proyecto;

public class Funciones {

	public ORM.Empleado crearEmpleado(String nombre, String dni)
	{
		Transaction t = null;
		ORM.Empleado emp = new ORM.Empleado();
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			emp.setDni(dni);
			emp.setNomEmp(nombre);
			s.save(emp);
			
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
			
		}
		
		return emp;
	}
	
	public ORM.DatosProf crearDatosProf(String dni, ORM.Empleado emp, String cat, BigDecimal sueldo )
	{
		Transaction t = null;
		ORM.DatosProf dp = new ORM.DatosProf();
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			dp.setDni(dni);
			dp.setCategoria(cat);
			dp.setEmpleado(emp);
			dp.setSueldoBrutoAnual(sueldo);
			s.save(dp);
			
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
			
		}
		
		return dp;
	}
	
	public ORM.Empleado crearEmpleadoConDatos(String nombre, String dni, ORM.DatosProf dp)
	{
		Transaction t = null;
		ORM.Empleado emp = new ORM.Empleado();
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			emp.setDni(dni);
			emp.setNomEmp(nombre);
			emp.setDatosProf(dp);
			s.save(emp);
			
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
			
		}
		
		return emp;
	}
	
	
	public ORM.AsigProyectoId idAsigProyecto(String dni, int idProy, Date fInicio)
	{
		ORM.AsigProyectoId apID = new ORM.AsigProyectoId();
		apID.setDniEmp(dni);
		apID.setIdProy(idProy);
		apID.setFInicio(fInicio);
		
		return apID;
	}
	
	public ORM.EmpPlantilla crearEmpPlantilla(int numEmp, ORM.Empleado emp)
	{
		Transaction t = null;
		
		ORM.EmpPlantilla empPlan = new ORM.EmpPlantilla();
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			empPlan.setEmpleado(emp);
			empPlan.setNumEmp(numEmp);
			
			s.save(empPlan);
			
			t.commit();
		}catch(Exception e )
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
		}
		
		return empPlan;
	}
	
	public ORM.Proyecto crearProyectoPlan(ORM.EmpPlantilla empPlan, String nombre, Date FInicio)
	{
		ORM.Proyecto pr = new ORM.Proyecto();
		Transaction t = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			pr.setNomProy(nombre);
			pr.setEmpPlantilla(empPlan);
			pr.setFInicio(FInicio);
			s.save(pr);
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
		}
		
		return pr;
	}
	
	public ORM.Proyecto crearProyecto(String nombre, Date FInicio){
		
		ORM.Proyecto pr = new ORM.Proyecto();
		Transaction t = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			pr.setNomProy(nombre);
			pr.setFInicio(FInicio);
			s.save(pr);
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
		}
		
		return pr;
	}
	
	public ORM.AsigProyecto AsignarProyecto(ORM.AsigProyectoId id, ORM.Empleado emp, ORM.Proyecto pr)
	{
		ORM.AsigProyecto ap = new ORM.AsigProyecto();
		Transaction t = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession())
		{
			t = s.beginTransaction();
			
			ap.setId(id);
			ap.setEmpleado(emp);
			ap.setProyecto(pr);
			s.save(ap);
			
			t.commit();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
			if(t != null)
			{
				t.rollback();
			}
				
		}
		
		return ap;
		
		
	}
	
	

}
