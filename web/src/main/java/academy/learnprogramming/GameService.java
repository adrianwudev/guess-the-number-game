package academy.learnprogramming;

public interface GameService {
    Boolean isGameOver();
    String getMainMessage();
    String getResultMessage();
    void checkGuess(int guess);
    void reset();
}
