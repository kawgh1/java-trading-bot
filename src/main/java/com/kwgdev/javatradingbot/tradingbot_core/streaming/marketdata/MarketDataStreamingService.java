package com.kwgdev.javatradingbot.tradingbot_core.streaming.marketdata;

/**
 * A service that provides streaming market data. Normally the implementation
 * would create a dedicated connection to the trading platform and would receive
 * a stream of prices ideally through a REST service or a callback from the
 * platform. The implementation must handle broken connections and attempt to
 * reconnect in a suitable manner. The service is normally coupled with a
 * heartbeats from the platform which indicates whether the connection is alive
 * or not.
 *
 * Due to the volume of data expected, it is recommended that the service
 * delegate the handling of market data to another service in order to avoid
 * building up of queue of events, waiting to be processed.
 *
 * @author Shekhar Varshney
 *
 */
public interface MarketDataStreamingService {

    /**
     * Start the streaming service which would ideally create a dedicated
     * connection to the platform or a callback listener. Ideally multiple
     * connections requesting the same market data should not be created.
     */
    void startMarketDataStreaming();

    /**
     * Stop the streaming services and dispose any resources/connections in a
     * suitable manner such that no resource leaks are created.
     */
    void stopMarketDataStreaming();

}
