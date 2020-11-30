package com.kwgdev.javatradingbot.tradingbot_core.marketdata;

import com.kwgdev.javatradingbot.tradingbot_core.instrument.TradeableInstrument;
import java.time.ZonedDateTime;

public class Price<T> {
    private final TradeableInstrument<T> instrument;
    private final double bidPrice, askPrice;
    private final ZonedDateTime pricePoint;

    public TradeableInstrument<T> getInstrument() {
        return instrument;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public ZonedDateTime getPricePoint() {
        return pricePoint;
    }

    public Price(TradeableInstrument<T> instrument, double bidPrice, double askPrice, ZonedDateTime pricePoint) {
        this.instrument = instrument;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.pricePoint = pricePoint;
    }

}