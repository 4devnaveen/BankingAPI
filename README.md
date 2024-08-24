# BankingAPI
Build Banking Crud using spring boot,hibernate,lombok,mysql,default Jparepository

#Using Postman to test api

#Create the Account Holder

API------>:http://localhost:8080/api/accounts/addAccount
*will pass json as the input in the body 

#Get all account
API---->: http://localhost:8080/api/accounts/getAccountDtl

#Get account by using ID
API---->:http://localhost:8080/api/accounts/getAccount/7

#Deposit the amount 
API---->:http://localhost:8080/api/accounts/deposit/2
Deposit the amount by using account id and will passing the deposit amount as a json, will receive the json as a map in back end.

#Withdraw the amount 
API---->:http://localhost:8080/api/accounts/withDraw/10
Withdraw the amount by using user account

#Delete the Account
API---->:http://localhost:8080/api/accounts/deleteAccount/4



