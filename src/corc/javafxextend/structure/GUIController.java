/*
Copyright 2019, Cordell Stocker (cordellstocker@gmail.com)
All rights reserved.

This file is part of CORC.

    CORC is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CORC is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CORC.  If not, see <https://www.gnu.org/licenses/>.
*/
package corc.javafxextend.structure;

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

    public static void addObjectToWaitOn(Object o) {
        GUIController.waitingOn.add(o);
    }

    public static void removeObjectToWaitOn(Object o) {
        GUIController.waitingOn.remove(o);
    }

    public static void waitOnGUI() {
        do {
            try {
                Thread.sleep(GUIController.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!GUIController.waitingOn.isEmpty());

    }

    protected void addNodeOnPlatformThread(Pane parent, Node child) {
        Platform.runLater(() -> parent.getChildren().add(child));
    }

    protected void removeNodeOnPlatformThread(Pane parent, Node child) {
        Platform.runLater(() -> parent.getChildren().remove(child));
    }
}
