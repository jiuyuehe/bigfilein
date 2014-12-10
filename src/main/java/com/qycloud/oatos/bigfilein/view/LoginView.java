package com.qycloud.oatos.bigfilein.view;

import com.qycloud.oatos.bigfilein.service.LoginService;
import com.qycloud.oatos.bigfilein.utils.Constant;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by jiuyuehe on 2014/12/10.
 */
public class LoginView extends Application {

    private static final double WIDTH = 200;

    private static Text txt =  new Text();

    private TextField userNameField = null;
    private PasswordField pwdField = null;
    private TextField urlField  = null;


    public Parent createContent(Stage primaryStage ) {

        VBox vBox = new VBox(7);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(20,10,10,10));

        Label userNameLabel = new Label("帐号：");
        userNameLabel.setPrefWidth(WIDTH);
         userNameField  = new TextField("手机/邮箱/帐号");
        Label pwdLabel = new Label("密码：");
        pwdLabel.setPrefWidth(WIDTH);
         pwdField  = new PasswordField();

        Label urlLabel = new Label("云端地址：");
        urlLabel.setPrefWidth(WIDTH);
        urlField  = new TextField("192.168.1.32");

        Button bu = new Button("登入");

        bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("登录中。。。"+ userNameField.getText()+"|"+pwdField.getText());
                txt.setText("登入中...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Constant.IP = urlField.getText();
                Constant.userName = userNameField.getText();
                Constant.pwd = pwdField.getText();
                if(LoginService.login()){
                    txt.setText("...");
                    txt.setText("成功登入...");
                }else{
                    txt.setText("帐号，密码，ip域名中有误！");
                }

            }
        });
        vBox.getChildren().addAll(userNameLabel,userNameField,pwdLabel,pwdField,urlLabel,urlField,bu,txt);
        return  vBox;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("文件导入");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(createContent(primaryStage)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
