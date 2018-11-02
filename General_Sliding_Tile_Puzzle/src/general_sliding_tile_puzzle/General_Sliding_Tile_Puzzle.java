package general_sliding_tile_puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Moaz
 */
public class General_Sliding_Tile_Puzzle extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.TRANSPARENT);

        stage.show();
        stage.setResizable(false);
    }

}
