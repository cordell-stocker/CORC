package javafxextend;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

/**
 * Only supports placing Nodes horizontally, with a vertical shift when selected.
 */
@SuppressWarnings("ALL")
public class OrganizablePane extends Pane {

    private final double SELECTED_VERTICAL_SHIFT;
    private final double HORIZONTAL_SPACING;

    private Node nodeBeingMoved;
    private Node selectedNode;
    private double mouseX;

    private EventHandler<MouseEvent> mouseReleased;
    private EventHandler<MouseEvent> mouseDragged;
    private EventHandler<MouseEvent> mouseClicked;

    public OrganizablePane(double spacing, double verticalShift) {
        this.HORIZONTAL_SPACING = spacing;
        this.SELECTED_VERTICAL_SHIFT = verticalShift;
        this.setMouseActions();
    }

    private void setListener() {
        this.getChildren().addListener((ListChangeListener<Node>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (Node node : c.getAddedSubList()) {
                        node.setOnMouseClicked(this.mouseClicked);
                        node.setOnMouseDragged(this.mouseDragged);
                        node.setOnMouseReleased(this.mouseReleased);
                    }
                }
                if (c.wasRemoved()) {
                    for (Node node : c.getRemoved()) {
                        node.setOnMouseClicked(null);
                        node.setOnMouseDragged(null);
                        node.setOnMouseReleased(null);
                        if (node == this.selectedNode) {
                            selectedNode.setTranslateY(0);
                            selectedNode = null;
                        }
                    }
                }
            }
        });
    }

    private void setMouseActions() {
        this.setMouseClicked();
        this.setMouseDragged();
        this.setMouseReleased();
    }

    private void setMouseClicked() {
        this.mouseClicked = e -> {
            if (e.getButton() == MouseButton.PRIMARY && e.getSource() instanceof Node) {
                this.mouseX = e.getSceneX();
                this.nodeBeingMoved = (Node) e.getSource();

                if (this.selectedNode != null) {
                    this.selectedNode.setTranslateY(0);
                }

                this.selectedNode = nodeBeingMoved;
                this.selectedNode.setTranslateY(this.SELECTED_VERTICAL_SHIFT);
                this.selectedNode.setViewOrder(-1.0);
            }
        };
    }

    private void setMouseDragged() {
        this.mouseDragged = e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                double deltaX = e.getSceneX() - mouseX;
                double currentX = nodeBeingMoved.getLayoutX();
                this.nodeBeingMoved.setLayoutX(currentX + deltaX);
                this.mouseX = e.getSceneX();
            }
        };
    }

    private void setMouseReleased() {
        this.mouseReleased = e -> {
            nodeBeingMoved = null;
            this.orderChildren();
            this.selectedNode.setViewOrder(0.0);
        };
    }

    public synchronized void orderChildren() {
        ObservableList<Node> children = this.getChildren();
        List<Node> copyOfChildren = new ArrayList<>(children);

        children.clear();

        while (!copyOfChildren.isEmpty()) {
            Node unplacedLeftMost = copyOfChildren.get(0);
            for (Node child : copyOfChildren) {
                if (child.getLayoutX() < unplacedLeftMost.getLayoutX()) {
                    unplacedLeftMost = child;
                }
            }
            copyOfChildren.remove(unplacedLeftMost);
            this.addNodeAfterLast(unplacedLeftMost);
        }
    }

    public void addNodeAfterLast(Node node) {
        ObservableList<Node> children = this.getChildren();
        children.add(node);
        if (children.isEmpty()) {
            node.setLayoutX(this.getLayoutX());
        } else {
            Node lastNode = children.get(children.size() - 1);
            double lastNodeMaxX = lastNode.getLayoutX() + lastNode.getBoundsInLocal().getWidth();
            double lastNodeLayoutY = lastNode.getLayoutY();

            node.setLayoutX(lastNodeMaxX + this.HORIZONTAL_SPACING);
            node.setLayoutY(lastNodeLayoutY);
        }
    }

    public double getSelectedVerticalShift() {
        return SELECTED_VERTICAL_SHIFT;
    }

    public double getHorizontalSpacing() {
        return HORIZONTAL_SPACING;
    }

    public Node getSelectedNode() {
        return selectedNode;
    }
}
