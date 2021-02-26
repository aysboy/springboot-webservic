
package com.example.client;

import com.example.client.service.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.client.wsdl");
		return marshaller;
	}

	@Bean
	public TongluRemoteClient countryClient(Jaxb2Marshaller marshaller) {
		TongluRemoteClient client = new TongluRemoteClient();
		client.setDefaultUri(Constant.REMOTE_URI);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
