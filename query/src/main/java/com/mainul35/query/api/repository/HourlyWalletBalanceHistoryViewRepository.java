package com.mainul35.query.api.repository;

import com.mainul35.query.api.entity.HourlyWalletBalanceHistoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface HourlyWalletBalanceHistoryViewRepository extends JpaRepository<HourlyWalletBalanceHistoryView, Long> {

    @Query("SELECT history FROM hourly_wallet_balance_history as history WHERE history.dateTime BETWEEN :begin AND :end AND history.wallerId = :walletId ORDER BY history.dateTime ASC")
    List<HourlyWalletBalanceHistoryView> findBetweenDateTimesForWallet(@Param("begin") ZonedDateTime begin, @Param("end") ZonedDateTime end, @Param("walletId") String walletId);
}
