package com.kwgdev.javatradingbot.tradingbot_core.instrument;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Shekhar Varshney
 *
 * @param <T>
 *            the type of instrumentId
 */
public class TradeableInstrument<T> {
    private final String instrument;
    private final String description;
    private final T instrumentId;
    private final double pip; /* pip is the lowest precision at which an instrument ticks. For e.g.
    the pip value for USDJPY is 0.001. If the current USDJPY price is 123.462, then at minimum the
    next price change would be to either 123.461 or 123.463. */
    private final int hash;
    private InstrumentPairInterestRate instrumentPairInterestRate;

    public TradeableInstrument(String instrument) {
        this(instrument, null);
    }

    public TradeableInstrument(String instrument, String description) {
        this(instrument, null, description);
    }

    public TradeableInstrument(String instrument, T instrumentId, String description) {
        this(instrument, instrumentId, 0, null);
    }

    public TradeableInstrument(final String instrument, final double pip,
                               InstrumentPairInterestRate instrumentPairInterestRate, String description) {
        this(instrument, null, pip, instrumentPairInterestRate, description);

    }

    public TradeableInstrument(final String instrument, T instrumentId, final double pip,
                               InstrumentPairInterestRate instrumentPairInterestRate) {
        this(instrument, instrumentId, pip, instrumentPairInterestRate, null);
    }

    public TradeableInstrument(final String instrument, T instrumentId, final double pip,
                               InstrumentPairInterestRate instrumentPairInterestRate, String description) {
        this.instrument = instrument;
        this.pip = pip;
        this.instrumentPairInterestRate = instrumentPairInterestRate;
        this.instrumentId = instrumentId;
        this.description = description;
        this.hash = calcHashCode();
    }


        private int calcHashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
        result = prime * result + ((instrumentId == null) ? 0 : instrumentId.hashCode());
        return result;
    }

    public T getInstrumentId() {
        return this.instrumentId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked")
        TradeableInstrument<T> other = (TradeableInstrument<T>) obj;
        if (instrument == null) {
            if (other.instrument != null) {
                return false;
            }
        } else if (!instrument.equals(other.instrument)) {
            return false;
        }
        if (instrumentId == null) {
            if (other.instrumentId != null) {
                return false;
            }
        } else if (!instrumentId.equals(other.instrumentId)) {
            return false;
        }
        return true;
    }

    public InstrumentPairInterestRate getInstrumentPairInterestRate() {
        return instrumentPairInterestRate;
    }

    public void setInstrumentPairInterestRate(InstrumentPairInterestRate instrumentPairInterestRate) {
        this.instrumentPairInterestRate = instrumentPairInterestRate;
    }

    @Override
    public String toString() {
        return "TradeableInstrument [instrument=" + instrument + ", description=" + description + ", instrumentId="
                + instrumentId + ", pip=" + pip + ", instrumentPairInterestRate=" + instrumentPairInterestRate + "]";
    }

    public String getInstrument() {
        return instrument;
    }

    public double getPip() {
        return pip;
    }
}