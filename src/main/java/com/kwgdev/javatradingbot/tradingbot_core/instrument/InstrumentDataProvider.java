package com.kwgdev.javatradingbot.tradingbot_core.instrument;

import java.util.Collection;

/**
 * A provider of tradeable instrument data information. At the very minimum the
 * provider must provide the instrument name and pip value for each instrument.
 * Since the instrument data almost never changes during trading hours, it is
 * highly recommended that the data returned from this provider is cached in an
 * immutable collection.
 *
 * @param <T>The type of instrumentId in class TradeableInstrument
 * @see TradeableInstrument
 */
public interface InstrumentDataProvider<T> {
    /**
     *
     * @return a collection of all TradeableInstrument available to trade on the
     *         brokerage platform.
     */
    Collection<TradeableInstrument<T>> getInstruments();
}