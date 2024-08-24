package com.BankingApplication.BankingAPI.Mapper;

import com.BankingApplication.BankingAPI.Entity.Account;
import com.BankingApplication.BankingAPI.dto.AccountDto;
import org.springframework.cache.annotation.AbstractCachingConfiguration;
import org.springframework.stereotype.Component;

@Component
public class MapAccount {

    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDto;
    }
}
