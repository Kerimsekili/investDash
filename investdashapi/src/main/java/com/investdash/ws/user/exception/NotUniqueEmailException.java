package com.investdash.ws.user.exception;

import com.investdash.ws.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Collections;
import java.util.Map;

public class NotUniqueEmailException extends RuntimeException {
    public NotUniqueEmailException() {
        super(Messages.getMessageForLocale("investdash.error.validation", LocaleContextHolder.getLocale()));
    }

    public Map<String, String> getValidationErrors() {
        return Collections.singletonMap("email", Messages.getMessageForLocale("investdash.constraint.email.notunique", LocaleContextHolder.getLocale()));
    }
}
