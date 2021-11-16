package eventManageApp.form;

import java.util.Date;

import lombok.Data;

@Data
public class EventForm {
	private String eventName;
	private Date eventDate;
	private String eventPlace;
}
