package com.degloba.ecommerce.profiles.eventsourcing.events;

import org.springframework.context.ApplicationEvent;

import com.degloba.ecommerce.profiles.domain.Profile;

public class ProfileCreatedEvent extends ApplicationEvent {

    public ProfileCreatedEvent(Profile source) {
        super(source);
    }
}
