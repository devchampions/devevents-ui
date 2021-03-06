package com.devchampions.app.event.addnew;

import com.devchampions.app.event.TwitterPresence;
import com.devchampions.infrastructure.Reaction;
import com.devchampions.infrastructure.indexing.Indexer;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class AddNewEventReaction implements Reaction<AddNewEvent, AddNewEvent.EventId> {

    private final EventRepository repository;
    private final Indexer indices;

    public AddNewEventReaction(EventRepository repository, Indexer indices) {
        this.repository = repository;
        this.indices = indices;
    }

    @Override
    public AddNewEvent.EventId react(AddNewEvent $) {
        Event event = new Event($.name, $.about, $.website, city($), $.startsOn);
        $.endsOn.ifPresent(event::endOn);

        $.twitter
                .map(twitter -> new TwitterPresence(twitter.handle, twitter.hashtag))
                .ifPresent(event::establish);

        Arrays.stream($.tags).forEach(event::tag);
        repository.save(event);
        indices.append(event.index());

        return new AddNewEvent.EventId(event.uuid());
    }

    private City city(AddNewEvent $) {
        Country country = new Country($.country);
        City city = country.city($.city);
        $.administrative.map(Administrative::new).ifPresent(city::enclose);
        return city;
    }
}


