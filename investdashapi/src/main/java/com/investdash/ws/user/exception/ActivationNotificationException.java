package com.investdash.ws.user.exception;

import com.investdash.ws.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class ActivationNotificationException extends RuntimeException {

    public ActivationNotificationException(){
        super(Messages.getMessageForLocale("investdash.create.user.email.failure", LocaleContextHolder.getLocale()));
    }
}
