package ct.oft.model;

public class WebResultModel extends BaseModel{
	
	/**
	 * 仅结果MODEL有效 结果码 
	 */
	private int code=0;
	/**
	 * 仅结果MODEL有效 信息
	 */
	private String message="正常执行";
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {		
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
