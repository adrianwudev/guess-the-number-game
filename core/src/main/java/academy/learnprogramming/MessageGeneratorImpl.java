package academy.learnprogramming;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;
    public MessageGeneratorImpl(Game game){
        this.game = game;
    }

    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                " Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return String.format("You guessed it! The number was %d", game.getNum());
        }
        if (game.isGameLost()) {
            return String.format("You lost. The number was %d", game.getNum());
        }
        if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        }
        if (game.getGuessCount() == game.getRemainingGuesses()) {
            return "What is your guess?";
        }
        String direction = game.getGuess() < game.getNum() ? "Higher" : "Lower";

        return String.format("%s! You have %d guesses left.", direction, game.getRemainingGuesses());
    }
}
