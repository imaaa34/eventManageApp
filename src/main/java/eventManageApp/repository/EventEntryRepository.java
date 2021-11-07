package eventManageApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eventManageApp.entity.EventEntry;

public interface EventEntryRepository extends JpaRepository<EventEntry, Integer> {
	public List<EventEntry> findByEventId(Integer eventEntryId);
}
