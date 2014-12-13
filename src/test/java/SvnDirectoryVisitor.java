import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by jiuyuehe on 2014/12/12.
 */
public class SvnDirectoryVisitor extends SimpleFileVisitor<Path>{

    private static int fileCount = 0;
    private static int fileFiledCount = 0;
    private static int folderCount = 0;


    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        folderCount++;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
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
            Files.walkFileTree(Paths.get("D:\\svn"),new SvnDirectoryVisitor());
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
