package com.salemdoux.ecole.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.salemdoux.ecole.domain.Eleve;

public abstract class AbstractEmailService implements EmailService{

	@Value("$(default.sender)")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Eleve obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromELeve(obj);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromELeve(Eleve obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getContact().getEmail());
		sm.setFrom(sender);
		sm.setSubject("CONFIRMATION DE CADATRE! MATRICULE : " + obj.getMatricule().getNumero());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	};
}
