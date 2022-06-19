package com.ajaycodes.location.utils;

import javax.mail.MessagingException;

public interface EmailUtil {
    void sendEmail(String toAddress, String subject, String body) throws MessagingException;

}
