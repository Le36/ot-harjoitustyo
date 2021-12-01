package com.chip8.ui;

import com.chip8.emulator.Executer;
import com.chip8.emulator.Keys;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;

public class Display extends Application {

    private Executer executer;
    private boolean fileChosen;
    private File selectedFile;
    private double gameSpeed;

    public void start(Stage stage) {

        final int width = 640;
        final int height = 320;

        PixelManager pixels = new PixelManager(64, 32);
        FileChooser fileChooser = new FileChooser();
        Keys keys = new Keys();

        Button selectRom = new Button("Select ROM");
        Button resetRom = new Button("Reset ROM");
        Slider slider = new Slider(1, 100, 1);
        Label label = new Label("ROM Speed: ");

        stage.setTitle("Chip8 Emulator");
        HBox hboxLeft = new HBox(4, selectRom, resetRom, slider);
        HBox hboxRight = new HBox(4, label, slider);
        HBox hbox = new HBox(260, hboxLeft, hboxRight);

        Canvas canvas = new Canvas(width, height);
        GraphicsContext paint = canvas.getGraphicsContext2D();
        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setTop(hbox);
        root.setCenter(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();

        // keyboard for emulator
        scene.addEventFilter(KeyEvent.ANY, keys::setKey);

        stage.setOnCloseRequest(windowEvent -> System.exit(0));

        selectRom.setOnAction(e -> {
            selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile == null || selectedFile.length() > 4096 || selectedFile.length() < 2) return;
            this.executer = new Executer(selectedFile.getAbsolutePath(), pixels, keys);
            fileChosen = true;
            pixels.clearDisplay();
        });

        resetRom.setOnAction(e -> {
            if (selectedFile == null) return;
            this.executer = new Executer(selectedFile.getAbsolutePath(), pixels, keys);
            fileChosen = true;
            pixels.clearDisplay();
        });


        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                    if (fileChosen) {
                        for (int i = 0; i < gameSpeed; i++) {
                            executer.execute();
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Platform.runLater(() -> {
                    gameSpeed = slider.getValue();
                    if (!fileChosen) return;
                    pixels.fade(); // fades all pixels that have been erased

                    // paints everything black every cycle
                    paint.setFill(Color.BLACK);
                    paint.fillRect(0, 0, width, height);

                    // draws fading pixels
                    HashMap<Integer, HashMap<Integer, Double>> fadeMap = pixels.getFadeMap();
                    for (int x = 0; x < fadeMap.size(); x++) {
                        for (int y = 0; y < fadeMap.get(x).size(); y++) {
                            if (fadeMap.get(x).get(y) > 0.0) {
                                double fading = Math.min(0.95, fadeMap.get(x).get(y));

                                Color color = new Color(fading, fading, fading, 1);

                                paint.setFill(color);
                                paint.fillRect(x * 10, y * 10, 10, 10);
                            }
                        }
                    }

                    // paints the current pixels that are actually on
                    boolean[][] display = pixels.getDisplay();
                    paint.setFill(Color.WHITE);
                    for (int x = 0; x < 32; x++) {
                        for (int y = 0; y < 64; y++) {
                            if (display[y][x]) {
                                paint.fillRect(y * 10, x * 10, 10, 10);
                            }
                        }
                    }
                });
            }
        }).start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

