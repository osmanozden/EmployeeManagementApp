package com.circle.types;

public enum MessageTypes {
    EMAIL_ALREADY_EXIST("Employee already exist , try another employee!","user_already_exist"),
    INVALID_EMAIL_FORMAT("The e-mail address format you entered is incorrect, please check it!","ınvalid_email_format"),
    EMPLOYEE_CREATED("Employee created successfully!","employee_created"),
    EMPLOYEE_UPDATED("Employee updated successfully!","employee_updated"),
    EMPLOYEE_NOT_FOUND("Employee not found, try another employee!","employee_not_found"),
    FIELD_MUST_NOT_BE_EMPTY("Field must not be empty","field_must_not_be_empty"),
    END_DATE_EARLIER("EndDate cannot be earlier than StartDate! Check EndDate!","end_date_earlier"),
    EMPLOYEE_DELETED_SUCCESSFULLY("Employee removed successfully!","employee_removed"),
    EMPLOYEE_HAS_TIMEOFF("This employee already has TimeOff, try it for a different employee!","employee_has_timeoff"),
    TIMEOFF_REQUEST_CREATED("TimeOff request created successfully!","timeoff_request_created"),
    SALARY_MUST_BE_NUMBER("Salary must be a number!","salary_must_be_number");

    private final String message;
    private final String key;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getKey() {
        return key;
    }

    MessageTypes(String message, String key) {
        this.message = message;
        this.key = key;
    }
}
