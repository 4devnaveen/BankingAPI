package com.BankingApplication.BankingAPI.Services.impl;

import com.BankingApplication.BankingAPI.Entity.Account;
import com.BankingApplication.BankingAPI.Mapper.MapAccount;
import com.BankingApplication.BankingAPI.Repository.AccountRepository;
import com.BankingApplication.BankingAPI.Services.AccountService;
import com.BankingApplication.BankingAPI.dto.AccountDto;
import lombok.NoArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class AccountServiceImple implements AccountService {

    @Autowired
    private AccountRepository accountRepository;




    public AccountServiceImple(AccountRepository accountRepository) {
        this.accountRepository=accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=MapAccount.mapToAccount(accountDto);
        Account saved= accountRepository.save(account);
        return MapAccount.mapToAccountDto(saved);
    }

    @Override
    public List<AccountDto> getAccountDetails() {
        List<Account> account= accountRepository.findAll();

         List<AccountDto> accountDto= account.stream().map(accounts->MapAccount.mapToAccountDto(accounts)).collect(Collectors.toList());

         return accountDto;

    }

    @Override
    public AccountDto getAccountDtlById(Long id) throws Exception {
        Account account=accountRepository.
                findById(id).
                orElseThrow(() -> new Exception("id is not found"));

         return MapAccount.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, Double amount) {
       Account account =accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("id is not found in the databases"));

       account.setBalance(account.getBalance()+amount);
       return MapAccount.mapToAccountDto(account);
    }

    @Override
    public AccountDto withDrawAmount(Long id, Double amount) throws Exception {

        Account account =accountRepository.
                findById(id).
                orElseThrow(()->new RuntimeException("user is not found the database"));

        Double currentBalance=account.getBalance();
        if(currentBalance>=amount)
        {
            account.setBalance(currentBalance-amount);
        }
        else
        {
           throw  new Exception("insufficient amount!! Please enter the less than "+account.getBalance());
        }
        accountRepository.save(account);
        return MapAccount.mapToAccountDto(account);

    }

    @Override
    public void DeleteAccount(Long id) {

        Account account =accountRepository.
                findById(id).
                orElseThrow(()->new RuntimeException("user is not found the database"));

        accountRepository.deleteById(id);
    }
}
