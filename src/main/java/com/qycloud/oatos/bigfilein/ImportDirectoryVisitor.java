package com.qycloud.oatos.bigfilein;

import com.qycloud.oatos.bigfilein.model.loacldb.ImportFile;
import com.qycloud.oatos.bigfilein.model.view.FileAnalysisModel;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiuyuehe on 2014/12/12.
 */
public class ImportDirectoryVisitor extends SimpleFileVisitor<Path>{

    private static int fileCount = 0;
    private static int fileFiledCount = 0;
    private static int folderCount = 0;

    private FileAnalysisModel fam = null;


    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("访问文件夹===："+dir.getFileName());
        folderCount++;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("访问文件夹》》》：" + file.toAbsolutePath());
        fileCount++;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        fileFiledCount++;
        System.out.println("**failed****fileName **" + file.toUri());
        return FileVisitResult.CONTINUE;
    }



    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        try {
            Files.walkFileTree(Paths.get("E:\\java8\\javafx-src"),new ImportDirectoryVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("文件总数："+fileCount);
        System.out.println("文件失败总数："+fileFiledCount);
        System.out.println("文件夹总数："+folderCount);

        System.out.println("费时："  +(end - start));
    }
}
