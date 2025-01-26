package com.brunner.e_commerce.user.domain;

public enum UserType {
    CLIENT("client", false, false),
    MERCHANT("merchant", false, true),
    ADMIN("admin", true, false);

    private final String id;
    private final boolean hasAdminRights;
    private final boolean canReceiveTransaction;

    UserType(String id, boolean hasAdminRights, boolean canReceiveTransaction) {
        this.id = id;
        this.hasAdminRights = hasAdminRights;
        this.canReceiveTransaction = canReceiveTransaction;
    }

    public boolean isCanReceiveTransaction() {
        return canReceiveTransaction;
    }

    public boolean isHasAdminRights() {
        return hasAdminRights;
    }

    public String getId() {
        return id;
    }

}
