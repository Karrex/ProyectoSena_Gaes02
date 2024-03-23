/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.email;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author CFL
 */


@Named(value = "correoBean")
@RequestScoped
public class CorreoBean {

    ConfiguracionCorreo configuracion;
    private String to;
    private String subject;
    private String descr;

    public ConfiguracionCorreo getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionCorreo configuracion) {
        this.configuracion = configuracion;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }



    public String enviarEmail() {
        configuracion = new ConfiguracionCorreo();
        Properties props = new Properties();
        props.put("mail.smtp.host", configuracion.getSmtpHost());
        props.put("mail.smtp.port", configuracion.getSmtpPort());
        props.put("mail.smtp.auth", configuracion.isSmtpAuth());
        props.put("mail.smtp.starttls.enable", configuracion.isStartTlsEnabled());
        props.put("mail.smtp.ssl.trust", configuracion.getSmtpHost());
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        configuracion.getSmtpUser(),
                        configuracion.getSmtpPassword()
                );
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(configuracion.getSmtpUser()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(descr);
            Transport.send(message);
            return "index"; // Página de éxito
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
           
        }
        return "index";
    }
}
