package com.kwgdev.javatradingbot.tradingbot_core.instrument;

public class InstrumentPairInterestRate {

    private final Double baseCurrencyBidInterestRate;
    private final Double baseCurrencyAskInterestRate;
    private final Double quoteCurrencyBidInterestRate;
    private final Double quoteCurrencyAskInterestRate;

    public InstrumentPairInterestRate() {
        this(null, null,
                null, null);
    }

    public InstrumentPairInterestRate(Double baseCurrencyBidInterestRate, Double baseCurrencyAskInterestRate,
                                      Double quoteCurrencyBidInterestRate, Double quoteCurrencyAskInterestRate) {
        this.baseCurrencyBidInterestRate = baseCurrencyBidInterestRate;
        this.baseCurrencyAskInterestRate = baseCurrencyAskInterestRate;
        this.quoteCurrencyBidInterestRate = quoteCurrencyBidInterestRate;
        this.quoteCurrencyAskInterestRate = quoteCurrencyAskInterestRate;
    }

    public Double getBaseCurrencyBidInterestRate() {
        return baseCurrencyBidInterestRate;
    }

    public Double getBaseCurrencyAskInterestRate() {
        return baseCurrencyAskInterestRate;
    }

    public Double getQuoteCurrencyBidInterestRate() {
        return quoteCurrencyBidInterestRate;
    }

    public Double getQuoteCurrencyAskInterestRate() {
        return quoteCurrencyAskInterestRate;
    }

    @Override
    public String toString() {
        return "InstrumentPairInterestRate [baseCurrencyBidInterestRate=" + baseCurrencyBidInterestRate
                + ", baseCurrencyAskInterestRate=" + baseCurrencyAskInterestRate + ", quoteCurrencyBidInterestRate="
                + quoteCurrencyBidInterestRate + ", quoteCurrencyAskInterestRate=" + quoteCurrencyAskInterestRate + "]";
    }
}