package unify;
/**
 * 簡易的なデータベースを実装したGUIプログラム
 *
 * データの追加、削除、検索ができる。
 * ファイルからのデータの読み込み、ファイルへの書き込み、Redo、Undoなど様々な機能も備えている。
 *
 * 検索にはユニフィケーションアルゴリズムを利用している。
 *
 * Created by shimtom on 15/11/19.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UnifyGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("unify.fxml"));

        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Unify GUI");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
