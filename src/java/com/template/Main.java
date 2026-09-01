package com.template;

import com.template.controller.MainController;
import com.template.validator.IPlantaValidator;
import com.template.validator.PlantaValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        IPlantaValidator pValidator = new PlantaValidator();

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("main.fxml"));
        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == MainController.class) {
                return new MainController(pValidator);
            }
            try {
                return controllerClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Scene scene = new Scene(loader.load(),1000,1000);

        stage.setTitle("Cadastro das plantinhas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}