package com.qycloud.oatos.bigfilein.view;

import com.qycloud.oatos.bigfilein.model.Constant;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;


/**
 * Created by jiuyuehe on 2014/12/11.
 */
public class AppView extends Application {

    //本地文件夹
    private File localDirectory;

    private Label scan = new Label();


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setResizable(false);
        primaryStage.setTitle("oatos文件批量导入工具");
        primaryStage.setScene(new Scene(createContent(primaryStage), 720, 500));
        primaryStage.show();

    }

    private Parent createContent(final Stage primaryStage) {
        VBox vBox = new VBox(4);

        HBox title = titleBox4DictChoose(primaryStage);

        HBox fileAnalysis = fileAnalysisBox();


        vBox.getChildren().addAll(title, fileAnalysis);

        return vBox;
    }

    /**
     * 文件分析界面
     *
     * @return
     */
    private HBox fileAnalysisBox() {
        HBox fileAnalysis = new HBox();
        fileAnalysis.setPrefSize(720, 100);
        fileAnalysis.setBorder(new Border(new BorderStroke(Paint.valueOf("#844200"), BorderStrokeStyle.DASHED, new CornerRadii(22), BorderStroke.THIN)));

        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 50, 20);
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setPrefWidth(580);
        flowPane.setBorder(new Border(new BorderStroke(Paint.valueOf("#654200"), BorderStrokeStyle.DASHED, new CornerRadii(22), BorderStroke.THIN)));

        Label folder = new Label();
        final SimpleStringProperty folderSS = new SimpleStringProperty("文件夹量:");
        folder.textProperty().bind(folderSS);

        Label file = new Label();
        final SimpleStringProperty fileSsp = new SimpleStringProperty("文件量:");
        file.textProperty().bind(fileSsp);

        Label bigfile = new Label();
        final SimpleStringProperty bigfileSS = new SimpleStringProperty("大文件量(大于1G):");
        bigfile.textProperty().bind(bigfileSS);

        Label failed = new Label();
        final SimpleStringProperty failedSS = new SimpleStringProperty("失败量:");
        failed.textProperty().bind(failedSS);

        scan = new Label();
        final SimpleStringProperty scanSS = new SimpleStringProperty("正在扫描:");
        scan.textProperty().bind(scanSS);

        //final FileAnalysisModel fas = new FileAnalysisModel();

        scan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            //  ImportDirectoryVisitor idv = new ImportDirectoryVisitor(scanSS);
            @Override
            public void handle(MouseEvent event) {

                scanSS.setValue("oooooooooooooo");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        flowPane.getChildren().addAll(folder, file, bigfile, failed, scan);

        ProgressIndicator p1 = new ProgressIndicator();
        p1.setPrefSize(50, 50);
        p1.setOpacity(1);


        fileAnalysis.getChildren().addAll(flowPane, p1);


        return fileAnalysis;
    }

    /**
     * 选择本地文件与云端文件
     *
     * @param primaryStage
     * @return
     */
    private HBox titleBox4DictChoose(final Stage primaryStage) {
        HBox title = new HBox(4);
        title.setSpacing(20);
        title.setAlignment(Pos.CENTER);
        title.setPrefSize(720, 50);
        title.setBorder(new Border(new BorderStroke(Paint.valueOf("#844200"), BorderStrokeStyle.DASHED, new CornerRadii(2), BorderStroke.THIN)));

        Label name = new Label("当前用户:" + Constant.userName);

        final Button localDirectoryBtn = new Button("选择本地目录");

        localDirectoryBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(event.getEventType() + " ... " + event.getTarget());
                localDirectoryChoose(primaryStage);
                if (localDirectory != null) {
                    localDirectoryBtn.setText(localDirectory.getName());
                }
            }
        });

        Button cloudDirectoryBtn = new Button("选择云端目录");

        Button lock = new Button("锁定");

        title.getChildren().addAll(name, localDirectoryBtn, cloudDirectoryBtn, lock);
        return title;
    }

    /**
     * 选择本地文件夹
     *
     * @param primaryStage
     * @return
     */
    private File localDirectoryChoose(Stage primaryStage) {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("选择一个文件夹");
        localDirectory = dc.showDialog(primaryStage);
        System.out.println(localDirectory.getAbsolutePath());
        return localDirectory;
    }


    public static void main(String[] args) {
        launch(args);
    }


}
