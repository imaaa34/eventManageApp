package eventManageApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventManageApp.entity.EventEntry;
import eventManageApp.entity.Participant;
import eventManageApp.form.EventEntryForm;
import eventManageApp.repository.EventEntryRepository;
import eventManageApp.repository.ParticipantRepository;


@Service
public class EventEntryServiceImpl implements EventEntryService {
	@Autowired
	EventEntryRepository eventEntryRepository;
	@Autowired
	ParticipantRepository participantRepository;
	
	public List<Participant> findByEventId(Integer eventId) {
//		イベントIDからイベント登録リストを取得
		List<EventEntry> eventEntryList = eventEntryRepository.findByEventId(eventId);
//		イベント参加者のIDを取得
		List<Integer> ids = new ArrayList<Integer> ();
		for(EventEntry eventEntry : eventEntryList) {
			ids.add(eventEntry.getParticipantId());
		}
//		イベント参加者の情報を検索して返却
		List<Participant> participantList = participantRepository.findAllById(ids);
		return participantList;
	}
	
	public void save(EventEntryForm eventEntryForm) {
//		イベント参加者の情報を登録
		Participant participant = new Participant();
		participant.setParticipantName(eventEntryForm.getParticipantName());
		participantRepository.save(participant);
//		イベント参加情報を登録
		EventEntry eventEntry = new EventEntry();
		eventEntry.setEventId(eventEntryForm.getEventId());
		eventEntry.setParticipantId(participant.getParticipantId());
		eventEntryRepository.save(eventEntry);
	}
}
