package com.coding.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.Lookify.models.Song;
import com.coding.Lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository songRepository;
	public SongService(SongRepository songRepository) {
		this.songRepository=songRepository;
	}
//create
	public void createSong(Song song) {
		songRepository.save(song);
	}
// find all
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
// find one
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;			
		}
	}
// find by artist
	public List<Song> findByArtist(String string){
		return songRepository.findByArtistStartingWith(string);
	}
// find top ten
	public 	List<Song> findTopTen(){
		List<Song> songs = songRepository.findTop10ByOrderByRatingDesc();
		return songs;
	}

	
//	delete
	public void deleteSong(Long id) {
//		Optional<Song> optionalSong = songRepository.findById(id);
		songRepository.deleteById(id);
	}
}
