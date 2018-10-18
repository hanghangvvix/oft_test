package ct.oft.service;

import ct.oft.model.WebResultModel;
import ct.oft.util.IPARAM;
import ct.oft.util.TxtUtils;

public class HandleService implements IHandleService {

	private static IHandleService instance;
	
	public static IHandleService getService() {
		if (instance == null) {
			instance = new HandleService();
		}
		return instance;
	}
	
	@Override
	public WebResultModel makeTxtFile(String batchId,String BatchData) {
		// TODO Auto-generated method stub
		WebResultModel resultModel = null;
		resultModel = new WebResultModel();
		
		resultModel.setCode(TxtUtils.writeTxtFile(IPARAM.INVEST_ORDER_FILE_PATH, batchId, BatchData));
		
		return resultModel;
	}

}
