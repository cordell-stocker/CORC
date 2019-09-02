package javafx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

@SuppressWarnings("unused")
public abstract class OptionPanel<T> extends VBox {

    @SuppressWarnings("FieldCanBeLocal")
    private final long SLEEP_TIME = 100;
    private volatile boolean clicked;
    private T optionClicked;

    public OptionPanel(String title, T[] options) {
        OptionPanel<T> that = this; // Prevents confusion in lambdas.
        Label header = new Label(title);
        this.getChildren().add(header);

        for (T option : options) {
            Button button = new Button(option.toString());
            button.setOnAction(e -> {
                that.optionClicked = option;
                that.clicked = true;
            });
            this.getChildren().add(button);
        }
    }

    protected T getOptionClicked() {
        this.clicked = false;
        while (!this.clicked) {
            try {
                Thread.sleep(this.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.optionClicked;
    }

}
