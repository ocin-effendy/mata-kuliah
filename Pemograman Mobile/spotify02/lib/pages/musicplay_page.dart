import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:spotify02/widget/musicplay.dart';

AudioPlayer player = AudioPlayer();
AudioCache cache = AudioCache();
Duration position = Duration();
Duration musicLength = Duration();



class MusicPlayPage extends StatefulWidget {
  final String song;
  final String nameArtist;
  final String linkImage;

  const MusicPlayPage(
      {Key? key,
      required this.song,
      required this.nameArtist,
      required this.linkImage})
      : super(key: key);

  @override
  State<MusicPlayPage> createState() => _MusicPlayPageState();
}

class _MusicPlayPageState extends State<MusicPlayPage> {
   Widget slider() {
    return Slider.adaptive(
        activeColor: Colors.teal,
        inactiveColor: Colors.grey,
        max: musicLength.inSeconds.toDouble(),
        value: position.inSeconds.toDouble(),
        onChanged: (value) {
          seekToSec(value.toInt());
        });
  }

  void seekToSec(int sec) {
    Duration newPos = Duration(seconds: sec);
    player.seek(newPos);
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    cache = AudioCache(fixedPlayer: player);

    player.onDurationChanged.listen((duration) {
      setState(() {
        musicLength = duration;
      });
    });

    player.onAudioPositionChanged.listen((duration) {
      setState(() {
        position = duration;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Stack(
          children: [
            Container(
              width: MediaQuery.of(context).size.width,
              height: MediaQuery.of(context).size.height * .5,
              decoration: const BoxDecoration(color: Colors.teal),
            ),
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 19, vertical: 10),
              decoration: BoxDecoration(
                  gradient: LinearGradient(
                      begin: Alignment.topCenter,
                      end: Alignment.bottomCenter,
                      colors: [
                    Colors.black.withOpacity(0),
                    Colors.black.withOpacity(.9),
                    Colors.black.withOpacity(1),
                    Colors.black.withOpacity(1),
                  ])),
              child: Observer(
                builder: (context) => Column(
                  children: [
                    Row(
											crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        const Icon(
                          Icons.arrow_back_ios,
                          size: 20,
                        ),
                        Column(
                          children: [
                            Text('PLAYING FROM ARTIST',
                                style: GoogleFonts.poppins(fontSize: 12)),
                            Text(passNameArtist.value,
                                style: GoogleFonts.poppins(fontSize: 12)),
                          ],
                        ),
                        const Icon(
                          Icons.more_vert,
                        ),
                      ],
                    ),
                    const SizedBox(
                      height: 30,
                    ),
                    SizedBox(
                      width: MediaQuery.of(context).size.width,
                      height: MediaQuery.of(context).size.height * .45,
                      child: Image(
                        image: AssetImage(passLinkImage.value),
                        fit: BoxFit.cover,
                      ),
                    ),
                    Expanded(
                      child: Container(
                        margin: const EdgeInsets.only(top: 30),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Row(
															crossAxisAlignment: CrossAxisAlignment.center,
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                const Icon(
                                  Icons.favorite,
                                ),
                                Column(
                                  children: [
                                    Text(
                                      passSong.value,
                                      style: GoogleFonts.poppins(fontSize: 20),
                                    ),
                                    Text(
                                      passNameArtist.value,
                                      style: GoogleFonts.poppins(),
                                    )
                                  ],
                                ),
                                const Icon(
                                  Icons.share,
                                )
                              ],
                            ),
                            SizedBox(
                              child: Column(
                                children: [
                                  Row(
                                    mainAxisAlignment:
                                        MainAxisAlignment.spaceBetween,
                                    children: [
                                      Text(
                                          "${position.inMinutes}:${position.inSeconds.remainder(60)}"),
                                      Text(
                                          "${musicLength.inMinutes}:${musicLength.inSeconds.remainder(60)}"),
                                    ],
                                  ),
                                  SliderTheme(
                                    data: SliderThemeData(
                                      trackHeight: 4,
                                      thumbShape: RoundSliderThumbShape(
                                          enabledThumbRadius: 6.0),
                                    ),
                                    child: slider(),
                                  )
                                ],
                              ),
                            ),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Icon(Icons.screen_share_outlined),
                                Row(
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      IconButton(
                                          iconSize: 40,
                                          onPressed: () {},
                                          icon: Icon(Icons.skip_previous)),
                                      Container(
                                        decoration: BoxDecoration(
                                            shape: BoxShape.circle,
                                            border: Border.all(
                                                color: Colors.white, width: 1)),
                                        child: IconButton(
                                            onPressed: () {
                                              if (statusMusic.value) {
                                                player.pause();
                                                statusMusic.musicStop();
                                              } else {
                                                cache.play(
                                                    passSong.value+'.mp3');
                                                statusMusic.musicPlay();
                                              }
                                            },
                                            iconSize: 60,
                                            icon: Observer(
                                                builder: (context) => Icon(
                                                    statusMusic.value
                                                        ? Icons.pause
                                                        : Icons.play_arrow))),
                                      ),
                                      IconButton(
                                          onPressed: () {
                                          },
                                          iconSize: 40,
                                          icon: Icon(Icons.skip_next)),
                                    ]),
                                Icon(Icons.cached_outlined)
                              ],
                            ),
                            const SizedBox(height: 20),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                Icon(
                                  Icons.devices,
                                  size: 15,
                                ),
                                SizedBox(width: 6),
                                Text(
                                  'DEVICES AVAILABLE',
                                  style: GoogleFonts.poppins(fontSize: 10),
                                )
                              ],
                            )
                          ],
                        ),
                      ),
                    )
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
