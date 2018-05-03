package com.eab;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.albumName = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

     public boolean addSong(String title, double duration){
        if (findSong(title)==null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
     }

     private Song findSong(String title){
         for (Song checkedSong:this.songs){
             if (checkedSong.getTitle().equals(title)){
                 return checkedSong;
             }
         }
         return null;
     }

     public boolean addtoPlayList(int trackNo, LinkedList<Song> playList){
         int index = trackNo-1;
         if (index>=0 && index<= this.songs.size()){
             playList.add(songs.get(index));
             return true;
         }
         System.out.println(this.albumName + " does not have a track "+ trackNo);
         return false;
     }

     public boolean addtoPlayList(String trackName, LinkedList<Song> playList){
         Song checkedSong=findSong(trackName);
         if (checkedSong!=null){
             playList.add(checkedSong);
             return true;
         }
         System.out.println(this.albumName + " does not have a track named" + trackName );
         return false;
     }


}
