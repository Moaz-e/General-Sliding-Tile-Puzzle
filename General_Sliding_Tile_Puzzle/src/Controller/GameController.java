package Controller;

import Algorithms.A_star;
import Algorithms.BFS;
import Algorithms.DFS;
import Algorithms.Dijkstra;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Moaz
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Grid MyGrid;
    // Player
    @FXML
    private GridPane GridPane;

    private int Selection = -1;

    public void setGrid(Grid g) {
        HashMap<Grid, Grid> Map = new HashMap<>();
//        MyGrid = g.bfs(g, Map);
//        System.out.println(Map);
        MyGrid = g;
        GridPane.getChildren().clear();
        Selection = -1;
        for (Piece P : MyGrid.getPieces()) {
            addPiece(P);
        }
        GridPane.getScene().setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        MoveUp();
                        break;
                    case S:
                        MoveDown();
                        break;
                    case A:
                        MoveLeft();
                        break;
                    case D:
                        MoveRight();
                        break;
                }
                if (MyGrid.checkEndState()) {
                    System.out.println("You Win");
                }
            }
        });

    }

    private void MoveUp() {
        if (Selection == -1) {
            return;
        }
        if (MyGrid.canMoveToUp(Selection)) {
            Piece P = MyGrid.getPieces().get(Selection);
            removePiece(P);
            addPiece(MyGrid.getUp(P));
            MyGrid = MyGrid.MoveToUp(Selection);
        }
        Selection = MyGrid.getPieces().size() - 1;
//        Colored(MyGrid.getPieces().get(Selection), false);
//        Selection = -1;
    }

    private void MoveDown() {
        if (Selection == -1) {
            return;
        }
        if (MyGrid.canMoveToDown(Selection)) {
            Piece P = MyGrid.getPieces().get(Selection);
            removePiece(P);
            addPiece(MyGrid.getDown(P));
            MyGrid = MyGrid.MoveToDown(Selection);
        }
        Selection = MyGrid.getPieces().size() - 1;
//        Colored(MyGrid.getPieces().get(Selection), false);
//        Selection = -1;
    }

    private void MoveRight() {
        if (Selection == -1) {
            return;
        }
        if (MyGrid.canMoveToRight(Selection)) {
            Piece P = MyGrid.getPieces().get(Selection);
            removePiece(P);
            addPiece(MyGrid.getRight(P));
            MyGrid = MyGrid.MoveToRight(Selection);
        }
        Selection = MyGrid.getPieces().size() - 1;
//        Colored(MyGrid.getPieces().get(Selection), false);
//        Selection = -1;
    }

    private void MoveLeft() {
        if (Selection == -1) {
            return;
        }
        if (MyGrid.canMoveToLeft(Selection)) {
            Piece P = MyGrid.getPieces().get(Selection);
            removePiece(P);
            addPiece(MyGrid.getLeft(P));
            MyGrid = MyGrid.MoveToLeft(Selection);
        }
        Selection = MyGrid.getPieces().size() - 1;
//        Colored(MyGrid.getPieces().get(Selection), false);
//        Selection = -1;
    }

    private void removePiece(Piece piece) {
        for (Square s : piece.getSquares()) {
            int x = s.getPositionX() - 1;
            int y = s.getPositionY() - 1;
            for (Node node : GridPane.getChildren()) {
                if (GridPane.getColumnIndex(node) == y && GridPane.getRowIndex(node) == x) {
                    GridPane.getChildren().remove(node);
                    break;
                }
            }
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

            btn.setOnAction(e -> {
                setPiece(X + 1, Y + 1);
            });
        }
    }

    private void setPiece(int X, int Y) {
        if (Selection != -1) {
            Colored(MyGrid.getPieces().get(Selection), false);
        }
        int i = 0;
        for (Piece P : MyGrid.getPieces()) {
            if (P.haveSquare(new Square(X, Y))) {
                Colored(P, true);
                Selection = i;
                return;
            }
            i++;
        }
    }

    private void Colored(Piece piece, boolean bo) {
        for (Square s : piece.getSquares()) {
            int x = s.getPositionX() - 1;
            int y = s.getPositionY() - 1;
            ColoredSquare(x, y, bo);
        }
    }

    private void ColoredSquare(int row, int col, boolean bo) {
        for (Node node : GridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                JFXButton btn = (JFXButton) node;
                if (bo) {
                    btn.setOpacity(0.5f);
                } else {
                    btn.setOpacity(1);
                }
                return;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void DFS(ActionEvent event) {
        HashMap<Grid, Grid> Father = new HashMap<>();
        DFS dfs = new DFS(MyGrid);
        Grid G = dfs.getSolve(MyGrid);
        Father = dfs.Map;
        System.out.println("Number of all move to solve = " + dfs.getNumMoveToSolve());
        System.out.println("Number minimum move to solve = " + dfs.getMinStepToSolve());
        System.out.println("Go");
        Go(Father, G);
    }

    @FXML
    private void BFS(ActionEvent event) throws InterruptedException {
        HashMap<Grid, Grid> Father = new HashMap<>();
        BFS bfs = new BFS(MyGrid);
        Grid G = bfs.getSolve(MyGrid);
        Father = bfs.Map;
        System.out.println("Number of all move to solve = " + bfs.getNumMoveToSolve());
        System.out.println("Number minimum move to solve = " + bfs.getMinStepToSolve());
        System.out.println("Go");
        Go(Father, G);
    }

    @FXML
    private void Dijkstra(ActionEvent event) {
        HashMap<Grid, Grid> Father = new HashMap<>();
        Dijkstra dijkstra = new Dijkstra(MyGrid);
        Grid G = dijkstra.getSolve(MyGrid);
        Father = dijkstra.Map;
        System.out.println("Number of all move to solve = " + dijkstra.getNumMoveToSolve());
        System.out.println("Number minimum move to solve = " + dijkstra.getMinStepToSolve());
        System.out.println("Go");
        Go(Father, G);
    }

    @FXML
    private void A_star(ActionEvent event) {
        HashMap<Grid, Grid> Father = new HashMap<>();
        A_star A = new A_star(MyGrid);
        Grid G = A.getSolve(MyGrid);
        Father = A.Map;
        System.out.println("Number of all move to solve = " + A.getNumMoveToSolve());
        System.out.println("Number minimum move to solve = " + A.getMinStepToSolve());
        System.out.println("Go");
        Go(Father, G);
    }

    private void Go(HashMap<Grid, Grid> Father, Grid G) {
        HashMap<Grid, Grid> Son = new HashMap<>();
        int x=0;
        while (Father.get(G) != null) {
            x++;
            Grid fa = Father.get(G);
            Son.put(fa, G);
            G = fa;
        }
        try {
            GridPane.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ShowSolve.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            ShowSolveController GC = (ShowSolveController) fxmlLoader.getController();
            GC.setSon(Son);
            GC.setFather(Father);
            GC.setGrid(G);
            GC.setMaxNumGrid(x);

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
