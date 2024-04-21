
public class Numero
{
    public boolean puedoGenerar(String[] a, String x){
        int pos = 0;
        String cadena = "";
        return puedoGenerar(a, x, pos, cadena);
    }
    
    private boolean puedoGenerar(String [] a, String x, int pos, String cadena){
         if(pos == a.length){
             return cadena.equals(x);
         }
         if(puedoGenerar(a,x,pos+1, cadena+a[pos])){
             return true;
         }
         if(puedoGenerar(a,x, pos+1, cadena)){
             return true;
         }
         return false;
    }
}

