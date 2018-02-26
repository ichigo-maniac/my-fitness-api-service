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

    /**
     * Get account by facebook id
     * @param facebookId Facebook id
     * @return Account
     */
    @Query("SELECT account FROM " + AccountEntity.ENTITY_NAME + " as account " +
            "WHERE account." + AccountEntity.FACEBOOK_ID + " = :facebookId")
    AccountEntity getAccountByFacebookId(@Param("facebookId") String facebookId);

    /**
     * Get account by vk.com id
     * @param vkId Vk.com id
     * @return Account
     */
    @Query("SELECT account FROM " + AccountEntity.ENTITY_NAME + " as account " +
            "WHERE account." + AccountEntity.VK_ID + " = :vkId")
    AccountEntity getAccountByVkId(@Param("vkId") String vkId);

    /**
     * Get account by twitter id
     * @param twitterId Twitter id
     * @return Account
     */
    @Query("SELECT account FROM " + AccountEntity.ENTITY_NAME + " as account " +
            "WHERE account." + AccountEntity.TWITTER_ID + " = :twitterId")
    AccountEntity getAccountByTwitterId(@Param("twitterId") String twitterId);

}
