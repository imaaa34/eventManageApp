package eventManageApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventManageApp.entity.Event;
import eventManageApp.form.EventForm;
import eventManageApp.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventRepository eventRepository;
	
	public List<Event> findAll() {
		List<Event> allEventList = eventRepository.findAll();
		return allEventList;
	}
	
	public List<Event> findByEventId(Integer eventId) {
//		イベントIDからイベントリストを取得
		List<Event> eventList = eventRepository.findByEventId(eventId);
		return eventList;
	}
	
	public void save(EventForm eventForm) {
//		イベント名を登録
		Event event = new Event();
		event.setEventName(eventForm.getEventName());
//		イベント日を登録
		event.setEventDate(eventForm.getEventDate());
//		イベント場所を登録
		event.setEventPlace(eventForm.getEventPlace());
		eventRepository.save(event);
	}
}
