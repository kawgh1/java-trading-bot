package com.kwgdev.javatradingbot.tradingbot_core.marketdata;

import java.time.ZonedDateTime;

import com.google.common.eventbus.EventBus;
import com.kwgdev.javatradingbot.tradingbot_core.instrument.TradeableInstrument;

public class MarketEventHandlerImpl<T> implements MarketEventCallback<T> {

    private final EventBus eventBus;

    public MarketEventHandlerImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void onMarketEvent(TradeableInstrument<T> instrument, double bid, double ask, ZonedDateTime eventDate) {
        MarketDataPayload<T> payload = new MarketDataPayload<T>(instrument, bid, ask, eventDate);
        eventBus.post(payload);

    }

}
