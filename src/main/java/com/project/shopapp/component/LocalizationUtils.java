package com.project.shopapp.component;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import com.project.shopapp.util.WebUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class LocalizationUtils {
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    public String getLocalizedMessage(String messageKey, Object... params) {
        HttpServletRequest request = WebUtils.getCurrentRequest();
        Locale locale = localeResolver.resolveLocale(request);
        return messageSource.getMessage(messageKey, params, locale);
    }
}
