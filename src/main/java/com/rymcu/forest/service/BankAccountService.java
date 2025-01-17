package com.rymcu.forest.service;

import com.rymcu.forest.core.service.Service;
import com.rymcu.forest.dto.BankAccountDTO;
import com.rymcu.forest.dto.BankAccountSearchDTO;
import com.rymcu.forest.dto.TransactionRecordDTO;
import com.rymcu.forest.entity.BankAccount;

import java.util.List;

/**
 * @author ronger
 */
public interface BankAccountService extends Service<BankAccount> {
    /**
     * 查询银行账户列表
     * @param bankAccountSearchDTO
     * @return
     */
    List<BankAccountDTO> findBankAccounts(BankAccountSearchDTO bankAccountSearchDTO);

    /**
     * 查询用户银行账户
     * @param idUser
     * @return
     */
    BankAccountDTO findBankAccountByIdUser(Integer idUser);

    /**
     * 根据账户查询银行账户信息
     * @param bankAccount
     * @return
     */
    BankAccountDTO findByBankAccount(String bankAccount);

    /**
     * 查询系统社区银行
     * @return
     */
    BankAccount findSystemBankAccount();

    /**
     * 查询账号信息
     * @param formBankAccount
     * @return
     */
    BankAccount findInfoByBankAccount(String formBankAccount);

    List<TransactionRecordDTO> findUserTransactionRecords(String bankAccount, String startDate, String endDate);
}
