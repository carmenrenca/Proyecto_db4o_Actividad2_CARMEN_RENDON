package Actividad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.crypto.Data;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Clientes {
	public int numcli;
	public String nombre;
	public String pobla;
	ArrayList<Clientes> lc = new ArrayList<Clientes>();
	Map<Integer, Clientes> clientemap= new HashMap<Integer, Clientes>();

	
	public Clientes(int numcli, String nombre, String poblacion) {
		this.numcli=numcli;
		this.nombre=nombre;
		this.pobla=poblacion;
	}
	
public Clientes() {
		
	}


public void guardar_cliente_PorDefecto() {

		
	
		Clientes cli1 = new Clientes(1,"Antonio Ruiz","Talavera");
		Clientes cli2 = new Clientes(2,"La Alameda S.L.","Talavera");
		Clientes cli3 = new Clientes(7,"Los molinos CB","Madrid");
		Clientes cli4 = new Clientes(8,"Pedro Moran S.L.","Talavera");
		Clientes cli5 = new Clientes(12,"Azulejos Martin S.L.","Talavera");
		Clientes cli6 = new Clientes(15,"Bar Girasol","Oropesa");
		Clientes cli7 = new Clientes(9,"Escuela Mayores","Talavera");
		Clientes cli8 = new Clientes(17,"Galeria Madrid S.L.","Madrid");
		Clientes cli9 = new Clientes(19,"El corte Chino","Talavera");
		Clientes cli10 = new Clientes(20,"UNICAS S.A.","Oropesa");
		Clientes cli11 = new Clientes(21,"Deportivo SAS","Talavera");
		Clientes cli12 = new Clientes(22,"Academia Padel","Madrid");
		
		lc.add(cli1);
		lc.add(cli2);
		lc.add(cli3);
		lc.add(cli4);
		lc.add(cli5);
		lc.add(cli6);
		lc.add(cli7);
		lc.add(cli8);
		lc.add(cli9);
		lc.add(cli10);
		lc.add(cli11);
		lc.add(cli12);
		
		
		
	}
public void mostrarResultado(ObjectSet res){
	Clientes c;
	System.out.println("CLIENTES: ");
System.out.println("Recuperados "+res.size()+" Objetos");
while(res.hasNext()){
c=(Clientes)res.next();
lc.add(c);
clientemap.put(c.getNumcli(), c);
System.out.println(c.toString());
}
}
public  void muestraCliente (ObjectContainer bd){
Clientes a=new Clientes(0, null, null);
ObjectSet res= bd.queryByExample(a);
mostrarResultado(res);
}
	

public void INFO_CLIENTE() {
	
	System.out.println("----------------------------------------------------------");
	System.out.println("----------------------------------------------------------");
	System.out.println("NUMCLI – NOMBRE – POBLACIÓN – TOTAL_IMPORTE – NUM_VENTAS");
	Ventas v= new Ventas();

	for (Entry<Integer, Clientes> entry : this.clientemap.entrySet()) {
	    Integer key = entry.getKey();
	    Object value = entry.getValue();
	  
	    
	System.out.println(entry.getValue()+" TOTAL_IMPORTE "+v.TOTAL_IMPORTE(key)+" NUMERO_VENTAS: "+v.NUM_VENTAS_CLIENTE(key));
	
	    // ...
	}
	
	
}



	
	
	@Override
	public String toString() {
		return "Numcli=" + this.getNumcli() + "- Nombre=" + this.getNombre() + "- Poblacion=" + this.getPobla() ;
	}
	public int getNumcli() {
		return numcli;
	}
	public void setNumcli(int numcli) {
		this.numcli = numcli;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPobla() {
		return pobla;
	}
	public void setPobla(String pobla) {
		this.pobla = pobla;
	}


	
	
	
	
}
