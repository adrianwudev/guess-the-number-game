package academy.learnprogramming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameImpl implements Game {
    private static final Logger logger = LoggerFactory.getLogger(GameImpl.class);
    private final NumberGenerator numberGenerator;
    private final int guessCount;
    private int num;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    public GameImpl(NumberGenerator numberGenerator, int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        //guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        num = numberGenerator.next();
        logger.debug("resset... the number is {}", num);
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("in Game preDestroy()");
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > num) {
                biggest = guess - 1;
            }

            if (guess < num) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == num;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses < 1;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
