package com.adarsh.ipl.statsboard.Repository;

import com.adarsh.ipl.statsboard.Model.BallStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallStatsRepository extends CrudRepository<BallStats, Long> {
}
