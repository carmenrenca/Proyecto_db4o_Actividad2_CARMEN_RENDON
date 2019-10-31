package Actividad2;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ventas {
	private int codventa;
	private Articulos codarti;
	private Clientes numcli ;
	private int univen;
	private String fecha;


	static ArrayList<Ventas> listven = new ArrayList<Ventas>();
	ArrayList<Float> suma_total_l = new ArrayList<Float>();
	ArrayList<Float> suma_tota_importe = new ArrayList<Float>();

	
	Map<Integer, Ventas> ventahasp = new HashMap<Integer, Ventas>();
	Map<Integer, Integer> MaxVenta = new HashMap<Integer, Integer>();
	static Map<Integer, Float> MaxCliente = new HashMap<Integer, Float>();
	static Map<Integer, Integer> MaxVentaCliente = new HashMap<Integer, Integer>();
	static Map<Integer, Float> lineaVenta = new HashMap<Integer,Float>();
	public Ventas() {
		
	}



	public Ventas(int codventa, Articulos codarti, Clientes numcli, int univen, String fecha) {
		super();
		this.codventa = codventa;
		this.codarti = codarti;
		this.numcli = numcli;
		this.univen = univen;
		this.fecha = fecha;
	}
	
	public void mostrarResultado(ObjectSet res){
		Ventas v;
		System.out.println("VENTAS ");
	System.out.println("Recuperados "+res.size()+" Objetos");
	while(res.hasNext()){
		
	v=(Ventas)res.next();
	this.ventahasp.put(v.getCodarti().getCodarti(), v);
	
	this.listven.add(v);
	System.out.println(v.toString());
	}
	}
	public  void muestraVenta (ObjectContainer bd){
	Ventas a=new Ventas(0, null, null, 0, null);
	ObjectSet res= bd.queryByExample(a);
	mostrarResultado(res);
	}

	
	
	public  void INFO_ARTICULOS() {
	
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("CODARTI-DENOMINACION–STOCK–PVP–SUMA_UNIVEN–SUMA_IMPORTE–NUM_VENTAS");

		float n;
		sumaunidadestotales(this.suma_uni(this.ventahasp.get(1).getCodarti().getCodarti()));
		
		System.out.println(this.ventahasp.get(1).ToString()+" - "+this.suma_uni(this.ventahasp.get(1).getCodarti().getCodarti())+" - "
		+this.SUMA_IMPORTE(this.ventahasp.get(1).getCodarti().getCodarti())+" - "+this.NUM_VENTAS(this.ventahasp.get(1).getCodarti().getCodarti()));

		sumaunidadestotales(this.suma_uni(this.ventahasp.get(2).getCodarti().getCodarti()));
		
		System.out.println(this.ventahasp.get(2).ToString()+" - "+this.suma_uni(this.ventahasp.get(2).getCodarti().getCodarti())+" - "+
		this.SUMA_IMPORTE(this.ventahasp.get(2).getCodarti().getCodarti())+" - "+this.NUM_VENTAS(this.ventahasp.get(2).getCodarti().getCodarti()));
		
		sumaunidadestotales(this.suma_uni(this.ventahasp.get(6).getCodarti().getCodarti()));
		
		System.out.println(this.ventahasp.get(6).ToString()+" - "+this.suma_uni(this.ventahasp.get(6).getCodarti().getCodarti())+" - "+
		this.SUMA_IMPORTE(this.ventahasp.get(6).getCodarti().getCodarti())+" - "+this.NUM_VENTAS(this.ventahasp.get(6).getCodarti().getCodarti()));

		   System.out.println("SUMA DE UNIDADES VENDIDAS: "+sumaunidadestotales(0));
		  System.out.println("SUMA DE IMPORTES TOTALES: "+this.suma_importe_total());
		  System.out.println("VENTAS TOTALES: "+this.listven.size());
	}
	
	  
	     
		
		
		 
	
	
	
	public float sumaunidadestotales(float n) {
		this.suma_total_l.add(n);
		  float  total=0;
			for (Float data : this.suma_total_l) {
		       total = total+data; 
		        
		        }
		
		return total ;
	}
	
	public float suma_uni(int cod_art) {
		 float n=0;
		for(int i=0; i<this.listven.size(); i++) {
			if(listven.get(i).getCodarti().getCodarti()==cod_art) {
				n+=listven.get(i).getUniven();
			}
			
		
		}
	
		return n;
		
	
		
	}
	
	
	
	public float SUMA_IMPORTE(int cod_art) {
		float n=0;
		float pvp=0;
		System.out.println(cod_art+"aerttt");

	n= this.ventahasp.get(cod_art).getCodarti().getPvp()*this.suma_uni(cod_art);
	this.lineaVenta.put(cod_art, n);
	
	this.suma_tota_importe.add(n);

		

		return n;
		
		
	}
		
	public int NUM_VENTAS(int cod_art) {
		int c=0;
		for(int i=0; i<this.listven.size(); i++) {
			if(this.listven.get(i).getCodarti().getCodarti()==cod_art){
				c++;
			}
		
		}
	
		this.MaxVenta.put(cod_art, c);
		
/////////////////////
		
		return c;
	}
	

	
	public float suma_importe_total() {
	
	
	
		  float  total=0;
			for (Float data : this.suma_tota_importe) {
		       total = total+data; 
		        
		        }
		
		return total ;
		
	}
	
	///////----------------------------------------------------------
	public float TOTAL_IMPORTE(int ncli) {
		
	float importe = 0;
	
	  for(int i=0; i<this.listven.size(); i++) {
		  if(this.listven.get(i).getNumcli().getNumcli()==ncli) {
			  importe+=this.listven.get(i).getCodarti().getPvp()*this.listven.get(i).getUniven();
		  }
	  }
	  this.MaxCliente.put(ncli, importe);
     return importe;
    }
	

	public int NUM_VENTAS_CLIENTE(int ncli) {
		
		int n=0;
		  for(int i=0; i<this.listven.size(); i++) {
			  if(this.listven.get(i).getNumcli().getNumcli()==ncli) {
				  n++;
			  }
		  }
	this.MaxVentaCliente.put(ncli, n);
		return n;
		
	}
	
	public int articulo_mas_vendido(){
		float n = 0;
		int art = 0;

for (Entry<Integer, Integer> entry : this.MaxVenta.entrySet()) {
    Integer key = entry.getKey();
    Object value = entry.getValue();
   if(entry.getValue()>n) {
	   n=entry.getValue();
	   art=key;
   }
}
		return art;
	}
	
	public void media_por_articulo() {
	
		float media=0;

		for (Entry<Integer, Ventas> entry : this.ventahasp.entrySet()) {
		    Integer key = entry.getKey();
		    Object value = entry.getValue();
		 
		   
			media=(this.suma_uni(key)*this.ventahasp.get(key).getCodarti().getPvp())/this.NUM_VENTAS(key);

			System.out.println("media articulo "+key+": "+media);
		    // ...
		}

	}
	
	public int cliente_maximo() {
		float n = 0;
		int cli = 0;

for (Entry<Integer, Float> entry : this.MaxCliente.entrySet()) {
    Integer key = entry.getKey();
    Object value = entry.getValue();
   if(entry.getValue()>n) {
	   n=entry.getValue();
	   cli=key;
   }
}
		return cli;
	}
	
	public int cliente_mas_ventas(){
		float n = 0;
		int cli = 0;
		
for (Entry<Integer, Integer> entry : this.MaxVentaCliente.entrySet()) {

    Integer key = entry.getKey();
    Object value = entry.getValue();
   if(entry.getValue()>n) {
	   n=entry.getValue();
	   cli=key;
   }
  
}
return cli;
	}
	

	public void setCodventa(int codventa) {
		this.codventa = codventa;
	}



	public Articulos getCodarti() {
		return codarti;
	}



	public void setCodarti(Articulos codarti) {
		this.codarti = codarti;
	}



	public Clientes getNumcli() {
		return numcli;
	}



	public void setNumcli(Clientes numcli) {
		this.numcli = numcli;
	}



	public int getUniven() {
		return univen;
	}



	public void setUniven(int univen) {
		this.univen = univen;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Ventas> getListven() {
		return listven;
	}



	public void setListven(ArrayList<Ventas> listven) {
		this.listven = listven;
	}







	@Override
	public String toString() {
		return "Ventas [codventa=" + codventa + ", codarti=" + codarti + ", numcli=" + numcli + ", univen=" + univen
				+ ", fecha=" + fecha + "]";
	}
	
	public String ToString() {
		return "codarti=" + codarti.getCodarti()+" Denominacion: "+codarti.getDenom()+" Stock: "+codarti.getStock()+" PVP: "+this.codarti.getPvp() ;
	}



	public int getCodventa() {
		// TODO Auto-generated method stub
		
		return codventa;
	}
	
}


