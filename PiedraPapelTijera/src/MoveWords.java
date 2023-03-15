import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "TORITO", "SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;
		int ganador=0;

	    first_i = getIndex(first);
	    second_i = getIndex(second);

	    if (first_i == second_i) return EMPATE;
	    
	    switch(first) {

			case "TIJERAS": 

				if(second.equals("TORITO")){
				return GANA;
				}

				if(second.equals("PAPEL")){
                    return GANA;
                }

                if(second.equals("PIEDRA")){
                    return PIERDE;
                }
                
                if(second.equals("SPOCK")){
                    return PIERDE;
                }
			break;

			case "PIEDRA": 
				if(second.equals("TORITO")){
				return GANA;
				}

				if(second.equals("PAPEL")){
                    return PIERDE;
                }

                if(second.equals("TIJERAS")){
                    return GANA;
                }
                
                if(second.equals("SPOCK")){
                    return PIERDE;
                }
			break;	

			case "PAPEL": 
				if(second.equals("TORITO")){
				return PIERDE;
				}

				if(second.equals("LAGARTO")){
				return PIERDE;
				}

				if(second.equals("TIJERAS")){
				return PIERDE;
				}
			
				if(second.equals("SPOCK")){
				return GANA;
				}
			break;	

			case "SPOCK": 
				if(second.equals("TORITO")){
				return PIERDE;
				}

				if(second.equals("PAPEL")){
                    return PIERDE;
                }

                if(second.equals("TIJERAS")){
                    return GANA;
                }
                
                if(second.equals("PIEDRA")){
                    return GANA;
                }
			break;	


			case "TORITO":
				if(second.equals("PIEDRA")){
				return PIERDE;
				}

				if(second.equals("PAPEL")){
                    return GANA;
                }

                if(second.equals("TIJERAS")){
                    return PIERDE;
                }
                
                if(second.equals("SPOCK")){
                    return GANA;
                }
			break;	
		}

		return ganador;
	
	} 
}