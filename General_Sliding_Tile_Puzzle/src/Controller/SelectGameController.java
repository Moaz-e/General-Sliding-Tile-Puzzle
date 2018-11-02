package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import general_sliding_tile_puzzle.Grid;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.print.DocFlavor;

/**
 * FXML Controller class
 *
 * @author Moaz
 */
public class SelectGameController implements Initializable {

    @FXML
    private JFXButton btn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private void Start(int Type) {
        try {
            btn1.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Game.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            GameController GC = fxmlLoader.getController();
            GC.setGrid(new Grid(Type));

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btn1(ActionEvent event) {
        Start(1);
    }

    @FXML
    private void btn2(ActionEvent event) {
        Start(2);
    }

    @FXML
    private void btn3(ActionEvent event) {
        Start(3);
    }
    
    @FXML
    private void btn4(ActionEvent event) {
        Start(4);
    }
    
    @FXML
    private void btn5(ActionEvent event) {
        Start(5);
    }
    
    @FXML
    private void btn14(ActionEvent event) {
        Start(6);
    }

    @FXML
    private void btn7(ActionEvent event) {
        Start(7);
    }

    

}
