package ct.oft.model.front;

import ct.oft.model.WebModel;

public class InvestOrderFrontMode extends WebModel {
	
	private String batchId;
	private String batchData;
	
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBatchData() {
		return batchData;
	}
	public void setBatchData(String batchData) {
		this.batchData = batchData;
	}
	
	
	
}
