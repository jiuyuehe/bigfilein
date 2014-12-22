package com.qycloud.oatos.bigfilein.service;

import com.qycloud.oatos.bigfilein.model.Constant;
import com.qycloud.oatos.bigfilein.model.oatos.*;
import com.qycloud.oatos.bigfilein.utils.*;

import java.util.UUID;

/**
 * Created by jiuyuehe on 2014/10/31.
 */
public class LoginService {

    /**
     * @param cfp
     * @return
     * @throws Exception
     */
    public static FilesDTO createFolder(CreateFolderParam cfp) throws Exception {

        String json = Json.toJson(cfp);

        String r = XhrProxy.post(Constant.getUrl(Constant.CREATE_FOLDER), Constant.UT, json);

        FilesDTO files = Json.parse(r, FilesDTO.class);

        return files;
    }

    /**
     * 自行登入；
     *
     * @return
     */
    public static boolean login() {
        return login(Constant.userName, Constant.pwd);
    }


    //TODO login
    public static boolean login(String username, String password) {

        String loginUrl = Constant.getUrl(Constant.LOGIN);
        Logs.getLogger().info("start ... loginUrl : " + loginUrl);
        try {
            LogonParam param = new LogonParam();
            param.setMode(LogonMode.Quick);
            param.setUserName(username);
            EncryptModel e = EncryptUtil.encrypt(username, password, param);
            param.setPassword(e.getPassword());
            param.setClientId(UUID.randomUUID().toString());
            String json = Json.toJson(param);
            String r = XhrProxy.post(loginUrl, null, json);
            if (isResponseError(r)) {
                Logs.getLogger().error("login ...  error : " + r);
                return false;
            }
            LoginResultDTO loginResultDTO = Json.parse(r, LoginResultDTO.class);
            Constant.UT = loginResultDTO.getToken();
            Logs.getLogger().info("login ... success : " + Constant.UT);
            return true;
        } catch (Exception ex) {
            Logs.getLogger().error("login error : ", ex);
        }
        return false;
    }

    public static boolean isResponseError(String result) {
        return result != null && result.startsWith(Constant.ERROR_MARK);
    }

    // TODO getUserInfo
    public static UserDTO getUserInfo() {
        String getInfoUrl = Constant.getUrl(Constant.GET_USER_INFO);
        try {
            String r = XhrProxy.post(getInfoUrl, Constant.UT, "");
            Logs.getLogger().info("userInfo ... load success ... : " + r);
            UserDTO user = Json.parse(r, UserDTO.class);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            Logs.getLogger().error("getUserInfo ... load fail ... " + e.getMessage());
        }
        return null;
    }

    // TODO getFiles

    public static FilesDTO getFiles() {
        String getFilesUrl = Constant.getUrl(Constant.GET_FILES);
        GetFileListDTO fileListDTO = new GetFileListDTO();
        fileListDTO.setFileType(Constant.ENT_FILE);
        fileListDTO.setFolderId(null);
        fileListDTO.setMaxResults(200);
        fileListDTO.setSkipResults(0);
        String str = null;
        try {
            str = Json.toJson(fileListDTO);
            Logs.getLogger().info("getFiles ... load .. " + str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String r = XhrProxy.post(getFilesUrl, Constant.UT, str);
            Logs.getLogger().info("getFiles ... load success ... : " + r);
            FilesDTO files = Json.parse(r, FilesDTO.class);
            return files;
        } catch (Exception e) {
            e.printStackTrace();
            Logs.getLogger().error("getFiles ... load fail ... " + e.getMessage());
        }
        return null;
    }
}
