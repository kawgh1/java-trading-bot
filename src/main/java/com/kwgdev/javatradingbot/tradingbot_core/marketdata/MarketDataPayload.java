package com.kwgdev.javatradingbot.tradingbot_core.marketdata;

import com.kwgdev.javatradingbot.tradingbot_core.instrument.TradeableInstrument;

import java.time.ZonedDateTime;

import com.kwgdev.javatradingbot.tradingbot_core.instrument.TradeableInstrument;

import java.time.ZonedDateTime;
public class MarketDataPayload < T > {

    private final double bidPrice, askPrice;
    private final TradeableInstrument<T> instrument;
    private final ZonedDateTime eventDate;

    public MarketDataPayload(TradeableInstrument<T> instrument, double bidPrice, double askPrice, ZonedDateTime eventDate) {
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.instrument = instrument;
        this.eventDate = eventDate;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public TradeableInstrument<T> getInstrument() {
        return instrument;
    }

    public ZonedDateTime getEventDate() {
        return eventDate;
    }
}
