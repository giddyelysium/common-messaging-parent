/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq;

/**
 * A callback that is used for processing the @Message annotations.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 * @version 1.0
 * @since SINCE-TDB
 */
public interface MessageAnnotationProcessorCallback
{
    /**
     * Callback method that is called for a class that contains the Message annotation.
     *
     * @param messageType  The messageType specified within the annotation.
     * @param messageClass The class that contains message annotation.
     */
    void found(String messageType, Class messageClass);

}
