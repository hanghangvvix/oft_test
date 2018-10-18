package ct.oft.servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ct.oft.model.WebResultModel;
import ct.oft.service.BaseService;
import ct.oft.util.ParamNameConfig;
import ct.oft.util.ZipHelper;

public class InvestOrderDataServlet extends HttpServlet {

	private BaseService service = new BaseService();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setStatus(response.SC_OK);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		BufferedInputStream contentInputStream = new BufferedInputStream(request.getInputStream());
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int c = 0;
		byte[] bs = new byte[512];
		while ((c = contentInputStream.read(bs)) != -1) {
			byteArrayOutputStream.write(bs, 0, c);
		}
		//
		String clientSource = getHeader(request, ParamNameConfig.CLIENT_SOURCE);
		//
		String channelId = getParameter(request, ParamNameConfig.CHANNEL_ID);
		//
		String deviceId = getParameter(request, ParamNameConfig.DEVICE_ID);
		
		String result = null;
		if (byteArrayOutputStream.toByteArray().length == 0) {// 没用请求消息体，构造一个空的JSON字符串
			result = new WebResultModel().toJsonString();
		} else {
			result = service.baseService(new String(ZipHelper.GzipDecompress1(byteArrayOutputStream.toByteArray()), "utf-8"));
		}
		
		byte[] byarr = ZipHelper.GzipCompress(result);
		response.getOutputStream().write(byarr);
		// response.getOutputStream().write(resultModel.toJsonString().getBytes("utf-8"));
		response.getOutputStream().flush();
	}
	
	protected String getHeader(HttpServletRequest request, String key) {
		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String k = enumeration.nextElement();
			if (k.toLowerCase().equalsIgnoreCase(key)) {
				return request.getHeader(k);
			}
		}
		return null;
	}

	protected String getParameter(HttpServletRequest request, String key) {
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String k = enumeration.nextElement();
			if (k.toLowerCase().equalsIgnoreCase(key)) {
				return request.getParameter(k);
			}
		}
		return null;
	}

}
