import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HW4Test {
	
	ArrayList<Playable> list = new ArrayList<Playable>();
	ArrayList<Playable> list1 = new ArrayList<Playable>();
	PlayList pl0;
	PlayList pl;
	PlayList empty;
	PlayList clear;
	Song s1;
	Song s2;
	Song s3;
	Song s4;
	Song s5;
	Song s6;
	
	
	@Before
	public void setUp() {
		s1 = new Song("Toto", "Africa", 3, 24);
		s2 = new Song("Toto", "Africa", 3, 24);
		s3 = new Song("Gucci Mane", "Wasted", 3, 46);
		s4 = new Song("Gucci Mane", "Lemonade", 4, 15);
		s5 = new Song(s4);
		s6 = new Song("The Weeknd", "The Morning");
		list1.add(s1);
		list1.add(s6);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		PlayList pl0 = new PlayList("Playlist");
		pl0.setPlayableList(list1);
		list.add(pl0);
		PlayList pl = new PlayList("Playlist");
		pl.setPlayableList(list);
		PlayList empty = new PlayList();
		PlayList clear = new PlayList();
		clear.setPlayableList(list);
	}

	@Test
	public void testSong1() {
		assertTrue(s6.getArtist().equals("The Weeknd") && s6.getTitle().equals("The Morning"));
	}
	@Test
	public void testSong2() {
		assertTrue(s6.getPlayTimeSeconds() == 0);
	}
	@Test
	public void testSong3() {
		assertTrue(s4.getTitle().equals("Lemonade") && s4.getArtist().equals("Gucci Mane"));
	}
	@Test
	public void testSong4() {
		assertTrue(s4.getMinutes() == 4 && s4.getSeconds() == 15);
	}
	@Test
	public void testSong5() {
		assertTrue(s5.getMinutes() == s4.getMinutes());
	}
	@Test
	public void testSong6() {
		assertTrue(s5.getArtist().equals(s4.getArtist()));
	}
	@Test
	public void testSongEquals1() {
		assertTrue(s1.equals(s2));
	}
	@Test
	public void testSongEquals2() {
		assertTrue(!s1.equals(s3));
	}
	@Test
	public void testSongToString1() {
		assertTrue(s1.toString().equals("{Song: title = Africa artist = Toto}"));
	}
	@Test
	public void testSongToString2() {
		assertTrue(s2.toString().equals("{Song: title = Africa artist = Toto}"));
	}
	@Test
	public void testSongCompareTo1() {
		assertTrue(s1.compareTo(s2) == 0);
	}
	@Test
	public void testSongCompareTo2() {
		assertTrue(s1.compareTo(s3) >= 1);
	}
	@Test
	public void testSongPlayTimeSeconds1() {
		assertTrue(s1.getPlayTimeSeconds() == 204);
	}
	@Test
	public void testSongPlayTimeSeconds2() {
		assertTrue(s4.getPlayTimeSeconds() == 255);
	}
	@Test
	public void testSongNumSongs1() {
		assertTrue(s1.numberOfSongs() == 1);
	}
	@Test
	public void testSongNumSongs2() {
		assertTrue(s2.numberOfSongs() == 1);
	}
	@Test
	public void testSongGetName1() {
		assertTrue(s1.getName().equals("Africa"));
	}
	@Test
	public void testSongGetName2() {
		assertTrue(s3.getName().equals("Wasted"));
	}
	@Test
	public void testPlayList1() {
		PlayList empty = new PlayList();
		assertTrue(empty.getName().equals("Untitled"));
	}
	@Test
	public void testPlayList2() {
		PlayList empty = new PlayList();
		assertTrue(empty.getPlayableList().size() == 0);
	}
	@Test
	public void testPlayList3() {
		PlayList pl0 = new PlayList("Playlist");
		assertTrue(pl0.getName().equals("Playlist"));
	}
	@Test
	public void testPlayList4() {
		PlayList pl0 = new PlayList("Playlist");
		assertTrue(pl0.getPlayableList().size() == 0);
	}
	@Test
	public void testClear() {
		PlayList clear = new PlayList();
		clear.setPlayableList(list);
		clear.clear();
		assertTrue(clear.getPlayableList().size() == 0);
	}
	@Test
	public void testClear2() {
		PlayList clear = new PlayList();
		clear.setPlayableList(list);
		assertTrue(clear.clear());
	}
	@Test
	public void testAddSong1() {
		PlayList pl0 = new PlayList("Playlist");
		pl0.addSong(s3);
		assertTrue(pl0.getPlayableList().contains(s3));
	}
	@Test
	public void testAddSong2() {
		PlayList pl0 = new PlayList("Playlist");
		pl0.addSong(s4);
		assertTrue(pl0.getPlayableList().contains(s4));
	}
	@Test
	public void testRemove1() {
		PlayList pl0 = new PlayList("Playlist");
		pl0.addSong(s4);
		pl0.removePlayable(0);
		assertTrue(!pl0.getPlayableList().contains(s4));
	}
	@Test
	public void testRemove2() {
		PlayList pl0 = new PlayList("PlayList");
		pl0.addSong(s1);
		pl0.addSong(s3);
		pl0.removePlayable(1);
		assertTrue(pl0.getPlayableList().contains(s1) && !pl0.getPlayableList().contains(s3));
	}
	@Test
	public void testRemove3() {
		PlayList pl0 = new PlayList("PlayList");
		pl0.addSong(s1);
		pl0.removePlayable(s1);
		assertTrue(pl0.getPlayableList().size() == 0);
	}
	@Test
	public void testRemove4() {
		PlayList pl0 = new PlayList();
		pl0.addSong(s1);
		pl0.addSong(s6);
		pl0.removePlayable(s6);
		assertTrue(pl0.getPlayableList().contains(s1) && !pl0.getPlayableList().contains(s6));
	}
	@Test
	public void testPlayListEquals1() {
		PlayList a = new PlayList();
		PlayList b = new PlayList();
		assertTrue(a.equals(b));
	}
	@Test
	public void testPlayListEquals2() {
		PlayList a = new PlayList();
		PlayList b = new PlayList();
		a.addSong(s1);
		assertTrue(!a.equals(b));
	}
	@Test
	public void testPlayListToString1() {
		PlayList a = new PlayList("pl");
		assertTrue(a.toString().equals("pl" + "\n"));
	}
	@Test
	public void testPlayListToString2() {
		PlayList a = new PlayList("pl");
		a.addSong(s3);
		a.addSong(s6);
		String s = a.toString();
		assertTrue(s.equals("pl" + "\n" + s3.toString() + "\n" + s6.toString() + "\n"));
	}
	@Test
	public void testGetPlayable1() {
		PlayList a = new PlayList("pl");
		a.addSong(s1);
		PlayList b = new PlayList();
		a.addPlayList(b);
		assertTrue(a.getPlayable(1).equals(b));
	}
	@Test
	public void testGetPlayable2() {
		PlayList a = new PlayList("pl");
		a.addSong(s1);
		PlayList b = new PlayList();
		a.addPlayList(b);
		assertTrue(a.getPlayable(0).equals(s1));
	}
	@Test
	public void testAddPlayList1() {
		PlayList a = new PlayList("pl");
		a.addSong(s1);
		PlayList b = new PlayList();
		a.addPlayList(b);
		assertTrue(a.getPlayableList().contains(b));
	}
	@Test
	public void testAddPlayList2() {
		PlayList a = new PlayList("pl");
		PlayList b = new PlayList();
		PlayList c = new PlayList();
		a.addPlayList(b);
		a.addPlayList(c);
		assertTrue(a.getPlayableList().contains(b) && !a.getPlayableList().contains(c));
	}
	@Test
	public void testPlayListPlayTimeSeconds1() {
		PlayList a = new PlayList();
		a.addSong(s1);
		a.addSong(s4);
		int num = a.getPlayTimeSeconds();
		assertTrue(num == 459);
	}
	@Test
	public void testPlayListPlayTimeSeconds2() {
		PlayList a = new PlayList();
		assertTrue(a.getPlayTimeSeconds() == 0);
	}
	@Test
	public void testPlayListNumberOfSongs1() {
		PlayList a = new PlayList();
		a.addSong(s1);
		a.addSong(s4);
		a.addSong(s6);
		assertTrue(a.numberOfSongs() == 3);
	}
	@Test
	public void testPlayListNumberOfSongs2() {
		PlayList a = new PlayList();
		PlayList b = new PlayList();
		b.addSong(s1);
		b.addSong(s6);
		a.addPlayList(b);
		assertTrue(a.numberOfSongs() == 2);
	}
	@Test
	public void testLoadSongs1() {
		Song s = new Song("Abba", "Dancing Queen", 4, 13);
		PlayList pl = new PlayList();
		pl.loadSongs("test.txt");
		assertTrue(pl.getPlayableList().contains(s));
	}
	@Test
	public void testLoadSongs2() {
		PlayList a = new PlayList();
		a.loadSongs("test.txt");
		Song s = new Song("Artie Jesperson and his Marching Polka Funk Ensemble", "Call Me Maybe", 3, 15);
		assertTrue(a.getPlayableList().contains(s));
	}
	@Test
	public void testSortByName() {
		PlayList a = new PlayList();
		a.addSong(s3);
		a.addSong(s1);
		a.addSong(s6);
		a.sortByName();
		assertTrue(a.getPlayableList().get(0).equals(s1));
	}
	@Test
	public void testSortByName2() {
		PlayList a = new PlayList();
		a.addSong(s3);
		a.addSong(s4);
		a.addSong(s6);
		a.sortByName();
		assertTrue(a.getPlayableList().get(0).equals(s4));
	}
	@Test
	public void testSortByTime() {
		PlayList a = new PlayList();
		a.addSong(s1);
		a.addSong(s3);
		a.addSong(s4);
		a.sortByTime();
		assertTrue(a.getPlayableList().get(0).equals(s1));
	}
	@Test
	public void testSortByTime2() {
		PlayList a = new PlayList();
		a.addSong(s3);
		a.addSong(s4);
		a.sortByTime();
		assertTrue(a.getPlayableList().get(0).equals(s3));
	}
}
