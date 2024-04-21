import java.util.ArrayList;
public class Ejercicio2
{
    public static void vectorGenerado(String [] vec, int x, String ini, ArrayList<String> combinacion){
        if(x < vec.length){
            String nCad = ini + vec[x]; 
            combinacion.add(nCad);
            vectorGenerado(vec, x + 1, nCad, combinacion);
            vectorGenerado(vec, x + 1, ini, combinacion);
        }
    }
    public static boolean puedoGenerar(String[] a, String x){
        ArrayList<String> combinacion = new ArrayList<String>();
        vectorGenerado(a, 0, "", combinacion);
        System.out.println(combinacion);
        return combinacion.contains(x);
    }
    public static void main(){
        String [] ejemplo1 = new String[]{"1","1","2"};
        boolean generar =  puedoGenerar(ejemplo1,  "112");
        System.out.println(generar);
    }  
}
