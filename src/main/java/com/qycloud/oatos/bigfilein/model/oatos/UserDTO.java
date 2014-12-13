package com.qycloud.oatos.bigfilein.model.oatos;

import com.qycloud.oatos.bigfilein.model.oatos.BaseDTO;

import java.util.Date;

/**
 * 用户DTO
 * 
 * @author yang
 */
public class UserDTO extends BaseDTO {

	/**
	 * 用户id
	 */
	private long userId;

	/**
	 * 企业id
	 */
	private long entId;

	/**
	 * 部门id
	 */
	private Long deptId;

	/**
	 * 用户登录帐号
	 */
	private String userName;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 用户类型<br>
	 */
	private int userType;

	/**
	 * 工号
	 */
	private String empNum;

	/**
	 * 职位
	 */
	private String jobTitle;

	/**
	 * 邮箱地址
	 */
	private String mail;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 专业
	 */
	private String major;

	/**
	 * 爱好
	 */
	private String hobby;

	/**
	 * 头像
	 */
	private String icon;

	/**
	 * 签名
	 */
	private String signature;

	/**
	 * 是否开启个人网盘
	 */
	private boolean diskEnabled;

	/**
	 * 个人网盘空间<br>
	 * 单位：byte
	 */
	private long diskSize;

	/**
	 * 个人文件外链是否开启
	 */
	private boolean personalLinkEnabled;

	/**
	 * 状态<br>
	 */
	private String userStatus;

	/**
	 * 是否锁定
	 */
	private boolean locked;

	/**
	 * 用户添加时间
	 */
	private Date joinTime;

	/**
	 * 创建者id
	 */
	private Long createUserId;

	/**
	 * 创建者姓名
	 */
	private String createUserName;

	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 设备的token(对IOS专用)
	 */
	private String deviceToken;

	/**
	 * 常联系人显示设置 0:为同事和联系人都显示，1：为显示同事，2：为显示常用联系人
	 */
	private int contactDisplay;

	/**
	 * 个人网盘已使用空间<br>
	 * 单位：byte
	 */
	private long diskUsed;

	/**
	 * 用户在线状态<br>
	 */
	private String onlineStatus = "offline";

	/**
	 * 用户登录设备<br>
	 */
	private String agent;

	/**
	 * 用户是否被加入常用联系人
	 */
	private boolean usualContact = false;

	/**
	 * 是否阻止
	 */
	private boolean blocked;

	/**
	 * 邮箱是否认证
	 */
	private boolean mailAuthed;

	/**
	 * 手机是否认证
	 */
	private boolean mobileAuthed;

	/**
	 * 用户来源<br>
	 */
	private String userFrom;

	public UserDTO() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEntId() {
		return entId;
	}

	public void setEntId(long entId) {
		this.entId = entId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public boolean isDiskEnabled() {
		return diskEnabled;
	}

	public void setDiskEnabled(boolean diskEnabled) {
		this.diskEnabled = diskEnabled;
	}

	public long getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(long diskSize) {
		this.diskSize = diskSize;
	}

	public boolean isPersonalLinkEnabled() {
		return personalLinkEnabled;
	}

	public void setPersonalLinkEnabled(boolean personalLinkEnabled) {
		this.personalLinkEnabled = personalLinkEnabled;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public int getContactDisplay() {
		return contactDisplay;
	}

	public void setContactDisplay(int contactDisplay) {
		this.contactDisplay = contactDisplay;
	}

	public long getDiskUsed() {
		return diskUsed;
	}

	public void setDiskUsed(long diskUsed) {
		this.diskUsed = diskUsed;
	}

	public String getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public boolean isUsualContact() {
		return usualContact;
	}

	public void setUsualContact(boolean usualContact) {
		this.usualContact = usualContact;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isMailAuthed() {
		return mailAuthed;
	}

	public void setMailAuthed(boolean mailAuthed) {
		this.mailAuthed = mailAuthed;
	}

	public boolean isMobileAuthed() {
		return mobileAuthed;
	}

	public void setMobileAuthed(boolean mobileAuthed) {
		this.mobileAuthed = mobileAuthed;
	}

	public String getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

}
