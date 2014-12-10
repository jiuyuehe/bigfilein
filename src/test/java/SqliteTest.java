import com.qycloud.oatos.bigfilein.model.ImportFile;
import com.qycloud.oatos.bigfilein.service.IDAO;
import com.qycloud.oatos.bigfilein.service.ImportDAO;
import com.qycloud.oatos.bigfilein.utils.SQLiteDB;
import org.junit.Test;

/**
 * Created by jiuyuehe on 2014/10/27.
 */
public class SqliteTest {


    @Test
    public void insertfile(){

        ImportFile imfile = new ImportFile();
        imfile.setFilePath("1212");
        imfile.setFileSize(4545);
        imfile.setFileType(1);
        imfile.setImported(1);
        imfile.setLastModify("11111");
        imfile.setName("fff.txt");
        imfile.setPid(0);
        try {

            IDAO dao = new ImportDAO();
           int pk =  dao.insertFile(imfile);
            System.out.println(pk);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
