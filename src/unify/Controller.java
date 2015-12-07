package unify;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * データベースを操作するGUI
 * <p/>
 * 検索システムにはユニフィケーションアルゴリズムを利用している。
 *
 * @author shimtom
 */
public class Controller implements Initializable {
    @FXML
    TextField inputText;
    @FXML
    TableView<Sentence> sentenceTable;
    @FXML
    TableColumn<Sentence, String> sentenceColumn;
    @FXML
    MenuItem editUndo;
    @FXML
    MenuItem editRedo;

    Unify unify = new Unify();
    String fileName = "";
    String filePath = "";
    ArrayList<History> histories = new ArrayList<History>();
    Stage primaryStage;
    ObservableList<Sentence> sentences = FXCollections.observableArrayList();
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();
    int historyTop = 0;
    boolean isSaved = false;
    boolean isChanged = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        sentenceColumn.setCellValueFactory(new PropertyValueFactory<Sentence, String>("sentence"));
        sentenceTable.setItems(sentences);
        sentenceTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        editUndo.setDisable(true);
        editRedo.setDisable(true);
    }


    @FXML
    protected void fileNewClicked(ActionEvent event) {
        if (confirmSave()) {
            fileName = "無題のドキュメント";
            filePath = "";
            primaryStage.setTitle(fileName + "- Unify GUI");
            sentences.clear();
            unify.clear();
            histories.clear();
            historyTop = 0;
            isChanged = false;
            isSaved = false;
        }
    }

    @FXML
    protected void fileOpenClicked(ActionEvent event) {
        if (confirmSave()) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file == null) return;
            if (!file.exists()) return;
            fileName = file.getName() + " (" + file.getAbsolutePath().subSequence(0, file.getPath().lastIndexOf(file.getName())) + ")";
            filePath = file.getAbsolutePath();
            unify.openFile(filePath);
            primaryStage.setTitle(fileName + " - Unify GUI");
            isChanged = false;
            isSaved = true;
            setTable();
        }
    }

    @FXML
    protected void fileCloseClicked(ActionEvent event) {
        if (confirmSave()) {
            fileName = "";
            filePath = "";
            primaryStage.setTitle("Unify GUI");
            sentences.clear();
            unify.clear();
            histories.clear();
            historyTop = 0;
            isChanged = false;
            isSaved = false;
        }

    }

    @FXML
    protected void fileSaveClicked(ActionEvent event) {
        if (!isSaved) {
            unify.saveFile();
            primaryStage.setTitle(fileName + " - Unify GUI");
            isChanged = false;
        } else {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(primaryStage);
            if (!file.exists()) return;
            String path = "" + file.getAbsolutePath().subSequence(0, file.getPath().lastIndexOf(file.getName()));
            fileName = file.getName() + " (" + path + ")";
            unify.saveFile(file.getAbsolutePath());
            primaryStage.setTitle(fileName + "- Unify GUI");
            isChanged = false;
        }
    }

    @FXML
    protected void fileSaveAsClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(primaryStage);
        filePath = file.getAbsolutePath();
        fileName = file.getName() + " (" + file.getAbsolutePath().subSequence(0, file.getPath().lastIndexOf(file.getName())) + ")";
        unify.saveFile(filePath);
        primaryStage.setTitle(fileName + "- Unify GUI");
        isChanged = false;
    }

    @FXML
    protected void fileExitClicked(ActionEvent event) {
        if (confirmSave()) {
            System.exit(0);
        }
    }

    @FXML
    protected void editUndoClicked(ActionEvent event) {
        if (!histories.isEmpty() && 0 < historyTop && historyTop <= histories.size()) {
            History history = histories.get(historyTop - 1);
            historyTop--;
            if (0 >= historyTop) editUndo.setDisable(true);
            editRedo.setDisable(false);
            if (history.key.equals("add")) {
                int num = 0;
                for (Integer index : history.indices) {
                    sentences.remove(index - num);
                    unify.remove(index - num);
                    num++;
                }
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
                isChanged = true;
            } else if (history.key.equals("search")) {
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
            } else if (history.key.equals("delete")) {
                for (int i = 0; i < history.indices.length; i++) {
                    unify.insert(history.indices[i], history.strings[i]);
                    sentences.add(history.indices[i], new Sentence(history.strings[i]));
                }
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
                isChanged = true;
            } else if (history.key.equals("cut")) {
                sentenceTable.getSelectionModel().clearSelection();
                for (int i = 0; i < history.strings.length; i++) {
                    unify.insert(history.indices[i], history.strings[i]);

                    sentences.add(history.indices[i], new Sentence(history.strings[i]));
                }

            } else if (history.key.equals("paste")) {
                int num = 0;
                for (Integer index : history.indices) {
                    sentences.remove(index - num);
                    unify.remove(index - num);
                    num++;
                }
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
                isChanged = true;
            }
        }
    }

    @FXML
    protected void editRedoClicked(ActionEvent event) {
        if (!histories.isEmpty() && 0 <= historyTop && historyTop < histories.size()) {
            History history = histories.get(historyTop);
            historyTop++;
            editUndo.setDisable(false);
            if (historyTop >= histories.size()) editRedo.setDisable(true);
            if (history.key.equals("add")) {
                for (int i = 0; i < history.indices.length; i++) {

                    sentences.add(history.indices[i], new Sentence(history.strings[i]));
                    unify.insert(history.indices[i], history.strings[i]);

                }
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
                isChanged = true;

            } else if (history.key.equals("search")) {
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
            } else if (history.key.equals("delete")) {
                int num = 0;
                for (int i = 0; i < history.indices.length; i++) {
                    sentences.remove(history.indices[i] - num);
                    unify.remove(history.indices[i] - num);
                    num++;
                }
                sentenceTable.getSelectionModel().clearSelection();
                for (int selectedIndex : history.selectedIndices) {
                    sentenceTable.getSelectionModel().select(selectedIndex, sentenceColumn);
                }
                isChanged = true;
            } else if (history.key.equals("cut")) {
                String buffer = "";
                int num = 0;
                for (int i = 0; i < history.indices.length; i++) {
                    buffer += sentences.get(history.indices[i] - num).getSentence() + "\n";
                    unify.remove(history.indices[i] - num);

                    sentences.remove(history.indices[i] - num);
                    num++;
                }
                content.putString(buffer);
                clipboard.setContent(content);
            } else if (history.key.equals("copy")) {
                String buffer = "";
                sentenceTable.getSelectionModel().clearSelection();
                for (String string : history.strings) {
                    buffer += string + "\n";
                }
                content.putString(buffer);
                clipboard.setContent(content);
            } else if (history.key.equals("paste")) {
                sentenceTable.getSelectionModel().clearSelection();
                for (int i = 0; i < history.strings.length; i++) {
                    unify.insert(history.indices[i], history.strings[i]);

                    sentences.add(history.indices[i], new Sentence(history.strings[i]));
                }

            }
        }
    }

    @FXML
    protected void editCutClicked(ActionEvent event) {
        Integer[] selectedRows = sentenceTable.getSelectionModel().getSelectedIndices().toArray(new Integer[0]);
        Integer[] indices = new Integer[selectedRows.length];
        String[] strings = new String[selectedRows.length];
        String buffer = "";

        for (int i = 0, num = 0; i < selectedRows.length; i++, num++) {
            indices[i] = selectedRows[i];
            strings[i] = sentences.get(selectedRows[i] - i).getSentence();
            buffer += sentences.get(selectedRows[i] - i).getSentence() + "\n";
            unify.remove(selectedRows[i] - i);

            sentences.remove(selectedRows[i] - i);
            num++;
        }

        isChanged = true;
        if (fileName.isEmpty()) primaryStage.setTitle("*Unify GUI");
        else primaryStage.setTitle("*" + fileName + " - Unify GUI");
        content.putString(buffer);
        clipboard.setContent(content);
        setHistory(new History("cut", indices, strings, selectedRows));
    }

    @FXML
    protected void editCopyClicked(ActionEvent event) {
        Integer[] selectedRows = sentenceTable.getSelectionModel().getSelectedIndices().toArray(new Integer[0]);
        Integer[] indices = new Integer[selectedRows.length];
        String[] strings = new String[selectedRows.length];
        String buffer = "";

        for (int i = 0; i < selectedRows.length; i++) {
            indices[i] = selectedRows[i];
            strings[i] = sentences.get(selectedRows[i]).getSentence();
            buffer += sentences.get(i).getSentence() + "\n";
        }

        content.putString(buffer);
        clipboard.setContent(content);
        setHistory(new History("copy", indices, strings, selectedRows));
    }

    @FXML
    protected void editPasteClicked(ActionEvent event) {
        ArrayList<String> selectedStrings = new ArrayList<String>();

        if (clipboard.hasString()) {
            String string = clipboard.getString();
            String strings[] = string.split("[\\t\\n\\x0B\\f\\r]*\\n[\\t\\n\\x0B\\f\\r]*");
            Integer indices[] = new Integer[strings.length];
            Integer[] selectedRows = sentenceTable.getSelectionModel().getSelectedIndices().toArray(new Integer[0]);

            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].replaceAll("\\s+", " ");
            }

            for (int selectRow : selectedRows) {
                for (int i = 0; i < strings.length; i++) {
                    indices[i] = selectRow + i + 1;
                    unify.insert(selectRow + i + 1, strings[i]);

                    sentences.add(selectRow + i + 1, new Sentence(strings[i]));
                }
            }
            isChanged = true;
            if (fileName.isEmpty()) primaryStage.setTitle("*Unify GUI");
            else primaryStage.setTitle("*" + fileName + " - Unify GUI");
            setHistory(new History("paste", indices, strings, selectedRows));
        }
    }

    @FXML
    protected void addButtonClicked(ActionEvent event) {
        String input = inputText.getText();
        if (!input.isEmpty()) {
            Pair<Integer[], String[]> pairs = add(split(input));
            setHistory(new History("add", pairs.first, pairs.second, sentenceTable.getSelectionModel().getSelectedIndices().toArray(new Integer[0])));
            inputText.setText("");
            if (fileName.isEmpty()) primaryStage.setTitle("*Unify GUI");
            else primaryStage.setTitle("*" + fileName + " - Unify GUI");
            isChanged = true;

        }
    }

    @FXML
    protected void searchButtonClicked(ActionEvent event) {
        String input = inputText.getText();
        if (!input.isEmpty()) {
            Pair<Integer[], String[]> pairs = search(unify.search(split(input)));
            setHistory(new History("search", pairs.first, pairs.second, sentenceTable.getSelectionModel().getSelectedIndices().toArray(new Integer[0])));
            inputText.setText("");
        }
    }

    @FXML
    protected void deleteButtonClicked(ActionEvent event) {
        String input = inputText.getText();
        if (!input.isEmpty()) {
            Pair<Integer[], String[]> pairs = delete(unify.search(split(input)));
            setHistory(new History("delete", pairs.first, pairs.second, sentenceTable.getSelectionModel().getSelectedIndices().toArray(new Integer[0])));
            inputText.setText("");
            if (fileName.isEmpty()) primaryStage.setTitle("*Unify GUI");
            else primaryStage.setTitle("*" + fileName + " - Unify GUI");
            isChanged = true;
        }
    }

    /**
     * primaryStageを得るためのsetter
     *
     * @param stage primaryStage
     */
    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     * テーブルを初期化する。
     */
    private void setTable() {
        String[] data = unify.getData();
        sentences.clear();
        for (String d : data) {
            sentences.add(new Sentence(d));
        }

    }

    /**
     * 履歴バッファに履歴を追加する
     *
     * @param history 追加する履歴
     */
    private void setHistory(History history) {
        while (historyTop < histories.size()) {
            histories.remove(historyTop);
            editRedo.setDisable(true);
        }
        histories.add(history);
        historyTop++;
        editUndo.setDisable(false);
    }

    /**
     * ファイル保存するかを確認するダイアログを表示
     *
     * @return 操作をキャンセルするなら偽。そうでないなら真。
     */
    private boolean confirmSave() {
        if (!isChanged) return true;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (fileName.isEmpty()) alert.setHeaderText("変更は保存されていません。変更を保存しますか?");
        else alert.setHeaderText(fileName + "は保存されていません。\n" + fileName + "への変更を保存しますか?");
        ButtonType saveButton = new ButtonType("保存");
        ButtonType cancelButton = new ButtonType("キャンセル");
        ButtonType notSaveButton = new ButtonType("保存しない");

        alert.getButtonTypes().setAll(saveButton, cancelButton, notSaveButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == saveButton) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(null);
            String path = "" + file.getAbsolutePath().subSequence(0, file.getPath().lastIndexOf(file.getName()));
            fileName = file.getName() + " (" + path + ")";
            unify.saveFile(file.getAbsolutePath());
            primaryStage.setTitle(fileName + "- Unify GUI");
            isChanged = false;
            return true;
        } else {
            return result.get() != cancelButton;
        }
    }

    /**
     * 文字列をデータベースに追加する。
     *
     * @param strings 追加する文字列
     * @return 追加した文字列とそのインデックスのペア
     */
    private Pair<Integer[], String[]> add(String... strings) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        ArrayList<String> newStrings = new ArrayList<String>();
        for (String string : strings) {
            indices.add(sentences.size());
            newStrings.add(string);
            sentences.add(new Sentence(string));
            unify.add(string);
        }
        return new Pair<Integer[], String[]>(indices.toArray(new Integer[0]), newStrings.toArray(new String[0]));
    }

    /**
     * 文字列と一致するデータをデータベースから削除する。
     *
     * @param strings 削除する文字列
     * @return 削除された文字列とそのインデックスのペア
     */
    private Pair<Integer[], String[]> delete(String... strings) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        ArrayList<String> newStrings = new ArrayList<String>();
        int num = 0;
        for (String string : strings) {
            for (int i = 0; i < sentences.size(); i++) {
                if (string.equals(sentences.get(i).getSentence())) {
                    indices.add(i + num);
                    newStrings.add(string);
                    sentences.remove(i);
                    unify.remove(i);
                    num++;
                    i--;
                }
            }
        }
        return new Pair<Integer[], String[]>(indices.toArray(new Integer[0]), newStrings.toArray(new String[0]));
    }

    /**
     * 文字列と一致するデータをデータベースから検索し、選択する。
     *
     * @param strings 検索する文字列。
     * @return 検索された文字列とそのインデックスのペア
     */
    private Pair<Integer[], String[]> search(String... strings) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        ArrayList<String> newStrings = new ArrayList<String>();

        sentenceTable.getSelectionModel().clearSelection();
        int num = 0;
        for (String string : strings) {
            for (int i = 0; i < sentences.size(); i++) {
                if (string.equals(sentences.get(i).getSentence())) {
                    if (num == 0) sentenceTable.scrollTo(i);
                    indices.add(i);
                    newStrings.add(string);
                    sentenceTable.getSelectionModel().select(i, sentenceColumn);
                    num++;
                }
            }
        }
        return new Pair<Integer[], String[]>(indices.toArray(new Integer[0]), newStrings.toArray(new String[0]));
    }

    /**
     * 文字列を","で分割し、連続のスペースを一つに変換する。また、文字列先頭と文末のスペースを削除する
     *
     * @param string 分割する文字列
     * @return 分割された文字列集合
     */
    private String[] split(String string) {
        String strings[] = string.split("\\s*,\\s*");
        ArrayList<String> newStrings = new ArrayList<String>();
        for (String str : strings) {
            if (str.matches("\\s*")) continue;
            newStrings.add(str.replaceAll("\\s+", " "));
        }
        return newStrings.toArray(new String[0]);
    }
}

/**
 * 履歴を保存しておくためのクラス
 */
class History {
    public final String key;
    public final Integer[] indices;
    public final String[] strings;
    public final Integer[] selectedIndices;
    public final int length;


    History(String key, Integer[] indices, String[] strings, Integer[] selected) {
        this.key = key;
        this.indices = indices;
        this.strings = strings;
        this.selectedIndices = selected;
        if (indices.length == strings.length)
            length = indices.length;
        else
            length = -1;
    }

}

/**
 * c++のpairの簡易実装
 *
 * @param <F> pair.firstの型
 * @param <S> pair.secondの型
 */
class Pair<F, S> {
    public final F first;
    public final S second;

    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}


