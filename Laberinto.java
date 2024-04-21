
public class Laberinto
{
    public boolean puedoSalir(int n, String [][] maze){
        boolean res;
        int xS = buscarPosX(maze,"S");
        int yS = buscarPosY(maze, "S");
        int xE = buscarPosX(maze, "E");
        int yE = buscarPosY(maze, "E");
        if(n != maze.length){
            res =  false;
        }else
        {
            res = puedoSalir(maze, xE,yE, xS, yS);
        }
        return res;
    }
        
    private int buscarPosX(String [][] laberinto, String letra){
        int res=0;
        for(int i=0; i<laberinto.length; i++){
            for(int j=0; j<laberinto.length;j++){
                if(laberinto[i][j].equals(letra)){
                    res = i;    
                }
            }
        }
        return res;
    }
    
    private int buscarPosY(String [][] laberinto, String letra){
        int res=0;
        for(int i=0; i<laberinto.length; i++){
            for(int j=0; j<laberinto.length;j++){
                if(laberinto[i][j].equals(letra)){
                    res = j;    
                }
            }
        }
        return res;
    }
    
    private boolean puedoSalir(String [][] maze, int x, int y, int xS, int yS){
        boolean res = false;
        if(dentroMapa(x,y,maze)){
            if(x == xS && y == xS){
                res = true;
            }else{
                if(maze[x][y]=="E"|| maze[x][y]=="*"){
                    maze[x][y] = "■";
                    res = puedoSalir(maze, x, y+1, xS,yS);
                    res = res || puedoSalir(maze, x-1, y, xS,yS);
                    res = res || puedoSalir(maze, x, y-1, xS,yS);
                    res = res || puedoSalir(maze, x+1, y, xS,yS);
                }else{
                    res = false;
                }
            }
        }else{
            res = false;
        }
        return res;                           
    }
    
    private boolean dentroMapa(int x, int y, String [][]laberinto){
        return x>=0 && y>=0 && x<laberinto.length && y<laberinto[x].length;
    }
}
