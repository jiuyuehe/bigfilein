package com.qycloud.oatos.bigfilein.biz;

import com.qycloud.oatos.bigfilein.model.loacl.ImportFile;
import com.qycloud.oatos.bigfilein.utils.FileUtil;
import com.qycloud.oatos.bigfilein.utils.Logs;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * Created by jiuyuehe on 2014/12/12.
 */
public class ImportFileAccess extends SimpleFileVisitor<Path> {

    private BlockingQueue queue;

    private int fileCount = 0;

    public ImportFileAccess(BlockingQueue queue) {
        this.queue = queue;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        ImportFile importFile = new ImportFile();
        // importFile.setFileSize();
        importFile.setFilePath(dir.toAbsolutePath().toString());
        importFile.setFileType(0);
        importFile.setImported(0);
        importFile.setName(dir.getFileName().toString());
        try {
            Logs.getLogger().info("放入队列" + dir.getFileName());
            queue.offer(importFile, 100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Logs.getLogger().error("放入队列超时" + e.getMessage());
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        ImportFile importFile = new ImportFile();
        importFile.setFilePath(file.toAbsolutePath().toString());
        importFile.setFileType(1);
        importFile.setImported(0);
        importFile.setName(file.getFileName().toString());
        importFile.setMd5(FileUtil.getFileMD5(file.toFile()));
        importFile.setFileSize(file.toFile().length());

        try {
            Logs.getLogger().info("放入队列" + file.getFileName());
            queue.offer(importFile, 100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Logs.getLogger().error("放入队列超时" + e.getMessage());
            e.printStackTrace();
        }

        fileCount++;
        System.out.println(fileCount);

        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        Logs.getLogger().error("access file failed , the file path is :" + file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        BlockingQueue<ImportFile> queue = new LinkedBlockingQueue<ImportFile>(30);

        try {
            Files.walkFileTree(Paths.get("E:\\java8\\javafx-src"), new ImportFileAccess(queue));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("费时：" + (end - start));
    }


}
