package com.degloba.infrastructure.sagas;

public interface ISagaEngine <IEvent>{

    void handleSagasEvent(Object event);
}