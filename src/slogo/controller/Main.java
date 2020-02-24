package slogo.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import slogo.exceptions.CommandDoesNotExistException;
import slogo.exceptions.InvalidArgumentException;
import slogo.exceptions.LanguageIsNotSupportedException;
import slogo.exceptions.WrongCommandFormatException;
import slogo.model.Turtle;
import slogo.view.ViewScreen;


/**
 *
 */
public class Main extends Application {

    public static final int FRAMES_PER_SECOND = 60;
    public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private long time;
    private ViewScreen viewScreen;
    private Parser parser;

    /**
     * Start the program.
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws LanguageIsNotSupportedException {
        viewScreen = new ViewScreen(primaryStage);
        time = System.currentTimeMillis();
        parser = new Parser(new Turtle(0));
        parser.setLanguage(viewScreen.getLanguage());
        setTiming();
    }

    private void setTiming() {
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
            try {
                step(SECOND_DELAY);
            } catch (WrongCommandFormatException | InvalidArgumentException | LanguageIsNotSupportedException | CommandDoesNotExistException ex) {
                ex.printStackTrace();
            }
        });
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void step(double secondDelay)
        throws WrongCommandFormatException, InvalidArgumentException, LanguageIsNotSupportedException, CommandDoesNotExistException {
        String inputString = viewScreen.getInputString();
        if (inputString != null) {
            parser.execute(inputString);
        }
        parser.setLanguage(viewScreen.getLanguage());
        ViewScreen.update();
    }
}

