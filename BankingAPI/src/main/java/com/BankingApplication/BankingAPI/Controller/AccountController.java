package com.BankingApplication.BankingAPI.Controller;


import com.BankingApplication.BankingAPI.Services.impl.AccountServiceImple;
import com.BankingApplication.BankingAPI.dto.AccountDto;
import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {



    private AccountServiceImple accountServiceImple;

    public AccountController(AccountServiceImple accountServiceImple) {
        this.accountServiceImple = accountServiceImple;
    }

    @PostMapping("/addAccount")
    public ResponseEntity AddAccount(@RequestBody AccountDto accountDto)
    {
        AccountDto savedAccount=accountServiceImple.createAccount(accountDto);
        return  new ResponseEntity<>(savedAccount, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAccountDtl")
    public ResponseEntity<List<AccountDto>> getAccountsDetails()
    {
        return  new ResponseEntity<>(accountServiceImple.getAccountDetails(),HttpStatus.OK ) ;
    }

    @GetMapping("/getAccount/{accountId}")
    public ResponseEntity<AccountDto> getAccountDetailsById(@PathVariable Long accountId) throws Exception {
        AccountDto accountDto=accountServiceImple.getAccountDtlById(accountId);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody HashMap<String,Double> request)
    {
        AccountDto accountDto=accountServiceImple.depositAmount(id,request.get("amount")) ;

        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/withDraw/{id}")
    public ResponseEntity<AccountDto> withDrawAmount(@PathVariable Long id, @RequestBody HashMap<String,Double> request) throws Exception {
        System.out.println(request.get("amount"));
        AccountDto accountDto=accountServiceImple.withDrawAmount(id,request.get("amount"));


        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id)
    {
        accountServiceImple.DeleteAccount(id);
        return  ResponseEntity.ok("Account is deleted successfully");
    }
    }

