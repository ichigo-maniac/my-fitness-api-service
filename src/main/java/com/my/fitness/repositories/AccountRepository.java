package com.my.fitness.repositories;

import com.my.fitness.entities.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Account repository
 */
public interface AccountRepository extends CrudRepository<AccountEntity, String> {

    /**
     * Get account by UUID
     * @param accountUUID Account UUID
     * @return Account
     */
    @Query("SELECT account FROM " + AccountEntity.ENTITY_NAME + " as account " +
            "WHERE account." + AccountEntity.UUID + " = :accountUUID")
    AccountEntity getAccountByUUID(@Param("accountUUID") String accountUUID);

}
