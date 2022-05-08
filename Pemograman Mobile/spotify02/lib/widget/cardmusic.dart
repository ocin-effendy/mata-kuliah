import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:spotify02/data/album_data.dart';
import 'package:spotify02/pages/musicplay_page.dart';
import 'package:spotify02/widget/musicplay.dart';

class CardMusic extends StatefulWidget{
  CardMusic({Key? key, required this.song, required this.nameArtist, required this.linkImage}) : super(key: key);
	final String song;
	final String nameArtist;
	final String linkImage;
  @override
  State<CardMusic> createState() => _CardMusicState();
}

class _CardMusicState extends State<CardMusic> {
	bool cardCheck = false;
	bool likeCheck = false;

	void toggleLikeCheck() {
		setState(() {
			likeCheck = !likeCheck;
		});
	}

	void playMusic() async{
		final pref = await SharedPreferences.getInstance();
		pref.setString('song', widget.song);
	}

	@override
	Widget build(BuildContext context){
		return  GestureDetector(
			onTap: (){
				passSong.setSong(widget.song);
				passNameArtist.setNameArtist(widget.nameArtist);
				passLinkImage.setLinkImage(widget.linkImage);
				statusMusic.musicPlay();
				playMusic();
				cache.play(passSong.value+'.mp3');
			},

		  child: Container(
		  	decoration: BoxDecoration(
					color: Colors.white.withOpacity(0.02),
		  		border: const Border(bottom: BorderSide(color: Colors.grey, width: 0.15)),
		  	),
				child: ListTile(
					leading: Container(
		  			decoration: BoxDecoration(
							image: DecorationImage(
		  					image: AssetImage(widget.linkImage),
		  					fit: BoxFit.cover
		      		),
		  	  		borderRadius: BorderRadius.circular(10)
			    	),
						width: 50,
		  	  	height: 50,
						child: Align(
							child: Observer(
							  builder: (context) => Icon(widget.song == passSong.value && statusMusic.value ? Icons.pause : Icons.play_arrow,
		  					color: Colors.white,
							  ),
							),
						),
					),
		  		title: Text(widget.song,
		  			style: const TextStyle(color: Colors.white),
		  		),
		  		subtitle: Text(widget.nameArtist,
		  			style: TextStyle(color: Colors.grey[700]),
		  		),
		  		trailing: FittedBox(
						fit: BoxFit.fill,
	  			  child: Row(
							children: [
								IconButton(
									onPressed: (){
										toggleLikeCheck();
									}, 
									color: likeCheck ? Colors.teal : Colors.white,
									icon: likeCheck ? const Icon(Icons.favorite) : const Icon(Icons.favorite_outline),
								),
		  					const Icon(Icons.more_vert, color: Colors.white,),
			  			],
		  			),
					)
		  	)
		  ),
		);
	}

}
