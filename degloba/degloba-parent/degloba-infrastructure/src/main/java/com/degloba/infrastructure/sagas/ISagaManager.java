package com.degloba.infrastructure.sagas;

public interface ISagaManager<T extends SagaInstance<D>, D> {

    void removeSaga(SagaInstance<D> sagaInstance);

    D createNewSagaData();
}