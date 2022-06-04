package com.amigoscode.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping(value = "api/v1/send")
public record NotificationController(NotificationService notificationService) {

    @PostMapping()
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New Notification... {}", notificationRequest.toCustomerId());
        notificationService.sendNotification(notificationRequest);
    }
}
