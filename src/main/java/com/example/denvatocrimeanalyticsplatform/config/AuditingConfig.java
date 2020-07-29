package com.example.denvatocrimeanalyticsplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfig
{
    // That's all here for now. More auditing configurations would be added later.
}
