package eventManageApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eventManageApp.entity.EventEntry;

@Repository
public interface EventEntryRepository extends JpaRepository<EventEntry, Integer> {
	public List<EventEntry> findByEventId(Integer eventEntryId);
}
