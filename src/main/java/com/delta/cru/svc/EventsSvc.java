package com.delta.cru.svc;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.delta.cru.bo.EventsBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EventsVo;

@RestController
public class EventsSvc {
	@Autowired
	EventsBoIfc eventService;

	@PostMapping("/example/event/v1/events")
	ResponseEntity<Void> postEvents(@RequestBody EventsVo events) throws DataAcesExcp {
		if (events == null)
			return ResponseEntity.noContent().build();
		String id= eventService.insEventDetails(events);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id)
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/example/event/v1/events/{id}")
	public EventsVo retrieveEventetails(@PathVariable String id) throws BsnObjExcp {

		return eventService.getEventDetails(id);
	}

}
