/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.aggregate;

import java.util.function.Consumer;

/**
 * Aggregator interface for aggregating multiple related messages.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 *
 * @see <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Aggregator.html">Aggregator pattern</a>
 * @see <a href="http://docs.spring.io/spring-integration/docs/2.0.0.RC1/reference/html/aggregator.html">Spring integrations aggregator</a>
 * @since 1.0
 */
public interface MessageAggregator<M extends Aggregate>
{
    /**
     * Trigger processing of an aggregate for given ID.
     */
    void process(final String correlationId, final Consumer<M> updateAction);
}
