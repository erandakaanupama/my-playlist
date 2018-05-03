package com.eab;

import java.util.*;

public class Main {

    private static LinkedList<Album> albums = new LinkedList<>();

    public static void main(String[] args) {
        Album album = new Album("freedom", "Akon");
        album.addSong("abc", 3.06);
        album.addSong("abd", 4.40);
        album.addSong("xyz", 5.06);
        album.addSong("pqr", 1.40);

        albums.add(album);

        album = new Album("Mix", "various");
        album.addSong("ggg", 2.4);
        album.addSong("zzz", 5.4);
        album.addSong("rtg", 5.7);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addtoPlayList("abc", playlist);
        albums.get(0).addtoPlayList(2, playlist);
        albums.get(1).addtoPlayList(3, playlist);

        play(playlist);
    }


    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenue();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next());
                    } else {
                        System.out.println("At the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing:" + listIterator.previous().toString());
                        forward = false;
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous());
                            forward=false;
                        }
                        else {
                            System.out.println("We are at the start ");
                        }
                    }
                    else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing: "+listIterator.next());
                            forward =true;
                        }
                        else {
                            System.out.println("We are at the end ");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenue();
                    break;

                case 6:
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing: "+listIterator.next());
                        }else if (listIterator.hasPrevious()){
                            System.out.println("Now playing: "+listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("=========================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=========================");
    }

    private static void printMenue() {
        System.out.println("Enter a number 0-5: 0 to exit");
        System.out.println("0 - exit\n" +
                "1 - go forward\n" +
                "2 - go backward\n" +
                "3 - replay current song\n" +
                "4 - print list\n" +
                "5 - show menue\n" +
                "6 - remove current song\n");
    }
}
