package com.circle.types;

public enum RequestCategoryEnum  {
    SICK_LEAVE("SICK_LEAVE"),
    ANNUAL_LEAVE("ANNUAL_LEAVE"),
    REMOTE_WORKING("REMOTE_WORKİNG");

    RequestCategoryEnum(String requestCategoryType) {
        RequestCategoryType = requestCategoryType;
    }

    private final String RequestCategoryType;

    public String getRequestCategoryType() {
        return RequestCategoryType;
    }
}

