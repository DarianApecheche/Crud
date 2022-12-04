import java.io.Serializable;

public class Ayudante implements Serializable{
    protected String name;
    protected String lastname;
    protected String CI;
    protected int edad;
    
    
    public Ayudante(){
        name="";
        lastname="";
        CI="";
        edad=0;
    }
    public Ayudante(String name,String lastname,String CI,int edad){
        this.name = name;
        this.lastname = lastname;
        this.CI = CI;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "{" + "nombre: " + name + " }";
    }

    
    
}
