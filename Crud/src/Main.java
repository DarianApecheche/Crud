import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Vector<Ayudante> helper = new Vector();
        //Cargando Datos
        try {
        	helper = gestiondecuentas2.LoadData();
        }
        catch(Exception ex) {
        	System.out.println("No hay datos");
        }
        //Seccion de opciones para el usuario
    	String option = "";
        while(true) {
        	try {
            	Opciones();
        		option = scan.next();
        		if(RevisarOption(option)==true) {
        		switch(option) {
        			//Mostrar lista
        			case "1":
        				AdquirirLista(helper);
        			break;
        			//Añadir nuevo ayudante
        			case "2":
        				System.out.println("-------------------------------------------------");
        				System.out.println("Introduzca los datos del nuevo ayudante en este orden");
        				System.out.println("Nombre - Apellidos - CI - Edad");
        		        String name = scan.next();
        		        String apellido = scan.next();
        		        String CI = scan.next();
        		        String edadtemp = scan.next();
        		        int edad = Integer.valueOf(edadtemp);
        		        
        		        Ayudante k = new Ayudante(name,apellido,CI,edad);
        		        helper.add(k);
        			break;
        			//Eliminar un ayudante
        			case "3":
        				System.out.println("-------------------------------------------------");
        				System.out.println("Introduzca el numero del ayudante que quiere eliminar");
        				AdquirirLista(helper);
        				String eliminartemp = scan.next();
        				int eleminar = Integer.valueOf(eliminartemp);
        				helper.remove(eleminar-1);
        			break;
        			//Guardar Datos
        			case "4":
        		    	gestiondecuentas2.SaveData(helper);
        				System.out.println("-------------------------------------------------");
        				System.out.println("Guardado con exito");
        			break;
        			//Finalizar aplicacion
        			case "5":
        				return;
        		}
        		}
        	}
        	catch(NumberFormatException ex1){
        		System.out.println("Ha escrito una letra en lugar de un numero");
        	}
        	catch(Exception ex) {
        		System.out.println(ex.getMessage());
        	}

        }
	}
	//Opciones a mostrar
	public static void Opciones() {
		System.out.println("-------------------------------------------------");
		System.out.println("Escriba el numero de la opcion deseada:");
		System.out.println("1-Mostrar listado.");
		System.out.println("2-Inscribir nuevo ayudante.");
		System.out.println("3-Eliminar un ayudante.");
		System.out.println("4-Guardar datos.");
		System.out.println("5-Cerrar.");
	}
	
	//Mostrar listado
	public static void AdquirirLista(Vector<Ayudante> helper) {
		System.out.println("-------------------------------------------------");
		System.out.println("Listado de ayudantes al evento");
		System.out.println("#-Nombre_Apellidos_CI_Edad");
        for(int i =0;i<helper.size();i++) {
        	System.out.println((i+1)+"-"+helper.get(i).name+" "+helper.get(i).lastname+
        			" "+helper.get(i).CI+" "+helper.get(i).edad);
        }
	}
	//Revisar q la opcion sea valida en el rango de opciones
	public static boolean RevisarOption(String k) {
		if(Integer.valueOf(k)>=1&&Integer.valueOf(k)<=5) {
			return true;
		}
		else {
			throw new InputMismatchException("La opcion es incorrecta");
		}
	}
}
