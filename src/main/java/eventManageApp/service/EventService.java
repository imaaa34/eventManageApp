package eventManageApp.service;

import java.util.List;

import eventManageApp.entity.Event;
import eventManageApp.form.EventForm;

public interface EventService {
	public List<Event> findAll();
	public List<Event> findByEventId(Integer eventId);
	public void save(EventForm eventForm);
}
