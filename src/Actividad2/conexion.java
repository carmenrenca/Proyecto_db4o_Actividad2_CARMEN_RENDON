package Actividad2;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class conexion {
private ObjectContainer oc;

private void open() {
	this.oc= Db4o.openFile("database.yap");
}
}
