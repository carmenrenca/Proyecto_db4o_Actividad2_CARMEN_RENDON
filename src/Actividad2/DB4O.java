package Actividad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O {

	static Map<Integer, Ventas> ventas = new HashMap<Integer, Ventas>();


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
					"empresa.db4o");
	 Clientes c = new Clientes();
	    Articulos a= new Articulos();
	    Ventas v = new Ventas();
					try{
						//GUARDAR_BASEDATOS();
						
					c.muestraCliente(bd);
					a.muestraArticulos(bd);
					v.muestraVenta(bd);
					v.INFO_ARTICULOS();
					c.INFO_CLIENTE();
					System.out.println("Articulo más vendido: "+v.articulo_mas_vendido());
					v.media_por_articulo();
					System.out.println("El Cliente "+v.cliente_maximo()+" es el que más ha gastado ");
					System.out.println("El Cliente "+v.cliente_mas_ventas()+ "  es el que más ventas tiene");
					}
					finally{
					bd.close();
					}
				
					
					
		}
		
		public static void GUARDAR_BASEDATOS() {
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
		 
		 ArrayList<Clientes> lc = new ArrayList<Clientes>();
			
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
			
			ArrayList<Ventas> lv = new ArrayList<Ventas>();
			Ventas v1 = new Ventas (1,ar1,cli1,5,"05/06/2014");
			Ventas v2 = new Ventas (2,ar1,cli2,4,"15/06/2014");
			Ventas v3 = new Ventas (3,ar1,cli6,3,"25/06/2014");
			Ventas v4 = new Ventas (4,ar2,cli6,5,"03/07/2014");
			Ventas v5 = new Ventas (5,ar2,cli7,4,"11/08/2014");
			Ventas v6 = new Ventas (6,ar3,cli1,3,"25/04/2014");
			
			lv.add(v1);
			lv.add(v2);
			lv.add(v3);
			lv.add(v4);
			lv.add(v5);
			lv.add(v6);
			
			ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
					"empresa.db4o");
			
			try {
				
				for(int i=0; i<lc.size(); i++) {
					bd.store(lc.get(i));
					System.out.println("Cliente: "+lc.get(i).getNombre()+" Insertado");
				}
				
				for(int i=0; i<la.size(); i++) {
					
					bd.store(la.get(i));
					System.out.println("Articulo: "+la.get(i).getDenom()+" Insertado");
				}
				
				for(int i=0; i<lv.size(); i++) {
					bd.store(lv.get(i));
					System.out.println("Venta: "+lv.get(i).getCodventa()+" Insertado");
				}
			}
			finally {
				bd.close();
			}
		 
			
			
		}
	
	
		
	

}
