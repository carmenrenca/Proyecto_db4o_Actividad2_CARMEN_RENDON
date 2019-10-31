package Actividad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Articulos {
	private int codarti;
	private String denom;
	private int stock;
	private float pvp;
	private Set<Ventas> Compras;
	public float suma_uni;
	Map<Integer, Articulos> articulomap= new HashMap<Integer, Articulos>();
	public Articulos() {
		super();
	}

	
	
	
	
	public Articulos(int codarti, String denom, int stock, float pvp) {
		super();
		this.codarti = codarti;
		this.denom = denom;
		this.stock = stock;
		this.pvp = pvp;

	}


		public void guardar_Articulo_defecto() {
			
			ArrayList<Articulos> la = new ArrayList<Articulos>();
			
			
			Articulos ar1 = new Articulos(1,"Mesas", 30, (float)100.5);
			Articulos ar2 = new Articulos(2,"Pupitres", 10, (float)150.7);
			Articulos ar3 = new Articulos(6,"Cuadernos", 100, (float)4.5);
			Articulos ar4 = new Articulos(8,"Tabletas", 10, (float)175.4);
			Articulos ar5 = new Articulos(9,"Bolígrafos", 100, (float)3.5);
			Articulos ar6 = new Articulos(10,"Lapiceros", 300, (float)2.5);
			Articulos ar7 = new Articulos(14,"Sillas", 30, (float)120.5);
			Articulos ar8 = new Articulos(16,"Portátil", 25, (float)400.5);
			Articulos ar11 = new Articulos(17,"Espejo baño", 20, (float)100.5);
			Articulos ar21 = new Articulos(18,"Reloj cocina", 10, (float)20.7);
			Articulos ar31 = new Articulos(20,"Tarjetero", 50, (float)14.5);
			Articulos ar41 = new Articulos(22,"Estuches", 110, (float)20.4);
			Articulos ar51 = new Articulos(23,"Libro BD", 10, (float)23.5);
			Articulos ar61 = new Articulos(24,"Tijeras", 30, (float)5.0);
			Articulos ar71 = new Articulos(25,"Cubiertos", 130, (float)10.5);
			Articulos ar81 = new Articulos(26,"Teclado", 25, (float)40.5);
			
		 la.add(ar1);
		 la.add(ar2);
		 la.add(ar3);
		 la.add(ar4);
		 la.add(ar5);
		 la.add(ar6);
		 la.add(ar7);
		 la.add(ar8);
		 la.add(ar11);
		 la.add(ar21);
		 la.add(ar31);
		 la.add(ar41);
		 la.add(ar51);
		 la.add(ar61);
		 la.add(ar71);
		 la.add(ar81);
		 
			ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
					"empresa.db4o");
			
			try {
				for(int i=0; i<la.size(); i++) {
					System.out.println("Articulo: "+la.get(i).getDenom()+" Insertado");
				}
			}
			finally {
				bd.close();
			}
		 
			
		}

		
		public void mostrarResultado(ObjectSet res){
			Articulos a;
			System.out.println("ARTICULOS: ");
		System.out.println("Recuperados "+res.size()+" Objetos");
		while(res.hasNext()){
		a=(Articulos)res.next();
		this.articulomap.put(a.getCodarti(), a);
		System.out.println(a.toString());
		}
		}
		public  void muestraArticulos(ObjectContainer bd){
		Articulos a=new Articulos(0, null, 0, 0);
		ObjectSet res= bd.queryByExample(a);
		mostrarResultado(res);
		}
		
		
		
		

	public int getCodarti() {
		return codarti;
	}

	public void setCodarti(int codarti) {
		this.codarti = codarti;
	}

	public String getDenom() {
		return denom;
	}

	public void setDenom(String denom) {
		this.denom = denom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public Set<Ventas> getCompras() {
		return Compras;
	}

	public void setCompras(Set<Ventas> compras) {
		Compras = compras;
	}


	public float getSuma_uni() {
		return suma_uni;
	}



	public void setSuma_uni(float suma_uni) {
		this.suma_uni = suma_uni;
	}


	

	@Override
	public String toString() {
		return "Articulos [codarti=" + codarti + ", denom=" + denom + ", stock=" + stock + ", pvp=" + pvp + ", suma_uni="
				+ suma_uni + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
