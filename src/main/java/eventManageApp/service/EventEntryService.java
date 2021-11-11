package eventManageApp.service;

import java.util.List;

import eventManageApp.entity.Participant;
import eventManageApp.form.EventEntryForm;

public interface EventEntryService {
	public List<Participant> findByEventId(Integer eventId);
	public void save(EventEntryForm eventEntryForm);
}
