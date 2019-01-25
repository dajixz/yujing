package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.InstallationProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2215:38
 */
public interface InstallationProcessRepository extends JpaRepository<InstallationProcess,Integer> {
    List<InstallationProcess> findAllByPid(Integer pid);
    @Query(value = "select * from installation_process where pid=:pid ORDER BY num ASC",nativeQuery = true)
    List<InstallationProcess> findInstallationListByPid(@Param("pid")Integer pid);
}
