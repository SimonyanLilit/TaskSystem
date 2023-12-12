package com.quotesystem.repository;

import com.quotesystem.model.QuoteEntity;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuoteRepository extends JpaRepository<QuoteEntity,Integer> {
    @Query(nativeQuery = true,value="select top(10) quotes.* from quotes join votes on quotes.id=votes.quote_entity_id where vote_type='UPVOTE' group by votes.quote_entity_id order by count(votes.id) DESC ")
   List<QuoteEntity> findTop10ByOrderByVotesDesc();
    @Query(nativeQuery = true,value="select top(10) quotes.* from quotes join votes on quotes.id=votes.quote_entity_id where vote_type='UPVOTE' group by votes.quote_entity_id order by count(votes.id) ASC ")
    List<QuoteEntity> findTop10ByOrderByVotesAsc();
}
