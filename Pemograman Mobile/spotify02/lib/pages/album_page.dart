import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:spotify02/data/album_data.dart';
import 'package:spotify02/widget/cardmusic.dart';
import 'package:spotify02/widget/musicplay.dart';

class Album extends StatefulWidget{
  const Album({Key? key, required this.name, required this.linkImage}) : super(key: key);
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
	void initState() {
		imageSize = initialSize;
		scrollController = ScrollController()
			..addListener(() {
				imageSize = initialSize - scrollController.offset;
				if (imageSize < 0){
					imageSize = 0;
				}
				containerHeight = containerInitialHeight - scrollController.offset;
				if (containerHeight < 0){
					containerHeight = 0;
				}
				imageOpacity = imageSize / initialSize;
				if (scrollController.offset > 224) {
					showTopBar = true;
				}else{
					showTopBar = false;
				}
				print(scrollController.offset);
				setState(() {});
			});
			super.initState();
	}

	

	@override
	Widget build(BuildContext context){
		return Scaffold(
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
								const SizedBox(height: 100,)
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
												]
											)
										),
										child: Padding(
										  padding: const EdgeInsets.only(left: 10, right: 10),
										  child: Column(
										  	crossAxisAlignment: CrossAxisAlignment.start,
										  	children: [
										  		SizedBox(height: initialSize + 32,),
										  		SizedBox(
										  			width: 160,
										  			child: Text(widget.name,
										  				style: const TextStyle(
										  					color: Colors.white,
										  					fontSize: 30,
										  					fontWeight: FontWeight.w900
										  				),
										  			),
										  		),
													const SizedBox(height: 7),
													SizedBox(
														child: Row(
															children: [
																Row(
																	children: const [
																		Icon(Icons.favorite_outline, color: Colors.grey, size: 15,),
																		Text('42.725 Likes',
																			style: TextStyle(
																				color: Colors.grey,
																				fontSize: 12
																			),
																		)
																	],
																),
																const SizedBox(width: 10,),
																Row(
																	children: const [
																		Icon(Icons.timer_outlined, color: Colors.grey, size: 15,),
																		Text('1h 37min',
																			style: TextStyle(
																				color: Colors.grey,
																				fontSize: 12
																			),
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
												const SizedBox(height: 20,),
												const Padding(
												  padding: EdgeInsets.only(left: 10),
												  child: Text('Featuring',
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
												  	itemBuilder: (BuildContext context, int index){
															return CardMusic(song: albumData[index]['song'], nameArtist: albumData[index]['nameArtist'], linkImage: albumData[index]['linkImage']);

												  	},
												  ),
												),
											],
										),
									)
								],
							),
						)
					),
					Positioned(
						child: Container(
							child: AnimatedContainer(
								duration: const Duration(milliseconds: 250),
								color: showTopBar 
									? Colors.teal.withOpacity(1) 
									: Colors.teal.withOpacity(0),
								padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
								child: SafeArea(
									child: Container(
										height: 40,
										width: MediaQuery.of(context).size.width,
										child: Stack(
											clipBehavior: Clip.none,
											alignment:  Alignment.center,
											children: [
												Positioned(
												width: MediaQuery.of(context).size.width,
													child: Row(
														mainAxisAlignment: MainAxisAlignment.spaceBetween,
													  children: [
															IconButton(
																onPressed: (){
																	Navigator.pop(context);
																},
																iconSize: 28,
																icon: const Icon(Icons.keyboard_arrow_left),
															),
															AnimatedOpacity(
																duration: const Duration(milliseconds: 250),
																opacity: showTopBar ? 0 : 1,
													  	  child: SizedBox(
																	child: Row(
																		children: const[
																			Icon(Icons.favorite_outline, color: Colors.white,),
																			Icon(Icons.more_vert, color: Colors.white,),
																		],
																	),
																),
													  	)
													  ],
													),
												),
												AnimatedOpacity(
													duration: const Duration(milliseconds: 250),
													opacity: showTopBar ? 1 : 0,
													child: Text(widget.name,
														style: Theme.of(context).textTheme.headline6,
													),
												),
												Positioned(
													right: 0,
													bottom: 150 - containerHeight.clamp(190.0, double.infinity),
													child: Stack(
														alignment: Alignment.bottomRight,
														children: [
															Container(
																width: 64, 
																height: 64,
																alignment: Alignment.center,
																decoration: const BoxDecoration(
																	shape: BoxShape.circle,
																	color: Color(0xff14D860)
																),
																child: const Icon(Icons.play_arrow, size: 38),
															),

															Container(
																width: 24,
																height: 24,
																decoration: const BoxDecoration(
																	shape: BoxShape.circle,
																	color: Colors.white,
																),
																child: const Icon(Icons.shuffle, color: Colors.black, size: 14,),
															)
														],
													)
												)
											],
										),
									),
								),
							),
						),
					),
					MusicPlay(),
				],
			),
		);
	}
}
