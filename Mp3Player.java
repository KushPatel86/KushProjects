
import javazoom.jl.player.advanced.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class representing an MP3 player GUI.
 */
public class Mp3Player extends JPanel implements ActionListener {

	static MyArrayList<Track> songList = new MyArrayList<>();
	private static final long serialVersionUID = 1L;
	static JButton play, pause, next, remove, addTrack;
	JLabel songname, songlist, artistName;
	PlayThread runnable;
	Thread t;

	static int selectedSong;
	Track selectedTrack;

	/**
	 * Constructs an Mp3Player object.
	 */
	public Mp3Player() {
		// Initialize variables
		selectedSong = 0;
		selectedTrack = new Track();
		// Set up the panel layout
		JPanel gl = new JPanel(new GridLayout(4, 1));
		setPreferredSize(new Dimension(300, 350));
		// Create buttons
		play = new JButton("Play");
		play.setVerticalTextPosition(AbstractButton.CENTER);
		play.setHorizontalTextPosition(AbstractButton.LEADING);
		play.setActionCommand("play");

		next = new JButton("Next");
		next.setVerticalTextPosition(AbstractButton.BOTTOM);
		next.setHorizontalTextPosition(AbstractButton.CENTER);
		next.setActionCommand("next");
		;

		pause = new JButton("Stop");
		pause.setActionCommand("pause");
		pause.setEnabled(false);

		remove = new JButton("Remove");
		remove.setActionCommand("remove");

		addTrack = new JButton("Add Eminem to Playlist");
		addTrack.setActionCommand("addTrack");
		// Register action listeners
		play.addActionListener(this);
		pause.addActionListener(this);
		next.addActionListener(this);
		remove.addActionListener(this);
		addTrack.addActionListener(this);
		// Set up song display labels
		selectedTrack = songList.get(selectedSong);
		songname = new JLabel(selectedTrack.getSongName());
		songname.setPreferredSize(new Dimension(200, 30));

		String htmlString = "<html>PlayList<br/>";
		for (int i = 0; i < songList.size(); i++) {
			Track ct = songList.get(i);
			htmlString += ct.toString() + "<br/>";
		}

		htmlString = htmlString + "</html>";
		songlist = new JLabel(htmlString);

		songlist.setPreferredSize(new Dimension(240, 180));
		JPanel songArtistPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel n = new JLabel("Song Name:");
		songArtistPanel.add(n);
		songArtistPanel.add(songname);
		gl.add(songArtistPanel);

		JPanel artistPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel artist = new JLabel("Artist: ");
		artistName = new JLabel(selectedTrack.getArtist());
		artistPanel.add(artist);
		artistPanel.add(artistName);
		gl.add(artistPanel);

		JPanel buttonPanel = new JPanel();

		buttonPanel.add(play);
		buttonPanel.add(pause);
		buttonPanel.add(next);
		buttonPanel.add(remove);

		JPanel addTrackPanel = new JPanel();
		addTrackPanel.add(addTrack);

		gl.add(buttonPanel);
		gl.add(addTrackPanel);
		add(gl);

		add(songlist);
	}

	/**
	 * Handles the button click events.
	 *
	 * @param e the action event
	 */
	public void actionPerformed(ActionEvent e) {
		if ("play".equals(e.getActionCommand())) {
			runnable = new PlayThread(selectedTrack.getMp3());
			t = new Thread(runnable);
			t.start();
			play.setEnabled(false);
			pause.setEnabled(true);
		}
		if ("pause".equals(e.getActionCommand())) {
			t.stop();

			pause.setEnabled(false);
			play.setEnabled(true);
		}
		if ("next".equals(e.getActionCommand())) {
			if (!songList.isEmpty()) {
				selectedSong++;
				selectedSong = selectedSong % songList.size();
				Track nextSong = songList.get(selectedSong);
				String nextsong = nextSong.getSongName();
				songname.setText(nextsong);
				artistName.setText(nextSong.getArtist());
				selectedTrack = nextSong;
			}
		}
		if ("remove".equals(e.getActionCommand())) {
			if (!songList.isEmpty()) {
				if (songList.size() % 2 == 0) {
					songList.remove(selectedSong);
				} else {
					Track ct = songList.get(selectedSong);
					songList.remove(ct);
				}
			}
			if (!songList.isEmpty()) {
				int nextSong = selectedSong;
				nextSong = nextSong % songList.size();
				Track next = songList.get(nextSong);
				String nextsong = next.getSongName();
				songname.setText(nextsong);
				artistName.setText(next.getArtist());
				selectedSong = nextSong;
				selectedTrack = next;
			} else {
				songname.setText(" ");
				artistName.setText("");
				selectedTrack = null;
			}

			String htmlString = "<html>PlayList<br/>";

			for (int i = 0; i < songList.size(); i++) {
				Track ct = songList.get(i);
				htmlString += ct.toString() + "<br/>";
			}
			htmlString = htmlString + "</html>";

			songlist.setText(htmlString);
		}
		if ("addTrack".equals(e.getActionCommand())) {
			Track t = new Track();
			t.setSongName("Lose Yourself");
			t.setArtist("Eminem");
			t.setMp3("LoseYourself.mp3");
			songList.add(t);
			String htmlString = "<html>PlayList<br/>";

			for (int i = 0; i < songList.size(); i++) {
				Track ct = songList.get(i);
				htmlString += ct.toString() + "<br/>";
			}
			htmlString = htmlString + "</html>";
			songlist.setText(htmlString);
		}
	}

	/**
	 * Notifies the GUI when a song has finished playing.
	 */
	public static void doneSong() {

		pause.setEnabled(false);
		play.setEnabled(true);
	}

	/**
	 * Creates and shows the GUI.
	 */
	private static void createAndShowGUI() {

		// Create and set up the window.
		JFrame frame = new JFrame("MP3 Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		Mp3Player newContentPane = new Mp3Player();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Create sample tracks
		Track t = new Track();
		t.setArtist("Prince");
		t.setSongName("When Doves Cry");
		t.setMp3("PrinceWhenDovesCry.mp3");

		Track t2 = new Track();
		t2.setArtist("Madonna");
		t2.setSongName("Vogue");
		t2.setMp3("Vogue.mp3");

		Track t3 = new Track();
		t3.setArtist("Guns N Roses");
		t3.setSongName("November Rain");
		t3.setMp3("NovemberRain.mp3");

		Track t4 = new Track();
		t4.setArtist("Bruno Mars");
		t4.setSongName("Uptown Funk");
		t4.setMp3("UptownFunk.mp3");

		Track t5 = new Track();
		t5.setArtist("Beyonce");
		t5.setSongName("Run the World");
		t5.setMp3("RunTheWorld.mp3");
		// Add tracks to the songList
		songList.add(t);
		songList.add(t2);
		// Clear and add new tracks to the songList
		songList.clear();
		songList.add(t3);
		songList.add(t4);
		songList.add(t5);
		songList.add(1, t);
		songList.add(2, t2);
		songList.set(2, t5);
		// Check if a specific track is in the playlist
		if (songList.contains(t5)) {
			System.out.println(t5.toString() + " is in playlist");
		} else {
			System.out.println("not in playlist");
		}
		// Create and show the GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}
}

/**
 * 
 * Represents a thread that plays an MP3 file.
 */
class PlayThread implements Runnable {
	private String song;

	/**
	 * Constructs a PlayThread with the specified song.
	 * 
	 * @param song the song to be played
	 */
	public PlayThread(String song) {
		this.song = song;
	}

	/**
	 * Plays the MP3 file.
	 */
	public void run() {
		try {

			FileInputStream fis = new FileInputStream(song);
			AdvancedPlayer p = new AdvancedPlayer(fis);
			p.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Mp3Player.doneSong();
	}
}