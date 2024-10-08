package com.omer.springpro6.chapter3.injectioncollections;

import com.omer.springpro6.chapter3.injectionandapplicationcontextnesting.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectingBean {
    @Autowired
    @Qualifier("list")
    List<Song> songList;

    public void printCollections() {
        songList.forEach(s -> System.out.println(s.getTitle()));
    }
}
