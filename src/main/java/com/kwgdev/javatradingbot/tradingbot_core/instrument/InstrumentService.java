package com.kwgdev.javatradingbot.tradingbot_core.instrument;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class InstrumentService<T> {

    private final Map<String, TradeableInstrument<T>> instrumentMap;

    public InstrumentService(InstrumentDataProvider<T> instrumentDataProvider) {
        Preconditions.checkNotNull(instrumentDataProvider);
        Collection<TradeableInstrument<T>> instruments = instrumentDataProvider.getInstruments();
        Map<String, TradeableInstrument<T>> tradeableInstrumenMap = Maps.newTreeMap();
        for (TradeableInstrument<T> instrument : instruments) {
            tradeableInstrumenMap.put(instrument.getInstrument(), instrument);
        }
        this.instrumentMap = Collections.unmodifiableMap(tradeableInstrumenMap);
    }

    public Collection<TradeableInstrument<T>> getInstruments() {
        return this.instrumentMap.values();
    }

    public Collection<TradeableInstrument<T>> getAllPairsWithCurrency(String currency) {
        Collection<TradeableInstrument<T>> allPairs = Sets.newHashSet();
        if (StringUtils.isEmpty(currency)) {
            return allPairs;
        }
        for (Map.Entry<String, TradeableInstrument<T>> entry : instrumentMap.entrySet()) {
            if (entry.getKey().contains(currency)) {
                allPairs.add(entry.getValue());
            }
        }
        return allPairs;
    }

    public Double getPipForInstrument(TradeableInstrument<T> instrument) {
        Preconditions.checkNotNull(instrument);
        TradeableInstrument<T> tradeableInstrument = this.instrumentMap.get(instrument.getInstrument());
        if (tradeableInstrument != null) {
            return tradeableInstrument.getPip();
        } else {
            return 1.0;
        }
    }
}