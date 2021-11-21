package eventManageApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eventManageApp.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	public List<Event> findByEventId(Integer eventId);
}
