package com.kwgdev.javatradingbot.tradingbot_core.account;


/**
* A POJO that holds account information. No setters are provided as
 * it is envisaged that the final member variables will be initialized
 * through the constructor(s).
 *
 * @param <T>
 *     the type of AccountId
 */

public class Account < T > {

    private final double totalBalance;
    private final double unrealizedPnl;
    private final double realizedPnl;
    private final double marginUsed;
    private final double marginAvailable;
    private final double netAssetValue;
    private final long openTrades;
    private final String currency;
    private final T accountId;
    private final String toStr;
    private final double amountAvailableRatio; /* The amount available to trade as a fraction of total amount */
    private final double marginRate; /* The leverage offered on this account. ex. 0.05, 0.1, etc. */
    private final int hash;



    public Account(final double totalBalance, double marginAvailable, String currency,
                   T accountId, double marginRate) {
        this(totalBalance, 0, 0, 0, marginAvailable, 0, currency, accountId, marginRate);
    }

    public Account(double totalBalance, double unrealizedPnl, double realizedPnl, double marginUsed,
                   double marginAvailable, long openTrades, String currency, T accountId, double marginRate) {
        this.totalBalance = totalBalance;
        this.unrealizedPnl = unrealizedPnl;
        this.realizedPnl = realizedPnl;
        this.marginUsed = marginUsed;
        this.marginAvailable = marginAvailable;
        this.openTrades = openTrades;
        this.currency = currency;
        this.accountId = accountId;
        this.amountAvailableRatio = this.marginAvailable / this.totalBalance;
        this.netAssetValue = this.marginUsed + this.marginAvailable;
        this.marginRate = marginRate;
        this.hash = calcHashCode();
        // Create toString here as all variables are final
        toStr = String.format("Currency=%s, NAV=%5.2f, TotalBalance=%5.2f, UnrealizedPnl=%5.2f, "
        )                       + "RealizedPnl=%5.2f, MarginUsed=%5.2f, MarginAvailable=%5.2f, "
                                + "OpenTrades=%d, amountAvailableRatio=%1.2f, marginRate=%1.2f, ",
                                currency, netAssetValue, totalBalance, unrealizedPnl realizedPnl,
                                marginUsed, marginAvailable, openTrades, this.amountAvailableRatio,
                                this.marginRate);
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public double getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public double getRealizedPnl() {
        return realizedPnl;
    }

    public double getMarginUsed() {
        return marginUsed;
    }

    public double getMarginAvailable() {
        return marginAvailable;
    }

    public double getNetAssetValue() {
        return netAssetValue;
    }

    public long getOpenTrades() {
        return openTrades;
    }

    public String getCurrency() {
        return currency;
    }

    public T getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return this.toStr;
    }

    public double getAmountAvailableRatio() {
        return amountAvailableRatio;
    }

    public double getMarginRate() {
        return marginRate;
    }

    @Override
    public int hashCode() {
        return this.hash;
    }

    private int calcHashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());

        return result;

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
        Account<T> other = (Account<T>) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;

        return true;
    }
}
