package com.coding.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding.Lookify.models.Song;
import com.coding.Lookify.services.SongService;

@Controller
public class SongsController {
	private SongService songService;
	public SongsController (SongService songService) {
		this.songService = songService ;
	}
	@RequestMapping("/")
	public String prelanding() {
		return "prelanding";
	}
	
	@RequestMapping("/dashboard")
	public String index(Model model) {
		List <Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "index";
	}
	@RequestMapping("/songs/new")
	public String addnew(@ModelAttribute("song") Song song) {
		System.out.println("hit add new get");
		return "new";
	}
	@RequestMapping("/songs/{id}")
	public String songdetail(@PathVariable("id") Long id,Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song",song);
		return "songdetail";
	}
	@RequestMapping("/songs/search/topten")
	public String topten(Model model) {
		System.out.println("hit topten get req");
		List <Song> songs = songService.findTopTen();
		model.addAttribute("songs", songs);
		return "topten";
	}
	@RequestMapping("/songs/search/{artist}")
	public String artistsongs(@PathVariable("artist") String artist, Model model) {
		List <Song> songs = songService.findByArtist(artist);
		model.addAttribute("songs",songs);
		return "artistsongs";
	}
// ~~~~~Operations	~~~~~~
	
// create Song
		@RequestMapping(value="/songs/new", method=RequestMethod.POST)
		public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
			if(result.hasErrors()) {
				return "new";
			}
			songService.createSong(song);
			return "redirect:/dashboard";
		}	
// Delete
		@RequestMapping(value="/songs/{id}/delete", method=RequestMethod.POST)
		public String delete(@PathVariable("id") Long id ) {
			songService.deleteSong(id);
			return "redirect:/dashboard";
		}
// passing redirect for search
		@RequestMapping(value="/songs/search", method=RequestMethod.POST)
		public String search(@RequestParam(value="searchstr") String searchstr, RedirectAttributes ra) {
			return "redirect:"+searchstr;
		}
}
