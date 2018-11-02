/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import general_sliding_tile_puzzle.Grid;
import general_sliding_tile_puzzle.Piece;
import general_sliding_tile_puzzle.Square;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Moaz
 */
public class ShowSolveController implements Initializable {

    @FXML
    private GridPane GridPane;
    private Grid MyGrid;
    HashMap<Grid, Grid> Son = new HashMap<>();
    HashMap<Grid, Grid> Father = new HashMap<>();
    int NumGrid = 0, MaxNumGrid = 0;
    @FXML
    private TextField NumGridShow;
    @FXML
    private TextField NumberAllMove;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setSon(HashMap<Grid, Grid> Son) {
        this.Son = Son;
    }

    public void setFather(HashMap<Grid, Grid> Father) {
        this.Father = Father;
    }

    public void setMaxNumGrid(int x) {
        this.MaxNumGrid = x;
        NumberAllMove.setText("Number All Move : " + String.valueOf(MaxNumGrid));
    }

    public void setGrid(Grid g) {
        MyGrid = g;
        GridPane.getChildren().clear();
        for (Piece P : MyGrid.getPieces()) {
            addPiece(P);
        }
    }

    private void addPiece(Piece piece) {

        String hexColor = MyGrid.getHexColor(piece.getColor());
        for (Square s : piece.getSquares()) {
            JFXButton btn = new JFXButton("");
            int Y = s.getPositionY() - 1;
            int X = s.getPositionX() - 1;
            GridPane.add(btn, Y, X);
            btn.setStyle("-fx-background-radius : 0 ; -fx-background-color: " + hexColor);
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);

        }
    }

    @FXML
    private void next(ActionEvent event) {
        getNextGrid();
    }

    void getNextGrid() {
        if (Son.get(MyGrid) == null) {
            return;
        }
        GridPane.getChildren().clear();
        MyGrid = Son.get(MyGrid);
        this.setGrid(MyGrid);
        NumGrid++;
        NumGridShow.setText(String.valueOf(NumGrid));
    }

    @FXML
    private void previous(ActionEvent event) {
        getPreviousGrid();
    }

    void getPreviousGrid() {
        if (Father.get(MyGrid) == null) {
            return;
        }
        GridPane.getChildren().clear();
        MyGrid = Father.get(MyGrid);
        this.setGrid(MyGrid);
        NumGrid--;
        NumGridShow.setText(String.valueOf(NumGrid));
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            GridPane.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/SelectGame.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void numGridShow(ActionEvent event) {
        String s = NumGridShow.getText();
        if (!s.matches("[0-9]+")) {
            return;
        }
        int x = Integer.valueOf(s);
        x = Math.min(x, MaxNumGrid);
        x = Math.max(0, x);
        while (x < NumGrid) {
            this.getPreviousGrid();
        }
        while (x > NumGrid) {
            this.getNextGrid();
        }
    }

}
