package com.qycloud.oatos.bigfilein.model;


import java.util.Date;
import java.util.List;

/**
 * 文件信息DTO
 * @author yang
 * @version 2.7
 */
@SuppressWarnings("serial")
public class FileNewDTO extends BaseDTO {

	/**
	 * 文件类型<br>
	 *
	 */
	private String fileType;

	/**
	 * 文件id
	 */
	private long fileId;

	/**
	 * 企业id
	 */
	private long entId;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 父文件夹id
	 */
	private Long parentId;

	/**
	 * 名称
	 */
	private String fileName;

	/**
	 * 实际文件存储名称
	 */
	private String fileGuid;

	/**
	 * 文件大小<br>
	 * 单位：byte
	 */
	private long fileSize;

	/**
	 * 缩略图
	 */
	private String thumb;

	/**
	 * 文件备注
	 */
	private String remark;

	/**
	 * 文件逻辑路径
	 */
	private String path;

	/**
	 * 文件MD5
	 */
	private String md5;

	/**
	 * 版本号
	 */
	private Long version;

	/**
	 * 是否是文件夹
	 */
	private boolean folder;

	/**
	 * 是否是系统文件夹
	 */
	private boolean sysFolder;

	/**
	 * 创建者姓名
	 */
	private String createrName;

	/**
	 * 文件上传时间
	 */
	private Date createTime;

	/**
	 * 最后修改者用户名
	 */
	private String upadteUserName;
	
	/**
	 * 文件最后修改时间
	 */
	private Date updateTime;

	/**
	 * 是否已收藏
	 */
	private Boolean favorite;

	/**
	 * 是否关注
	 */
	private Boolean remind;

	/**
	 * 文件转换状态<br>
	 *
	 */
	private String convStatus;



	public FileNewDTO() {
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getEntId() {
		return entId;
	}

	public void setEntId(long entId) {
		this.entId = entId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileGuid() {
		return fileGuid;
	}

	public void setFileGuid(String fileGuid) {
		this.fileGuid = fileGuid;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

	public boolean isSysFolder() {
		return sysFolder;
	}

	public void setSysFolder(boolean sysFolder) {
		this.sysFolder = sysFolder;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpadteUserName() {
		return upadteUserName;
	}

	public void setUpadteUserName(String upadteUserName) {
		this.upadteUserName = upadteUserName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}





	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public Boolean getRemind() {
		return remind;
	}

	public void setRemind(Boolean remind) {
		this.remind = remind;
	}



	public String getConvStatus() {
		return convStatus;
	}

	public void setConvStatus(String convStatus) {
		this.convStatus = convStatus;
	}





}
