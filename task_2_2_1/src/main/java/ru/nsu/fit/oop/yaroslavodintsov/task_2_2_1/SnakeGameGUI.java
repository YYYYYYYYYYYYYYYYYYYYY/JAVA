package ru.nsu.fit.oop.yaroslavodintsov.task_2_2_1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_2_1.*;

import static javafx.scene.input.KeyCode.*;

/**
 * The SnakeGameGUI creates the whole look of the Snake game. Moreover it is
 * responsible for handling user inputs and for playing the actual game.
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes", "restriction" })
public class SnakeGameGUI extends Application {

    private HBox buttonBox;
    private Button btnPlay;
    private Button btnPause;

    private HBox scoreBox;
    private Label scoreName;
    private Label scoreValue;

    private GridPane gamePane;
    private Timeline timeline = new Timeline();
    private Direction pressedDir;
    private boolean hasGameStarted = false;
    private boolean paused;

    private Snake snake;
    private Fruit fruit;

    private final int normalFruitValue = 1;
    private final int specialFruitValue = 3;
    private final int specialFruitFrequency = 5;
    private final int gridSize = 30;
    private final double speed = 250;
    private final double increment = 0.1;

    private final Font fatFont = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25);
    //private final Font mediumFont = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20);
    private final Font smallFont = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Snake");
        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.BOTTOM_CENTER);
        primaryStage.setScene(new Scene(root));

        snake = new Snake(gridSize);
        fruit = new Fruit(snake, 1);
        gamePane = createGamePane();

        scoreName = new Label("Score: ");
        scoreName.setMinWidth(60);
        scoreName.setMinHeight(20);
        scoreName.setFont(fatFont);
        scoreValue = new Label();
        scoreValue.setText(Integer.toString(snake.getScore()));
        scoreValue.setMinWidth(60);
        scoreValue.setMinHeight(20);
        scoreValue.setFont(fatFont);

        btnPlay = new Button("Start");
        btnPlay.setFont(smallFont);
        btnPause = new Button("Pause");
        btnPause.setFont(smallFont);

        btnPlay.setMinWidth(100);
        btnPlay.setMinHeight(60);
        btnPause.setMinWidth(100);
        btnPause.setMinHeight(60);

        scoreBox = new HBox(3.0);
        scoreBox.getChildren().addAll(scoreName, scoreValue);
        HBox.setMargin(scoreName, new Insets(10, 0, 0, 0));
        HBox.setMargin(scoreValue, new Insets(10, 0, 0, 0));

        buttonBox = new HBox(8.0);
        buttonBox.getChildren().addAll(btnPlay, btnPause);
        HBox.setMargin(btnPlay, new Insets(0, 0, 10, 0));

        btnPlay.setOnAction(event -> {
            if (!hasGameStarted) {
                fruit.generateRandomPosition();
                startSnakeGame();
            }
            if (paused) {
                restartGame();
                btnPlay.setText("Start");
                btnPause.setText("Pause");
            }
        });

        btnPause.setOnAction(event -> {
            if (paused) {
                timeline.play();
                btnPause.setText("Pause");
                btnPlay.setText("Start");
                paused = false;
            } else {
                timeline.pause();
                paused = true;
                btnPause.setText("Resume");
                btnPlay.setText("Restart");

            }

        });

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Direction currentDir = snake.getSnakebody().getFirst().getDirection();
                if (event.getCode() == RIGHT && !currentDir.equals(Direction.WEST)) {
                    pressedDir = Direction.EAST;
                }
                if (event.getCode() == LEFT && !currentDir.equals(Direction.EAST)) {
                    pressedDir = Direction.WEST;
                }
                if (event.getCode() == UP && !currentDir.equals(Direction.SOUTH)) {
                    pressedDir = Direction.NORTH;
                }
                if (event.getCode() == DOWN && !currentDir.equals(Direction.NORTH)) {
                    pressedDir = Direction.SOUTH;
                }
            }
        });

        root.getChildren().addAll(scoreBox, gamePane, buttonBox);
        primaryStage.show();

    }

    /**
     * Starts the timeline for the snake game and monitors the snake action
     */
    private void startSnakeGame() {
        hasGameStarted = true;
        paused = false;
        timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (pressedDir != null) {
                    snake.setNewDirection(pressedDir);
                }
                snake.move();
                if (snake.snakeReachedFruit(fruit)) {
                    snakeEatsFruit();
                }
                if (snake.isGameOver()) {
                    timeline.stop();
                    createGameOverPane();
                }
                repaintPane();
            }
        }), new KeyFrame(Duration.millis(speed)));

        if (snake.isSnakeAlive()) {
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }

    private int calcIndex(int row, int col) {
        return row * gridSize + col;
    }

    private void repaintPane() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                CellButton cb = (CellButton) gamePane.getChildren().get(calcIndex(row, col));
                if (snake.isSnakePosition(row, col)) {
                    cb.setStatus(CellStatus.SNAKE);
                } else {
                    if (fruit.isFruitPosition(row, col)) {
                        cb.setStatus(CellStatus.FRUIT);

                    } else {
                        cb.setStatus(CellStatus.BOARD);
                    }
                }
            }
        }
    }

    private GridPane createGamePane() {
        GridPane pane = new GridPane();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                pane.add(new CellButton(), row, col);
            }
        }
        return pane;
    }

    private void snakeEatsFruit() {
        snake.eatFruit(fruit);
        scoreValue.setText(Integer.toString(snake.getScore()));
        fruit.generateRandomPosition();

        // If the player has eaten a certain amount of fruits, the next fruit is
        // a
        // special fruit
        if (snake.getFruitsEaten() % specialFruitFrequency == 0 && snake.getFruitsEaten() != 0) {
            fruit.setValue(specialFruitValue);
        } else {
            fruit.setValue(normalFruitValue);
        }
        timeline.setRate(timeline.getCurrentRate() + increment);
    }

    private void restartGame() {
        snake = new Snake(gridSize);
        scoreValue.setText(Integer.toString(snake.getScore()));
        pressedDir = Direction.NORTH;
        fruit.generateRandomPosition();
        startSnakeGame();
    }

    private void createGameOverPane() {
        Stage gameOverStage = new Stage();
        BorderPane gameOverScreen = new BorderPane();
        gameOverScreen.setPrefHeight(500);
        gameOverScreen.setPrefWidth(500);
        Label gameOver = new Label("Game Over!");
        gameOver.setTextFill(Color.BLACK);
        gameOver.setFont(Font.font("Courier New", FontWeight.BOLD, 60));
        gameOverScreen.setCenter(gameOver);
        gameOverScreen.setPadding(new Insets(0, 0, 10, 0));

        Button restart = new Button("New Game");
        Button quit = new Button("Exit Game");
        HBox buttonBoxGameOver = new HBox(3.0);
        buttonBoxGameOver.getChildren().addAll(restart, quit);
        gameOverScreen.setBottom(buttonBoxGameOver);
        buttonBoxGameOver.setAlignment(Pos.BOTTOM_CENTER);

        gameOverStage.setTitle("Game Over!");
        gameOverStage.setScene(new Scene(gameOverScreen, 380, 200));
        gameOverStage.show();

        gameOverStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent we) {
                Platform.exit();
                System.exit(0);
            }
        });

        // Exit Game
        quit.setOnAction((ActionEvent e) -> {
            Platform.exit();
            System.exit(0);
        });

        // New Game
        restart.setOnAction((ActionEvent e) -> {
            gameOverStage.close();
            restartGame();
        });
    }

}