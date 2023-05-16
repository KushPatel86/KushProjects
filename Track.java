/**
 * Represents a track in an MP3 player.
 */
public class Track {

	String songName;
	String artist;
	String mp3FileLocation;

	/**
	 * Retrieves the location of the MP3 file for this track.
	 * 
	 * @return the location of the MP3 file
	 */
	public String getMp3() {
		return mp3FileLocation;
	}

	/**
	 * Sets the location of the MP3 file for this track.
	 * 
	 * @param mp3 the location of the MP3 file
	 */
	public void setMp3(String mp3) {
		this.mp3FileLocation = mp3;
	}

	/**
	 * Retrieves the name of the song for this track.
	 * 
	 * @return the name of the song
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * Sets the name of the song for this track.
	 * 
	 * @param songName the name of the song
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * Retrieves the artist of the song for this track.
	 * 
	 * @return the artist of the song
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets the artist of the song for this track.
	 * 
	 * @param artist the artist of the song
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Returns a string representation of the track, which is the song name.
	 * 
	 * @return a string representation of the track
	 */
	public String toString() {
		return getSongName();
	}

	/**
	 * Checks if this track is equal to the specified object.
	 * 
	 * @param o the object to compare
	 * @return true if the object is equal to this track, false otherwise
	 */
	public boolean equals(Object o) {
		if (o.toString().equalsIgnoreCase(getSongName()))
			return true;
		else
			return false;
	}
}