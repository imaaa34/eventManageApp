package eventManageApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eventManageApp.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	public List<Event> findByEventId(Integer eventId);
}
