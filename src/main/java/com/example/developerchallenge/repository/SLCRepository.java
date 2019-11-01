package com.example.developerchallenge.repository;

import com.example.developerchallenge.model.Doc;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SLCRepository extends JpaRepository<Doc, Long> {

    @Query("SELECT d "
            + "FROM Doc d INNER JOIN d.bcmsg b "
            + "WHERE b.nuOp = :nuOp ")
    Optional<Doc> getByNuOp(@Param("nuOp") String nuOp);
}
