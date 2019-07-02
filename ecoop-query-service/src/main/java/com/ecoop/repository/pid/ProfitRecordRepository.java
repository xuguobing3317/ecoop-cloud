package com.ecoop.repository.pid;

import com.ecoop.entity.pid.ProfitRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProfitRecordRepository
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 19:28
 * @Version 1.0
 **/
public interface ProfitRecordRepository  extends JpaRepository<ProfitRecordEntity, Long> {

    long countByTnWalletId(Long tnWalletId);

    @Query("select count(*) from ProfitRecordEntity e")
    long countTotal();

    @Query(value = "select * from profit_record limit 1", nativeQuery = true)
    List<Map<String, Object>> querySomeRecord();
}
