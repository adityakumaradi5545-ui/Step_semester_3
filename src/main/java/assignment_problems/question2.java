package assignment_problems;

import java.util.Arrays;

public class question2 {
}


class Playlist {
    private final String[] songs;   // private storage, never handed out directly
    private int count = 0;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
    }

    public void addSong(String title) {
        if (count >= songs.length) {
            System.out.println("Cannot add \"" + title + "\": playlist is full");
            return;
        }
        songs[count] = title;
        count++;
    }

    // Returns a brand new array holding only the songs added so far
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

 class A2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";   // changes only the copy

        System.out.println("Copy after tampering: " + Arrays.toString(copy));
        System.out.println("Playlist still holds: " + Arrays.toString(p.getSongs()));
        System.out.println("getSongs()[0] = " + p.getSongs()[0]);
        System.out.println("getSongCount() = " + p.getSongCount());
    }
}