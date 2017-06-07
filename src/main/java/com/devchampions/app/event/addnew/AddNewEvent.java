package com.devchampions.app.event.addnew;

import com.devchampions.infrastructure.Command;

import java.time.LocalDate;
import java.util.Optional;

public class AddNewEvent implements Command<AddNewEvent.EventId> {

//    public enum Iam {
//        Tracking, Attending, Organising, Speaking
//    }

    public String name;

    public String city;
    public String country;
    public Optional<String> administrative = Optional.empty();

    public Optional<String> about = Optional.empty();
    public Optional<String> website = Optional.empty();
    //
//    public String seriesId;
    public String[] tags = new String[]{};
    //
    public LocalDate startsOn;
    public Optional<LocalDate> endsOn = Optional.empty();
//
//    public String twitterHandle;
//    public String twitterHashtag;
//
//    public Iam iam;

    static class EventId implements Command.R {

        private final String id;

        public EventId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }
    }

}
