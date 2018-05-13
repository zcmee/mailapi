package com.github.zcmee.mailapi.mail;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.Map;

@Service
public class MailContentBuilder {
    private final TemplateEngine templateEngine;

    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String template, Map<String, Object> contextVariables) {
        Context context = new Context();
        context.setVariables(contextVariables);
        return templateEngine.process(template, context);
    }
}
