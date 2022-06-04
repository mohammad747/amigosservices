package com.amigoscode.notification;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(
        NotificationRepository notificationRepository
) {

    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .sender("Mohammad")
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}

