
package com.example.client;

import com.example.client.service.Constant;
import com.example.client.wsdl.GetUserInfo;
import com.example.client.wsdl.GetUserInfoResponse;
import com.example.client.wsdl.GetUserType;
import com.example.client.wsdl.GetUserTypeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TongluRemoteClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(TongluRemoteClient.class);

	public GetUserInfoResponse getUserInfo() {

		GetUserInfo request = new GetUserInfo();
		request.setUserToken("47CDB7D2-8212-4F23-9C1D-96984767913B");
		request.setUserID("7377");

		GetUserInfoResponse response = (GetUserInfoResponse) getWebServiceTemplate()
				.marshalSendAndReceive(Constant.REMOTE_URI, request,
						new SoapActionCallback(
								Constant.NAMESPACE_URI+"GetUserInfo"));

		return response;
	}

	public GetUserTypeResponse getUserType() {

		GetUserType request = new GetUserType();
		request.setUserToken("47CDB7D2-8212-4F23-9C1D-96984767913B");
		request.setPage(2);
		request.setPageSize(10);
		request.setUserName("建设");

		GetUserTypeResponse response = (GetUserTypeResponse) getWebServiceTemplate()
				.marshalSendAndReceive(Constant.REMOTE_URI, request,
						new SoapActionCallback(
								Constant.NAMESPACE_URI+"GetUserType"));

		return response;
	}

}
