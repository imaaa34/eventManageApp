package eventManageApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eventManageApp.entity.Event;
import eventManageApp.entity.Participant;
import eventManageApp.form.EventEntryForm;
import eventManageApp.form.EventForm;
import eventManageApp.service.EventEntryService;
import eventManageApp.service.EventService;

@Controller
public class eventController {
	@Autowired
	EventService eventService;
	
	@Autowired
	EventEntryService eventEntryService;
	
//	トップページ（イベント一覧画面）
	@GetMapping("/")
	public String index(Model model) {
		// DBに登録されているイベントの一覧を取得
		List<Event> eventList = eventService.findAll();
		// modelにイベントの一覧をセット
		model.addAttribute("eventList", eventList);
		// 次に表示する画面のパス（htmlファイルの名称）を返却
		return "eventlist";
	}
	
//	イベント登録画面
	@GetMapping("regist")
	public String regist(Model model) {
		// 次に表示する画面のパス（htmlファイルの名称）を返却
		return "regist";
	}

//	イベント詳細画面
	@GetMapping("entry/{eventId}")
	public String entry(@PathVariable("eventId") Integer eventId,
						Model model) {
		// 引数で受け取ったイベントIDからイベントの情報を取得
		// イベントの情報は1件の前提で処理
		List<Event> event = eventService.findByEventId(eventId);
		// modelに結果をセット
		model.addAttribute("event", event.get(0));
		// 引数で受け取ったイベントIDからイベントの参加者情報を取得
		List<Participant> participantList = eventEntryService.findByEventId(eventId);
		// modelに結果をセット
		model.addAttribute("participantList", participantList);
		// 次に表示する画面のパス（htmlファイルの名称）を返却
		return "eventdetail";
	}

//	イベント登録処理
	@PostMapping("eventregist")
	public String registrationEvent(@ModelAttribute EventForm eventForm) {
		// フォームから値を取得してデータベース登録処理へ
		eventService.save(eventForm);
		// 次に表示する画面のパス（リダイレクト先のページ）を返却
		return "redirect:/";
	}

//	イベント参加処理
	@PostMapping("entry/add")
	public String entryEvent(
		@ModelAttribute EventEntryForm eventEntryForm) {
			// フォームから値を取得してデータベース登録処理へ
			eventEntryService.save(eventEntryForm);
			// 次に表示する画面のパス（リダイレクト先のページ）を返却
			return "redirect:/entry/" + eventEntryForm.getEventId();
	}	
}
