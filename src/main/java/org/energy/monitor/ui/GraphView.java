package org.energy.monitor.ui;



import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class GraphView {
    private StackPane view;

    public GraphView() {
        view = new StackPane();
        Label placeholder = new Label("Graph View - Charts will be here soon!");
        placeholder.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        view.getChildren().add(placeholder);
    }

    public StackPane getView() {
        return view;
    }
}
