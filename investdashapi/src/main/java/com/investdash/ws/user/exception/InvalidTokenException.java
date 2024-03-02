package com.investdash.ws.user.exception;

import com.investdash.ws.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException(){
        super(Messages.getMessageForLocale("investdash.activate.user.invalid.token", LocaleContextHolder.getLocale()));
    }
}
