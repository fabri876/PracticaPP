public class Ejercicio1
{
    public static int[] hallarInicio(int n, String[] maze, int x){
        if(x == n){
        return null;
        }
        if(maze[x].contains("S")){
           return new int[]{x, maze[x].indexOf("S")};
        }
        return hallarInicio(n, maze, x + 1);
    }
    
    public static boolean posiValida(int n, String[] maze, int x, int y, boolean[][] visitados){
        if(x<0 || y<0 || x>=n || y>=n){
            return false;
        }
        if(maze[x].charAt(y) == '?'|| visitados[x][y]){
            return false;
        }
        return true;
    }
    
    public static boolean searchSalida(int n, String[] maze, int x, int y,boolean[][] visitados){
        boolean posValida = posiValida(n, maze, x, y, visitados);
        if(posValida == false){
            return false;
        } 
        visitados[x][y] = true;
        if(maze[x].charAt(y) == 'E'){
            return true;
        }
        boolean norte = searchSalida(n, maze, x+1, y,visitados);
        boolean sur = searchSalida(n, maze, x-1, y,visitados);
        boolean este = searchSalida(n, maze, x, y+1,visitados);
        boolean oeste = searchSalida(n, maze, x, y-1,visitados);
        return norte|| sur||este||oeste;
    }
    
    public static boolean puedoSalir(int n, String[] maze){
        int [] posIni = hallarInicio(n, maze, 0);
        int x = posIni[0];
        int y = posIni[1];
        boolean[][] visitados = new boolean[n][n];
        boolean busSalida = searchSalida(n, maze, x, y, visitados);
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++) {
               if(visitados[i][j]){
                System.out.print(" * ");
                } else{
                    System.out.print(" ? ");
                }
            }
            System.out.println();
        }
        return busSalida;
    }
    
    public static void main(){
        String [] ejemplo1 = { 
        "S*???",
        "?**",
        "???",
        "???",
        "??**E"
        };
        boolean salir = puedoSalir (5 ,ejemplo1);
        System.out.println("res: " + salir);
    }
}
