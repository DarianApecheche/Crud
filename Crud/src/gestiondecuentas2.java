import java.io.*;
import java.util.*;
public class gestiondecuentas2 {
	static String direc ="C:\\data.bin";
    //GuardarDatos de CLIENTES
    public static void SaveData(Vector<Ayudante> data) throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(data.size());
        
        for(int i =0;i<data.size();i++){
            outStream.writeUTF(data.get(i).name);
            outStream.writeUTF(data.get(i).lastname);
            outStream.writeUTF(data.get(i).CI);
            outStream.writeInt(data.get(i).edad);
        }

        outStream.flush();
        outStream.close();
    }
    //LoadData de clientes
    public static Vector<Ayudante> LoadData() throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        Vector<Ayudante> users = new Vector();
        
        for(int i =0;i<capacidad;i++){
            String nombre =InStream.readUTF();
            String apellido =InStream.readUTF();
            String CI =InStream.readUTF();
            int edad =InStream.readInt();

            Ayudante nuevoUser = new Ayudante(nombre,apellido,CI,edad);
        	users.add(nuevoUser);
        }
        
        InStream.close();
        return users;
    }
}
