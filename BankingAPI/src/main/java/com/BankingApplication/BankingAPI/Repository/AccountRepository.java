package com.BankingApplication.BankingAPI.Repository;

import com.BankingApplication.BankingAPI.Entity.Account;
import com.BankingApplication.BankingAPI.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {


}
