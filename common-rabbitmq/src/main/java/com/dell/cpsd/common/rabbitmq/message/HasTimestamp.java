/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved. Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.message;

import java.util.Date;

/**
 * Marker interface for messages having 'timestamp' property.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved. Dell EMC Confidential/Proprietary Information
 * </p>
 */
/**
 * The class is deprecated as it will be moved to amqp-contract-extension repo, The implementation will be provided in the next release of
 * common-messaging-parent and amqp-contract-extension
 */
@Deprecated
public interface HasTimestamp
{
    Date getTimestamp();

    void setTimestamp(Date timestamp);
}
