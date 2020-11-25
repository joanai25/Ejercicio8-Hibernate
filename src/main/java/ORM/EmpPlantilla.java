package ORM;
// Generated 18 nov. 2020 20:00:38 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * EmpPlantilla generated by hbm2java
 */
public class EmpPlantilla implements java.io.Serializable {

	private int numEmp;
	private Empleado empleado;
	private Set proyectos = new HashSet(0);

	public EmpPlantilla() {
	}

	public EmpPlantilla(int numEmp) {
		this.numEmp = numEmp;
	}
	
	

	public EmpPlantilla(int numEmp, Empleado empleado, Set proyectos) {
		this.numEmp = numEmp;
		this.empleado = empleado;
		this.proyectos = proyectos;
	}

	public int getNumEmp() {
		return this.numEmp;
	}

	public void setNumEmp(int numEmp) {
		this.numEmp = numEmp;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Set getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Set proyectos) {
		this.proyectos = proyectos;
	}

}