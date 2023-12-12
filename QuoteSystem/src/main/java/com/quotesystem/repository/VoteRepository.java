package com.quotesystem.repository;

import com.quotesystem.model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity,Integer> {
    @Query(nativeQuery = true,value = "select * from votes where quote_entity_id=?1 order by vote_date")
List<VoteEntity> findByQuoteIdOrderByVoteDate(Integer quoteId);
}
