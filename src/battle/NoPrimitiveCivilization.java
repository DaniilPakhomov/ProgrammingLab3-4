package battle;

public class NoPrimitiveCivilization extends Exception {
    public NoPrimitiveCivilization(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
