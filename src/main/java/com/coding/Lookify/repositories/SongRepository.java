package com.coding.Lookify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding.Lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song , Long>{
	List<Song> findAll();
	List<Song> findByArtistStartingWith(String string);
    List<Song> findTop10ByOrderByRatingDesc();
}
