/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.annotation.stereotypes;

/**
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 *
 * @since SINCE-TBD
 * @deprecated use {@link com.dell.cpsd.contract.extension.amqp.annotation.stereotypes.StereotypeMessage} instead
 */
@Deprecated
public enum MessageStereotype
{
    REQUEST,
    REPLY,
    EVENT,
    ERROR;
}
