package com.perye.dokit.repository;

import com.perye.dokit.entity.ServerDeploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:26 下午
 */
public interface ServerDeployRepository extends JpaRepository<ServerDeploy, Long>, JpaSpecificationExecutor<ServerDeploy> {
    @Modifying
    @Query(value = "update mnt_server set account_id = null where account_id = ?1", nativeQuery = true)
    void changeByAccount(String id);

    ServerDeploy findByIp(String ip);
}
