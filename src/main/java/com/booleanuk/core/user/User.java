package com.booleanuk.core.user;

import java.util.UUID;

public abstract class User {
    public final UUID uuid;

    public User() {
        this.uuid = UUID.randomUUID();
    }
}
