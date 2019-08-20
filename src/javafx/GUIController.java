package javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class GUIController extends Application {




    protected void addNodeOnPlatformThread(Pane parent, Node child) {
        Platform.runLater(() -> parent.getChildren().add(child));
    }

    protected void removeNodeOnPlatformThread(Pane parent, Node child) {
        Platform.runLater(() -> parent.getChildren().remove(child));
    }
}
