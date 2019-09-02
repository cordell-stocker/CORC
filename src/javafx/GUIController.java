package javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class GUIController extends Application {

    private static List<Object> waitingOn = new ArrayList<>();
    private static long SLEEP_TIME = 100;

    public void addObjectToWaitOn(Object o) {
        GUIController.waitingOn.add(o);
    }

    public void removeObjectToWaitOn(Object o) {
        GUIController.waitingOn.remove(o);
    }

    public void waitOnGUI() {
        if (!GUIController.waitingOn.isEmpty()) {
            do {
                try {
                    Thread.sleep(GUIController.SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (!GUIController.waitingOn.isEmpty());
        }
    }

    protected void addNodeOnPlatformThread(Pane parent, Node child) {
        Platform.runLater(() -> parent.getChildren().add(child));
    }

    protected void removeNodeOnPlatformThread(Pane parent, Node child) {
        Platform.runLater(() -> parent.getChildren().remove(child));
    }
}
