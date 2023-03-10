package com.f42o.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.f42o.app.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.MercadoPagoConfig;

@Service
public class NotificationServiceImpl implements INotificationService {
	private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Value("${ACCESS_TOKEN}")
	private String AccessToken;


	@Override
	public void getNotification(NotificationDTO dto) throws JsonProcessingException {
		
		if(dto.getType() != null &&  dto.getType().equals("payment")) {
		try {
			MercadoPagoConfig.setAccessToken(AccessToken);

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			log.info("Notificacion:");
			log.info(json);
		} catch (Exception e) {

			e.printStackTrace();
		}
		}
		// handle notification here, persist, etc

	}

}
