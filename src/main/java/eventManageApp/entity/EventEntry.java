package eventManageApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "eventEntry")
public class EventEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evententry_id")
	private Integer eventEntryId;
	@Column(name = "event_id")
	private Integer eventId;
	@Column(name = "paticipant_id")
	private Integer participantId;
}
