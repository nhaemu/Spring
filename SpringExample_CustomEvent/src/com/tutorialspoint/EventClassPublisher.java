package com.tutorialspoint;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class EventClassPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher = arg0;
		
	}

	public void publish() {
		CustomEvent ce = new CustomEvent(this);
		publisher.publishEvent(ce);
	}
}
