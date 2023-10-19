public class FavoriteSongLyrics {
    private String songTitle;
    private String[] lyrics;

    public FavoriteSongLyrics(String songTitle, String[] lyrics) {
        this.songTitle = songTitle;
        this.lyrics = lyrics;
    }

    public void displayLyrics() {
        System.out.println("Song: " + songTitle);
        System.out.println("Lyrics:");
        for (String line : lyrics) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        String songTitle = "Don't Stop Believin'Song by Journey";
        String[] lyrics = {
            "Just a small town girl, Livin' in a lonely world",
            "She took the midnight train going anywhere",
            "Just a city boy, Born and raised in South Detroit",
            "He took the midnight train going anywhere"
        };

        FavoriteSongLyrics favoriteSong = new FavoriteSongLyrics(songTitle, lyrics);
        favoriteSong.displayLyrics();
    }
}