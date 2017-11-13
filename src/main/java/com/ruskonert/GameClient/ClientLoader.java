package com.ruskonert.GameClient;

import com.ruskonert.GameClient.connect.ClientBackground;
import com.ruskonert.GameClient.event.ClientLayoutEvent;
import com.ruskonert.GameEngine.ProgramInitializable;
import com.ruskonert.GameEngine.event.EventController;
import com.ruskonert.GameEngine.event.EventListener;
import com.ruskonert.GameEngine.event.LayoutListener;
import com.ruskonert.GameEngine.program.Register;
import com.ruskonert.GameEngine.util.SystemUtil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientLoader extends Application implements ProgramInitializable, Register
{
    private static ClientBackground backgroundConnection;
    public static ClientBackground getBackgroundConnection() { return backgroundConnection; }

    public static void main(String[] args) { launch(args);}

    public static void setBackgroundConnection(ClientBackground backgroundConnection)
    {
        ClientLoader.backgroundConnection = backgroundConnection;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(SystemUtil.Companion.getStylePath("style/client_login.fxml"));
        primaryStage.setTitle("Ruskonert Card Game Launcher");
        primaryStage.setScene(new Scene(loader.load(), 600,400));
        this.registerEvent(new ClientLayoutEvent());
        primaryStage.show();
    }

    @Override
    public boolean initialize(Object handleInstance)
    {
        return true;
    }

    @Override
    public void registerEvent(LayoutListener listener)
    {
        listener.register(this);
    }

    @Override
    public void registerEvent(EventListener listener)
    {
        EventController.signatureListener(listener);
    }
}