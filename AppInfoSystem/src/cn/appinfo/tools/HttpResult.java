package cn.appinfo.tools;

import java.io.Serializable;

import cn.appinfo.pojo.AppInfo;

public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = 3637122497350396679L;

    private Integer code;
    private T data;
    private String msg;
    private Integer count;
    private boolean success=false;
    private String path;
    private String imgName;
    private AppInfo appInfo;

    public AppInfo getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(AppInfo appInfo) {
		this.appInfo = appInfo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public HttpResult() {
    	
    }
    public HttpResult(Integer code) {
    	
        this.code = code;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public HttpResult(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public HttpResult(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
