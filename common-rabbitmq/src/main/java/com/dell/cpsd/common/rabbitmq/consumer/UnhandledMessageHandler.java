/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.consumer;

/**
 * The UnhandledMessageHandler that will be invoked when an unhandled message
 * is received by the consumer.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 * @version 1.0
 * @since SINCE-TDB
 * @deprecated Use DefaultMessageHandler or MessageHandler instead.
 */
@Deprecated
public interface UnhandledMessageHandler
{
    /**
     * Handles the byte array, this is called from SpringAMQP when an unhandled
     * message is received.
     *
     * @param messagePayload The message payload
     */
    void unhandledMessage(byte[] messagePayload);
}
