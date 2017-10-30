/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq;

import java.lang.annotation.Annotation;
import java.util.List;

import com.dell.cpsd.contract.extension.amqp.annotation.Message;

/**
 * An annotation process for evaluating @Message annotations.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 * @version 1.0
 * @since SINCE-TDB
 */
public class MessageAnnotationProcessor
{
    /**
     * Called to process the list of classes.
     *
     */
    public void process(final MessageAnnotationProcessorCallback callback, final List<Class<?>> classes)
    {
        for (final Class aClass : classes)
        {
            process(callback, aClass);
        }
    }

    /**
     * Calls the callback if the class contains the Message annotation.
     *
     */
    public void process(final MessageAnnotationProcessorCallback callback, final Class<?> aClass)
    {
        Annotation annotation = aClass.getAnnotation(Message.class);

        if (annotation != null)
        {
            Message messageAnnotation = (Message) annotation;
            callback.found(messageAnnotation.value(),
                    aClass); // @TODO, update callback to include version ... messageAnnotation.version());
        }
    }
}
