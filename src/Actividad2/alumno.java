package Actividad2;

public class alumno {
	
	private String nombre;
	private int edad;
	private double nota;
	public alumno(){
	this.nombre = null;
	edad = 0;
	nota = 0;
	}
	
	
	
	public alumno(String n,int e) {
	this.nombre = n;
	this.edad = e;
	this.nota = -1; //nota no establecida
	}
	public alumno(String nom,int e, double not) {
		this.nombre = nom;
		this.edad = e;
		this.nota = not;
		}
		public void setNombre(String n) {
		this.nombre = n;
		}
		public String getNombre() {
		return this.nombre;
		}
		public void setNota(double n) {
		this.nota=n;
		}
		public double getNota() {
		return this.nota;
		}
		public void setEdad(int e) {
		this.edad=e;
		}
		public int getEdad() {
		return this.edad;
		}
		public String toString() {
		if (this.nota != -1)
		return this.nombre+"("+this.edad+") Nota:"+this.nota;
		return this.nombre+"("+this.edad+")";
		}
		
		

}
