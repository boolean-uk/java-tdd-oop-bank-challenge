package com.booleanuk.core;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public abstract class BaseEntity {
    private UUID id;

    public BaseEntity() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public BaseEntity setId(UUID id) {
        this.id = id;
        return this;
    }
}
