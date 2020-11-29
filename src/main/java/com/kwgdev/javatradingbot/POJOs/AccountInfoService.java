package com.kwgdev.javatradingbot.POJOs;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @param <K>
 *     type of accountId
 * @param <N>
 *     type of the type of instrumentId in class TradeableInstrument
 * @see TradeableInstrument
 */
public class AccountInfoService <K, N>{

    private final AccountDataProvider<K> accountDataProvider;
    private final BaseTradingConfig baseTradingConfig;
    private final CurrentPriceInfoProvider <N> currentPriceInfoProvider;
    private final ProviderHelper providerHelper;
    private Comparator<Account<K>> accountComparator = new MarginAvailableComparator<K>();

    public AccountInfoService(AccountDataProvider<K> accountDataProvider,
                              BaseTradingConfig baseTradingConfig,
                              CurrentPriceInfoProvider<N> currentPriceInfoProvider,
                              ProviderHelper providerHelper) {

        this.accountDataProvider = accountDataProvider;
        this.baseTradingConfig = baseTradingConfig;
        this.currentPriceInfoProvider = currentPriceInfoProvider;
        this.providerHelper = providerHelper;
    }

    public Collection< K > findAccountsToTrade() {
        List< Account < K >> accounts = Lists.newArrayList(getAllAccounts());
        Collection < K > accountsFound = Lists.newArrayList();
        Collections.sort(accounts, accountComparator);

        for (Account < K > account : accounts) {
            if (account.getAmountAvailableRatio() >= baseTradingConfig.getMinReserveRatio()
                && account.getNetAssetValue() >= baseTradingConfig.getMinAmountRequired()) {

                accountsFound.add(account.getAccountId());
            }
        }

        return accountsFound;
    }
}
