/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.message;

/**
 * Marker interface for messages having 'correlationId' property.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 * @deprecated use {@link com.dell.cpsd.contract.extension.amqp.message.HasCorrelationId} instead

 */
@Deprecated
public interface HasCorrelationId
{
    String getCorrelationId();

    void setCorrelationId(String correlationId);
}
