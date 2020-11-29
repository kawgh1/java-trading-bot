package com.kwgdev.javatradingbot.tradingbot_core;

public class BaseTradingConfig {
    private double minReserveRatio;
    private double minAmountRequired;

    private int maxAllowedQuantity;
    private int maxAllowedNetContracts;
    private double max10yrWmaOffset;

    public double getMinAmountRequired() {
        return minAmountRequired;
    }

    public void setMinAmountRequired(double minAmountRequired) {
        this.minAmountRequired = minAmountRequired;
    }

    public double getMax10yrWmaOffset() {
        return max10yrWmaOffset;
    }

    public void setMax10yrWmaOffset(double max10yrWmaOffset) {
        this.max10yrWmaOffset = max10yrWmaOffset;
    }

    public int getMaxAllowedNetContracts() {
        return maxAllowedNetContracts;
    }

    public void setMaxAllowedNetContracts(int maxAllowedNetContracts) {
        this.maxAllowedNetContracts = maxAllowedNetContracts;
    }

    public double getMinReserveRatio() {
        return minReserveRatio;
    }

    public void setMinReserveRatio(double minReserveRatio) {
        this.minReserveRatio = minReserveRatio;
    }

    public int getMaxAllowedQuantity() {
        return maxAllowedQuantity;
    }

    public void setMaxAllowedQuantity(int maxAllowedQuantity) {
        this.maxAllowedQuantity = maxAllowedQuantity;
    }
}
