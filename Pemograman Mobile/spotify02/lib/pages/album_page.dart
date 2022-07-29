import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:spotify02/data/album_data.dart';
import 'package:spotify02/widget/cardmusic.dart';
import 'package:spotify02/provider/listsongnotifier.dart';
import 'package:spotify02/widget/musicplay.dart';

class Album extends StatefulWidget {
  const Album({Key? key, required this.name, required this.linkImage})
      : super(key: key);
  final String name;
  final String linkImage;

  @override
  State<Album> createState() => _AlbumState();
}

class _AlbumState extends State<Album> {
  List<Map<String, dynamic>> albumData = AlbumData.data;
  ScrollController scrollController = ScrollController();
  double imageSize = 0;
  double initialSize = 240;
  double containerHeight = 500;
  double containerInitialHeight = 500;
  double imageOpacity = 1;
  bool showTopBar = false;

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<ListSongNotifier>(
			create: (_) => ListSongNotifier(),
      child: Scaffold(
        body: Stack(
          children: [
            Container(
              height: containerHeight,
              width: MediaQuery.of(context).size.width,
              alignment: Alignment.center,
              color: Colors.black,
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Opacity(
                    opacity: imageOpacity.clamp(0, 1.0),
                    child: Container(
                      child: Image(
                        image: AssetImage(widget.linkImage),
                        width: 400,
                        height: 400,
                        fit: BoxFit.cover,
                      ),
                    ),
                  ),
                  const SizedBox(
                    height: 100,
                  )
                ],
              ),
            ),
            SafeArea(
                child: SingleChildScrollView(
              controller: scrollController,
              physics: const BouncingScrollPhysics(),
              child: Column(
                children: [
                  Container(
                    width: MediaQuery.of(context).size.width,
                    decoration: BoxDecoration(
                        gradient: LinearGradient(
                            begin: Alignment.topCenter,
                            end: Alignment.bottomCenter,
                            colors: [
                          Colors.black.withOpacity(0),
                          Colors.black.withOpacity(0),
                          Colors.black.withOpacity(1),
                        ])),
                    child: Padding(
                      padding: const EdgeInsets.only(left: 10, right: 10),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          SizedBox(
                            height: initialSize + 32,
                          ),
                          SizedBox(
                            width: 200,
                            child: Text(
                              widget.name,
                              style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 40,
                                  fontWeight: FontWeight.w900),
                            ),
                          ),
                          const SizedBox(height: 7),
                          SizedBox(
                            child: Row(
                              children: [
                                Row(
                                  children: const [
                                    Icon(
                                      Icons.favorite_outline,
                                      color: Colors.grey,
                                      size: 15,
                                    ),
                                    Text(
                                      '42.725 Likes',
                                      style: TextStyle(
                                          color: Colors.grey, fontSize: 12),
                                    )
                                  ],
                                ),
                                const SizedBox(
                                  width: 10,
                                ),
                                Row(
                                  children: const [
                                    Icon(
                                      Icons.timer_outlined,
                                      color: Colors.grey,
                                      size: 15,
                                    ),
                                    Text(
                                      '1h 37min',
                                      style: TextStyle(
                                          color: Colors.grey, fontSize: 12),
                                    )
                                  ],
                                )
                              ],
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                  Container(
                    width: MediaQuery.of(context).size.width,
                    color: Colors.black,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        const SizedBox(
                          height: 20,
                        ),
                        const Padding(
                          padding: EdgeInsets.only(left: 10),
                          child: Text(
                            'Featuring',
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 18,
                              fontWeight: FontWeight.w500,
                            ),
                          ),
                        ),
                        Observer(
                          builder: (context) => ListView.builder(
                            physics: const NeverScrollableScrollPhysics(),
                            shrinkWrap: true,
                            itemCount: albumData.length,
                            itemBuilder: (BuildContext context, int index) {
                              return CardMusic(
                                  song: albumData[index]['song'],
                                  nameArtist: albumData[index]['nameArtist'],
                                  linkImage: albumData[index]['linkImage']);
                            },
                          ),
                        ),
                      ],
                    ),
                  )
                ],
              ),
            )),
            const MusicPlay(),
          ],
        ),
      ),
    );
  }
}
