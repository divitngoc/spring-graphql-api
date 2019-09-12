package com.divitngoc.db.service.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.divitngoc.db.service.MusicService;

@Component
public class MusicServiceFactory {

	private final Map<ServiceType, MusicService> serviceMap;

	public MusicServiceFactory(final List<MusicService> services) {
		serviceMap = services.stream().collect(Collectors.toMap(s -> s.getType(), s -> s));
	}

	public <T> T getInstance(final ServiceType type, final Class<T> cls) {
		final MusicService service = serviceMap.get(type);
		if (service == null) {
			throw new RuntimeException("Service type not implemented: " + type);
		}
		return cls.cast(service);
	}
}
