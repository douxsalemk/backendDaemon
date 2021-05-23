package com.salemdoux.ecole.services;

import org.springframework.mail.SimpleMailMessage;

import com.salemdoux.ecole.domain.Eleve;

public interface EmailService {

	void sendOrderConfirmationEmail(Eleve obj);

	void sendEmail(SimpleMailMessage msg);

}
