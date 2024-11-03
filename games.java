import java.util.Scanner;
import java.util.Random;
public class games
{    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int [][] game = new int [4][4];
        fill(game);
        int number = 1 ;
        // character W baraye bala raftan 
        // character S baraye payin raftan
        // character D baraye samt raast raftan 
        // character A baraye samt chap raftan
        // i satr jadval ast
        // j sotoon jadval ast
        do
        { 
            if ( number == 1) {
            random(game);
            random(game);
            }
            else {
                random(game);
            }
            
            table(game);
            char direction = in.next().charAt(0);
            move( game , direction);
            move( game , direction);
            move( game , direction);
            move( game , direction);
            plus (game , direction);
            move(game , direction);
            table(game);
            number ++;

        }
        while(CONTINUE(game));
        System.out.flush();
        fill(game);
        

    }

    public static void table( int [][] game) // chap kardan jadval 
    {
        System.out.println("-----------------");
        for ( int i = 0 ; i < 4 ; i++) {
            System.out.printf("\u2503%4d\u2503%4d\u2503%4d\u2503%4d\u2503\n",game[i][0],game[i][1],game[i][2],game[i][3]);
            System.out.println("-----------------");
            
        }
    }
  public static void move( int [][] game , char direction ) // harekat dadan adadha dar jadval
   {
    if ( direction == 'W') {
        for ( int j = 0; j < 4 ; j++ ) {
            for ( int i = 1 ; i < 4 ; i++) {
                int MOVE ;
                
                MOVE = i - 1 ; 
                while ( MOVE >=0 && MOVE < 4) {
                if ( game[MOVE][j] == 0) {
                    game[MOVE][j] = game[i][j];
                    game[i][j] = 0 ;
                    MOVE--;
                
                }
                else
                break;
                }
                
            }
        }
    }
    if ( direction == 'S') {
        for ( int j = 0 ; j < 4 ; j++) {
            for ( int i = 0 ; i < 3 ; i++) {
                int MOVE;
                
                    MOVE = i + 1;
                    while ( MOVE >= 0 && MOVE < 4 ) {
                        if ( game[MOVE][j] == 0) {
                            game[MOVE][j] = game[i][j];
                            game[i][j] = 0 ;
                            MOVE++;

                        }
                        else 
                        break;
                    }
                
            }
        }
    }
    if ( direction == 'D') {
        for ( int i = 0 ; i < 4 ; i++) {
            for ( int j = 0 ; j < 3 ; j++) {
                int MOVE;
                
                    MOVE = j + 1;
                    while ( MOVE >=0 && MOVE < 4) {
                    if ( game[i][MOVE]== 0) {
                            game[i][MOVE]= game[i][j];
                            game[i][j] = 0;
                            MOVE++;
                    }
                    else
                    break;
                    }
                
            }
        }
    }
    if ( direction == 'A') {
        for ( int i = 0 ; i < 4 ; i++) {
            for ( int j = 1 ; j < 4 ; j++) {
                int MOVE;
                MOVE = j -1 ; 
                while ( MOVE >= 0 && MOVE < 4 ) {
                    if ( game[i][MOVE] == 0) {
                        game[i][MOVE] = game[i][j];
                        game[i][j] = 0 ;
                        MOVE--;
                    }
                    else
                    break;
                }
            }
        }
    }
}

    public static void plus(  int[][] game , char direction ) // jam karadan adahaye moshabeh dar khanehaye kenar ham vesl 2 va 2
    {   
       if ( direction == 'W' || direction == 'S') {
           for ( int i = 0 ; i < 3 ;i++ ) {
               for ( int j = 0 ; j < 4 ; j++) {
                   if ( game[i][j] == game[i+1][j]) {
                       if ( direction == 'W')
                       game[i][j] = game[i][j] + game[i+1][j];
                       
                       game[i+1][j] = 0;
                       if ( direction == 'S') {
                           game[i+1][j] = game[i][j] * 2 ;
                           game[i][j]=0;
                           
                       }
                   }
               }
           }
       }
       if ( direction == 'A' || direction == 'D') {
           for ( int i = 0 ; i < 4 ; i++) {
               for ( int j = 0 ; j < 3 ; j++) {
                   if ( game[i][j] == game[i][j+1]) {
                       if ( direction == 'A') {
                           game[i][j] = game[i][j] + game[i][j+1];
                           
                           game[i][j+1]=0;
                       }
                       if ( direction == 'D')
                       {
                           game[i][j+1] = game[i][j] + game[i][j+1];
                           game[i][j] = 0;
                           
                       }
                   }
               }
           }
       }
    }
    
     
    public static boolean CONTINUE ( int[][] game ) // check kardan inke aya hameye khanehaye jadval por shodeand ya na 
    {   boolean cont = true;
         int count = 0;
            for ( int i = 0 ; i < 4 ; i++) {
                for ( int j = 0 ; j < 4 ;j++) {
                    if (game[i][j]!= 0) {
                        count++;
                        
                    }
                    else {
                        count = count;
                    }
                    

                    }
                }
            
            if ( count == 16) {
                cont = false;
            }
            return cont;
            

    }
    public static void fill( int [][] game ) //tamam khaneha ra sefr mikonad
{
    for ( int i = 0 ; i < 4 ; i++) {
        for ( int j = 0 ; j < 4 ; j++) {
            game[i][j] = 0;
        }
    }
}
public static void random (  int[][] game ) // peyda kardan khaneii be soorat tasadofi baraye adad tasadofi
{
    Random n = new Random();
    int num = n.nextInt(4);
    int numb = n.nextInt(4);
    int t = randoom(game);
    if ( game[num][numb] == 0 )
    game[num][numb] = t;
    else {
        int numm = n.nextInt(4);
        int numbb = n.nextInt(4);
        int e = randoom(game);
        game[numm][numbb] = e;
    }

}
public static int randoom ( int[][] game ) // dadan adad tasadofi be jadval
{
    Random r = new Random();
    int rnd = r.nextInt(3);
    if ( rnd == 1 ) {
        return 2;
    }
    if (rnd == 2) {
        return 4;
    }
    return 4 ;
}

}
