package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
//@Import(OtherConfig.class)  // Use this tag to import other config file.
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // The values from the config file will take priority over the values specified in the @Value tag.
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;
    // If no value is assigned, the value from the config file will still be taken first.
    @Value("${game.minNumber:10}")
    private int minNumber;
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount() {return guessCount;}
    @Bean
    @MinNumber
    public int minNumber(){return minNumber;}
}
