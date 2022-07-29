import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:spotify02/api_service.dart';
import 'package:spotify02/pages/musicplay_page.dart';
import 'package:spotify02/provider/listsongnotifier.dart';
import 'package:spotify02/views/home.dart';
import 'package:spotify02/views/library.dart';
import 'package:spotify02/views/profile.dart';
import 'package:spotify02/views/search.dart';
import 'package:spotify02/widget/musicplay.dart';

class Tabbar extends StatefulWidget {
  final String name;
  const Tabbar({Key? key, required this.name}) : super(key: key);
  @override
  State<Tabbar> createState() => _TabbarState();
}

class _TabbarState extends State<Tabbar> {
  int _selectedTab = 0;

  @override
  void initState() {
    super.initState();
		// click notification push to MusicPlayPage
    FirebaseMessaging.instance.getInitialMessage().then((message) {
      if (message != null) {
        Navigator.push(
            context,
            MaterialPageRoute(
                builder: (context) => const MusicPlayPage(
                      song: "Sunroof",
                      nameArtist: "Nicky Youre, Dazy",
                      linkImage: "assets/Nicky Youre Dazy.jpeg",
                    )));
      }
    });
  }

  @override
  Widget build(BuildContext context) {
		// ApiService().getSongModel().then((value) => print("value: $value"));
    return ChangeNotifierProvider<ListSongNotifier>(
        create: (_) => ListSongNotifier(),
        child: Scaffold(
          bottomNavigationBar: Container(
              child: BottomNavigationBar(
            currentIndex: _selectedTab,
            onTap: (index) {
              setState(() {
                _selectedTab = index;
              });
            },
            items: const [
              BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Home'),
              BottomNavigationBarItem(
                  icon: Icon(Icons.search_outlined), label: 'Search'),
              BottomNavigationBarItem(
                  icon: Icon(Icons.library_music), label: 'Library'),
              BottomNavigationBarItem(
                  icon: Icon(Icons.person), label: 'Profile'),
            ],
          )),
          body: Stack(
            children: [
              renderView(
                0,
                HomePage(
                  name: widget.name,
                ),
              ),
              renderView(1, SearchPage()),
              renderView(2, LibraryPage()),
              renderView(3, ProfilePage()),
            ],
          ),
        ));
  }

  Widget renderView(int tabIndex, Widget view) {
    return IgnorePointer(
      ignoring: _selectedTab != tabIndex,
      child: Opacity(
        opacity: _selectedTab == tabIndex ? 1 : 0,
        child: view,
      ),
    );
  }
}
