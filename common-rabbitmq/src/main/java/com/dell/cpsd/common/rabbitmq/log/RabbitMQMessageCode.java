/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.log;

import com.dell.cpsd.common.rabbitmq.i18n.DefaultMessageFormatter;
import com.dell.cpsd.common.rabbitmq.i18n.RabbitMQMessageBundle;
import com.dell.cpsd.common.rabbitmq.i18n.error.LocalizedError;
import com.dell.cpsd.common.rabbitmq.i18n.error.LocalizedErrorCode;

/**
 * This is the message code enum for the package subscription client.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 * @version 1.0
 * @since SINCE-TDB
 */
public enum RabbitMQMessageCode implements LocalizedErrorCode
{
    CONNECTION_FACTORY_INIT_E(1001, "VAMQP1001E"),
    CONNECTION_FACTORY_INIT_I(1002, "VAMQP1002I"),
    AMQP_CONNECTION_FAILURE_E(1003, "VAMQP1003E"),
    NO_AMQP_CONNECTIONS_E(1004, "VAMQP1004E"),
    NO_EXCHANGE_FOUND_E(1005, "VAMQP1005E"),
    MESSAGE_CONSUMER_E(1006, "VAMQP1006E"),
    MESSAGE_IMMEDIATE_ACK_E(1007, "VAMQP1007E"),
    AMQP_ERROR_RETRY_E(1008, "VAMQP1008E"),
    AMQP_ERROR_E(1009, "VAMQP1009E"),

    ERROR_RESPONSE_FAILED_E(1010, "VAMQP1010E"),
    ERROR_RESPONSE_NO_PROPERTY_E(1011, "VAMQP1011E"),
    ERROR_RESPONSE_UNEXPECTED_ERROR_E(1012, "VAMQP1012E"),

    JAVA_TRUST_STORE_IS_NOT_SET_E(1013, "VAMQP1013E"),
    JAVA_TRUST_STORE_PASSWORD_IS_NOT_SET_E(1014, "VAMQP1014E"),

    VALIDATION_INTERNAL_ERROR_E(2001, "VAMQP2001E"),
    VALIDATION_MESSAGE_IS_NULL_E(2002, "VAMQP2002E"),
    VALIDATION_PROPERTY_IS_NULL_E(2003, "VAMQP2003E"),
    VALIDATION_STRING_IS_EMPTY_E(2004, "VAMQP2004E"),;

    private static final DefaultMessageFormatter FORMATTER = new DefaultMessageFormatter(RabbitMQMessageBundle.class);

    /*
     * The error code.
     */
    private final int errorCode;

    /*
     * The message code.
     */
    private final String messageCode;

    /**
     * RabbitMQMessageCode constructor
     *
     * @param errorCode   The error code.
     * @param messageCode The message code.
     * @since SINCE-TDB
     */
    RabbitMQMessageCode(int errorCode, String messageCode)
    {
        this.errorCode = errorCode;
        this.messageCode = messageCode;
    }

    /**
     * This returns the message code.
     *
     * @return The message code.
     * @since SINCE-TDB
     */
    public String getMessageCode()
    {
        return this.messageCode;
    }

    /**
     * This returns the error code.
     *
     * @return The error code.
     * @since SINCE-TDB
     */
    public int getErrorCode()
    {
        return this.errorCode;
    }

    /**
     * This returns the error text.
     *
     * @return The error text.
     * @since SINCE-TDB
     */
    public String getErrorText()
    {
        return FORMATTER.getMessage(messageCode);
    }

    /**
     * This formats the  message using the array of parameters.
     *
     * @param params The message parameters.
     * @return The localized message populated with the parameters.
     * @since SINCE-TDB
     */
    public String getMessageText(Object... params)
    {
        return FORMATTER.getMessage(messageCode, params);
    }

    public LocalizedError getLocalizedError(Object... params)
    {
        return FORMATTER.getApplicationMessage(messageCode, params);
    }
}
