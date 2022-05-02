package FinalPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ComboBox<String> comboBox;
    public ObservableList<String> list = FXCollections.observableArrayList("default", "1", "3", "5");
    public Label lbl;
    public Label lbl2;
    public int num;
    public ImageView rockImage;
    public ImageView paperImage;
    public ImageView scissorsImage;
    public rps game = new rps();
    public Button resetBtn;
    public Button setBtn;
    public ImageView you_win;
    public ImageView tenor;
    public ImageView rodRock;
    public ImageView rodHand;
    public ImageView rodScissors;
    public ImageView title2;
    public ImageView title1;
    public ImageView title3;
    public ImageView title4;
    public Label usrScore;
    public Label compScore;
    public Label userScoreLabel;
    public Label rodneyScoreLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
        comboBox.setPromptText("Best of:");
        comboBox.setStyle("-fx-font: bold 36px \"Segoe UI Black\";");
    }
    public void setNum(int num) {
        this.num = num;
    }

    public void resetNum(){
        rodneyScoreLabel.setVisible(false);
        userScoreLabel.setVisible(false);
        usrScore.setText("");
        compScore.setText("");
        rockImage.setVisible(false);
        paperImage.setVisible(false);
        scissorsImage.setVisible(false);
        rodRock.setVisible(false);
        rodHand.setVisible(false);
        rodScissors.setVisible(false);
        game.resetWins();
        setBtn.setVisible(true);
        comboBox.setVisible(true);
        you_win.setVisible(false);
        tenor.setVisible(false);
        title1.setVisible(true);
        title2.setVisible(true);
        title3.setVisible(true);
        title4.setVisible(true);
        lbl.setText("");
    }

    public void comboChanged(){
        if(!comboBox.getValue().equals("default")) {
            int number = Integer.parseInt(comboBox.getValue());
            setNum(number);
        }
        else{
            setNum(99999);
        }
        rockImage.setVisible(true);
        paperImage.setVisible(true);
        scissorsImage.setVisible(true);
        resetBtn.setVisible(true);
    }

    public void newRock() {
        rps.Outcome result = rps.pickedRock();
        rodRock.setVisible(false);
        rodHand.setVisible(false);
        rodScissors.setVisible(false);
        if(result== rps.Outcome.WIN){
            rodScissors.setVisible(true);
            game.adder(true);
        }
        else if(result == rps.Outcome.DRAW){
            rodRock.setVisible(true);
        }
        else{
            rodHand.setVisible(true);
            game.adder(false);
        }
        end();
    }

    public void newPaper() {
        rps.Outcome result = rps.pickedPaper();
        rodRock.setVisible(false);
        rodHand.setVisible(false);
        rodScissors.setVisible(false);
        if(result== rps.Outcome.WIN){
            rodRock.setVisible(true);
            game.adder(true);
        }
        else if(result == rps.Outcome.DRAW){
            rodHand.setVisible(true);
        }
        else{
            rodScissors.setVisible(true);
            game.adder(false);
        }
        end();
    }

    public void newScissors() {
        rps.Outcome result = rps.pickedScissors();
        rodRock.setVisible(false);
        rodHand.setVisible(false);
        rodScissors.setVisible(false);
        if(result== rps.Outcome.WIN){
            rodHand.setVisible(true);
            game.adder(true);
        }
        else if(result == rps.Outcome.DRAW){
            rodScissors.setVisible(true);
        }
        else{
            rodRock.setVisible(true);
            game.adder(false);
        }
        end();
    }
    public void end(){
        if(num > 0 && game.getCompWins() > (num / 2)){
            rockImage.setVisible(false);
            paperImage.setVisible(false);
            scissorsImage.setVisible(false);
            tenor.setVisible(true);
            rodRock.setVisible(false);
            rodHand.setVisible(false);
            rodScissors.setVisible(false);
            lbl.setText("");
        }
        if(num > 0 && game.getUserWins() > (num / 2)){
            rockImage.setVisible(false);
            paperImage.setVisible(false);
            scissorsImage.setVisible(false);
            you_win.setVisible(true);
            rodRock.setVisible(false);
            rodHand.setVisible(false);
            rodScissors.setVisible(false);
            lbl.setText("");
        }
        usrScore.setText(""+game.getUserWins());
        compScore.setText(""+game.getCompWins());
    }

    public void setGame(ActionEvent actionEvent) {
        comboChanged();
        comboBox.setVisible(false);
        setBtn.setVisible(false);
        lbl.setText("Rodney picked:");
        title1.setVisible(false);
        title2.setVisible(false);
        title3.setVisible(false);
        title4.setVisible(false);
        userScoreLabel.setVisible(true);
        rodneyScoreLabel.setVisible(true);
    }
}
