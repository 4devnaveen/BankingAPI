package com.BankingApplication.BankingAPI.Services;


import com.BankingApplication.BankingAPI.Entity.Account;
import com.BankingApplication.BankingAPI.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto account);
    List<AccountDto> getAccountDetails();
    AccountDto getAccountDtlById(Long id) throws Exception;
    AccountDto depositAmount(Long id,Double amount);
    AccountDto withDrawAmount(Long id,Double amount) throws Exception;
    void DeleteAccount(Long id);
}
