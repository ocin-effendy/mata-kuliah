import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:spotify02/data/album_data.dart';
import 'package:spotify02/mobx/passlinkimage.dart';
import 'package:spotify02/mobx/passnameartist.dart';
import 'package:spotify02/mobx/passsong.dart';
import 'package:spotify02/mobx/statusmusic.dart';
import 'package:spotify02/pages/musicplay_page.dart';

final PassSongMobx passSong = PassSongMobx();
final PassNameArtistMobx passNameArtist = PassNameArtistMobx();
final PassLinkImageMobx passLinkImage = PassLinkImageMobx();
final StatusMusicMobx statusMusic = StatusMusicMobx();
class MusicPlay extends StatefulWidget{
	const MusicPlay({Key? key}) : super(key: key);
  @override
  State<MusicPlay> createState() => MusicPlayState();
}

class MusicPlayState extends State<MusicPlay> {
	List<Map<String, dynamic>> albumData = AlbumData.data;
	String song = '';
	String nameArtist = '';
	String linkImage = '';

	void getSong() async{
		final pref = await SharedPreferences.getInstance();
		for(int i = 0; i < albumData.length; i++){
			if(pref.getString('song').toString() == albumData[i]['song']){
				setState(() {
					song = albumData[i]['song'];
					nameArtist = albumData[i]['nameArtist'];
					linkImage = albumData[i]['linkImage'];
					passSong.setSong(song);
					passNameArtist.setNameArtist(nameArtist);
					passLinkImage.setLinkImage(linkImage);
				});
			}
		}
    cache = AudioCache(fixedPlayer: player);
	}

	@override
	  void initState() {
			getSong();
	    super.initState();
	  }




  @override
  Widget build(BuildContext context) {
		return GestureDetector(
			onTap: (){
				Navigator.push(context, MaterialPageRoute(builder: (context) => MusicPlayPage(song: song, nameArtist: nameArtist, linkImage: linkImage,) ));
			},
		  child: Align(
		  	alignment: Alignment.bottomCenter,
		  		child: Container(
		  			color: const Color.fromRGBO(26, 26, 26, 1),
		  	    child: ListTile(
		  	  	  leading: Observer(
		  	  	    builder: (context) => Container(
		  	  	    	decoration: BoxDecoration(
		  			  	  image: DecorationImage(
		  			  			image: AssetImage(passLinkImage.value == '' ? linkImage : passLinkImage.value),
		  				  			fit: BoxFit.cover
		  	  	    		),
		  		  	  		borderRadius: BorderRadius.circular(10)
		  	  	    	),
		  		  	  	width: 50,
		  						height: 50,
		  			  ),
		  	  	  ),
		  			  title: Observer(
		  					builder: (context) => Text(passSong.value == '' ? song : passSong.value,
		  	  	  	style: const TextStyle(color: Colors.white),
		  	  	  ),
		  			  ),
		  				subtitle: Observer(
		  				  builder: (context) => Text(passNameArtist.value == '' ? nameArtist : passNameArtist.value,
		  				  	style: TextStyle(color: Colors.grey[700]),
		  			  ),
		  				),
		  			  trailing: FittedBox(
		  			  	fit: BoxFit.fill,
		  	  	  	child: Row(
		  	  	  		children: [
		  							IconButton(
		  			  				onPressed: (){
		  									if(statusMusic.value){
		  										statusMusic.musicStop();
												player.pause();	
		  									}else{
		  										statusMusic.musicPlay();
													cache.play(passSong.value+'.mp3');
		  									}
		  								}, 
		  			  					color: Colors.white,
		  	  	  					icon: Observer(builder: (context) => Icon(statusMusic.value ? Icons.pause : Icons.play_arrow)),
		    	  				),
		  							GestureDetector(
		  									onTap: (){},
		  									child: const Icon(Icons.more_vert, color: Colors.white,))
		  						],
		    	  		),
		  			)
		  		),
		  )
	),
		);
  }
}
