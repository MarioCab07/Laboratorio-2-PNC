package com.labpnc.lab2.Repositories;

import com.labpnc.lab2.Domain.Entities.UserXGift;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface iUserXGiftRepository extends iGenericRepository<UserXGift, UUID> {

    List<UserXGift> findByUserIdUser(UUID userId);

    @Query("SELECT ug FROM UserXGift ug WHERE ug.gift.name = :giftName")
    List<UserXGift> findByGiftName(@Param("giftName") String giftName);

    @Query(value = "SELECT * FROM user_x_gift WHERE redeem_date = :redeemDate", nativeQuery = true)
    List<UserXGift> findByRedeemDateNative(@Param("redeemDate") String redeemDate);

}
