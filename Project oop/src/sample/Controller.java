package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public class Controller {
    public TextField usrname;
    public TextField address;
    public TextField name;
    public Button signup;
    public Button show;
    public TextField password;
    public TextField kutu;
    public TextField singuptxtf;
    public TextField showtxtf;

    public void handleButtonAction(ActionEvent actionEvent) {


        if (actionEvent.getSource() == signup) {
            Savetofile();
        }
        else if (actionEvent.getSource() == show) {
            ReadFile();
        }
    }

    private String ReadFile() {
        try {

            String text = showtxtf.getText();
            String all = Files.readString(Path.of(text));
            kutu.setText(all);
            System.out.println(all);

            return "File read";
        }
        catch (Exception e){
            kutu.setText("There is no files and please place .txt");
            return "No Read";
        }

    }

    private String getalltext() {
        String text = name.getText() + " " +usrname.getText() + " " + password.getText() + " " + address.getText()+"\n";
        System.out.println(text);
        return text;
    }

    private String Savetofile() {
        try {
            String name = singuptxtf.getText();
            FileWriter writer = new FileWriter(name, true);
            writer.write(kutu.getText());
            writer.close();
            System.out.println("Success");
            return "Success";
        } catch (Exception e) {
            System.out.println("wp");
            kutu.setText("Dosnt work");
            return "Failed";
        }


    }
}

