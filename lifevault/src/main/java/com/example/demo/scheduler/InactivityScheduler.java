package com.example.demo.scheduler;

import com.example.demo.service.ReleaseTriggerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InactivityScheduler {

    private final ReleaseTriggerService releaseTriggerService;

    public InactivityScheduler(ReleaseTriggerService releaseTriggerService) {
        this.releaseTriggerService = releaseTriggerService;
    }

    // Runs once daily at 2 AM
    @Scheduled(cron = "0 * * * * ?")
    public void runInactivityCheck() {
        releaseTriggerService.checkAndReleaseVaults();
    }
}
