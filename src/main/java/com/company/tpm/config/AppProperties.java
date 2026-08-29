package com.company.tpm.config;
import org.springframework.boot.context.properties.ConfigurationProperties; import java.time.Duration;
@ConfigurationProperties("app") public record AppProperties(String timezone,String publicBaseUrl,Telegram telegram,Reminder reminder){
 public record Telegram(boolean enabled,String botToken,String botUsername,String webhookSecret,Duration linkTokenTtl){}
 public record Reminder(int daysBefore,int hoursBefore,int finalHoursBefore){}
}
