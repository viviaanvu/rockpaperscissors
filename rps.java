package FinalPackage;

public class rps {
    private int compWins;
    private int userWins;
    enum Outcome{
        WIN, LOSS, DRAW
    }
    enum Choice{
        ROCK, PAPER, SCISSORS
    }
    public rps(){
        compWins=0;
        userWins=0;
    }

    public static Choice comp(){
        int num = (int) (Math.random()*3);
        if(num == 0){
            return Choice.ROCK;
        }
        else if (num == 1){
            return Choice.PAPER;
        }
        else{
            return Choice.SCISSORS;
        }
    }
    public static Outcome pickedRock(){
        Choice comp = comp();

        if(comp == Choice.ROCK){
            return Outcome.DRAW;

        }
        else if(comp == Choice.PAPER){
            return Outcome.LOSS;
        }
        else{
            return Outcome.WIN;
        }
    }
    public static Outcome pickedPaper(){
        Choice comp = comp();

        if(comp == Choice.ROCK){
            return Outcome.WIN;

        }
        else if(comp == Choice.PAPER){
            return Outcome.DRAW;
        }
        else{
            return Outcome.LOSS;
        }
    }
    public static Outcome pickedScissors(){
        Choice comp = comp();

        if(comp == Choice.ROCK){
            return Outcome.LOSS;

        }
        else if(comp == Choice.PAPER){
            return Outcome.WIN;
        }
        else{
            return Outcome.DRAW;
        }
    }
    public void adder(boolean b){
        if(b){
            userWins++;
        }
        if(!b){
            compWins++;
        }
    }

    public int getCompWins() {
        return compWins;
    }

    public int getUserWins() {
        return userWins;
    }
    public void resetWins(){
        compWins=0;
        userWins=0;
    }
}
