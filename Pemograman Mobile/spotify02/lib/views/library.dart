import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:spotify02/api_service.dart';
import 'package:spotify02/models/song_model.dart';
import 'package:spotify02/provider/listsongnotifier.dart';
import 'package:spotify02/widget/cardmusic.dart';
import 'package:spotify02/widget/musicplay.dart';
import 'package:spotify02/widget/song.dart';

class LibraryPage extends StatefulWidget {
  const LibraryPage({Key? key}) : super(key: key);

  @override
  State<LibraryPage> createState() => _LibraryPageState();
}

class _LibraryPageState extends State<LibraryPage> {
	// late ApiService apiService;
	
	@override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("My Music Play"),
      ),

      body: Stack(
        children: [
					SingleChildScrollView(
					physics: const BouncingScrollPhysics(),
					child: Consumer<ListSongNotifier>(
						builder: (context, listSong, _) => ListView.builder(
								itemCount: listSong.listSongTemp.length,
								itemBuilder: (context, index){
									return Text(listSong.listSongTemp[index]['song']);
								},
								),
							),
          ),
          const MusicPlay(),
        ],
      ),
    );
  }
}
