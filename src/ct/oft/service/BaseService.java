package ct.oft.service;

import ct.oft.model.WebModel;
import ct.oft.model.WebResultModel;
import ct.oft.model.front.InvestOrderFrontMode;
import net.sf.json.JSONObject;

public class BaseService {

	private IHandleService IHService = HandleService.getService();

	public String baseService(String reqString) {
		WebResultModel resultModel = null;
//		InvestOrderFrontMode webModel = (InvestOrderFrontMode) WebModel.toModel(reqString,
//				InvestOrderFrontMode.class);
//		System.out.println(webModel.toJsonString());
//		resultModel = IHService.makeTxtFile(webModel.getBatchId(),webModel.getBatchData());
		JSONObject json = JSONObject.fromObject(reqString);
		System.out.println(json.get("batchId").toString());
		System.out.println(json.get("batchData").toString());
		
		resultModel = IHService.makeTxtFile(json.get("batchId").toString(),json.get("batchData").toString());
		
		return resultModel.toJsonString();
	}
}
