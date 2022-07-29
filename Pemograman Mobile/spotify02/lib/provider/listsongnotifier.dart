import 'package:flutter/material.dart';

class ListSongNotifier extends ChangeNotifier {
  List<Map<String, dynamic>> listSongTemp = [
    {
      "song": "Sunroof",
      "nameArtist": "Nicky Youre, Dazy",
      "linkImage": "assets/Nicky Youre, Dazy.jpeg",
    },
    {
      "song": "As it was",
      "nameArtist": "Harry Style",
      "linkImage": "assets/Harry Style.png",
    },
  ];

  void deleteSong(String song) {
    for (int i = 0; i < listSongTemp.length; i++) {
      if (listSongTemp[i]["song"] == song) {
        listSongTemp.removeAt(i);
				break;
      }
    }
    notifyListeners();
  }

  void addListSong(String song, String nameArtist, String linkImage) {
    listSongTemp.add({
      "song": song,
      "nameArtist": nameArtist,
      "linkImage": linkImage,
    });

    for (int i = 0; i < listSongTemp.length; i++) {
      print(listSongTemp[i]["song"]);
    }
    notifyListeners();
  }

  List<Map<String, dynamic>> get listCok => listSongTemp;
}
